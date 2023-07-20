package com.eInvoice.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eInvoice.models.BuyerDtls;
import com.eInvoice.models.DocDtls;
import com.eInvoice.models.ItemList;
import com.eInvoice.models.Root;
import com.eInvoice.models.SalesInvoiceModel;
import com.eInvoice.models.SellerDtls;
import com.eInvoice.models.TranDtls;
import com.eInvoice.models.ValDtls;
import com.eInvoice.repo.EinvoiceRepo;
import com.eInvoice.util.DateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EinvoiceService {

	@Autowired
	private EinvoiceRepo eInvoiceRepo;

	public Page<?> getPendingInvoiceList(int startIndex, int endIndex, String searchQuery,String startDate,String endDate) throws Exception {
		try {

			int pageNo = startIndex / endIndex;
			Pageable pageable = PageRequest.of(pageNo, endIndex);
			StringBuilder query = new StringBuilder();
			if(searchQuery != null && !searchQuery.isEmpty()) {
				searchQuery = searchQuery.replaceAll(" ", "%").concat("%");
				query.append(" and (SalesInvoiceNo LIKE '"+searchQuery+"'");
				query.append(" or CONVERT(VARCHAR,SalesInvoiceDate,103) LIKE '"+searchQuery+"'");
				query.append(" or SalesInvoiceType LIKE '"+searchQuery+"'");
				query.append(" or b.CustFName LIKE '"+searchQuery+"' ");
				query.append(" or c.GSTNo LIKE '"+searchQuery+"' )");
			}
			
			if(startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
				query.append(" and SalesInvoiceDate between '" + DateUtil.sqlFormatterDate(startDate) + "' and DATEADD(SECOND,86399,'" + DateUtil.sqlFormatterDate(endDate) + "')");
			}
			
			return eInvoiceRepo.getPendingInvoiceList(query.toString(), pageable);

		} finally {

		}
	}
	
	public Page<?> getPendingInvoiceItemList(int startIndex, int endIndex, String searchQuery,String salesInvoiceId) throws Exception {
		try {
			int pageNo = startIndex / endIndex;
			Pageable pageable = PageRequest.of(pageNo, endIndex);
			return eInvoiceRepo.getPendingInvoiceItemList(searchQuery, pageable,salesInvoiceId);

		} finally {

		}
	}

	public byte[] getPrepareJsonFileInvoice(String invoiceId) throws JsonProcessingException, SQLException {
		SalesInvoiceModel invoice = eInvoiceRepo.getTranDtlsAndDocDetails(invoiceId);
		BuyerDtls buyerDetail = eInvoiceRepo.getCustomerDetails(invoice.getCustId());
		System.out.println(buyerDetail);
		List<ItemList> itemList = eInvoiceRepo.getPendingInvoiceItemListForJson(invoiceId);
		ValDtls valDetls = eInvoiceRepo.getInvoiceValueDetails(invoiceId);
		valDetls.setOthChrg(invoice.getOthChrg());
		valDetls.setRndOffAmt(invoice.getRndOffAmt());
		
		TranDtls transDet = new TranDtls();
		transDet.setSupTyp("B2B");
		transDet.setTaxSch("GST");
		transDet.setIgstOnIntra(invoice.getSalesInvoiceType().equalsIgnoreCase("local") ? "N" : "Y");
		
		DocDtls docDtls = new DocDtls();
		docDtls.setTyp("INV");
		docDtls.setNo(invoice.getSalesInvoiceNo());
		docDtls.setDt(invoice.getSalesInvoiceDate());
		
		
		ObjectMapper mapper = new ObjectMapper(); 
		AtomicInteger index = new AtomicInteger();
		itemList.forEach(item -> {
			item.setSlNo(index.getAndIncrement()+1+"");
			item.setIsServc(item.getIsServc().equals("0") ? "N" : "Y");
			item.setHsnCd(item.getHsnCd().trim()) ;
		});
		
		if(buyerDetail != null &&  (buyerDetail.getAddrone() == null || buyerDetail.getAddrone().isEmpty())) {
			buyerDetail.setAddrone(buyerDetail.getCustaddress());
			buyerDetail.setAddrtwo(buyerDetail.getCustaddress());
		}
		
		List<Root> rootList = new ArrayList<Root>();
		Root root = new Root();
		root.setItemList(itemList);
		root.setBuyerDtls(buyerDetail);
		root.setSellerDtls(new SellerDtls());
		root.setTranDtls(transDet);
		root.setDocDtls(docDtls);
		root.setValDtls(valDetls);
		rootList.add(root);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(rootList);
	}

}

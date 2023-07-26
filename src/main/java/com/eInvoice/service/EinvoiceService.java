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

	public byte[] getPrepareJsonFileInvoice(String invoiceId) throws Exception {
		
		
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
		
		if(buyerDetail != null &&  (buyerDetail.getAddrone() == null || buyerDetail.getAddrone().isEmpty())) {
			buyerDetail.setAddrone(buyerDetail.getCustaddress());
			buyerDetail.setAddrtwo(buyerDetail.getCustaddress());
		}
		
		if(null == docDtls.getNo() || docDtls.getNo().trim().equals("")) {
			throw new Exception("Invoice number not available for "+invoice.getSalesInvoiceNo());
		}
		if(null == docDtls.getDt() || docDtls.getDt().trim().equals("")) {
			throw new Exception("Invoice date not available for "+invoice.getSalesInvoiceNo());
		}
		if (null == buyerDetail.getGstin() || buyerDetail.getGstin().trim().equals("")) {
			throw new Exception("Buyer's GSTIN is not available for "+invoice.getSalesInvoiceNo());
		}
		if (null == buyerDetail.getLglNm() || buyerDetail.getLglNm().trim().equals("")) {
			throw new Exception("Buyer's legal name is not available for "+invoice.getSalesInvoiceNo());
		}
		if (null == buyerDetail.getPos() || buyerDetail.getPos().trim().equals("")) {
			throw new Exception("Buyer's point of sell(pos) is not available for "+invoice.getSalesInvoiceNo());
		}
		if (null == buyerDetail.getAddrone() || buyerDetail.getAddrone().trim().equals("")) {
			throw new Exception("Buyer's address is not available for "+invoice.getSalesInvoiceNo());
		}
		if (null == buyerDetail.getLoc() || buyerDetail.getLoc().trim().equals("")) {
			throw new Exception("Buyer's location is not available for "+invoice.getSalesInvoiceNo());
		} 
		if (null == buyerDetail.getStcd() || buyerDetail.getStcd().trim().equals("")) {
			throw new Exception("Buyer's state code is not available for "+invoice.getSalesInvoiceNo());
		}
		
		
		AtomicInteger index = new AtomicInteger();
		for(ItemList item : itemList) {
			item.setSlNo(index.getAndIncrement()+1+"");
			item.setIsServc((item.getIsServc() == null || item.getIsServc().equals("0")) ? "N" : "Y");
			
			if(null == item.getHsnCd() || item.getHsnCd().trim().equals("")) {
				throw new Exception("HSN code not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
			item.setHsnCd(item.getHsnCd().trim()) ;
			
			if(null == item.getUnitPrice()) {
				throw new Exception("Unit price not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
			if(null == item.getTotAmt()) {
				throw new Exception("Total amount not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
			if(null == item.getAssAmt()) {
				throw new Exception("Assessable amount not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
			if(null == item.getGstRt()) {
				throw new Exception("GST rate not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
			if(null == item.getTotItemVal()) {
				throw new Exception("Total item value not available in SL No "+item.getSlNo()+" for "+invoice.getSalesInvoiceNo());
			}
		}
		
		
		if(null == valDetls.getAssVal()) {
			throw new Exception("Total assessable value not available for "+invoice.getSalesInvoiceNo());
		}
		if(null == valDetls.getTotInvVal()) {
			throw new Exception("Total invoice value not available for "+invoice.getSalesInvoiceNo());
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

	public void saveInvoiceDownloadFlag(String invoiceList) throws Exception{

		try {

			eInvoiceRepo.saveInvoiceDownloadFlag(invoiceList);
			
		} finally {

		}
	}

}

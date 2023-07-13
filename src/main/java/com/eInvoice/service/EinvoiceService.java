package com.eInvoice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eInvoice.models.ItemList;
import com.eInvoice.models.Root;
import com.eInvoice.repo.EinvoiceRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EinvoiceService {

	@Autowired
	private EinvoiceRepo eInvoiceRepo;

	public Page<?> getPendingInvoiceList(int startIndex, int endIndex, String searchQuery) throws Exception {
		try {

			int pageNo = startIndex / endIndex;
			Pageable pageable = PageRequest.of(pageNo, endIndex);

			return eInvoiceRepo.getPendingInvoiceList(searchQuery, pageable);

		} finally {

		}
	}
	
	public Page<?> getPendingInvoiceItemList(int startIndex, int endIndex, String searchQuery) throws Exception {
		try {
			int pageNo = startIndex / endIndex;
			Pageable pageable = PageRequest.of(pageNo, endIndex);
			return eInvoiceRepo.getPendingInvoiceItemList(searchQuery, pageable);

		} finally {

		}
	}

	public byte[] getPrepareJsonFileInvoice(String invoiceId) throws JsonProcessingException, SQLException {
		List<ItemList> itemList = eInvoiceRepo.getPendingInvoiceItemListForJson(invoiceId);
		ObjectMapper mapper = new ObjectMapper(); 
		AtomicInteger index = new AtomicInteger();
		itemList.forEach(item -> {
			item.setSlNo(index.getAndIncrement()+1+"");
			item.setIsServc(item.getIsServc().equals("0") ? "N" : "Y");
		});
		Root root = new Root();
		root.setItemList(itemList);
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(root);
	}

}

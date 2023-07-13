package com.eInvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eInvoice.models.Root;
import com.eInvoice.repo.EinvoiceRepo;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

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

	public byte[] getPrepareJsonFileInvoice(String invoiceId) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); 
		Root[] root = new Root[1];
		root[0] = new Root();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(root);
	}

}

package com.eInvoice.controller;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eInvoice.models.DataTableDTO;
import com.eInvoice.service.EinvoiceService;

@Controller
public class EinvoiceController {
	
	private static Logger log = Logger.getLogger(EinvoiceController.class);

	@Autowired
	private EinvoiceService eInvoiceservice;
	
	
	@GetMapping("/getPendingInvoiceList")
	@ResponseBody
	public DataTableDTO getPendingInvoiceList(Integer start, Integer length, Integer draw, @RequestParam(name = "search[value]", required = false, defaultValue = "") String searchQuery){
		
		try {
			
			int startIndex =  start == null ? 0 : start;
			int endIndex = length == null ? 20 : length;
			int drawLen = draw == null ? 0 : draw;
			
			return DataTableDTO.toDataTable(eInvoiceservice.getPendingInvoiceList(startIndex, endIndex, searchQuery), drawLen, startIndex);
		} catch (Exception e) {
			log.error("Exception Occured in getPendingInvoiceList : ", e);
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping("/getPendingInvoiceItemList/{salesInvoiceId}")
	@ResponseBody
	public DataTableDTO getPendingInvoiceItemList(Integer start, Integer length, Integer draw, @RequestParam(name = "search[value]", required = false, defaultValue = "") String searchQuery,@PathVariable(name = "salesInvoiceId") String salesInvoiceId){
		
		try {
			
			int startIndex =  start == null ? 0 : start;
			int endIndex = length == null ? 20 : length;
			int drawLen = draw == null ? 0 : draw;
			
			return DataTableDTO.toDataTable(eInvoiceservice.getPendingInvoiceItemList(startIndex, endIndex, searchQuery,salesInvoiceId), drawLen, startIndex);
		} catch (Exception e) {
			log.error("Exception Occured in getPendingInvoiceItemList : ", e);
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getPrepareJsonFileInvoice")
	@ResponseBody
	public ResponseEntity<?> getPrepareJsonFileInvoice(@RequestParam(name = "salesInvoiceId", required = true) String invoiceId,@RequestParam(name = "salesInvoiceNo", required = true) String invoiceNo){
		try {
			
			byte[] buf = eInvoiceservice.getPrepareJsonFileInvoice(invoiceId);

			return ResponseEntity
			        .ok()
			        .contentLength(buf.length)
			        .contentType(
			                MediaType.parseMediaType("application/octet-stream"))
			        .header("Content-Disposition", "attachment; filename="+invoiceNo+".json")
			        .body(new InputStreamResource(new ByteArrayInputStream(buf)));
		} catch (Exception e) {
			log.error("Exception Occured in getPendingInvoiceList : ", e);
			e.printStackTrace();
			return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

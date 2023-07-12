package com.eInvoice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public DataTableDTO getPotentialConnetionList(Integer start, Integer length, Integer draw, @RequestParam(name = "search[value]", required = false, defaultValue = "") String searchQuery){
		
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
	
	
}

package com.eInvoice.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public DataTableDTO getPendingInvoiceList(Integer start, Integer length, Integer draw, @RequestParam(name = "search[value]", required = false, defaultValue = "") String searchQuery,String startDate,String endDate){
		
		try {
			int startIndex =  start == null ? 0 : start;
			int endIndex = length == null ? 20 : length;
			int drawLen = draw == null ? 0 : draw;
			
			return DataTableDTO.toDataTable(eInvoiceservice.getPendingInvoiceList(startIndex, endIndex, searchQuery,startDate,endDate), drawLen, startIndex);
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
	
	@PostMapping("/getPrepareJsonFileInvoice")
	public ResponseEntity<?> getPrepareJsonFileInvoice(HttpServletResponse resp, @RequestParam(name = "salesInvoiceId[]") List<String> invoiceList,@RequestParam(name = "salesInvoiceNo", required = false) String invoiceNo ) throws Exception{
		try {
			
			
			
//			List<String> invoiceList = new ArrayList<String>();
//			invoiceList.add(invoiceId);
			
			OutputStream out  =  resp.getOutputStream();
				ZipOutputStream zos = new ZipOutputStream(out);
				for(String invoiceId1  : invoiceList) {
					zos.putNextEntry(new ZipEntry(invoiceId1+".json"));
					zos.write(eInvoiceservice.getPrepareJsonFileInvoice(invoiceId1));
	   				zos.closeEntry();
				}
				resp.setContentType("application/zip;charset=UTF-8");
				resp.setHeader("Content-Disposition", "attachment; filename=eInvoice.zip");
				zos.flush();
				zos.close();
				out.close();
			
			return ResponseEntity.ok(resp);
			
		} catch (Exception e) {
			log.error("Exception Occured in getPendingInvoiceList : ", e);
			e.printStackTrace();
			return new ResponseEntity<>(ExceptionUtils.getRootCauseMessage(e),HttpStatus.INTERNAL_SERVER_ERROR);
//			throw new Exception( e.getCause());
		}
	}
	
	
}

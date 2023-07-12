package com.eInvoice.models;

import java.io.Serializable;

public class SalesInvoiceModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer SalesInvoiceId;
	private String SalesInvoiceNo;
	private String SalesInvoiceDate;

	public SalesInvoiceModel() {
		// TODO Auto-generated constructor stub
	}

	public SalesInvoiceModel(Integer salesInvoiceId, String salesInvoiceNo, String salesInvoiceDate) {
		super();
		this.SalesInvoiceId = salesInvoiceId;
		SalesInvoiceNo = salesInvoiceNo;
		SalesInvoiceDate = salesInvoiceDate;
	}

	public Integer getSalesInvoiceId() {
		return SalesInvoiceId;
	}

	public void setSalesInvoiceId(Integer SalesInvoiceId) {
		this.SalesInvoiceId = SalesInvoiceId;
	}

	public String getSalesInvoiceNo() {
		return SalesInvoiceNo;
	}

	public void setSalesInvoiceNo(String salesInvoiceNo) {
		SalesInvoiceNo = salesInvoiceNo;
	}

	public String getSalesInvoiceDate() {
		return SalesInvoiceDate;
	}

	public void setSalesInvoiceDate(String salesInvoiceDate) {
		SalesInvoiceDate = salesInvoiceDate;
	}

	@Override
	public String toString() {
		return "SalesInvoiceModel [SalesInvoiceId=" + SalesInvoiceId + ", SalesInvoiceNo=" + SalesInvoiceNo
				+ ", SalesInvoiceDate=" + SalesInvoiceDate + "]";
	}

}

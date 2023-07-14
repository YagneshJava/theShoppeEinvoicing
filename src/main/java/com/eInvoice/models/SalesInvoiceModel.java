package com.eInvoice.models;

import java.io.Serializable;

public class SalesInvoiceModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer SalesInvoiceId;
	private String SalesInvoiceNo;
	private String SalesInvoiceDate;
	private int Total;
	private String CustId;
	private String CustFName;
	private int OthChrg;
	private int RndOffAmt;
	private String SalesInvoiceType;

	public Integer getSalesInvoiceId() {
		return SalesInvoiceId;
	}

	public void setSalesInvoiceId(Integer salesInvoiceId) {
		SalesInvoiceId = salesInvoiceId;
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

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String custId) {
		CustId = custId;
	}

	public String getCustFName() {
		return CustFName;
	}

	public void setCustFName(String custFName) {
		CustFName = custFName;
	}

	public int getOthChrg() {
		return OthChrg;
	}

	public void setOthChrg(int othChrg) {
		OthChrg = othChrg;
	}

	public int getRndOffAmt() {
		return RndOffAmt;
	}

	public void setRndOffAmt(int rndOffAmt) {
		RndOffAmt = rndOffAmt;
	}

	public String getSalesInvoiceType() {
		return SalesInvoiceType;
	}

	public void setSalesInvoiceType(String salesInvoiceType) {
		SalesInvoiceType = salesInvoiceType;
	}

	@Override
	public String toString() {
		return "SalesInvoiceModel [SalesInvoiceId=" + SalesInvoiceId + ", SalesInvoiceNo=" + SalesInvoiceNo
				+ ", SalesInvoiceDate=" + SalesInvoiceDate + ", Total=" + Total + ", CustId=" + CustId + ", CustFName="
				+ CustFName + ", OthChrg=" + OthChrg + ", RndOffAmt=" + RndOffAmt + ", SalesInvoiceType="
				+ SalesInvoiceType + "]";
	}

}

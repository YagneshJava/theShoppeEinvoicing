package com.eInvoice.models;

import java.io.Serializable;

public class SalesInvoiceModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer SalesInvoiceId;
	private String SalesInvoiceNo;
	private String SalesInvoiceDate;
	private Integer Total;
	private String CustId;
	private String CustFName;
	private Double OthChrg;
	private Double RndOffAmt;
	private String SalesInvoiceType;
	private String CustGSTNo;

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

	public Integer getTotal() {
		return Total;
	}

	public void setTotal(Integer total) {
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

	public Double getOthChrg() {
		return OthChrg;
	}

	public void setOthChrg(Double othChrg) {
		OthChrg = othChrg;
	}

	public Double getRndOffAmt() {
		return RndOffAmt;
	}

	public void setRndOffAmt(Double rndOffAmt) {
		RndOffAmt = rndOffAmt;
	}

	public String getSalesInvoiceType() {
		return SalesInvoiceType;
	}

	public void setSalesInvoiceType(String salesInvoiceType) {
		SalesInvoiceType = salesInvoiceType;
	}

	public String getCustGSTNo() {
		return CustGSTNo;
	}

	public void setCustGSTNo(String custGSTNo) {
		CustGSTNo = custGSTNo;
	}

	@Override
	public String toString() {
		return "SalesInvoiceModel [SalesInvoiceId=" + SalesInvoiceId + ", SalesInvoiceNo=" + SalesInvoiceNo
				+ ", SalesInvoiceDate=" + SalesInvoiceDate + ", Total=" + Total + ", CustId=" + CustId + ", CustFName="
				+ CustFName + ", OthChrg=" + OthChrg + ", RndOffAmt=" + RndOffAmt + ", SalesInvoiceType="
				+ SalesInvoiceType + ", CustGSTNo=" + CustGSTNo + "]";
	}

}

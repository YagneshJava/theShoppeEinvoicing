package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ValDtls {
	@JsonProperty("AssVal")
	private Double AssVal;
	@JsonProperty("IgstVal")
	private Double IgstVal;
	@JsonProperty("CgstVal")
	private Double CgstVal;
	@JsonProperty("SgstVal")
	private Double SgstVal;
	@JsonProperty("CesVal")
	private Double CesVal;
	@JsonProperty("StCesVal")
	private Double StCesVal;
	@JsonProperty("Discount")
	private Double Discount;
	@JsonProperty("OthChrg")
	private Double OthChrg;
	@JsonProperty("RndOffAmt")
	private Double RndOffAmt;
	@JsonProperty("TotInvVal")
	private Double TotInvVal;

	public Double getAssVal() {
		return AssVal;
	}

	public void setAssVal(Double assVal) {
		AssVal = assVal;
	}

	public Double getIgstVal() {
		return IgstVal;
	}

	public void setIgstVal(Double igstVal) {
		IgstVal = igstVal;
	}

	public Double getCgstVal() {
		return CgstVal;
	}

	public void setCgstVal(Double cgstVal) {
		CgstVal = cgstVal;
	}

	public Double getSgstVal() {
		return SgstVal;
	}

	public void setSgstVal(Double sgstVal) {
		SgstVal = sgstVal;
	}

	public Double getCesVal() {
		return CesVal;
	}

	public void setCesVal(Double cesVal) {
		CesVal = cesVal;
	}

	public Double getStCesVal() {
		return StCesVal;
	}

	public void setStCesVal(Double stCesVal) {
		StCesVal = stCesVal;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
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

	public Double getTotInvVal() {
		return TotInvVal;
	}

	public void setTotInvVal(Double totInvVal) {
		TotInvVal = totInvVal;
	}

	@Override
	public String toString() {
		return "ValDtls [AssVal=" + AssVal + ", IgstVal=" + IgstVal + ", CgstVal=" + CgstVal + ", SgstVal=" + SgstVal
				+ ", CesVal=" + CesVal + ", StCesVal=" + StCesVal + ", Discount=" + Discount + ", OthChrg=" + OthChrg
				+ ", RndOffAmt=" + RndOffAmt + ", TotInvVal=" + TotInvVal + "]";
	}

}
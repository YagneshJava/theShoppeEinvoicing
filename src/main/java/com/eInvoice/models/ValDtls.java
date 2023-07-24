package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ValDtls {
	@JsonProperty("AssVal")
	private double AssVal;
	@JsonProperty("IgstVal")
	private double IgstVal;
	@JsonProperty("CgstVal")
	private double CgstVal;
	@JsonProperty("SgstVal")
	private double SgstVal;
	@JsonProperty("CesVal")
	private double CesVal;
	@JsonProperty("StCesVal")
	private double StCesVal;
	@JsonProperty("Discount")
	private double Discount;
	@JsonProperty("OthChrg")
	private double OthChrg;
	@JsonProperty("RndOffAmt")
	private double RndOffAmt;
	@JsonProperty("TotInvVal")
	private double TotInvVal;

	public double getAssVal() {
		return AssVal;
	}

	public void setAssVal(double assVal) {
		AssVal = assVal;
	}

	public double getIgstVal() {
		return IgstVal;
	}

	public void setIgstVal(double igstVal) {
		IgstVal = igstVal;
	}

	public double getCgstVal() {
		return CgstVal;
	}

	public void setCgstVal(double cgstVal) {
		CgstVal = cgstVal;
	}

	public double getSgstVal() {
		return SgstVal;
	}

	public void setSgstVal(double sgstVal) {
		SgstVal = sgstVal;
	}

	public double getCesVal() {
		return CesVal;
	}

	public void setCesVal(double cesVal) {
		CesVal = cesVal;
	}

	public double getStCesVal() {
		return StCesVal;
	}

	public void setStCesVal(double stCesVal) {
		StCesVal = stCesVal;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

	public double getOthChrg() {
		return OthChrg;
	}

	public void setOthChrg(double othChrg) {
		OthChrg = othChrg;
	}

	public double getRndOffAmt() {
		return RndOffAmt;
	}

	public void setRndOffAmt(double rndOffAmt) {
		RndOffAmt = rndOffAmt;
	}

	public double getTotInvVal() {
		return TotInvVal;
	}

	public void setTotInvVal(double totInvVal) {
		TotInvVal = totInvVal;
	}

	@Override
	public String toString() {
		return "ValDtls [AssVal=" + AssVal + ", IgstVal=" + IgstVal + ", CgstVal=" + CgstVal + ", SgstVal=" + SgstVal
				+ ", CesVal=" + CesVal + ", StCesVal=" + StCesVal + ", Discount=" + Discount + ", OthChrg=" + OthChrg
				+ ", RndOffAmt=" + RndOffAmt + ", TotInvVal=" + TotInvVal + "]";
	}

}
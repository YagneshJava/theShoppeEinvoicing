package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ValDtls {
	@JsonProperty("AssVal")
	private int AssVal;
	@JsonProperty("IgstVal")
	private int IgstVal;
	@JsonProperty("CgstVal")
	private int CgstVal;
	@JsonProperty("SgstVal")
	private int SgstVal;
	@JsonProperty("CesVal")
	private int CesVal;
	@JsonProperty("StCesVal")
	private int StCesVal;
	@JsonProperty("Discount")
	private int Discount;
	@JsonProperty("OthChrg")
	private int OthChrg;
	@JsonProperty("RndOffAmt")
	private int RndOffAmt;
	@JsonProperty("TotInvVal")
	private int TotInvVal;

	public int getAssVal() {
		return AssVal;
	}

	public void setAssVal(int assVal) {
		AssVal = assVal;
	}

	public int getIgstVal() {
		return IgstVal;
	}

	public void setIgstVal(int igstVal) {
		IgstVal = igstVal;
	}

	public int getCgstVal() {
		return CgstVal;
	}

	public void setCgstVal(int cgstVal) {
		CgstVal = cgstVal;
	}

	public int getSgstVal() {
		return SgstVal;
	}

	public void setSgstVal(int sgstVal) {
		SgstVal = sgstVal;
	}

	public int getCesVal() {
		return CesVal;
	}

	public void setCesVal(int cesVal) {
		CesVal = cesVal;
	}

	public int getStCesVal() {
		return StCesVal;
	}

	public void setStCesVal(int stCesVal) {
		StCesVal = stCesVal;
	}

	public int getDiscount() {
		return Discount;
	}

	public void setDiscount(int discount) {
		Discount = discount;
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

	public int getTotInvVal() {
		return TotInvVal;
	}

	@Override
	public String toString() {
		return "ValDtls [AssVal=" + AssVal + ", IgstVal=" + IgstVal + ", CgstVal=" + CgstVal + ", SgstVal=" + SgstVal
				+ ", CesVal=" + CesVal + ", StCesVal=" + StCesVal + ", Discount=" + Discount + ", OthChrg=" + OthChrg
				+ ", RndOffAmt=" + RndOffAmt + ", TotInvVal=" + TotInvVal + "]";
	}

	public void setTotInvVal(int totInvVal) {
		TotInvVal = totInvVal;
	}

}
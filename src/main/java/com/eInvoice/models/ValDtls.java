package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValDtls {
	@JsonProperty("AssVal")
	private int assVal;
	@JsonProperty("IgstVal")
	private int igstVal;
	@JsonProperty("CgstVal")
	private int cgstVal;
	@JsonProperty("SgstVal")
	private int sgstVal;
	@JsonProperty("CesVal")
	private int cesVal;
	@JsonProperty("StCesVal")
	private int stCesVal;
	@JsonProperty("Discount")
	private int discount;
	@JsonProperty("OthChrg")
	private int othChrg;
	@JsonProperty("RndOffAmt")
	private int rndOffAmt;
	@JsonProperty("TotInvVal")
	private int totInvVal;
}
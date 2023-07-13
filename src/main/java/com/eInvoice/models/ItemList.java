package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemList {
	@JsonProperty("SlNo")
	private String slNo;
	@JsonProperty("PrdDesc")
	private String prdDesc;
	@JsonProperty("IsServc")
	private String isServc;
	@JsonProperty("HsnCd")
	private String hsnCd;
	@JsonProperty("Barcde")
	private String barcde;
	@JsonProperty("Qty")
	private int qty;
	@JsonProperty("FreeQty")
	private int freeQty;
	@JsonProperty("Unit")
	private String unit;
	@JsonProperty("UnitPrice")
	private int unitPrice;
	@JsonProperty("TotAmt")
	private int totAmt;
	@JsonProperty("Discount")
	private int discount;
	@JsonProperty("PreTaxVal")
	private int preTaxVal;
	@JsonProperty("AssAmt")
	private int assAmt;
	@JsonProperty("GstRt")
	private int gstRt;
	@JsonProperty("IgstAmt")
	private int igstAmt;
	@JsonProperty("CgstAmt")
	private int cgstAmt;
	@JsonProperty("SgstAmt")
	private int sgstAmt;
	@JsonProperty("CesRt")
	private int cesRt;
	@JsonProperty("CesAmt")
	private int cesAmt;
	@JsonProperty("CesNonAdvlAmt")
	private int cesNonAdvlAmt;
	@JsonProperty("StateCesRt")
	private int stateCesRt;
	@JsonProperty("StateCesAmt")
	private int stateCesAmt;
	@JsonProperty("StateCesNonAdvlAmt")
	private int stateCesNonAdvlAmt;
	@JsonProperty("OthChrg")
	private int othChrg;
	@JsonProperty("TotItemVal")
	private int totItemVal;
	@JsonProperty("BchDtls")
	private BchDtls bchDtls;
	@JsonProperty("AttribDtls")
	private AttribDtls attribDtls;
}
package com.eInvoice.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	@JsonProperty("Version")
	private String version = "1.1";
	@JsonProperty("TranDtls")
	private TranDtls tranDtls;
	@JsonProperty("DocDtls")
	private DocDtls docDtls;
	@JsonProperty("SellerDtls")
	private SellerDtls sellerDtls;
	@JsonProperty("BuyerDtls")
	private BuyerDtls buyerDtls;
	@JsonProperty("DispDtls")
	private DispDtls dispDtls;
	@JsonProperty("ShipDtls")
	private ShipDtls shipDtls;
	@JsonProperty("ValDtls")
	private ValDtls valDtls;
	@JsonProperty("EwbDtls")
	private Object ewbDtls;
	@JsonProperty("ItemList")
	private ArrayList<ItemList> itemList;
}

package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellerDtls {
	@JsonProperty("Gstin")
	private String gstin;
	@JsonProperty("LglNm")
	private String lglNm;
	@JsonProperty("TrdNm")
	private String trdNm;
	@JsonProperty("Addr1")
	private String addr1;
	@JsonProperty("Addr2")
	private String addr2;
	@JsonProperty("Loc")
	private String loc;
	@JsonProperty("Pin")
	private int pin;
	@JsonProperty("Stcd")
	private String stcd;
	@JsonProperty("Ph")
	private String ph;
	@JsonProperty("Em")
	private String em;
}

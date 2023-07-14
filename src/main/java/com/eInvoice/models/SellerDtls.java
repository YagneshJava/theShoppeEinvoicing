package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellerDtls {
	@JsonProperty("Gstin")
	private String gstin = "24AABFT5812E1ZK";
	@JsonProperty("LglNm")
	private String lglNm = "THE SHOPPE";
	@JsonProperty("TrdNm")
	private String trdNm = "THE SHOPPE";
	@JsonProperty("Addr1")
	private String addr1="DIVYA SIDDHI";
	@JsonProperty("Addr2")
	private String addr2="NR NATUBHAI CIRCLE";
	@JsonProperty("Loc")
	private String loc="GOTRI, VADODARA";
	@JsonProperty("Pin")
	private int pin=390007;
	@JsonProperty("Stcd")
	private String stcd="24";
	@JsonProperty("Ph")
	private String ph="6357776822";
	@JsonProperty("Em")
	private String em="shoppebaroda@gmail.com";
}

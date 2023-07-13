package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipDtls {

	@JsonProperty("Nm")
	private String gstin;
	@JsonProperty("LglNm")
	private String lglnm;
	@JsonProperty("TrdNm")
	private String trdnm;
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

}

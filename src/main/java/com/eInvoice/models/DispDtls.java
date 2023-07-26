package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DispDtls {

	@JsonProperty("Nm")
	private String nm;
	@JsonProperty("Addr1")
	private String addr1;
	@JsonProperty("Addr2")
	private String addr2;
	@JsonProperty("Loc")
	private String loc;
	@JsonProperty("Pin")
	private Integer pin;
	@JsonProperty("Stcd")
	private String stcd;

}

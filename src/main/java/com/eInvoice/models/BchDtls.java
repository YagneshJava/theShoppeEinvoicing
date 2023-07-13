package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BchDtls {

	@JsonProperty("Nm")
	private String nm;
	@JsonProperty("ExpDt")
	private String expDt;
	@JsonProperty("WrDt")
	private String wrDt;
}

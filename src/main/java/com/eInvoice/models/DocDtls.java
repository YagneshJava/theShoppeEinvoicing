package com.eInvoice.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocDtls {
	@JsonProperty("Typ")
	private String typ;
	@JsonProperty("No")
	private String no;
	@JsonProperty("Dt")
	private String dt;
}

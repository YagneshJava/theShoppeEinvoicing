package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranDtls {
	@JsonProperty("TaxSch")
	private String taxSch;
	@JsonProperty("SupTyp")
	private String supTyp;
	@JsonProperty("IgstOnIntra")
	private String igstOnIntra;
	@JsonProperty("RegRev")
	private String regRev;
	@JsonProperty("EcmGstin")
	private String ecmGstin;
}
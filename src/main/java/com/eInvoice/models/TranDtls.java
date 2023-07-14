package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class TranDtls {
	@JsonProperty("TaxSch")
	private String TaxSch;
	@JsonProperty("SupTyp")
	private String SupTyp;
	@JsonProperty("IgstOnIntra")
	private String IgstOnIntra;
	@JsonProperty("RegRev")
	private String RegRev;
	@JsonProperty("EcmGstin")
	private String EcmGstin;

	public String getTaxSch() {
		return TaxSch;
	}

	public void setTaxSch(String taxSch) {
		TaxSch = taxSch;
	}

	public String getSupTyp() {
		return SupTyp;
	}

	public void setSupTyp(String supTyp) {
		SupTyp = supTyp;
	}

	public String getIgstOnIntra() {
		return IgstOnIntra;
	}

	public void setIgstOnIntra(String igstOnIntra) {
		IgstOnIntra = igstOnIntra;
	}

	public String getRegRev() {
		return RegRev;
	}

	public void setRegRev(String regRev) {
		RegRev = regRev;
	}

	public String getEcmGstin() {
		return EcmGstin;
	}

	public void setEcmGstin(String ecmGstin) {
		EcmGstin = ecmGstin;
	}

	@Override
	public String toString() {
		return "TranDtls [TaxSch=" + TaxSch + ", SupTyp=" + SupTyp + ", IgstOnIntra=" + IgstOnIntra + ", RegRev="
				+ RegRev + ", EcmGstin=" + EcmGstin + "]";
	}

}
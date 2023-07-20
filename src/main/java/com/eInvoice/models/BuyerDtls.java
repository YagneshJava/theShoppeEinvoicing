package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class BuyerDtls {
	@JsonProperty("Gstin")
	private String Gstin;
	@JsonProperty("LglNm")
	private String LglNm;
	@JsonProperty("TrdNm")
	private String TrdNm;
	@JsonProperty("Pos")
	private String Pos;
	@JsonProperty("Addr1")
	private String Addrone;
	@JsonProperty("Addr2")
	private String Addrtwo;
	@JsonProperty("Loc")
	private String Loc;
	@JsonProperty("Pin")
	private int Pin;
	@JsonProperty("Stcd")
	private String Stcd;
	@JsonProperty("Ph")
	private String Ph;
	@JsonProperty("Em")
	private String Em;
	@JsonIgnore
	private String custaddress;

	public String getGstin() {
		return Gstin;
	}

	public void setGstin(String gstin) {
		Gstin = gstin;
	}

	public String getLglNm() {
		return LglNm;
	}

	public void setLglNm(String lglNm) {
		LglNm = lglNm;
	}

	public String getTrdNm() {
		return TrdNm;
	}

	public void setTrdNm(String trdNm) {
		TrdNm = trdNm;
	}

	public String getPos() {
		return Pos;
	}

	public void setPos(String pos) {
		Pos = pos;
	}

	public String getAddrone() {
		return Addrone;
	}

	public void setAddrone(String addrone) {
		Addrone = addrone;
	}

	public String getAddrtwo() {
		return Addrtwo;
	}

	public void setAddrtwo(String addrtwo) {
		Addrtwo = addrtwo;
	}

	public String getLoc() {
		return Loc;
	}

	public void setLoc(String loc) {
		Loc = loc;
	}

	public int getPin() {
		return Pin;
	}

	public void setPin(int pin) {
		Pin = pin;
	}

	public String getStcd() {
		return Stcd;
	}

	public void setStcd(String stcd) {
		Stcd = stcd;
	}

	public String getPh() {
		return Ph;
	}

	public void setPh(String ph) {
		Ph = ph;
	}

	public String getEm() {
		return Em;
	}

	public void setEm(String em) {
		Em = em;
	}

	public String getCustaddress() {
		return custaddress;
	}

	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}

	@Override
	public String toString() {
		return "BuyerDtls [Gstin=" + Gstin + ", LglNm=" + LglNm + ", TrdNm=" + TrdNm + ", Pos=" + Pos + ", Addrone="
				+ Addrone + ", Addrtwo=" + Addrtwo + ", Loc=" + Loc + ", Pin=" + Pin + ", Stcd=" + Stcd + ", Ph=" + Ph
				+ ", Em=" + Em + ", custaddress=" + custaddress + "]";
	}

}

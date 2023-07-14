package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

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
	private String Addr1;
	@JsonProperty("Addr2")
	private String Addr2;
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

	public String getAddr1() {
		return Addr1;
	}

	public void setAddr1(String addr1) {
		Addr1 = addr1;
	}

	public String getAddr2() {
		return Addr2;
	}

	public void setAddr2(String addr2) {
		Addr2 = addr2;
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

}

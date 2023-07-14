package com.eInvoice.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class DocDtls {
	@JsonProperty("Typ")
	private String Typ;
	@JsonProperty("No")
	private String No;
	@JsonProperty("Dt")
	private String Dt;

	public String getTyp() {
		return Typ;
	}

	public void setTyp(String typ) {
		Typ = typ;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public String getDt() {
		return Dt;
	}

	public void setDt(String dt) {
		Dt = dt;
	}

	@Override
	public String toString() {
		return "DocDtls [Typ=" + Typ + ", No=" + No + ", Dt=" + Dt + "]";
	}

}

package com.eInvoice.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class ItemList {

	@JsonProperty("SlNo")
	private String SlNo;
	@JsonProperty("PrdDesc")
	private String PrdDesc;
	@JsonProperty("IsServc")
	private String IsServc;
	@JsonProperty("HsnCd")
	private String HsnCd;
	@JsonProperty("Barcde")
	private String Barcde;
	@JsonProperty("Qty")
	private int Qty;
	@JsonProperty("FreeQty")
	private int FreeQty;
	@JsonProperty("Unit")
	private String Unit;
	@JsonProperty("UnitPrice")
	private double UnitPrice;
	@JsonProperty("TotAmt")
	private double TotAmt;
	@JsonProperty("Discount")
	private double Discount;
	@JsonProperty("PreTaxVal")
	private double PreTaxVal;
	@JsonProperty("AssAmt")
	private double AssAmt;
	@JsonProperty("GstRt")
	private int GstRt;
	@JsonProperty("IgstAmt")
	private double IgstAmt;
	@JsonProperty("CgstAmt")
	private double CgstAmt;
	@JsonProperty("SgstAmt")
	private double SgstAmt;
	@JsonProperty("CesRt")
	private double CesRt;
	@JsonProperty("CesAmt")
	private double CesAmt;
	@JsonProperty("CesNonAdvlAmt")
	private double CesNonAdvlAmt;
	@JsonProperty("StateCesRt")
	private double StateCesRt;
	@JsonProperty("StateCesAmt")
	private double StateCesAmt;
	@JsonProperty("StateCesNonAdvlAmt")
	private double StateCesNonAdvlAmt;
	@JsonProperty("OthChrg")
	private double OthChrg;
	@JsonProperty("TotItemVal")
	private double TotItemVal;
	@JsonProperty("BchDtls")
	private BchDtls BchDtls;
	@JsonProperty("AttribDtls")
	private AttribDtls AttribDtls;

	public String getSlNo() {
		return SlNo;
	}

	public void setSlNo(String slNo) {
		SlNo = slNo;
	}

	public String getPrdDesc() {
		return PrdDesc;
	}

	public void setPrdDesc(String prdDesc) {
		PrdDesc = prdDesc;
	}

	public String getIsServc() {
		return IsServc;
	}

	public void setIsServc(String isServc) {
		IsServc = isServc;
	}

	public String getHsnCd() {
		return HsnCd;
	}

	public void setHsnCd(String hsnCd) {
		HsnCd = hsnCd;
	}

	public String getBarcde() {
		return Barcde;
	}

	public void setBarcde(String barcde) {
		Barcde = barcde;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public int getFreeQty() {
		return FreeQty;
	}

	public void setFreeQty(int freeQty) {
		FreeQty = freeQty;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public double getTotAmt() {
		return TotAmt;
	}

	public void setTotAmt(double totAmt) {
		TotAmt = totAmt;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

	public double getPreTaxVal() {
		return PreTaxVal;
	}

	public void setPreTaxVal(double preTaxVal) {
		PreTaxVal = preTaxVal;
	}

	public double getAssAmt() {
		return AssAmt;
	}

	public void setAssAmt(double assAmt) {
		AssAmt = assAmt;
	}

	public int getGstRt() {
		return GstRt;
	}

	public void setGstRt(int gstRt) {
		GstRt = gstRt;
	}

	public double getIgstAmt() {
		return IgstAmt;
	}

	public void setIgstAmt(double igstAmt) {
		IgstAmt = igstAmt;
	}

	public double getCgstAmt() {
		return CgstAmt;
	}

	public void setCgstAmt(double cgstAmt) {
		CgstAmt = cgstAmt;
	}

	public double getSgstAmt() {
		return SgstAmt;
	}

	public void setSgstAmt(double sgstAmt) {
		SgstAmt = sgstAmt;
	}

	public double getCesRt() {
		return CesRt;
	}

	public void setCesRt(double cesRt) {
		CesRt = cesRt;
	}

	public double getCesAmt() {
		return CesAmt;
	}

	public void setCesAmt(double cesAmt) {
		CesAmt = cesAmt;
	}

	public double getCesNonAdvlAmt() {
		return CesNonAdvlAmt;
	}

	public void setCesNonAdvlAmt(double cesNonAdvlAmt) {
		CesNonAdvlAmt = cesNonAdvlAmt;
	}

	public double getStateCesRt() {
		return StateCesRt;
	}

	public void setStateCesRt(double stateCesRt) {
		StateCesRt = stateCesRt;
	}

	public double getStateCesAmt() {
		return StateCesAmt;
	}

	public void setStateCesAmt(double stateCesAmt) {
		StateCesAmt = stateCesAmt;
	}

	public double getStateCesNonAdvlAmt() {
		return StateCesNonAdvlAmt;
	}

	public void setStateCesNonAdvlAmt(double stateCesNonAdvlAmt) {
		StateCesNonAdvlAmt = stateCesNonAdvlAmt;
	}

	public double getOthChrg() {
		return OthChrg;
	}

	public void setOthChrg(double othChrg) {
		OthChrg = othChrg;
	}

	public double getTotItemVal() {
		return TotItemVal;
	}

	public void setTotItemVal(double totItemVal) {
		TotItemVal = totItemVal;
	}

	public BchDtls getBchDtls() {
		return BchDtls;
	}

	public void setBchDtls(BchDtls bchDtls) {
		BchDtls = bchDtls;
	}

	public AttribDtls getAttribDtls() {
		return AttribDtls;
	}

	public void setAttribDtls(AttribDtls attribDtls) {
		AttribDtls = attribDtls;
	}

	@Override
	public String toString() {
		return "ItemList [SlNo=" + SlNo + ", PrdDesc=" + PrdDesc + ", IsServc=" + IsServc + ", HsnCd=" + HsnCd
				+ ", Barcde=" + Barcde + ", Qty=" + Qty + ", FreeQty=" + FreeQty + ", Unit=" + Unit + ", UnitPrice="
				+ UnitPrice + ", TotAmt=" + TotAmt + ", Discount=" + Discount + ", PreTaxVal=" + PreTaxVal + ", AssAmt="
				+ AssAmt + ", GstRt=" + GstRt + ", IgstAmt=" + IgstAmt + ", CgstAmt=" + CgstAmt + ", SgstAmt=" + SgstAmt
				+ ", CesRt=" + CesRt + ", CesAmt=" + CesAmt + ", CesNonAdvlAmt=" + CesNonAdvlAmt + ", StateCesRt="
				+ StateCesRt + ", StateCesAmt=" + StateCesAmt + ", StateCesNonAdvlAmt=" + StateCesNonAdvlAmt
				+ ", OthChrg=" + OthChrg + ", TotItemVal=" + TotItemVal + ", BchDtls=" + BchDtls + ", AttribDtls="
				+ AttribDtls + "]";
	}

}
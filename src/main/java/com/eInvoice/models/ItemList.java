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
	private Integer Qty;
	@JsonProperty("FreeQty")
	private Integer FreeQty;
	@JsonProperty("Unit")
	private String Unit;
	@JsonProperty("UnitPrice")
	private Double UnitPrice;
	@JsonProperty("TotAmt")
	private Double TotAmt;
	@JsonProperty("Discount")
	private Double Discount;
	@JsonProperty("PreTaxVal")
	private Double PreTaxVal;
	@JsonProperty("AssAmt")
	private Double AssAmt;
	@JsonProperty("GstRt")
	private Integer GstRt;
	@JsonProperty("IgstAmt")
	private Double IgstAmt;
	@JsonProperty("CgstAmt")
	private Double CgstAmt;
	@JsonProperty("SgstAmt")
	private Double SgstAmt;
	@JsonProperty("CesRt")
	private Double CesRt;
	@JsonProperty("CesAmt")
	private Double CesAmt;
	@JsonProperty("CesNonAdvlAmt")
	private Double CesNonAdvlAmt;
	@JsonProperty("StateCesRt")
	private Double StateCesRt;
	@JsonProperty("StateCesAmt")
	private Double StateCesAmt;
	@JsonProperty("StateCesNonAdvlAmt")
	private Double StateCesNonAdvlAmt;
	@JsonProperty("OthChrg")
	private Double OthChrg;
	@JsonProperty("TotItemVal")
	private Double TotItemVal;
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

	public Integer getQty() {
		return Qty;
	}

	public void setQty(Integer qty) {
		Qty = qty;
	}

	public Integer getFreeQty() {
		return FreeQty;
	}

	public void setFreeQty(Integer freeQty) {
		FreeQty = freeQty;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public Double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}

	public Double getTotAmt() {
		return TotAmt;
	}

	public void setTotAmt(Double totAmt) {
		TotAmt = totAmt;
	}

	public Double getDiscount() {
		return Discount;
	}

	public void setDiscount(Double discount) {
		Discount = discount;
	}

	public Double getPreTaxVal() {
		return PreTaxVal;
	}

	public void setPreTaxVal(Double preTaxVal) {
		PreTaxVal = preTaxVal;
	}

	public Double getAssAmt() {
		return AssAmt;
	}

	public void setAssAmt(Double assAmt) {
		AssAmt = assAmt;
	}

	public Integer getGstRt() {
		return GstRt;
	}

	public void setGstRt(Integer gstRt) {
		GstRt = gstRt;
	}

	public Double getIgstAmt() {
		return IgstAmt;
	}

	public void setIgstAmt(Double igstAmt) {
		IgstAmt = igstAmt;
	}

	public Double getCgstAmt() {
		return CgstAmt;
	}

	public void setCgstAmt(Double cgstAmt) {
		CgstAmt = cgstAmt;
	}

	public Double getSgstAmt() {
		return SgstAmt;
	}

	public void setSgstAmt(Double sgstAmt) {
		SgstAmt = sgstAmt;
	}

	public Double getCesRt() {
		return CesRt;
	}

	public void setCesRt(Double cesRt) {
		CesRt = cesRt;
	}

	public Double getCesAmt() {
		return CesAmt;
	}

	public void setCesAmt(Double cesAmt) {
		CesAmt = cesAmt;
	}

	public Double getCesNonAdvlAmt() {
		return CesNonAdvlAmt;
	}

	public void setCesNonAdvlAmt(Double cesNonAdvlAmt) {
		CesNonAdvlAmt = cesNonAdvlAmt;
	}

	public Double getStateCesRt() {
		return StateCesRt;
	}

	public void setStateCesRt(Double stateCesRt) {
		StateCesRt = stateCesRt;
	}

	public Double getStateCesAmt() {
		return StateCesAmt;
	}

	public void setStateCesAmt(Double stateCesAmt) {
		StateCesAmt = stateCesAmt;
	}

	public Double getStateCesNonAdvlAmt() {
		return StateCesNonAdvlAmt;
	}

	public void setStateCesNonAdvlAmt(Double stateCesNonAdvlAmt) {
		StateCesNonAdvlAmt = stateCesNonAdvlAmt;
	}

	public Double getOthChrg() {
		return OthChrg;
	}

	public void setOthChrg(Double othChrg) {
		OthChrg = othChrg;
	}

	public Double getTotItemVal() {
		return TotItemVal;
	}

	public void setTotItemVal(Double totItemVal) {
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
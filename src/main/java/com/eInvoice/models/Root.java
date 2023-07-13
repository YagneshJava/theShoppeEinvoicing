package com.eInvoice.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, creatorVisibility=JsonAutoDetect.Visibility.NONE)
public class Root {
	@JsonProperty("Version")
	private String Version = "1.1";
	@JsonProperty("TranDtls")
	private TranDtls TranDtls;
	@JsonProperty("DocDtls")
	private DocDtls DocDtls;
	@JsonProperty("SellerDtls")
	private SellerDtls SellerDtls;
	@JsonProperty("BuyerDtls")
	private BuyerDtls BuyerDtls;
	@JsonProperty("DispDtls")
	private DispDtls DispDtls;
	@JsonProperty("ShipDtls")
	private ShipDtls ShipDtls;
	@JsonProperty("ValDtls")
	private ValDtls ValDtls;
	@JsonProperty("EwbDtls")
	private Object EwbDtls;
	@JsonProperty("ItemList")
	private List<ItemList> ItemList;

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public TranDtls getTranDtls() {
		return TranDtls;
	}

	public void setTranDtls(TranDtls tranDtls) {
		TranDtls = tranDtls;
	}

	public DocDtls getDocDtls() {
		return DocDtls;
	}

	public void setDocDtls(DocDtls docDtls) {
		DocDtls = docDtls;
	}

	public SellerDtls getSellerDtls() {
		return SellerDtls;
	}

	public void setSellerDtls(SellerDtls sellerDtls) {
		SellerDtls = sellerDtls;
	}

	public BuyerDtls getBuyerDtls() {
		return BuyerDtls;
	}

	public void setBuyerDtls(BuyerDtls buyerDtls) {
		BuyerDtls = buyerDtls;
	}

	public DispDtls getDispDtls() {
		return DispDtls;
	}

	public void setDispDtls(DispDtls dispDtls) {
		DispDtls = dispDtls;
	}

	public ShipDtls getShipDtls() {
		return ShipDtls;
	}

	public void setShipDtls(ShipDtls shipDtls) {
		ShipDtls = shipDtls;
	}

	public ValDtls getValDtls() {
		return ValDtls;
	}

	public void setValDtls(ValDtls valDtls) {
		ValDtls = valDtls;
	}

	public Object getEwbDtls() {
		return EwbDtls;
	}

	public void setEwbDtls(Object ewbDtls) {
		EwbDtls = ewbDtls;
	}

	public List<ItemList> getItemList() {
		return ItemList;
	}

	public void setItemList(List<ItemList> itemList) {
		ItemList = itemList;
	}

	@Override
	public String toString() {
		return "Root [Version=" + Version + ", TranDtls=" + TranDtls + ", DocDtls=" + DocDtls + ", SellerDtls="
				+ SellerDtls + ", BuyerDtls=" + BuyerDtls + ", DispDtls=" + DispDtls + ", ShipDtls=" + ShipDtls
				+ ", ValDtls=" + ValDtls + ", EwbDtls=" + EwbDtls + ", ItemList=" + ItemList + "]";
	}

}

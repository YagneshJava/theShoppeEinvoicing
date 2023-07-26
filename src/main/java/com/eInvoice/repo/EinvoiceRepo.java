package com.eInvoice.repo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eInvoice.models.BuyerDtls;
import com.eInvoice.models.ItemList;
import com.eInvoice.models.SalesInvoiceModel;
import com.eInvoice.models.ValDtls;

public interface EinvoiceRepo {

	Page<?> getPendingInvoiceList(String searchQuery, Pageable pageable) throws SQLException;

	Page<?> getPendingInvoiceItemList(String searchQuery, Pageable pageable, String salesInvoiceId) throws SQLException;

	List<ItemList> getPendingInvoiceItemListForJson(String salesItemId) throws SQLException;

	BuyerDtls getCustomerDetails(String customerId) throws SQLException;

	ValDtls getInvoiceValueDetails(String salesItemId) throws SQLException;

	SalesInvoiceModel getTranDtlsAndDocDetails(String salesItemId) throws SQLException;

	void saveInvoiceDownloadFlag(String invoiceList) throws Exception;

}

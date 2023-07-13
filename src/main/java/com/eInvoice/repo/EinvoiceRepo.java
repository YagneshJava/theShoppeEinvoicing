package com.eInvoice.repo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eInvoice.models.ItemList;

public interface EinvoiceRepo {

	Page<?> getPendingInvoiceList(String searchQuery, Pageable pageable) throws SQLException;
	
	Page<?> getPendingInvoiceItemList(String searchQuery, Pageable pageable) throws SQLException;
	
	List<ItemList> getPendingInvoiceItemListForJson(String salesItemId) throws SQLException;

	
	
}

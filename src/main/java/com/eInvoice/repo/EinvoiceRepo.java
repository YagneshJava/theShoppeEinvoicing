package com.eInvoice.repo;

import java.sql.SQLException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EinvoiceRepo {

	Page<?> getPendingInvoiceList(String searchQuery, Pageable pageable) throws SQLException;

	
	
}

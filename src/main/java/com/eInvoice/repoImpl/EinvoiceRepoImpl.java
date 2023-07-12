package com.eInvoice.repoImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eInvoice.models.SalesInvoiceModel;
import com.eInvoice.repo.EinvoiceRepo;

@Repository
@PropertySource("classpath:eInvoice.properties")
public class EinvoiceRepoImpl implements EinvoiceRepo{
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private Environment env;

	@Override
	public Page<?> getPendingInvoiceList(String searchQuery, Pageable pageable) throws SQLException {
		try {
			
			List<SalesInvoiceModel> pendingEinvoiceList = template.query(env.getProperty("getEinvoicePendingList")+" OFFSET "+ pageable.getOffset() +" ROWS "+" FETCH NEXT "+ pageable.getPageSize() +" ROWS ONLY ",
	                BeanPropertyRowMapper.newInstance(SalesInvoiceModel.class));
			return new PageImpl<SalesInvoiceModel>(pendingEinvoiceList, pageable,
					template.queryForObject(env.getProperty("getEinvoicePendingListCount") , Integer.class));
		} finally {
			
		}
	}

}

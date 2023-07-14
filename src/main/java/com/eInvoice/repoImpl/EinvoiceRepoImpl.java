package com.eInvoice.repoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eInvoice.models.BuyerDtls;
import com.eInvoice.models.ItemList;
import com.eInvoice.models.SalesInvoiceModel;
import com.eInvoice.models.ValDtls;
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
			
			List<SalesInvoiceModel> pendingEinvoiceList = template.query(env.getProperty("getEinvoicePendingList") + searchQuery +" order by SalesInvoiceDate desc OFFSET "+ pageable.getOffset() +" ROWS "+" FETCH NEXT "+ pageable.getPageSize() +" ROWS ONLY ",
	                BeanPropertyRowMapper.newInstance(SalesInvoiceModel.class));
			return new PageImpl<SalesInvoiceModel>(pendingEinvoiceList, pageable,
					template.queryForObject(env.getProperty("getEinvoicePendingListCount") + searchQuery, Integer.class));
		} finally {
			
		}
	}
	
	@Override
	public Page<?> getPendingInvoiceItemList(String searchQuery, Pageable pageable,String salesInvoiceId) throws SQLException {
		try {
			List<ItemList> pendingEinvoiceList = template.query(env.getProperty("getPendingInvoiceItemList")+" ORDER BY SalesInvoiceItemId OFFSET "+ pageable.getOffset() +" ROWS "+" FETCH NEXT "+ pageable.getPageSize() +" ROWS ONLY ",
					BeanPropertyRowMapper.newInstance(ItemList.class),salesInvoiceId);
			return new PageImpl<ItemList>(pendingEinvoiceList, pageable,
					template.queryForObject(env.getProperty("getPendingInvoiceItemListCount"), Integer.class,salesInvoiceId));
		} finally {
			
		}
	}
	
	
	@Override
	public List<ItemList> getPendingInvoiceItemListForJson(String salesItemId) throws SQLException {
		try {
			List<ItemList> pendingEinvoiceList = template.query(env.getProperty("getPendingInvoiceItemList"),
					BeanPropertyRowMapper.newInstance(ItemList.class),salesItemId);
			return pendingEinvoiceList;
		} finally {
			
		}
	}
	
	@Override
	public BuyerDtls getCustomerDetails(String customerId) throws SQLException {
		try {
			BuyerDtls pendingEinvoiceList = template.queryForObject(env.getProperty("getCustomerDetails"),
					BeanPropertyRowMapper.newInstance(BuyerDtls.class),customerId);
			return pendingEinvoiceList;
		}catch (ConfigDataResourceNotFoundException ce) {
			return new BuyerDtls();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			
		}
	}
	
	@Override
	public ValDtls getInvoiceValueDetails(String salesItemId) throws SQLException {
		try {
			ValDtls pendingEinvoiceList = template.queryForObject(env.getProperty("getInvoiceValueDetails"),
					BeanPropertyRowMapper.newInstance(ValDtls.class),salesItemId);
			return pendingEinvoiceList;
		}catch (ConfigDataResourceNotFoundException ce) {
			return new ValDtls();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			
		}
	}
	
	@Override
	public SalesInvoiceModel getTranDtlsAndDocDetails(String salesItemId) throws SQLException {
		try {
			SalesInvoiceModel pendingEinvoiceList = template.queryForObject(env.getProperty("getTranDtlsAndDocDetails"),
					BeanPropertyRowMapper.newInstance(SalesInvoiceModel.class),salesItemId);
			return pendingEinvoiceList;
		}catch (ConfigDataResourceNotFoundException ce) {
			return new SalesInvoiceModel();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			
		}
	}

}

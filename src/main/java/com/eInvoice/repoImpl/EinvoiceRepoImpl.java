package com.eInvoice.repoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
		List<SalesInvoiceModel> pendingEinvoiceList = new ArrayList<SalesInvoiceModel>();
		try {
			
			pendingEinvoiceList = template.query(env.getProperty("getEinvoicePendingList") + searchQuery +" ) d ORDER BY SalesInvoiceId DESC" ,
	                BeanPropertyRowMapper.newInstance(SalesInvoiceModel.class)).parallelStream()
										.skip(pageable.getOffset())
										.limit(pageable.getPageSize())
										.collect(Collectors.toList());
			
			return new PageImpl<SalesInvoiceModel>(pendingEinvoiceList, pageable,
					template.queryForObject(env.getProperty("getEinvoicePendingListCount") + searchQuery, Integer.class));
		} finally {
			pendingEinvoiceList = null;
		}
	}
	
	@Override
	public Page<?> getPendingInvoiceItemList(String searchQuery, Pageable pageable,String salesInvoiceId) throws SQLException {
		try {
			List<ItemList> pendingEinvoiceList = template.query(env.getProperty("getPendingInvoiceItemList"),
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

	@Override
	public void saveInvoiceDownloadFlag(String invoiceList)throws Exception {
		try {
			
			template.update(
				    new PreparedStatementCreator() {
				        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				            PreparedStatement ps =
				                connection.prepareStatement(env.getProperty("saveInvoiceDownloadFlag"));
				            ps.setString(1, invoiceList);
				            ps.setString(2, new Date().toString());
				            return ps;
				        }
				    });
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
	}

}

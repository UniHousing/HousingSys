package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.InvoiceDao;
import com.webapp.model.Invoice;

public class InvoiceDaoTest extends SpringTransactionContextTest {

	@Resource(name = "invoiceDaoImpl")
	private InvoiceDao invoiceDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void save() {
		Invoice invoice = new Invoice();
		invoice.setId("1000");
		invoice.setLeaseId("2000");
		invoice.setDamageCharge(200.00);
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dob = format.format(curDate);
		invoice.setPayDate(dob);
		invoice.setPayMethod("credit card");
		invoice.setPenalty(300.00);
		invoice.setStatus("payed");
		invoice.setLateFee(40.00);
		invoice.setTotal(540.00);
		invoiceDao.save(invoice);
		Invoice test = invoiceDao.findById("1000");
		assertEquals(test.getLeaseId(), "2000"); // Test findById
		
		Invoice invoice1 = new Invoice();
		invoice1.setId("1001");
		invoiceDao.save(invoice1);
		List<Invoice> lists = invoiceDao.findAll();
		assertEquals(lists.size(), 2);
		
		invoiceDao.delete(invoice);
		invoiceDao.delete(invoice1);
	}

}

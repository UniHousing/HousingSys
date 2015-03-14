package com.webapp.dao.impl.sql;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	}

}

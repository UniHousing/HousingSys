package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.TicketDao;
import com.webapp.model.Ticket;

public class TicketDaoTest extends SpringTransactionContextTest {

	@Resource(name = "ticketDaoImpl")
	private TicketDao ticketDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		Ticket ticket = new Ticket();
		ticket.setDate(new Date(2015, 3, 14));
		ticket.setLocation("House");
		ticket.setStudentId("2");
		ticket.setType("Maintenence");
		ticketDao.save(ticket);
		ticketDao.delete(ticket);

	}

	@Test
	public void find() {
		Ticket ticket = new Ticket();
		ticket.setDate(new Date(2015, 3, 14));
		ticket.setLocation("House");
		ticket.setStudentId("2");
		ticket.setType("Maintenence");
		ticketDao.save(ticket);
		assertEquals(ticketDao.findById("1").getStudentId(), "2");
		ticketDao.delete(ticket);
	}

	@Test
	public void findAll() {
		Ticket ticket = new Ticket();
		ticket.setDate(new Date(2015, 3, 14));
		ticket.setLocation("House");
		ticket.setStudentId("2");
		ticket.setType("Maintenence");
		ticketDao.save(ticket);
		Ticket ticket2 = new Ticket();
		ticket2.setDate(new Date(2015, 4, 14));
		ticket2.setLocation("Office");
		ticket2.setStudentId("3");
		ticket2.setType("Repair");
		ticketDao.save(ticket2);
		List<Ticket> tickets = ticketDao.findAll();
		assertEquals(tickets.size(), 2);
		ticketDao.delete(ticket);
		ticketDao.delete(ticket2);
	}
}

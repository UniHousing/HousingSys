package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.ParkingSpotDao;
import com.webapp.dao.TerminReqDao;
import com.webapp.model.ParkingSpot;
import com.webapp.model.TerminReq;

public class TerminReqDaoTest extends SpringTransactionContextTest {

	@Resource(name = "terminReqDaoImpl")
	private TerminReqDao terminReqDao;
	

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		TerminReq terminReq= new TerminReq();
		terminReq.setLeaseId("2");
		terminReq.setReason("abc");
		terminReq.setExtraFee(100);
		terminReq.setDate(new Date(2015, 4, 4));
		terminReq.setInspectionDate(new Date(2015, 4, 6));
		terminReq.setStatus("pending");
		terminReqDao.save(terminReq);
		terminReqDao.delete(terminReq);
	}

	
	 @Test
	public void find() {
		 TerminReq terminReq= new TerminReq();
			terminReq.setLeaseId("2");
			terminReq.setReason("abc");
			terminReq.setExtraFee(100);
			terminReq.setDate(new Date(2015, 4, 4));
			terminReq.setInspectionDate(new Date(2015, 4, 6));
			terminReq.setStatus("pending");
			terminReqDao.save(terminReq);
			assertEquals(terminReqDao.findById("1").getLeaseId(), "2");
			terminReqDao.delete(terminReq);
	}


	@Test
	public void findAll() {
		TerminReq terminReq= new TerminReq();
		terminReq.setLeaseId("2");
		terminReq.setReason("abc");
		terminReq.setExtraFee(100);
		terminReq.setDate(new Date(2015, 4, 4));
		terminReq.setInspectionDate(new Date(2015, 4, 6));
		terminReq.setStatus("pending");
		terminReqDao.save(terminReq);
		TerminReq terminReq2= new TerminReq();
		terminReq2.setLeaseId("5");
		terminReq2.setReason("abcd");
		terminReq2.setExtraFee(1040);
		terminReq2.setDate(new Date(2013, 3, 4));
		terminReq2.setInspectionDate(new Date(2013, 4, 6));
		terminReq2.setStatus("approved");
		terminReqDao.save(terminReq2);
		List<TerminReq> terminReqs=terminReqDao.findAll();
		assertEquals(terminReqs.size(), 2);
		terminReqDao.delete(terminReq);
		terminReqDao.delete(terminReq2);
	}
}

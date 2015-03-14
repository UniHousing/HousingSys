package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.LeaseDao;
import com.webapp.model.Lease;

public class LeaseDaoTest extends SpringTransactionContextTest {

	@Resource(name = "leaseDaoImpl")
	private LeaseDao leaseDao;

	@Test
	public void save() {
		Lease entity = new Lease();
		entity.setStudentId("3000");
		entity.setHouseId("2000");
		entity.setRoomId("2001");
		entity.setParkingId("200");
		entity.setDuration("One year");
		Date enterDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String enterDate1 = format.format(enterDate);
		entity.setEnterDate(enterDate1);
		
		Date leaveDate = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		String leaveDate1 = format1.format(leaveDate);
		entity.setLeaveDate(leaveDate1);
		entity.setDeposit(500.00);
		entity.setPayment("monthly");
		entity.setPenalty(50.00);
		
		Date inspectDate = new Date();
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
		String inspectDate1 = format2.format(inspectDate);
		entity.setInspectDate(inspectDate1);
		
		leaseDao.save(entity);
		Lease test = leaseDao.findById("1000");
		assertEquals(test.getHouseId(), "2000"); // Test findById
		
		Lease entity1 = new Lease();
		leaseDao.save(entity1);
		List<Lease> lists = leaseDao.findAll();  // Test findAll
		assertEquals(lists.size(), 2);
		
//		leaseDao.delete(entity);
		leaseDao.delete(entity1);
	}

}

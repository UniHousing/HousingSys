package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.GeneralApartmentDao;
import com.webapp.model.GeneralApartment;

public class GeneralApartmentDaoTest extends SpringTransactionContextTest {

	@Resource(name = "generalApartmentDaoImpl")
	private GeneralApartmentDao gAptDao;
	
	@Test
	public void save() {
		GeneralApartment gApt = new GeneralApartment();
		gApt.setId("1000");
		gApt.setName("Tower Hall");
		gApt.setAddr("900 Varsity Dr.");
		gApt.setTel("919-449-9999");
		gApt.setRoomCount(5);
		gApt.setBathCount(2);
		gAptDao.save(gApt);
		gAptDao.delete(gApt);
	}
	@Test
	public void findById() {
		GeneralApartment gApt = new GeneralApartment();
		gApt.setId("1001");
		gApt.setName("Tower Hall");
		gApt.setAddr("900 Varsity Dr.");
		gApt.setTel("919-449-9999");
		gApt.setRoomCount(5);
		gApt.setBathCount(2);
		gAptDao.save(gApt);
		GeneralApartment gampt = gAptDao.findById("1001");
		assertEquals(gampt.getRoomCount(), 5);
		
		GeneralApartment gApt2 = new GeneralApartment();
		gApt2.setId("1002");
		gApt2.setName("Tower Hall");
		gApt2.setAddr("900 Varsity Dr.");
		gApt2.setTel("919-449-9999");
		gApt2.setRoomCount(5);
		gApt2.setBathCount(2);
		gAptDao.save(gApt2);
		
		List<GeneralApartment> gampts = gAptDao.findByName("Tower Hall");   // FindByName Test
		assertEquals(gampts.size(), 2);
		
		gAptDao.delete(gApt);
		gAptDao.delete(gApt2);
	}
	
	@Test
	public void updateName() {
		GeneralApartment gApt = new GeneralApartment();
		gApt.setId("1002");
		gApt.setName("Tower Hall");
		gApt.setAddr("900 Varsity Dr.");
		gApt.setTel("919-449-9999");
		gApt.setRoomCount(5);
		gApt.setBathCount(2);
		gAptDao.save(gApt);
		gAptDao.updateName(gApt, "Hunt Hall");
		GeneralApartment gampt = gAptDao.findById("1002");
		assertEquals(gampt.getRoomCount(), 5);
		gAptDao.delete(gampt);
	}
	@Test
	public void findAll() {
		GeneralApartment gamt1 = new GeneralApartment();
		gamt1.setId("1003");
		gAptDao.save(gamt1);
		GeneralApartment gamt2 = new GeneralApartment();
		gamt2.setId("1004");
		gAptDao.save(gamt2);
		List<GeneralApartment> famts = gAptDao.findAll();
		assertEquals(famts.size(), 2);
		gAptDao.delete(gamt2);
		gAptDao.delete(gamt2);
	}
}

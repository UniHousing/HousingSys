package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.FamilyApartmentDao;
import com.webapp.model.FamilyApartment;

public class FamilyApartmentDaoImplTest extends SpringTransactionContextTest {

	@Resource(name = "familyApartmentDaoImpl")
	private FamilyApartmentDao familyApartmentDao;
	
	@Test
	public void save() {
		FamilyApartment fApartment = new FamilyApartment();
		fApartment.setId("1000");
		fApartment.setName("Tower Hall");
		fApartment.setAddr("900 Varsity Dr.");
		fApartment.setTel("919-449-9999");
		fApartment.setRoomCount(5);
		fApartment.setBathCount(2);
		fApartment.setMonthRate(800.00);
		familyApartmentDao.save(fApartment);
		familyApartmentDao.delete(fApartment);
	}
	@Test
	public void findById() {
		FamilyApartment fApartment = new FamilyApartment();
		fApartment.setId("1001");
		fApartment.setName("Tower Hall");
		fApartment.setAddr("900 Varsity Dr.");
		fApartment.setTel("919-449-9999");
		fApartment.setRoomCount(5);
		fApartment.setBathCount(2);
		fApartment.setMonthRate(800.00);
		familyApartmentDao.save(fApartment);
		FamilyApartment fampt = familyApartmentDao.findById("1001");
		assertEquals(fampt.getRoomCount(), 5);
		
		FamilyApartment fApartment2 = new FamilyApartment();
		fApartment2.setId("1002");
		fApartment2.setName("Tower Hall");
		fApartment2.setAddr("900 Varsity Dr.");
		fApartment2.setTel("919-449-9999");
		fApartment2.setRoomCount(5);
		fApartment2.setBathCount(2);
		fApartment2.setMonthRate(800.00);
		familyApartmentDao.save(fApartment2);
		
		List<FamilyApartment> fampts = familyApartmentDao.findByName("Tower Hall");   // FindByName Test
		assertEquals(fampts.size(), 2);
		
		familyApartmentDao.delete(fApartment);
		familyApartmentDao.delete(fApartment2);
	}
	
	@Test
	public void updateName() {
		FamilyApartment fApartment = new FamilyApartment();
		fApartment.setId("1002");
		fApartment.setName("Tower Hall");
		fApartment.setAddr("900 Varsity Dr.");
		fApartment.setTel("919-449-9999");
		fApartment.setRoomCount(5);
		fApartment.setBathCount(2);
		fApartment.setMonthRate(800.00);
		familyApartmentDao.save(fApartment);
		familyApartmentDao.updateName(fApartment, "Hunt Hall");
		FamilyApartment fampt = familyApartmentDao.findById("1002");
		assertEquals(fampt.getRoomCount(), 5);
		familyApartmentDao.delete(fampt);
	}
}

package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cassandra.cli.CliParser.newColumnFamily_return;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.ParkingSpotDao;
import com.webapp.dao.StaffDao;
import com.webapp.model.ParkingSpot;
import com.webapp.model.Staff;

public class StaffDaoTest extends SpringTransactionContextTest {

	@Resource(name = "staffDaoImpl")
	private StaffDao staffDao;
	

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		Staff staff=new Staff();
		staff.setAddr("Oval Drive");
		staff.setBirthDate(new Date(1992, 2, 2));
		staff.setCity("Raleigh");
		staff.setFname("Jack");
		staff.setLname("Richard");
		staff.setGender("Male");
		staff.setPosition("Director");
		staff.setPostCode("27606");
		staff.setWorkAt("Office");
		staffDao.save(staff);
		staffDao.delete(staff);
	}


	@Test
	public void find() {
		Staff staff = new Staff();
		staff.setAddr("Oval Drive");
		staff.setBirthDate(new Date(1992, 2, 2));
		staff.setCity("Raleigh");
		staff.setFname("Jack");
		staff.setLname("Richard");
		staff.setGender("Male");
		staff.setPosition("Director");
		staff.setPostCode("27606");
		staff.setWorkAt("Office");
		staffDao.save(staff);
		Staff staff2 = staffDao.findById("1");
		assertEquals(staff2.getCity(), "Raleigh");
		staffDao.delete(staff);
	}


	@Test
	public void findAll() {
		Staff staff=new Staff();
		staff.setAddr("Oval Drive");
		staff.setBirthDate(new Date(1992, 2, 2));
		staff.setCity("Raleigh");
		staff.setFname("Jack");
		staff.setLname("Richard");
		staff.setGender("Male");
		staff.setPosition("Director");
		staff.setPostCode("27606");
		staff.setWorkAt("Office");
		staffDao.save(staff);
		Staff staff2=new Staff();
		staff2.setAddr("Oval Drive");
		staff2.setBirthDate(new Date(1992, 2, 2));
		staff2.setCity("Raleigh");
		staff2.setFname("Jackson");
		staff2.setLname("Rich");
		staff2.setGender("Female");
		staff2.setPosition("Manager");
		staff2.setPostCode("27606");
		staff2.setWorkAt("Hall");
		staffDao.save(staff2);
		List<Staff> staffs=staffDao.findAll();
		assertEquals(staffs.size(), 2);
		staffDao.delete(staff2);
		staffDao.delete(staff);
	}
}

package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.ResidenceHallDao;
import com.webapp.model.ResidenceHall;


public class ResidenceHallDaoTest extends SpringTransactionContextTest {

	@Resource(name = "residenceHallDaoImpl")
	private ResidenceHallDao residenceHallDao;
	

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		ResidenceHall residenceHall=new ResidenceHall();
		residenceHall.setName("Alex Hall");
		residenceHall.setAddr("Oval Drive");
		residenceHall.setTel("9194301321");
		residenceHall.setManagerId(19);
		residenceHallDao.save(residenceHall);
		residenceHallDao.delete(residenceHall);
	}


	@Test
	public void find() {
		ResidenceHall residenceHall = new ResidenceHall();
		residenceHall.setName("Alex Hall");
		residenceHall.setAddr("Oval Drive");
		residenceHall.setTel("9194301321");
		residenceHall.setManagerId(19);
		residenceHallDao.save(residenceHall);
		ResidenceHall residenceHall2=residenceHallDao.findById("1");
		assertEquals(residenceHall2.getName(), "Alex Hall");
		residenceHallDao.delete(residenceHall2);
	}
	@Test
	public void findAll() {
		ResidenceHall residenceHall=new ResidenceHall();
		residenceHall.setName("Alex Hall");
		residenceHall.setAddr("Oval Drive");
		residenceHall.setTel("9194301321");
		residenceHall.setManagerId(19);
		residenceHallDao.save(residenceHall);
		ResidenceHall residenceHall2=new ResidenceHall();
		residenceHall2.setName("Alex Hall");
		residenceHall2.setAddr("Oval Drive");
		residenceHall2.setTel("9194301321");
		residenceHall2.setManagerId(19);
		residenceHallDao.save(residenceHall2);
		List<ResidenceHall> residenceHalls=residenceHallDao.findAll();
		assertEquals(residenceHalls.size(), 2);
		residenceHallDao.delete(residenceHall);
		residenceHallDao.delete(residenceHall2);
	}
}

package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.KinInfoDao;
import com.webapp.model.KinInfo;

public class KinInfoDaoTest extends SpringTransactionContextTest {

	@Resource(name = "kinInfoDaoImpl")
	private KinInfoDao kinInfoDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void save() {
		KinInfo entity = new KinInfo();
		entity.setId(1000);
		entity.setAddr("900 Avent Ferry Rd.");
		entity.setCity("Raleigh");
		entity.setName("Ken");
		entity.setPostCode("27606");
		entity.setRelationship("classmate");
		entity.setStudentId("2000");
		entity.setTel("919-449-9999");
		kinInfoDao.save(entity);
		KinInfo test = kinInfoDao.findById("1000");
		assertEquals(test.getStudentId(), "2000"); // Test findById
		
		KinInfo entity1 = new KinInfo();
		entity1.setId(1001);
		kinInfoDao.save(entity1);
		List<KinInfo> lists = kinInfoDao.findAll(); // Test findAll
		assertEquals(lists.size(), 2);
		
		kinInfoDao.delete(entity);
		kinInfoDao.delete(entity1);
	}

}

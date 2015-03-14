package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.NearbyDao;
import com.webapp.model.Nearby;

public class NearbyDaoTest extends SpringTransactionContextTest {

	@Resource(name = "nearbyDaoImpl")
	private NearbyDao nearbyDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void save() {
		Nearby entity = new Nearby();
//		entity.setId("1000");
		entity.setLotId("200");
		entity.setHouseId("2000");
		nearbyDao.save(entity);
		Nearby test = nearbyDao.findById("1000");
		assertEquals(test.getHouseId(), "2000"); // Test findById
		
//		Nearby entity1 = new Nearby();
////		entity1.setId("1001");
//		entity1.setLotId("201");
//		entity1.setHouseId("2001");
//		nearbyDao.save(entity1);
//		List<Nearby> lists = nearbyDao.findAll(); // Test findAll
//		assertEquals(lists.size(), 2);
		
		nearbyDao.delete(entity);
//		nearbyDao.delete(entity1);
	}

}

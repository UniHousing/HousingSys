package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.ParkingLotDao;
import com.webapp.model.ParkingLot;

public class ParkingLotDaoTest extends SpringTransactionContextTest {

	@Resource(name = "parkingLotDaoImpl")
	private ParkingLotDao parkingLotDao;
	

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		ParkingLot parkingLot=new ParkingLot();
		parkingLot.setNumParkingSpot(10);
		parkingLotDao.save(parkingLot);
		parkingLotDao.delete(parkingLot);
	}

//	@Test
	public void update() {
		ParkingLot parkingLot=new ParkingLot();
		parkingLot.setNumParkingSpot(11);
		parkingLotDao.save(parkingLot);
		parkingLotDao.updateSpotsNumber(parkingLot, 12);
		parkingLotDao.delete(parkingLot);
	}

//	 @Test
	public void find() {
		 ParkingLot parkingLot=new ParkingLot();
		 parkingLot.setNumParkingSpot(12);
			parkingLotDao.save(parkingLot);
			ParkingLot parkingLot2= parkingLotDao.findById("12");
			assertEquals(parkingLot2.getNumParkingSpot(), 12);
			parkingLotDao.delete(parkingLot2);
	}


//	@Test
	public void findAll() {
		ParkingLot p1=new ParkingLot();
		p1.setNumParkingSpot(10);
		parkingLotDao.save(p1);
		ParkingLot p2=new ParkingLot();
		p2.setNumParkingSpot(11);
		parkingLotDao.save(p2);
		ParkingLot p3=new ParkingLot();
		p3.setNumParkingSpot(12);
		parkingLotDao.save(p3);
		List<ParkingLot> parkingLots= parkingLotDao.findAll();
		assertEquals(parkingLots.size(), 3);
		parkingLotDao.delete(p1);
		parkingLotDao.delete(p2);
		parkingLotDao.delete(p3);
		
	}
}

package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.ParkingSpotDao;
import com.webapp.model.ParkingSpot;

public class ParkingSpotDaoTest extends SpringTransactionContextTest {

	@Resource(name = "parkingSpotDaoImpl")
	private ParkingSpotDao parkingSpotDao;
	

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		ParkingSpot parkingSpot=new ParkingSpot();
		parkingSpot.setId("1");
		parkingSpot.setLot_id("10");
		parkingSpot.setClassification("Handicapped");
		parkingSpot.setFee(300);
		parkingSpot.setAvailability("Available");
		parkingSpotDao.save(parkingSpot);
		parkingSpotDao.delete(parkingSpot);
	}

	@Test
	public void updateAvailability() {
		ParkingSpot parkingSpot=new ParkingSpot();
		parkingSpot.setId("1");
		parkingSpot.setLot_id("10");
		parkingSpot.setClassification("Handicapped");
		parkingSpot.setFee(300);
		parkingSpot.setAvailability("Available");
		parkingSpotDao.save(parkingSpot);
		parkingSpotDao.updateAvailablity(parkingSpot, false);
		assertEquals(parkingSpotDao.findById("1").getAvailability(), "Unavailable");
		parkingSpotDao.delete(parkingSpot);
	}

	 @Test
	public void find() {
		 ParkingSpot parkingSpot=new ParkingSpot();
			parkingSpot.setId("1");
			parkingSpot.setLot_id("10");
			parkingSpot.setClassification("Handicapped");
			parkingSpot.setFee(300);
			parkingSpot.setAvailability("Available");
			parkingSpotDao.save(parkingSpot);
			assertEquals(parkingSpotDao.findById("1").getLot_id(), "10");
			parkingSpotDao.delete(parkingSpot);
	}


	@Test
	public void findAll() {
		ParkingSpot parkingSpot=new ParkingSpot();
		parkingSpot.setId("1");
		parkingSpot.setLot_id("10");
		parkingSpot.setClassification("Handicapped");
		parkingSpot.setFee(300);
		parkingSpot.setAvailability("Available");
		parkingSpotDao.save(parkingSpot);
		ParkingSpot parkingSpot2=new ParkingSpot();
		parkingSpot2.setId("2");
		parkingSpot2.setLot_id("11");
		parkingSpot2.setClassification("Normal");
		parkingSpot2.setFee(200);
		parkingSpot2.setAvailability("Available");
		parkingSpotDao.save(parkingSpot2);
		List<ParkingSpot> parkingSpots=parkingSpotDao.findAll();
		assertEquals(parkingSpots.size(), 2);
		parkingSpotDao.delete(parkingSpot);
		parkingSpotDao.delete(parkingSpot2);
	}
}

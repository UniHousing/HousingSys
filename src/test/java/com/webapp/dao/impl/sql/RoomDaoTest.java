package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.RoomDao;
import com.webapp.model.Room;

public class RoomDaoTest extends SpringTransactionContextTest {

	@Resource(name = "roomDaoImpl")
	private RoomDao roomDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		Room room = new Room();
		room.setHouseId("10");
		room.setId("1");
		room.setMonthRate(300);
		room.setRoomNumber("2003");
		roomDao.save(room);
		roomDao.delete(room);
	}

	@Test
	public void find() {
		Room room = new Room();
		room.setHouseId("10");
		room.setId("1");
		room.setMonthRate(300);
		room.setRoomNumber("2003");
		roomDao.save(room);
		assertEquals(roomDao.findById("1").getRoomNumber(), "2003");
		roomDao.delete(room);

	}

	@Test
	public void findAll() {
		Room room = new Room();
		room.setHouseId("10");
		room.setId("1");
		room.setMonthRate(300);
		room.setRoomNumber("2003");
		roomDao.save(room);
		Room room2 = new Room();
		room2.setHouseId("10");
		room2.setId("2");
		room2.setMonthRate(305);
		room2.setRoomNumber("2003");
		roomDao.save(room2);
		List<Room> rooms = roomDao.findAll();
		assertEquals(rooms.size(), 2);
		roomDao.delete(room);
		roomDao.delete(room2);
	}
}

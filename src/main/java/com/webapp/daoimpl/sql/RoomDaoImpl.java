package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.RoomDao;
import com.webapp.model.Room;
@Component
public class RoomDaoImpl extends BaseSQLImpl<Room> implements RoomDao{

	@Override
	public Room findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM room WHERE id = ?";
		Room room = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Room>(Room.class));
		return room;
	}

	@Override
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from room ";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Room> rooms = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Room.class));
		return rooms;
	}

	@Override
	public List<Room> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Room entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into room"
				+ " (id,room_number,month_rate,house_id) values(?,?,?,?)",
				entity.getId(),entity.getRoomNumber(),entity.getMonthRate(),entity.getHouseId());
	}

	@Override
	public void delete(Room entity) {
		// TODO Auto-generated method stub
		String query = "delete from room where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

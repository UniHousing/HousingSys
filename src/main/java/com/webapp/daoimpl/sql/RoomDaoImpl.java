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
	public void save(Room entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into room"
					+ " (room_number,month_rate,house_id) values(?,?,?)",
					entity.getRoomNumber(),entity.getMonthRate(),entity.getHouseId());
		} else {
			this.jdbcTemplate.update("update room"
					+ "set room_number=?,month_rate=?,house_id=? where id=?",
					entity.getRoomNumber(),entity.getMonthRate(),entity.getHouseId(),entity.getId());
		}
		
	}

	

}

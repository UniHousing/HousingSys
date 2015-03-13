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
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into room"
				+ " (id,room_number,month_rate,house_id) values(?,?,?,?)",
				entity.getId(),entity.getRoomNumber(),entity.getMonthRate(),entity.getHouseId());
	}

	

}

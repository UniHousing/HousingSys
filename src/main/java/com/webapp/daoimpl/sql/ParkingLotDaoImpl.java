package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.ParkingLotDao;
import com.webapp.model.ParkingLot;


@Component
public class ParkingLotDaoImpl extends BaseSQLImpl<ParkingLot> implements ParkingLotDao{



	@Override
	public void save(ParkingLot entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into parking_lot (num_parking_spot) values(?)",
					entity.getNumParkingSpot());
		} else {
			this.jdbcTemplate.update("update parking_lot set num_parking_spot=? where id=?",
					entity.getNumParkingSpot(),entity.getId());
		}
		
	}
}

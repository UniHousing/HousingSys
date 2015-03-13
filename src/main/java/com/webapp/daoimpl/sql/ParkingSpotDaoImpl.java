package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.ParkingSpotDao;
import com.webapp.model.ParkingSpot;

@Component
public class ParkingSpotDaoImpl extends BaseSQLImpl<ParkingSpot> implements ParkingSpotDao{

	

	@Override
	public void save(ParkingSpot entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into parking_spot (id,lot_id,classification,fee,availability) values(?,?,?,?,?)",
				entity.getId(),	entity.getLot_id(),entity.getClassification(),
				entity.getFee(),entity.getAvailability());
	}

	

	

	@Override
	public void updateAvailablity(ParkingSpot parkingSpot,boolean flag) {
		// TODO Auto-generated method stub
		String availableString;
		if (flag) {
			availableString="Available";
		}
		else {
			availableString="Unavailable";
		}
		String query = "update parking_spot set availability= '" + availableString + "' where id='"
				+ parkingSpot.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

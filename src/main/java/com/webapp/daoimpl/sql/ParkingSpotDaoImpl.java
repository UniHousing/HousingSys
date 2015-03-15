package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.ParkingSpotDao;
import com.webapp.model.ParkingSpot;

@Component
public class ParkingSpotDaoImpl extends BaseSQLImpl<ParkingSpot> implements ParkingSpotDao{
	@Override
	public void save(ParkingSpot entity) {
		if( entity.getId()==0){
			this.jdbcTemplate.update("insert into parking_spot (id,lot_id,classification,fee,availability) values(?,?,?,?,?)",
				entity.getId(),	entity.getLot_id(),entity.getClassification(),
				entity.getFee(),entity.getAvailability());
		}else{
			this.jdbcTemplate.update("update parking_spot set id=?,lot_id=?,classification=?,fee=?,availability=?",
					entity.getId(),	entity.getLot_id(),entity.getClassification(),
					entity.getFee(),entity.getAvailability());
		}
	}
}

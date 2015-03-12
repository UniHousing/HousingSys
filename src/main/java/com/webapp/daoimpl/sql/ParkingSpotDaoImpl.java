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
	public List<ParkingSpot> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from parking_spot";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ParkingSpot> parkingSpots = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ParkingSpot.class));
		return parkingSpots;
	}

	@Override
	public void save(ParkingSpot entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into parking_spot (id,lot_id,classification,fee,availability) values(?,?,?,?,?)",
				entity.getId(),	entity.getLot_id(),entity.getClassification(),
				entity.getFee(),entity.getAvailability());
	}

	@Override
	public void delete(ParkingSpot entity) {
		// TODO Auto-generated method stub
		String query = "delete from parking_spot where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public ParkingSpot findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM parking_spot WHERE id = ?";
		ParkingSpot parkingSpot = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<ParkingSpot>(ParkingSpot.class));
		return parkingSpot;
	}

	@Override
	public List<ParkingSpot> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
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

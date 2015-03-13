package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.ParkingLotDao;
import com.webapp.model.ParkingLot;


@Component
public class ParkingLotDaoImpl extends BaseSQLImpl<ParkingLot> implements ParkingLotDao{

	public ParkingLot findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM parking_lot WHERE id = ?";
		ParkingLot parkingLot = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<ParkingLot>(ParkingLot.class));
		return parkingLot;
	}

	public List<ParkingLot> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from parking_lot";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ParkingLot> parkingLots = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ParkingLot.class));
		return parkingLots;
	}

	@Override
	public List<ParkingLot> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ParkingLot entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into parking_lot (id,num_parking_spot) values(?,?)",
			entity.getId(),	entity.getNumParkingSpot());
	}

	public void delete(ParkingLot entity) {
		// TODO Auto-generated method stub
		String query = "delete from parking_lot where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public void updateSpotsNumber(ParkingLot parkingLot,int number) {
		// TODO Auto-generated method stub
		String query = "update parking_lot set num_parking_spot= '" + number + "' where id='"
				+ parkingLot.getId() + "' ";
		jdbcTemplate.update(query);
	}


}

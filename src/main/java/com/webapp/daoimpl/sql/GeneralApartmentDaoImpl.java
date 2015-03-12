package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.GeneralApartmentDao;
import com.webapp.model.FamilyApartment;
import com.webapp.model.GeneralApartment;

@Component
public class GeneralApartmentDaoImpl extends BaseSQLImpl<GeneralApartment> implements GeneralApartmentDao {

	@Override
	public void save(GeneralApartment gApt) {
		this.jdbcTemplate.update("insert into general_apartment (id, name, addr, tel, room_count, bath_count) values(?,?,?,?,?,?)",
				gApt.getId(),
				gApt.getName(), 
				gApt.getAddr(),
				gApt.getTel(),
				gApt.getRoomCount(),
				gApt.getBathCount());
	}

	@Override
	public void delete(GeneralApartment gApt) {
		String query = "delete from general_apartment where id='" + gApt.getId() + "' ";
		jdbcTemplate.update(query);
	}
	
	@Override
	public void updateName(GeneralApartment gApt, String str) {
		String query = "update general_apartment set name= '" + str + "' where id='"
				+ gApt.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public GeneralApartment findById(Serializable id) {
		String sql = "SELECT * FROM general_apartment WHERE id = ?";
		GeneralApartment gApt = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<GeneralApartment>(GeneralApartment.class));
		return gApt;
	}
	
	@Override
	public List<GeneralApartment> findByName(String name) {
		String sql = "select * from general_apartment where name = ?";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<GeneralApartment> gApts = jdbcTemplate.query(sql, new Object[] { name },
				new BeanPropertyRowMapper(GeneralApartment.class));
		return gApts;
	}

	@Override
	public List<GeneralApartment> findAll() {
		String sql = "select * from general_apartment";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<GeneralApartment> gApts = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				FamilyApartment.class));
		return gApts;
	}

}

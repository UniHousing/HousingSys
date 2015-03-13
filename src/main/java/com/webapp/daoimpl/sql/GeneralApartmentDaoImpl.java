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
		if (gApt.getId() == 0) {
			this.jdbcTemplate.update("insert into general_apartment (name, addr, tel, room_count, bath_count) values(?,?,?,?,?)",
					gApt.getName(), 
					gApt.getAddr(),
					gApt.getTel(),
					gApt.getRoomCount(),
					gApt.getBathCount());
		}
		else {
			this.jdbcTemplate.update("update general_apartment set name=?, addr=?, tel=?, room_count=?, bath_count=? where id=?",
					gApt.getName(), 
					gApt.getAddr(),
					gApt.getTel(),
					gApt.getRoomCount(),
					gApt.getBathCount(),
					gApt.getId());
		}
	}
	@Override
	public void delete(GeneralApartment gApt) {
		String query = "delete from general_apartment where id='" + gApt.getId() + "' ";
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

	@Override
	public List<GeneralApartment> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

}

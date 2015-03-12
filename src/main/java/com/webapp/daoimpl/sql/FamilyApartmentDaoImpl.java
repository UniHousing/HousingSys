package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.FamilyApartmentDao;
import com.webapp.model.FamilyApartment;

@Component
public class FamilyApartmentDaoImpl extends BaseSQLImpl<FamilyApartment> implements FamilyApartmentDao {
	@Override
	public List<FamilyApartment> findByName(String name) {
		String sql = "select * from family_apartment where name = ?";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<FamilyApartment> fApts = jdbcTemplate.query(sql, new Object[] { name },
				new BeanPropertyRowMapper(FamilyApartment.class));
		return fApts;
	}

	@Override
	public List<FamilyApartment> findAll() {
		String sql = "select * from family_apartment";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<FamilyApartment> fApts = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				FamilyApartment.class));
		return fApts;
	}


	@Override
	public void save(FamilyApartment fApt) {
		this.jdbcTemplate.update("insert into family_apartment (id, name, addr, tel, room_count, bath_count, month_rate) values(?,?,?,?,?,?,?)",
				fApt.getId(),
				fApt.getName(), 
				fApt.getAddr(),
				fApt.getTel(),
				fApt.getRoomCount(),
				fApt.getBathCount(),
				fApt.getMonthRate());
	}

	@Override
	public void delete(FamilyApartment fApt) {
		String query = "delete from family_apartment where id='" + fApt.getId() + "' ";
		jdbcTemplate.update(query);
	}
	
	@Override
	public void updateName(FamilyApartment fApt, String str) {
		String query = "update family_apartment set name= '" + str + "' where id='"
				+ fApt.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public FamilyApartment findById(Serializable id) {
		String sql = "SELECT * FROM family_apartment WHERE id = ?";
		FamilyApartment fApt = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<FamilyApartment>(FamilyApartment.class));
		return fApt;
	}
	
}

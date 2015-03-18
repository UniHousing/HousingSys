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
	public void save(FamilyApartment fApt) {
		if (fApt.getId() == 0) {
			this.jdbcTemplate.update("insert into family_apartment (name, addr, tel, room_count, bath_count, month_rate) values(?,?,?,?,?,?)",
					fApt.getName(), 
					fApt.getAddr(),
					fApt.getTel(),
					fApt.getRoomCount(),
					fApt.getBathCount(),
					fApt.getMonthRate());
		} else {
			this.jdbcTemplate.update("update family_apartment set name=?, addr=?, tel=?, room_count=?, bath_count=?, month_rate=? where id=?",
					fApt.getName(), 
					fApt.getAddr(),
					fApt.getTel(),
					fApt.getRoomCount(),
					fApt.getBathCount(),
					fApt.getMonthRate(),
					fApt.getId());
		}
		
	}
}

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


}

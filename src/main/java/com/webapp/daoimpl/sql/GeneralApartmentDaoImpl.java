package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.GeneralApartmentDao;
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
}

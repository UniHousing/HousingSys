package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.FamilyApartmentDao;
import com.webapp.model.FamilyApartment;

@Component
public class FamilyApartmentDaoImpl extends BaseSQLImpl<FamilyApartment> implements FamilyApartmentDao {

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

	
}

package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.StaffDao;
import com.webapp.model.Staff;
@Component
public class StaffDaoImpl extends BaseSQLImpl<Staff> implements StaffDao{

	@Override
	public void save(Staff entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into staff"
				+ " (id,fname,lname,addr,city,post_code,birth_date,gender,"
				+ "position,work_at) values(?,?,?,?,?,?,?,?,?,?)",
				entity.getId(),entity.getFname(),entity.getLname(),entity.getAddr(),
				entity.getCity(),entity.getPostCode(),entity.getBirthDate(),
				entity.getGender(),entity.getPosition(),entity.getWorkAt());
	}

}

package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.StaffDao;
import com.webapp.model.Staff;
@Component
public class StaffDaoImpl extends BaseSQLImpl<Staff> implements StaffDao{

	@Override
	public Staff findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM staff WHERE id = ?";
		Staff staff = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Staff>(Staff.class));
		return staff;
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from staff ";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Staff> staffs = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Staff.class));
		return staffs;
	}

	@Override
	public List<Staff> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public void delete(Staff entity) {
		// TODO Auto-generated method stub
		String query = "delete from staff where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

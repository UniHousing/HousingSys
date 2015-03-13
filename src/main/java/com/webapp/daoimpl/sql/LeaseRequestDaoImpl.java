package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.LeaseRequestDao;
import com.webapp.model.LeaseRequest;
@Component
public class LeaseRequestDaoImpl extends BaseSQLImpl<LeaseRequest> implements LeaseRequestDao {

	@Override
	public LeaseRequest findById(Serializable id) {
		String sql = "select * from lease_request where id = ?";
		LeaseRequest entity = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<LeaseRequest>(LeaseRequest.class));
		return entity;
	}

	@Override
	public List<LeaseRequest> findAll() {
		String sql = "select * from lease_request";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<LeaseRequest> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				LeaseRequest.class));
		return entities;
	}

	@Override
	public List<LeaseRequest> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(LeaseRequest entity) {
		this.jdbcTemplate.update("insert into lease_request (id,student_id,preference1,preference2,preference3,status,start_date,end_date"
				+ ") values (?,?,?,?,?,?,?,?)",
				entity.getId(),
				entity.getStudentId(),
				entity.getPreference1(),
				entity.getPreference2(),
				entity.getPreference3(),
				entity.getStatus(),
				entity.getStartDate(),
				entity.getEndDate());
	}

	@Override
	public void delete(LeaseRequest entity) {
		String query = "delete from lease_request where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

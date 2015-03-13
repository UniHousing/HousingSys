package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.TerminReqDao;
import com.webapp.model.TerminReq;
@Component
public class TerminReqDaoImpl extends BaseSQLImpl<TerminReq> implements TerminReqDao{

	@Override
	public TerminReq findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM terminate_request WHERE id = ?";
		TerminReq terminReq = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<TerminReq>(TerminReq.class));
		return terminReq;
	}

	@Override
	public List<TerminReq> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from terminate_request ";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<TerminReq> terminReqs = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				TerminReq.class));
		return terminReqs;
	}

	@Override
	public List<TerminReq> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TerminReq entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into terminate_request"
				+ " (id,lease_id,reason,date,status,inspection_date,extra_fee"
				+ ") values(?,?,?,?,?,?,?)",
				entity.getId(),entity.getLeaseId(),entity.getReason(),entity.getDate(),
				entity.getStatus(),entity.getInspectionDate(),entity.getExtraFee());
	}

	@Override
	public void delete(TerminReq entity) {
		// TODO Auto-generated method stub
		String query = "delete from terminate_request where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

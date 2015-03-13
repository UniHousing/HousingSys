package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.ResidenceHallDao;
import com.webapp.model.ResidenceHall;
@Component
public class ResidenceHallDaoImpl extends BaseSQLImpl<ResidenceHall> implements ResidenceHallDao{

	@Override
	public ResidenceHall findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM residence_hall WHERE id = ?";
		ResidenceHall residenceHall = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<ResidenceHall>(ResidenceHall.class));
		return residenceHall;
	}

	@Override
	public List<ResidenceHall> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from residence_hall ";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<ResidenceHall> residenceHalls = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ResidenceHall.class));
		return residenceHalls;
	}

	@Override
	public List<ResidenceHall> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ResidenceHall entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into residence_hall"
				+ " (id,name,addr,tel,manager_id) values(?,?,?,?,?)",
				entity.getId(),entity.getName(),
				entity.getAddr(),entity.getTel(),entity.getManagerId()	);
	}

	@Override
	public void delete(ResidenceHall entity) {
		// TODO Auto-generated method stub
		String query = "delete from residence_hall where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

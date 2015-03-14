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
	public void save(ResidenceHall entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into residence_hall"
					+ " (name,addr,tel,manager_id) values(?,?,?,?)",
					entity.getName(),entity.getAddr(),entity.getTel(),entity.getManagerId()	);
		} else {
			this.jdbcTemplate.update("update residence_hall"
					+ "set name=?,addr=?,tel=?,manager_id=? where id=?",
					entity.getName(),entity.getAddr(),entity.getTel(),entity.getManagerId(),entity.getId());
		}

	}



}

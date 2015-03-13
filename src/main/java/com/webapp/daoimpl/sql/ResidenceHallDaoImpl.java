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
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into residence_hall"
				+ " (id,name,addr,tel,manager_id) values(?,?,?,?,?)",
				entity.getId(),entity.getName(),
				entity.getAddr(),entity.getTel(),entity.getManagerId()	);
	}



}

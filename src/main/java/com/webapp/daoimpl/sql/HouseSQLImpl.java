package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.dao.Parameter;
import com.webapp.model.House;

@Component
public class HouseSQLImpl extends BaseSQLImpl<House> implements HouseDao {


	public void save(House house){
		if(house.getId()==0){
			this.jdbcTemplate.update("insert into house( type,name) values(?,?)",house.getType(), house.getName());
		}else{
			this.jdbcTemplate.update("UPDATE HOUSE SET TYPE=?, NAME=? WHERE id=?", house.getType(),house.getName(),house.getId());
		}
	}

}

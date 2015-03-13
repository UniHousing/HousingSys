package com.webapp.daoimpl.sql;


import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.model.House;

@Component
public class HouseDaoImpl extends BaseSQLImpl<House> implements HouseDao {

    
	public void save(House house){
		if(house.getId()==0){
			this.jdbcTemplate.update("insert into house( type,name) values(?,?)",house.getType(), house.getName());
		}else{
			this.jdbcTemplate.update("UPDATE HOUSE SET TYPE=?, NAME=? WHERE id=?", house.getType(),house.getName(),house.getId());
		}
	}


}

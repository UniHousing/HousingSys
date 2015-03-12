package com.webapp.daoimpl.sql;

import java.util.List;

import org.springframework.stereotype.Component;

import com.webapp.dao.HouseDao;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.House;

@Component
public class HouseSQLImpl extends BaseSQLImpl<House> implements HouseDao {

	@Override
	public List<House> findByType(String typeString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<House> findAll(Parameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<House> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(House entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(House entity) {
		// TODO Auto-generated method stub
		
	}

}

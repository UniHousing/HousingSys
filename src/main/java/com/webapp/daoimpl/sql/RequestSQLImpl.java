package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.RequestDao;
import com.webapp.model.Request;

@Component
public class RequestSQLImpl extends BaseSQLImpl<Request> implements RequestDao {

	@Override
	public void save(Request entity) {
		// TODO Auto-generated method stub
		
	}

}

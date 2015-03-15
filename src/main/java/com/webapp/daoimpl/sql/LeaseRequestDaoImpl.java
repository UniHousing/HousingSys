package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Repository;

import com.webapp.dao.LeaseRequestDao;
import com.webapp.model.LeaseRequest;

@Repository
public class LeaseRequestDaoImpl extends BaseSQLImpl<LeaseRequest> implements LeaseRequestDao{

	@Override
	public void save(LeaseRequest entity) {
		// TODO Auto-generated method stub
		
	}

}

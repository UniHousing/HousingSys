package com.webapp.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.model.LeaseRequest;

public class LeaseRequestService {
	@Autowired
	private LeaseRequestDao leaseRequestDao;

	public LeaseRequest get(Serializable id){
		return leaseRequestDao.get(id);
	}
	
	public Page<LeaseRequest> find(Page<LeaseRequest> page, LeaseRequest leaseRequest){
		String sqlstr = "select * from lease_request";
		Parameter parameter = new Parameter();
		page = leaseRequestDao.find(page, sqlstr, parameter);
		return page;
	}
	
}

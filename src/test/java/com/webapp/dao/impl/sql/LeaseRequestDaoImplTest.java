package com.webapp.dao.impl.sql;

import org.junit.Test;
import org.omg.Dynamic.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.Page;
import com.webapp.model.House;
import com.webapp.model.LeaseRequest;


public class LeaseRequestDaoImplTest extends SpringTransactionContextTest{
	@Autowired
	private LeaseRequestDao leaseRequestDao;
	
	@Test
	public void pageFind(){
		Page<LeaseRequest> page = new Page<LeaseRequest>();
		Parameter parameter = new Parameter();
    	page = leaseRequestDao.find(page,"select * from lease_request", null);
    	for(LeaseRequest leaseRequest: page.getList()){
    		System.out.println("id: "+leaseRequest.getId()+" student_id:"+ leaseRequest.getStudentId());
    	}
	}
}

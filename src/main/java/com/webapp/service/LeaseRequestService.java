package com.webapp.service;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.model.LeaseRequest;

@Service
public class LeaseRequestService {
	@Autowired
	private LeaseRequestDao leaseRequestDao;

	public LeaseRequestService() {
		// TODO Auto-generated constructor stub
	}

	public void save(LeaseRequest leaseRequest) {
		leaseRequestDao.save(leaseRequest);
	}
	
	public void delete(LeaseRequest leaseRequest){
		leaseRequestDao.deleteById(leaseRequest.getId());
	}

	public LeaseRequest get(int id) {
		// TODO Auto-generated method stub
		return leaseRequestDao.get(id);
	}

	public Page<LeaseRequest> find(Page<LeaseRequest> page, LeaseRequest leaseRequest){
		String sqlstr = "select * from lease_request";
		Parameter parameter = new Parameter();
		
		if(StringUtils.isNotBlank(Integer.toString(leaseRequest.getStudentId()))){
			parameter.put("student_id", leaseRequest.getStudentId());
		}
		if(StringUtils.isNotBlank(leaseRequest.getPreference1())){
			parameter.put("preference1",leaseRequest.getPreference1());
		}
		if(StringUtils.isNotBlank(leaseRequest.getPreference2())){
			parameter.put("preference2",leaseRequest.getPreference2());
		}
		if(StringUtils.isNotBlank(leaseRequest.getPreference3())){
			parameter.put("preference3",leaseRequest.getPreference3());
		}
		
		page = leaseRequestDao.find(page,sqlstr, parameter);
		return page;
	}


}

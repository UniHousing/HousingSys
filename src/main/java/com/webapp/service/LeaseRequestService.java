package com.webapp.service;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.dao.StudentDao;
import com.webapp.model.House;
import com.webapp.model.LeaseRequest;
import com.webapp.model.Student;

@Service
public class LeaseRequestService {
	@Autowired
	private LeaseRequestDao leaseRequestDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private HouseDao houseDao;

	public LeaseRequestService() {
		// TODO Auto-generated constructor stub
	}

	public void save(LeaseRequest leaseRequest) {
		leaseRequestDao.save(leaseRequest);
	}
	
	public Student getStudent(int id){
		return studentDao.get(id);
	}
	public List<House> getHouses(String string){
		String sqlstr = "select * from house";
		String qlstr=sqlstr+ "where type like '%" + string+"%'" ;
		return houseDao.findAll(qlstr);
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
		
		if(StringUtils.isNotBlank(leaseRequest.getStudentId())){
			parameter.put("student_id", new Object[]{"=", "'"+leaseRequest.getStudentId()+"'"});
		}
		if(StringUtils.isNotBlank(leaseRequest.getPreference1())){
			parameter.put("preference1", new Object[]{"like", "'%"+leaseRequest.getPreference1()+"%'"});
		}

		page = leaseRequestDao.find(page,sqlstr, parameter);
		return page;
	}


}

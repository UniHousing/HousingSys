package com.webapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.LeaseRequestDao;
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

	public void saveRequest(LeaseRequest leaseRequest) {
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

}

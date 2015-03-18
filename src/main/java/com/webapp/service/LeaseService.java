package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.LeaseDao;
import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.StudentDao;
import com.webapp.model.House;
import com.webapp.model.Lease;
import com.webapp.model.LeaseRequest;
@Service
public class LeaseService {
	@Autowired
	private LeaseRequestDao leaseRequestDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private LeaseDao leaseDao;
	
	public void save(){
		List<LeaseRequest> leaseRequests=leaseRequestDao.findAll();
		if(leaseRequests!=null){
			LeaseRequest leaseRequest=leaseRequests.get(0);
			leaseRequests.remove(0);
			int sid=leaseRequest.getStudentId();
			Lease lease= new Lease();
			lease.setStudentId(sid);
			List<House> houses=houseDao.findAll();
			House temphHouse=null;
			if (houses!=null) {
				temphHouse=houses.get(0);
			}
			lease.setHouseId(temphHouse.getId());
			leaseDao.save(lease);
		}
		
		
		
	}
}

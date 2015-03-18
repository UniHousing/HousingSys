package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.LeaseDao;
import com.webapp.model.House;
import com.webapp.model.Lease;
import com.webapp.model.LeaseRequest;

@Service
public class LeaseService {
	@Autowired
	private LeaseRequestService leaseRequestService;
	@Autowired
	private HouseService houseService;
	@Autowired
	private LeaseDao leaseDao;

	public void save(LeaseRequest leaseRequest) {

		int sid = leaseRequest.getStudentId();
		Lease lease = new Lease();
		lease.setStudentId(sid);
		List<House> houses = houseService.findHouseByType(leaseRequest.getPreference1());
		House temphHouse = null;
		if (houses != null) {
			temphHouse = houses.get(0);
			lease.setHouseId(temphHouse.getId());
			lease.setEnterDate(leaseRequest.getStartDate());
			lease.setLeaveDate(leaseRequest.getEndDate());
			leaseDao.save(lease);
		}
		

	}
}

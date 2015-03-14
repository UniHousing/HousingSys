package com.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.LeaseRequestDao;
import com.webapp.dao.UserDao;
import com.webapp.model.House;
import com.webapp.model.LeaseRequest;
import com.webapp.model.User;

@Service
public class LeaseRequestService {
	@Autowired
	private LeaseRequestDao leaseRequestDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HouseDao houseDao;

	public LeaseRequestService() {
		// TODO Auto-generated constructor stub
	}

	public void saveRequest(LeaseRequest leaseRequest) {
		leaseRequestDao.save(leaseRequest);
	}



	public void saveUser(User user) {
		userDao.save(user);
	}

	public void saveHouse(House house) {
		houseDao.save(house);
	}


}

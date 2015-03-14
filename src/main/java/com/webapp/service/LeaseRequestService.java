package com.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.RequestDao;
import com.webapp.dao.UserDao;
import com.webapp.model.House;
import com.webapp.model.Request;
import com.webapp.model.User;

@Service
public class RequestService {
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HouseDao houseDao;

	public RequestService() {
		// TODO Auto-generated constructor stub
	}

	public void saveRequest(Request request) {
		requestDao.save(request);
	}



	public void saveUser(User user) {
		userDao.save(user);
	}

	public void saveHouse(House house) {
		houseDao.save(house);
	}


}

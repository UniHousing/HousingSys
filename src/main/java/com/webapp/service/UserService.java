package com.webapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.Parameter;
import com.webapp.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public UserService() {

	}

}

package com.webapp.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

@Service
public class SystemService {
	@Autowired
	private UserDao userDao;
	
	public User get(Serializable id){
		return userDao.get(id);
	}
	
	public User getUserByLoginName(String loginName) {
		return userDao.findByLoginName(loginName);
	}
}

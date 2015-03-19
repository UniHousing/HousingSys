package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.UserDao;
import com.webapp.model.User;

@Component
public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao {

	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByLoginName(String loginName) {
		return find("select * from user where login_name="+loginName);
	}


}

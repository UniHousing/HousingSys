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


}

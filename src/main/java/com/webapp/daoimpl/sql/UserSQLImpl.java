package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.webapp.dao.Parameter;
import com.webapp.dao.UserDao;
import com.webapp.model.User;

@Component
public class UserSQLImpl extends BaseSQLImpl<User> implements UserDao {

	@Override
	public void save(User entity) {
		// TODO Auto-generated method stub
		
	}


}

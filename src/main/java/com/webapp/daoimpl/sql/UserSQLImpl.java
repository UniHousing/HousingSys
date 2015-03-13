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
	public List<User> findAll() {
		String sql = "select * from user";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				User.class));
		return users;
	}



	@Override
	public void save(User user) {
		this.jdbcTemplate.update("insert into user (name, id) values(?,?)",
				user.getName(), user.getId());
	}

	@Override
	public User findById(Serializable id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User user = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<User>(User.class));
		return user;
	}

}

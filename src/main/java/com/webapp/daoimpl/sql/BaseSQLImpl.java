package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import com.webapp.common.util.Reflections;
import com.webapp.dao.BaseDao;

public class BaseSQLImpl<T> implements BaseDao<T> {
   
	//@Resource
	//private SessionFactory sessionFactory;
	
	private Class<?> entityClass;
	
	public BaseSQLImpl(){
		this.entityClass =  Reflections.getClassGenricType(getClass());
	}
	
	public Class<?> getEntityClass(){
		return this.entityClass;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(List<T> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

package com.webapp.dao;

import java.io.Serializable;
import java.util.List;

import com.webapp.model.House;


public interface BaseDao<T> {
	/**
	 * Find an Entity By ID
	 * 
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T get(Serializable id);


	public List<T> findAll();
	/**
	 * Find All the Entity Using Query
	 * 
	 * @param qlstr
	 */
	public List<T> findAll(String qlstr);

	
	public <E> Page<E> find(Page<E> page, String sqlstr, Parameter parameter );
	/**
	 * Save Entity
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * Save a List of Entities
	 * 
	 * @param entities
	 */
	public void save(List<T> entities);

	/**
	 * Update
	 * 
	 * @param qlstr
	 *            TODO
	 */
	public void update(String qlstr);

	/**
	 * Delete Entity By id
	 * 
	 * @param id
	 */

	public void deleteById(Serializable id);
	
	public void delete(T entity);


}

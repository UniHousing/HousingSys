package com.webapp.dao;

import java.util.List;

import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.Student;

public interface StudentDao extends BaseDao<Student> {

	/**
	 * Find All the Users with Same Name
	 * 
	 * @param name
	 * @return
	 */
	public List<Student> findByFName(String fname);

	/**
	 * Find One Entity with Limitation
	 * 
	 * @param parameter
	 * @return
	 */
	public Student findOne(Parameter parameter);

	public void updateName(Student user, String fname,String lname);
}

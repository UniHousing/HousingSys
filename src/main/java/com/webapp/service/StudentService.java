package com.webapp.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.dao.StudentDao;
import com.webapp.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public StudentService() {

	}
	
	public Student get(int id){
		return studentDao.get(id);
	}
	
	/**
	 * Using Parameter to support multiple query condition
	 * translate parameter to sql query:
	 *  parameter[name]={"like","'%house.name%'"} => name like '%house.name%' 
	 *  parameter[type]=house.type => where type='house.type' 
	 * @param page
	 * @param house
	 * @return
	 */
	public Page<Student> find(Page<Student> page, Student entity){
		String sqlstr = "select * from student";
		Parameter parameter = new Parameter();
		
		if(StringUtils.isNotBlank(entity.getFname())){
			parameter.put("fname", new Object[]{"like", "'%"+entity.getFname()+"%'"});
		}
		if(StringUtils.isNotBlank(entity.getLname())){
			parameter.put("lname", new Object[]{"like", "'%"+entity.getLname()+"%'"});
		}
		
		if(StringUtils.isNotBlank(entity.getAddr())){
			parameter.put("addr", new Object[]{"like", "'%"+entity.getAddr()+"%'"});
		}
		
		page = studentDao.find(page,sqlstr, parameter);
		return page;
	}

	public void save(Student student){
		studentDao.save(student);
	}

	public void delete(Student student){
		studentDao.deleteById(student.getId());
	}	
}

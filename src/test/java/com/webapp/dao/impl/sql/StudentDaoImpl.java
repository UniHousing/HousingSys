package com.webapp.dao.impl.sql;



import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.HouseDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.dao.StudentDao;
import com.webapp.model.House;
import com.webapp.model.Student;

public class StudentDaoImpl extends SpringTransactionContextTest {
	
    @Autowired
    private StudentDao studentDao;
	
    
    @Test
    public void save(){
    	Student student = new Student();
    	student.setFname("jiang");
    	student.setLname("gu");
    	student.setBirthDate(new Date());
    	studentDao.save(student);
    }
    

}

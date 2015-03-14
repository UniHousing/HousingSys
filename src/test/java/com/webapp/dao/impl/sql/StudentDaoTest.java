package com.webapp.dao.impl.sql;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.StudentDao;
import com.webapp.model.Student;
public class StudentDaoTest extends SpringTransactionContextTest {

	@Resource(name = "studentDaoImpl")
	private StudentDao studentDao;

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Test
	public void save() {
		Student student = new Student();
		student.setFname("Jesse");
		student.setLname("Xu");
		studentDao.save(student);
		studentDao.delete(student);
	}

	@Test
	public void update() {
		Student student = new Student();
		student.setFname("Jesse");
		student.setLname("Xu");
		studentDao.save(student);
		studentDao.delete(student);

	}

	 @Test
	public void find() {
		Student student = new Student();
		student.setFname("Jesse");
		student.setLname("Xu");
		studentDao.save(student);
		Student newUser = studentDao.findById("210002");
		if (student != null) {
			System.out.println(student.getFname()+student.getLname());
		}
		studentDao.delete(student);
	}

	@Test
	public void findByName() {
		Student student = new Student();
		student.setFname("Jesse");
		student.setLname("Xu");
		Student user2 = new Student();
		user2.setFname("Fred");
		user2.setLname("Li");
		studentDao.save(student);
		studentDao.save(user2);

//		List<Student> users = studentDao.findByFName("fred");
//		assertEquals(users.size(), 1);
		studentDao.delete(student);
		studentDao.delete(user2);
	}

	@Test
	public void findAll() {
		Student user1 = new Student();
		user1.setFname("Fred");
		user1.setLname("Li");
		Student user2 = new Student();
		user1.setFname("Fred");
		user1.setLname("Li");
		studentDao.save(user1);
		studentDao.save(user2);

		List<Student> users = studentDao.findAll();
		assertEquals(users.size(), 2);
		studentDao.delete(user1);
		studentDao.delete(user2);
	}
}

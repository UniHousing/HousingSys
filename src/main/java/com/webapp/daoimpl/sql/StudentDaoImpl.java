package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.StudentDao;
import com.webapp.daoimpl.mdb.Parameter;
import com.webapp.model.Student;

@Component
public class StudentDaoImpl extends BaseSQLImpl<Student> implements StudentDao {

	@Override
	public List<Student> findByFName(String fname) {
		String sql = "select * from student where fname = ?";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Student> students = jdbcTemplate.query(sql, new Object[] { fname },
				new BeanPropertyRowMapper(Student.class));
		return students;
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Student.class));
		return students;
	}

	@Override
	public Student findOne(Parameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Student student) {
		this.jdbcTemplate.update("insert into student (fname,lname, id) values(?,?,?)",
				student.getFname(),student.getLname(), student.getId());
	}

	@Override
	public void delete(Student student) {
		String query = "delete from student where id='" + student.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public void updateName(Student student, String fname,String lname) {
		String query = "update student set fname= '" + fname + "',lname='"+lname+ "' where id='"
				+ student.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public Student findById(Serializable id) {
		String sql = "SELECT * FROM student WHERE id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Student>(Student.class));
		return student;
	}
}

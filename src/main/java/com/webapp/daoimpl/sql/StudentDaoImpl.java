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
	public void save(Student entity) {
		this.jdbcTemplate.update("insert into student (id,fname,lname,type"
				+ "gender,tel,alter_tel,addr,city,post_code,birth_date,category,"
				+ "nation,smoker,need,comment,status,courses.approval_id,kin_id)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				entity.getId(),entity.getFname(),entity.getLname(), entity.getType(),
				entity.getGender(),entity.getTel(),entity.getAlterTel(),entity.getAddr(),
				entity.getCity(),entity.getPostCode(),entity.getBirthDate(),entity.getCategory(),
				entity.getNation(),entity.getSmoker(),entity.getNeed(),entity.getComment(),
				entity.getStatus(),entity.getCourses(),entity.getApprovalId(),entity.getKinId());
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


	@Override
	public List<Student> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}
}

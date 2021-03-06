package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.StudentDao;
import com.webapp.model.Student;

@Component
public class StudentDaoImpl extends BaseSQLImpl<Student> implements StudentDao {


	@Override
	public void save(Student entity) {

		if(entity.getId()==0){
			this.jdbcTemplate.update("insert into student (fname,lname,type,"
				+ "gender,tel,alter_tel,addr,city,post_code,birth_date,category,"
				+ "nation,smoker,need,comment,status,courses,approval_id,kin_id)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				entity.getFname(),entity.getLname(), entity.getType(),
				entity.getGender(),entity.getTel(),entity.getAlterTel(),entity.getAddr(),
				entity.getCity(),entity.getPostCode(),entity.getBirthDate(),entity.getCategory(),
				entity.getNation(),entity.getSmoker(),entity.getNeed(),entity.getComment(),
				entity.getStatus(),entity.getCourses(),entity.getApprovalId(),entity.getKinId());
		}else{
			this.jdbcTemplate.update("update student set fname=?,lname=?,type=?,"
					+ "gender=?,tel=?,alter_tel=?,addr=?,city=?,post_code=?,birth_date=?,category=?,"
					+ "nation=?,smoker=?,need=?,comment=?,status=?,courses=?,approval_id=?,kin_id=? where id="+entity.getId(),
					entity.getFname(),entity.getLname(), entity.getType(),
					entity.getGender(),entity.getTel(),entity.getAlterTel(),entity.getAddr(),
					entity.getCity(),entity.getPostCode(),entity.getBirthDate(),entity.getCategory(),
					entity.getNation(),entity.getSmoker(),entity.getNeed(),entity.getComment(),
					entity.getStatus(),entity.getCourses(),entity.getApprovalId(),entity.getKinId());

		}
	}
}

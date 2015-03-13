package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.FamilyMemberDao;
import com.webapp.model.FamilyApartment;
import com.webapp.model.FamilyMember;

@Component
public class FamilyMemberDaoImpl extends BaseSQLImpl<FamilyMember> implements FamilyMemberDao {

	@Override
	public void save(FamilyMember fmember) {
		this.jdbcTemplate.update("insert into family_member (id, student_id, name, birth_date) values(?,?,?,?)",
				fmember.getId(),
				fmember.getStudentId(), 
				fmember.getName(),
				fmember.getBirthDate());
	}
}

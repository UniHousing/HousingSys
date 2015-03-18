package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.FamilyMemberDao;
import com.webapp.model.FamilyMember;

@Component
public class FamilyMemberDaoImpl extends BaseSQLImpl<FamilyMember> implements FamilyMemberDao {

	@Override
	public void save(FamilyMember fmember) {
		if (fmember.getId() == 0) {
			this.jdbcTemplate.update("insert into family_member (student_id, name, birth_date) values(?,?,?)",
					fmember.getStudentId(), 
					fmember.getName(),
					fmember.getBirthDate());
		} else {
			this.jdbcTemplate.update("update family_member set student_id=?, name=?, birth_date=? where id=?",
					fmember.getStudentId(), 
					fmember.getName(),
					fmember.getBirthDate(),
					fmember.getId());
		}
	}
	
}

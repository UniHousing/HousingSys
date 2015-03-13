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

	@Override
	public void delete(FamilyMember fmember) {
		String query = "delete from family_member where id='" + fmember.getId() + "' ";
		jdbcTemplate.update(query);
	}
	
	@Override
	public void updateName(FamilyMember fmember, String str) {
		String query = "update family_member set name= '" + str + "' where id='"
				+ fmember.getId() + "' ";
		jdbcTemplate.update(query);
	}

	@Override
	public FamilyMember findById(Serializable id) {
		String sql = "SELECT * FROM family_member WHERE id = ?";
		FamilyMember fmember = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<FamilyMember>(FamilyMember.class));
		return fmember;
	}
	
	@Override
	public List<FamilyMember> findByName(String name) {
		String sql = "select * from family_member where name = ?";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<FamilyMember> fmembers = jdbcTemplate.query(sql, new Object[] { name },
				new BeanPropertyRowMapper(FamilyMember.class));
		return fmembers;
	}

	@Override
	public List<FamilyMember> findAll() {
		String sql = "select * from family_member";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<FamilyMember> fmembers = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				FamilyApartment.class));
		return fmembers;
	}

}

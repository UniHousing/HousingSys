package com.webapp.dao.impl.sql;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.FamilyMemberDao;
import com.webapp.model.FamilyMember;

public class FamilyMemberDaoTest extends SpringTransactionContextTest {

	@Resource(name = "familyMemberDaoImpl")
	private FamilyMemberDao fMemberDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void save() {
		FamilyMember fMember = new FamilyMember();
		fMember.setId("1000");
		fMember.setStudentId("2015001");
		fMember.setName("Fred");
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dob = format.format(curDate);
		fMember.setBirthDate(dob);
		fMemberDao.save(fMember);
		fMemberDao.delete(fMember);
	}
	@Test
	public void findById() {
		FamilyMember fMember = new FamilyMember();
		fMember.setId("1001");
		fMember.setStudentId("2015001");
		fMember.setName("Fred");
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dob = format.format(curDate);
		fMember.setBirthDate(dob);
		fMemberDao.save(fMember);
		FamilyMember fMember1 = fMemberDao.findById("1001");
		assertEquals(fMember1.getStudentId(), "2015001");
		
		FamilyMember fMember2 = new FamilyMember();
		fMember2.setId("1002");
		fMember2.setStudentId("2015001");
		fMember2.setName("Fred");
		Date curDate1 = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		String dob1 = format.format(curDate);
		fMember2.setBirthDate(dob1);
		fMemberDao.save(fMember2);
		
		List<FamilyMember> fmembers = fMemberDao.findByName("Fred");   // FindByName Test
		assertEquals(fmembers.size(), 2);
		
		fMemberDao.delete(fMember);
		fMemberDao.delete(fMember2);
	}
	
	@Test
	public void updateName() {
		FamilyMember fMember = new FamilyMember();
		fMember.setId("1001");
		fMember.setStudentId("2015001");
		fMember.setName("Fred");
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dob = format.format(curDate);
		fMember.setBirthDate(dob);
		fMemberDao.save(fMember);
		fMemberDao.updateName(fMember, "Frank");
		FamilyMember fMember1 = fMemberDao.findById("1001");
		assertEquals(fMember1.getStudentId(), "2015001");
		fMemberDao.delete(fMember1);
	}
	@Test
	public void findAll() {
		FamilyMember fMember = new FamilyMember();
		fMember.setId("1003");
		fMemberDao.save(fMember);
		FamilyMember fMember2 = new FamilyMember();
		fMember2.setId("1004");
		fMemberDao.save(fMember2);
		List<FamilyMember> famts = fMemberDao.findAll();
		assertEquals(famts.size(), 2);
		fMemberDao.delete(fMember2);
		fMemberDao.delete(fMember2);
	}
}

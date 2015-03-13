package com.webapp.dao;

import java.util.List;

import com.webapp.model.FamilyMember;

public interface FamilyMemberDao extends BaseDao<FamilyMember> {

	void updateName(FamilyMember gApt, String str);

	List<FamilyMember> findByName(String name);

}

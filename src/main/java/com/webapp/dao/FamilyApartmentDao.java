package com.webapp.dao;

import java.util.List;

import com.webapp.model.FamilyApartment;

public interface FamilyApartmentDao extends BaseDao<FamilyApartment>  {

	List<FamilyApartment> findByName(String name);

	void updateName(FamilyApartment familyApartment, String str);

}

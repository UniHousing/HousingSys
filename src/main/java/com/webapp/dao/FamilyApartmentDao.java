package com.webapp.dao;

import java.util.List;

import com.webapp.model.FamilyApartment;

public interface FamilyApartmentDao extends BaseDao<FamilyApartment>  {

	void updateName(FamilyApartment fApartment, String string);

	@Override
	List<FamilyApartment> findAll();

	List<FamilyApartment> findByName(String string);

}
package com.webapp.dao;

import java.util.List;

import com.webapp.model.GeneralApartment;

public interface GeneralApartmentDao extends BaseDao<GeneralApartment> {

	List<GeneralApartment> findByName(String name);

	void updateName(GeneralApartment gApt, String str);

}

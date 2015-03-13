package com.webapp.dao.impl.sql;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.common.test.SpringTransactionContextTest;
import com.webapp.dao.HouseDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.model.House;

public class HouseDaoImpl extends SpringTransactionContextTest {
	
    @Autowired
    private HouseDao houseDao;
	
    @Test
    public void pageFind(){
    	Page<House> page = new Page<House>();
    	Parameter parameter = new Parameter();
    	page = houseDao.find(page,"select * from house", parameter);
    	for(House house: page.getList()){
    		System.out.println(house.getId());
    	}
    }
}

package com.webapp.service;

import java.io.Serializable;
import java.util.List;






import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.dao.HouseDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;
import com.webapp.model.House;

@Service
public class HouseService {
	@Autowired
	private HouseDao houseDao;

	public HouseService() {

	}
	

	public House get(int id){
		return houseDao.get(id);
	}
	
	public Page<House> find(Page<House> page, House house){
		String sqlstr = "select * from house";
		Parameter parameter = new Parameter();
		if(StringUtils.isNotBlank(house.getName())){
			parameter.put("name", house.getName());
		}
		if(StringUtils.isNotBlank(house.getType())){
			parameter.put("type", house.getType());
		}
		page = houseDao.find(page,sqlstr, parameter);
		return page;
	}

	public void save(House house){
		houseDao.save(house);
	}

	public void delete(House house){
		houseDao.deleteById(house.getId());
	}	
}

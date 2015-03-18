package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.NearbyDao;
import com.webapp.model.Nearby;
@Component
public class NearbyDaoImpl extends BaseSQLImpl<Nearby> implements NearbyDao {

	@Override
	public void save(Nearby entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into nearby (lot_id,house_id) values (?,?)",
					entity.getLotId(),
					entity.getHouseId());
		} else {
			this.jdbcTemplate.update("update nearby set lot_id=?,house_id=? where id=?",
					entity.getLotId(),
					entity.getHouseId(),
					entity.getId());
		}
		
	}

}

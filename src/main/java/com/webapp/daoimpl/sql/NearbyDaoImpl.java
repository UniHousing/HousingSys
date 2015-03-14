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
	public Nearby findById(Serializable id) {
		String sql = "SELECT * FROM nearby WHERE id = ?";
		Nearby entity = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Nearby>(Nearby.class));
		return entity;
	}

	@Override
	public List<Nearby> findAll() {
		String sql = "select * from nearby";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Nearby> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Nearby.class));
		return entities;
	}

	@Override
	public List<Nearby> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public void delete(Nearby entity) {
		String query = "delete from nearby where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

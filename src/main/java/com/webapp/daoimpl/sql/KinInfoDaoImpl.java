package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.KinInfoDao;
import com.webapp.model.KinInfo;
@Component
public class KinInfoDaoImpl extends BaseSQLImpl<KinInfo> implements KinInfoDao {

	@Override
	public KinInfo findById(Serializable id) {
		String sql = "SELECT * FROM kin_info WHERE id = ?";
		KinInfo entity = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<KinInfo>(KinInfo.class));
		return entity;
	}

	@Override
	public List<KinInfo> findAll() {
		String sql = "select * from kin_info";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<KinInfo> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				KinInfo.class));
		return entities;
	}

	@Override
	public List<KinInfo> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(KinInfo entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into kin_info (student_id,name,relationship,addr,city,post_code,tel) values (?,?,?,?,?,?,?)",
					entity.getStudentId(),
					entity.getName(),
					entity.getRelationship(),
					entity.getAddr(),
					entity.getCity(),
					entity.getPostCode(),
					entity.getTel());
		} else {
			this.jdbcTemplate.update("update kin_info set student_id=?,name=?,relationship=?,addr=?,city=?,post_code=?,tel=? where id=?",
					entity.getStudentId(),
					entity.getName(),
					entity.getRelationship(),
					entity.getAddr(),
					entity.getCity(),
					entity.getPostCode(),
					entity.getTel(),
					entity.getId());
		}
		
	}

	@Override
	public void delete(KinInfo entity) {
		String query = "delete from kin_info where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

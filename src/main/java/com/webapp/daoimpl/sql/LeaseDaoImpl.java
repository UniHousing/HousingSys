package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.LeaseDao;
import com.webapp.model.Lease;
@Component
public class LeaseDaoImpl extends BaseSQLImpl<Lease> implements LeaseDao {

	@Override
	public Lease findById(Serializable id) {
		String sql = "select * from lease where id = ?";
		Lease entity = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Lease>(Lease.class));
		return entity;
	}

	@Override
	public List<Lease> findAll() {
		String sql = "select * from lease";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Lease> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Lease.class));
		return entities;
	}

	@Override
	public List<Lease> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Lease entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into lease (student_id,house_id,room_id,room_num,duration,enter_date,leave_date,"
					+ "deposit,payment,penalty,inspect_date,parking_id" + ") values (?,?,?,?,?,?,?,?,?,?,?,?)",
					entity.getStudentId(),
					entity.getHouseId(),
					entity.getRoomId(),
					entity.getRoomNum(),
					entity.getDuration(),
					entity.getEnterDate(),
					entity.getLeaveDate(),
					entity.getDeposit(),
					entity.getPayment(),
					entity.getPenalty(),
					entity.getInspectDate(),
					entity.getParkingId());
		} else {
			this.jdbcTemplate.update("update lease set student_id=?,house_id=?,room_id=?,room_num=?,duration=?,enter_date=?,leave_date=?,"
					+ "deposit=?,payment=?,penalty=?,inspect_date=?,parking_id=?, where id=?",
					entity.getStudentId(),
					entity.getHouseId(),
					entity.getRoomId(),
					entity.getRoomNum(),
					entity.getDuration(),
					entity.getEnterDate(),
					entity.getLeaveDate(),
					entity.getDeposit(),
					entity.getPayment(),
					entity.getPenalty(),
					entity.getInspectDate(),
					entity.getParkingId(),
					entity.getId());
		}
		this.jdbcTemplate.update("insert into lease (id,student_id,house_id,room_id,room_num,duration,enter_date,leave_date,"
				+ "deposit,payment,penalty,inspect_date,parking_id" + ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
				entity.getId(),
				entity.getStudentId(),
				entity.getHouseId(),
				entity.getRoomId(),
				entity.getRoomNum(),
				entity.getDuration(),
				entity.getEnterDate(),
				entity.getLeaveDate(),
				entity.getDeposit(),
				entity.getPayment(),
				entity.getPenalty(),
				entity.getInspectDate(),
				entity.getParkingId());
	}

	@Override
	public void delete(Lease entity) {
		String query = "delete from lease where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

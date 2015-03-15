package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.LeaseDao;
import com.webapp.model.Lease;
@Component
public class LeaseDaoImpl extends BaseSQLImpl<Lease> implements LeaseDao {

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
					+ "deposit=?,payment=?,penalty=?,inspect_date=?,parking_id=? where id=?",
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
	}

}

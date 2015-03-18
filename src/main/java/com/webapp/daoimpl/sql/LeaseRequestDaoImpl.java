package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.LeaseRequestDao;
import com.webapp.model.LeaseRequest;
@Component
public class LeaseRequestDaoImpl extends BaseSQLImpl<LeaseRequest> implements LeaseRequestDao {

	@Override
	public void save(LeaseRequest entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into lease_request (student_id,preference1,preference2,preference3,status,start_date,end_date"
					+ ") values (?,?,?,?,?,?,?)",
					entity.getStudentId(),
					entity.getPreference1(),
					entity.getPreference2(),
					entity.getPreference3(),
					entity.getStatus(),
					entity.getStartDate(),
					entity.getEndDate());
		} else {
			this.jdbcTemplate.update("update lease_request set student_id=?,preference1=?,preference2=?,preference3=?,status=?,start_date=?,end_date=? where id=?",
					entity.getStudentId(),
					entity.getPreference1(),
					entity.getPreference2(),
					entity.getPreference3(),
					entity.getStatus(),
					entity.getStartDate(),
					entity.getEndDate(),
					entity.getId());
		}
		
	}
}

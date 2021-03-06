package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.TerminReqDao;
import com.webapp.model.TerminReq;
@Component
public class TerminReqDaoImpl extends BaseSQLImpl<TerminReq> implements TerminReqDao{

	@Override
	public void save(TerminReq entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into terminate_request"
					+ " (lease_id,reason,date,status,inspection_date,extra_fee"
					+ ") values(?,?,?,?,?,?)",
					entity.getLeaseId(),entity.getReason(),entity.getDate(),
					entity.getStatus(),entity.getInspectionDate(),entity.getExtraFee());
		} else {
			this.jdbcTemplate.update("update terminate_request"
					+ "set lease_id=?,reason=?,date=?,status=?,inspection_date=?,extra_fee=? where id=?",
					entity.getLeaseId(),entity.getReason(),entity.getDate(),
					entity.getStatus(),entity.getInspectionDate(),entity.getExtraFee(),entity.getId());
		}
		
	}


}

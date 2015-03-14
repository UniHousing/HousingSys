package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.TicketDao;
import com.webapp.model.Ticket;
@Component
public class TicketDaoImpl extends BaseSQLImpl<Ticket> implements TicketDao{



	@Override
	public void save(Ticket entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into ticket"
					+ " (type,student_id,date,location) values(?,?,?,?)",
					entity.getType(),entity.getStudentId(),entity.getDate(),entity.getLocation());
		} else {
			this.jdbcTemplate.update("update ticket"
					+ "set type=?,student_id=?,date=?,location=? where id=?",
					entity.getType(),entity.getStudentId(),entity.getDate(),entity.getLocation(),entity.getId());
		}
	
	}

}

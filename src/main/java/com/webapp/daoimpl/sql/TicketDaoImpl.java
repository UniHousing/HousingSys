package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.TicketDao;
import com.webapp.model.Ticket;
@Component
public class TicketDaoImpl extends BaseSQLImpl<Ticket> implements TicketDao{



	@Override
	public void save(Ticket entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into ticket"
				+ " (id,type,student_id,date,location) values(?,?,?,?,?)",
				entity.getId(),entity.getType(),entity.getStudentId(),entity.getDate(),entity.getLocation());
	}

}

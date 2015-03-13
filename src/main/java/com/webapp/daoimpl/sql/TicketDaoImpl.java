package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.TicketDao;
import com.webapp.model.Ticket;
@Component
public class TicketDaoImpl extends BaseSQLImpl<Ticket> implements TicketDao{

	@Override
	public Ticket findById(Serializable id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ticket WHERE id = ?";
		Ticket ticket = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return ticket;
	}

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from ticket ";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Ticket> tickets = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Ticket.class));
		return tickets;
	}

	@Override
	public List<Ticket> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Ticket entity) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into staff"
				+ " (id,type,student_id,date,location) values(?,?,?,?,?)",
				entity.getId(),entity.getType(),entity.getStudentId(),entity.getDate(),entity.getLocation());
	}

	@Override
	public void delete(Ticket entity) {
		// TODO Auto-generated method stub
		String query = "delete from ticket where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

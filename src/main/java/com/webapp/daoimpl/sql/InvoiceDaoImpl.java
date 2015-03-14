package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dao.InvoiceDao;
import com.webapp.model.Invoice;
@Component
public class InvoiceDaoImpl extends BaseSQLImpl<Invoice> implements InvoiceDao {

	@Override
	public Invoice findById(Serializable id) {
		String sql = "SELECT * FROM invoice WHERE id = ?";
		Invoice entity = jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Invoice>(Invoice.class));
		return entity;
	}

	@Override
	public List<Invoice> findAll() {
		String sql = "select * from invoice";
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Invoice> entities = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				Invoice.class));
		return entities;
	}

	@Override
	public List<Invoice> findAll(String qlstr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Invoice entity) {
		if (entity.getId() == 0) {
			this.jdbcTemplate.update("insert into invoice (lease_id,pay_date,pay_method,status,penalty,damage_charge,late_fee,total) values (?,?,?,?,?,?,?,?)",
					entity.getLeaseId(),
					entity.getPayDate(),
					entity.getPayMethod(),
					entity.getStatus(),
					entity.getPenalty(),
					entity.getDamageCharge(),
					entity.getLateFee(),
					entity.getTotal());
		} else {
			this.jdbcTemplate.update("update invoice set lease_id=?,pay_date=?,pay_method=?,status=?,penalty=?,damage_charge=?,late_fee=?,total=? where id=?",
					entity.getLeaseId(),
					entity.getPayDate(),
					entity.getPayMethod(),
					entity.getStatus(),
					entity.getPenalty(),
					entity.getDamageCharge(),
					entity.getLateFee(),
					entity.getTotal(),
					entity.getId());
		}
		
	}

	@Override
	public void delete(Invoice entity) {
		String query = "delete from invoice where id='" + entity.getId() + "' ";
		jdbcTemplate.update(query);
	}

}

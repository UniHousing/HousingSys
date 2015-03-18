package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.InvoiceDao;
import com.webapp.model.Invoice;
@Component
public class InvoiceDaoImpl extends BaseSQLImpl<Invoice> implements InvoiceDao {
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
}

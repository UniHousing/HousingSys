package com.webapp.daoimpl.sql;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.webapp.common.util.Reflections;
import com.webapp.common.util.StringUtils;
import com.webapp.dao.BaseDao;
import com.webapp.dao.Page;
import com.webapp.dao.Parameter;

@Component
public abstract class BaseSQLImpl<T> implements BaseDao<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private Class<?> entityClass;

	private String tableName;
	
	public BaseSQLImpl() {
		this.entityClass = Reflections.getClassGenricType(getClass());
		this.tableName = toUnderScore(entityClass.getSimpleName());
	}

	public Class<?> getEntityClass() {
		return this.entityClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id){
		return (T) this.jdbcTemplate.queryForObject("select * from "+tableName+" where id=?", new Object[]{id}, 
	              new BeanPropertyRowMapper(this.entityClass));
	}
	
	@Override
	public T findById(Serializable id) {
		return get(id);
	}

	@Override
	public List<T> findAll(){
		return findAll("select * from "+ tableName);
	}
	
	@Override
	public List<T> findAll(String qlstr) {
		return this.jdbcTemplate.query(qlstr, new BeanPropertyRowMapper(this.entityClass));
	}
	

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from " + tableName
				+ " where id=?", id);
	}
	
	@Override
	public void delete(T entity){
		int id;
		try {
			id = (Integer) entityClass.getMethod("getId").invoke( null);
			deleteById(id);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void save(List<T> entities) {
		for(T entity : entities){
			save(entity);
		}

	}

	@Override
	public void update(String qlstr) {
		// TODO Auto-generated method stub

	}
	
	//============SQL Query===============

	@Override
	public <E> Page<E> find(Page<E> page,String sqlstr, Parameter parameter){
		// Get Count
		if(!page.isDisabled()&&!page.isNotCount()){
			String countSqlstr = "select count(*) " + removeSelect(removeOrders(sqlstr));
			
			String query = createQuery(countSqlstr, parameter);
		    System.out.println("Count query:"+query);
			int count = this.jdbcTemplate.queryForObject(query, Integer.class);
			page.setCount(count);
			if(page.getCount()<1){
				return page;
			}
		}
		
		// order by
    	String sql = sqlstr;
		if (org.apache.commons.lang3.StringUtils.isNotBlank(page.getOrderBy())){
			sql += " order by " + page.getOrderBy();
		}
		
		String query = createQuery(sql, parameter);
		if(!page.isDisabled()){
			query +=  " limit "+ page.getFirstResult()+" , "+page.getMaxResults();
		}
		System.out.println("Pagin query: "+query);
		List<E>  result = (List<E>) findAll(query);
		page.setList(result);
		return page;
	}
	
	private String createQuery(String sqlstr, Parameter parameter){
	
		if(parameter==null||parameter.size()==0){
			return sqlstr;
		}
		
		String query = sqlstr;
		if (!sqlstr.toLowerCase().contains("where")){
			query +=" where ";
		}else{
			query +=" and ";
		}
		
		
		for (String key: parameter.keySet()){
			Object value = parameter.get(key);
			if( value instanceof Collection<?>){
				;
			}else if(value instanceof Object[]){
				query += key  ;
				for(Object ob : (Object[])value){
					query += " "+ob;
				}
			}else {
				query  += key+"=";
				/*If  value is string, should be quote*/
				if( value instanceof String){        
					query +="'"+value+"'";
				}else{
					query += value;
				}
			}
			query +=" and ";
		}
		//remove last "and";
		return query.trim().substring(0, query.length()-4);
	}
	//=============Tools  ================
	/**
	 * Remove select 
	 * @param qlString
	 * @return
	 */
	 private String removeSelect(String qlString){  
	        int beginPos = qlString.toLowerCase().indexOf("from");  
	        return qlString.substring(beginPos);  
	    }  
	      
	    /** 
	     * Remove orderBy。 
	     * @param qlString
	     * @return 
	     */  
	    private String removeOrders(String qlString) {  
	        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);  
	        Matcher m = p.matcher(qlString);  
	        StringBuffer sb = new StringBuffer();  
	        while (m.find()) {  
	            m.appendReplacement(sb, "");  
	        }
	        m.appendTail(sb);
	        return sb.toString();  
	    } 
	    
	    private String toUnderScore(String ClassName){
	    	return ClassName;
	    }
	






}

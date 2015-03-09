package com.webapp.daoimpl.sql;

import org.springframework.stereotype.Component;

import com.webapp.dao.RequestDao;
import com.webapp.model.Request;
import com.webapp.model.User;
@Component
public class RequestSQLImpl extends BaseSQLImpl<Request> implements RequestDao{

}

<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ page import="com.webapp.common.beanvalidator.BeanValidators"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%response.setStatus(200);%>
<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
	//记录日志
	if (ex!=null){
		Logger logger = LoggerFactory.getLogger("500.jsp");
		logger.error(ex.getMessage(), ex);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>500 - Server Internal Error</title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header"><h1>server internal error.</h1></div>
		<p>error info：</p><p>
		<%
			if (ex!=null){
				/*
				if (ex instanceof javax.validation.ConstraintViolationException){
					for (String s : BeanValidators.extractPropertyAndMessageAsList((javax.validation.ConstraintViolationException)ex, ": ")){
						out.print(s+"<br/>");
					}
				}else{
					out.print(ex+"<br/>");
				}*/
				out.print(ex+"<br/>");
			}
		%>
		</p>
		<div><a href="javascript:" onclick="history.go(-1);" class="btn">back</a></div>
		<script>try{top.$.jBox.closeTip();}catch(e){}</script>
	</div>
</body>
</html>
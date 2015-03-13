<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>student manage</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/or/student/">student list</a></li>
		<li><a href="${ctx}/or/student/form">add student</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="student" action="${ctx}/or/student/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>fname ：</label><form:input path="fname" htmlEscape="false" maxlength="50" class="input-small"/>
		<label>type ：</label><form:input path="type" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="Search"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>First Name</th><th>Type</th><shiro:hasPermission name="or:student:edit"><th>operation</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="student">
			<tr>
				<td><a href="${ctx}/or/student/form?id=${student.id}">${student.fname}</a></td>
				<td>${student.type}</td>
				<shiro:hasPermission name="or:student:edit"><td>
    				<a href="${ctx}/or/student/form?id=${student.id}">edit</a>
					<a href="${ctx}/or/student/delete?id=${student.id}" onclick="return confirmx('are you sure delete this student？', this.href)">delete</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>

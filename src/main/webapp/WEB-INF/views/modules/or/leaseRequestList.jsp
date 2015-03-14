<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>leaseRequest manage</title>
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
		<li class="active"><a href="${ctx}/or/student/">leaseRequest list</a></li>
		<li><a href="${ctx}/or/student/form">add leaseRequest</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="leaseRequest" action="${ctx}/or/leaseRequest/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>fname ：</label><form:input path="fname" htmlEscape="false" maxlength="50" class="input-small"/>
		<label>type ：</label><form:input path="type" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="Search"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>studentId</th><th>preference1</th><th>preference2</th><th>preference3</th><th>status</th><th>startDate</th><th>endDate</th><shiro:hasPermission name="or:leaseRequest:edit"><th>operation</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="leaseRequest">
			<tr>
				<td><a href="${ctx}/or/leaseRequest/form?id=${leaseRequest.id}">${leaseRequest.studentId}</a></td>
				<td>${leaseRequest.preference1}</td>
				<td>${leaseRequest.preference2}</td>
				<td>${leaseRequest.preference3}</td>
				<td>${leaseRequest.status}</td>
				<td>${leaseRequest.startDate}</td>
				<td>${leaseRequest.endDate}</td>
				<shiro:hasPermission name="or:leaseRequest:edit"><td>
    				<a href="${ctx}/or/student/form?id=${leaseRequest.id}">edit</a>
					<a href="${ctx}/or/student/delete?id=${leaseRequest.id}" onclick="return confirmx('are you sure delete this leaseRequest？', this.href)">delete</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>

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
		<li class="active"><a href="${ctx}/or/leaseRequest/">leaseRequest list</a></li>
		<li><a href="${ctx}/or/leaseRequest/form">add leaseRequest</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="leaseRequest" action="${ctx}/or/leaseRequest/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<label>studentId ：</label><form:input path="studentId" htmlEscape="false" maxlength="50" class="input-small"/>
		<label>preference1 ：</label><form:input path="preference1" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="Search"/>
	</form:form>
	<tags:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>Student Id</th><th>Preference 1</th><shiro:hasPermission name="or:leaseRequest:edit"><th>operation</th></shiro:hasPermission></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="lease_request">
			<tr>
				<td><a href="${ctx}/or/leaseRequest/form?id=${lease_request.id}">${lease_request.studentId}</a></td>
	
				<shiro:hasPermission name="or:leaseRequest:edit"><td>
    				<a href="${ctx}/or/leaseRequest/form?id=${lease_request.id}">edit</a>
					<a href="${ctx}/or/leaseRequest/delete?id=${lease_request.id}" onclick="return confirmx('are you sure delete this leaseRequest？', this.href)">delete</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>

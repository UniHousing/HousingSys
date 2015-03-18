<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Request House</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
			$("#studentType").on("change",function(){
				var studenttype = $(this).val();
				if(studenttype == 1){
				  $(".control-group.apartment").hide();
				}else{
				  $(".control-group.apartment").show();
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/or/leaseRequest/">LeaseRequest List</a></li>
		<li class="active"><a href="${ctx}/or/leaseRequest/form?id=${leaseRequest.id}">leaseRequest<shiro:hasPermission name="or:leaseRequest:edit">${not empty leaseRequest.id?'edit':'add'}</shiro:hasPermission><shiro:lacksPermission name="or:leaseRequest:edit">view</shiro:lacksPermission></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="leaseRequest" action="${ctx}/or/leaseRequest/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="name">studentId:</label>
			<div class="controls">
				<form:input path="studentId" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">preference1:</label>
			<div class="controls">
				<form:input path="preference1" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">preference2:</label>
			<div class="controls">
				<form:input path="preference2" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">preference3:</label>
			<div class="controls">
				<form:input path="preference3" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="name">startDate:</label>
			<div class="controls">
				<input id="startDate" name="startDate" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${LeaseRequest.startDate}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">endDate:</label>
			<div class="controls">
				<input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${LeaseRequest.endDate}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="or:leaseRequest:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="Save"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="Back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>Student Management</title>
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
		<li><a href="${ctx}/or/student/">student List</a></li>
		<li class="active"><a href="${ctx}/or/student/form?id=${student.id}">student<shiro:hasPermission name="or:student:edit">${not empty student.id?'edit':'add'}</shiro:hasPermission><shiro:lacksPermission name="or:student:edit">view</shiro:lacksPermission></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="student" action="${ctx}/or/student/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="name">FirstName:</label>
			<div class="controls">
				<form:input path="fname" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">LastName:</label>
			<div class="controls">
				<form:input path="lname" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="endTime">Birth Date：</label>
			<div class="controls">
				<input id="birthDate" name="birthDate" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${student.birthDate}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Type:</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">telephone:</label>
			<div class="controls">
				<form:input path="tel" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Alternative Telephone:</label>
			<div class="controls">
				<form:input path="alterTel" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Address:</label>
			<div class="controls">
				<form:input path="addr" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">City:</label>
			<div class="controls">
				<form:input path="city" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Post Code:</label>
			<div class="controls">
				<form:input path="postCode" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Category:</label>
			<div class="controls">
				<form:input path="category" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Nation:</label>
			<div class="controls">
				<form:input path="nation" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Somker:</label>
			<div class="controls">
				<form:input path="smoker" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Need:</label>
			<div class="controls">
				<form:input path="need" htmlEscape="false" maxlength="200" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Comment:</label>
			<div class="controls">
				<form:input path="comment" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">Status:</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="name">courses:</label>
			<div class="controls">
				<form:input path="courses" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="or:student:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="Save"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="Back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>

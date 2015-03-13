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
			<label class="control-label" for="name">LastName:</label>
			<div class="controls">
				<form:input path="lname" htmlEscape="false" maxlength="200" class="required"/>
			</div>
			<label class="control-label">student Type：</label>
			<div class="controls" id="student-type">
			
					<form:input path="type" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Gender：</label>
			<div class="controls" id="gender">
			
					<form:input path="gender" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			
			<label class="control-label">Tel：</label>
			<div class="controls" id="tel">
			
					<form:input path="tel" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Alternative Tel：</label>
			<div class="controls" id="alter_tel">
			
					<form:input path="alterTel" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Address：</label>
			<div class="controls" id="addr">
			
					<form:input path="addr" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">City：</label>
			<div class="controls" id="city">
			
					<form:input path="city" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Postal Code：</label>
			<div class="controls" id="post_code">
			
					<form:input path="postCode" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Birth Date：</label>
			<div class="controls" id="birth_date">
			
					<form:input path="birthDate" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Category：</label>
			<div class="controls" id="category">
			
					<form:input path="category" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Nationality：</label>
			<div class="controls" id="nation">
			
					<form:input path="nation" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Smoker：</label>
			<div class="controls" id="smoker">
			
					<form:input path="smoker" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Special Need：</label>
			<div class="controls" id="need">
			
					<form:input path="need" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Comment：</label>
			<div class="controls" id="comment">
			
					<form:input path="comment" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Status：</label>
			<div class="controls" id="status">
			
					<form:input path="status" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Courses：</label>
			<div class="controls" id="courses">
			
					<form:input path="courses" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">Approval ID：</label>
			<div class="controls" id="approval_id">
			
					<form:input path="approvalId" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
			<label class="control-label">KIN ID：</label>
			<div class="controls" id="kin_id">
			
					<form:input path="kinId" htmlEscape="false" maxlength="200" class="required"/>
				
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

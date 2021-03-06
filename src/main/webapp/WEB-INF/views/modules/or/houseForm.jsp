<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>house管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
			$("#houseType").on("change",function(){
				var housetype = $(this).val();
				if(housetype == 1){
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
		<li><a href="${ctx}/or/house/">house列表</a></li>
		<li class="active"><a href="${ctx}/or/house/form?id=${house.id}">house<shiro:hasPermission name="or:house:edit">${not empty house.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="or:house:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="house" action="${ctx}/or/house/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		<div class="control-group">
			<label class="control-label" for="name">Name/Number:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="200" class="required"/>
			</div>
			
		<div class="control-group">
			<label class="control-label">House Type：</label>
			<div class="controls" id="house-type">
			
					<form:input path="type" htmlEscape="false" maxlength="200" class="required"/>
				
			</div>
		</div>
		</div>

		
		<div class="form-actions">
			<shiro:hasPermission name="or:house:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="Save"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="Back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>

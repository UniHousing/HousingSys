<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>application Manage</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate();
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/or/application/">application list</a></li>
		<li class="active"><a href="${ctx}/or/application/form?id=${application.id}">${not empty application.id?'edit':'new'}application detail</a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="application" action="${ctx}/or/application/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${message}"/>
		
		<div class="control-group">
			<label class="control-label">house type：</label>
			<div class="controls">
				<form:select path="houseType" >
					<form:options items="" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="startTime">start：</label>
			<div class="controls">
				<input id="startTime" name="startTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${application.startTime}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="endTime">end：</label>
			<div class="controls">
				<input id="endTime" name="endTime" type="text" readonly="readonly" maxlength="20" class="Wdate required"
					value="<fmt:formatDate value="${application.endTime}" pattern="yyyy-MM-dd "/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="comment">comment:</label>
			<div class="controls">
				<form:textarea path="comment" class="required" rows="5" maxlength="255"/>
			</div>
		</div>
		
		<div class="form-actions">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="Apply"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="back" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>

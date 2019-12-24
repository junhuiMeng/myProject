<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>评议议题管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			if('${demTheme.year}'!= ''){
				$('#year').attr("readonly",true);
			}
			
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/theme/demTheme/">评议议题列表</a></li>
		<li class="active"><a href="${ctx}/theme/demTheme/form?id=${demTheme.id}">评议议题<shiro:hasPermission name="theme:demTheme:edit">${not empty demTheme.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="theme:demTheme:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="demTheme" action="${ctx}/theme/demTheme/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">年       度：</label>
			<div class="controls">
				<form:select path="year" class="input-xlarge" id="year">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('year')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
				<%-- <form:input path="year" htmlEscape="false" maxlength="10" class="input-xlarge "/> --%>
		</div>
		<div class="control-group">
			<label class="control-label">议      题：</label>
			<div class="controls">
				<form:input path="theme" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">起始时间：</label>
			<div class="controls">
				<%-- <input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${demTheme.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> --%>
					<input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${demTheme.startDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${demTheme.endDate}" pattern="yyyy-MM-dd"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">协议：</label>
			<div class="controls">
				<%-- <form:input path="attention" htmlEscape="false" maxlength="600" class="input-xlarge "/> --%>
				<form:textarea path="attention" htmlEscape="false" rows="4" maxlength="500" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="2" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">预留字段1：</label>
			<div class="controls">
				<form:input path="hold1" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预留字段2：</label>
			<div class="controls">
				<form:input path="hold2" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预留字段3：</label>
			<div class="controls">
				<form:input path="hold3" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预留字段4：</label>
			<div class="controls">
				<form:input path="hold4" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预留字段5：</label>
			<div class="controls">
				<form:input path="hold5" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div> --%>
		<%-- <div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:select path="status" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div> --%>
		<div class="form-actions">
			<shiro:hasPermission name="theme:demTheme:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
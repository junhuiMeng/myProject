<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>评议议题管理</title>
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
		<li class="active"><a href="${ctx}/theme/demTheme/">评议议题列表</a></li>
		<shiro:hasPermission name="theme:demTheme:edit"><li><a href="${ctx}/theme/demTheme/form">评议议题添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="demTheme" action="${ctx}/theme/demTheme/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>年度：</label>
			<form:select path="year" class="input-medium">
					<form:option value="" label=""/>
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('year')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
				<%-- <form:input path="year" htmlEscape="false" maxlength="10" class="input-medium"/> --%>
			</li>
			<%-- <li><label>协议：</label>
				<form:input path="attention" htmlEscape="false" maxlength="600" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width=40px;>年度</th>
				<th width="15%">议题</th>
				<th width=70px;>起始时间</th>
				<th width=70px;>终止时间</th>
				<th width="40%">协议</th>
				<!-- <th>更新时间</th> -->
				<th>备注信息</th>
				<!-- <th>状态</th> -->
				<shiro:hasPermission name="theme:demTheme:edit"><th width="5%">操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="demTheme">
			<tr>
				<td><a href="${ctx}/theme/demTheme/form?id=${demTheme.id}">
					${demTheme.year}
				</a></td>
				<td>
					${demTheme.theme}
				</td>
				<td>
					<fmt:formatDate value="${demTheme.startDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<fmt:formatDate value="${demTheme.endDate}" pattern="yyyy-MM-dd"/>
				</td>
				<td title="${demTheme.attention}">
					${demTheme.attention}
				</td>
				<%-- <td>
					<fmt:formatDate value="${demTheme.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${demTheme.remarks}
				</td>
				<%-- <td>
					${fns:getDictLabel(demTheme.status, '', '')}
				</td> --%>
				<shiro:hasPermission name="theme:demTheme:edit"><td>
    				<a href="${ctx}/theme/demTheme/form?id=${demTheme.id}">修改</a>
					<a href="${ctx}/theme/demTheme/delete?id=${demTheme.id}" onclick="return confirmx('确认要删除该评议议题吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
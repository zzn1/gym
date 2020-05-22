<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>岩馆管理管理</title>
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
		<li class="active"><a href="${ctx}/sys/rockHall/">岩馆管理列表</a></li>
		<shiro:hasPermission name="sys:rockHall:edit"><li><a href="${ctx}/sys/rockHall/form">岩馆管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rockHall" action="${ctx}/sys/rockHall/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>地区：</label>
				<form:input path="region" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>岩馆名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:input path="status" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>岩馆类型：</label>
				<form:input path="type" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>地区</th>
				<th>岩馆名称</th>
				<th>状态</th>
				<th>岩馆类型</th>
				<th>update_date</th>
				<th>remarks</th>
				<shiro:hasPermission name="sys:rockHall:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rockHall">
			<tr>
				<td><a href="${ctx}/sys/rockHall/form?id=${rockHall.id}">
					${rockHall.region}
				</a></td>
				<td>
					${rockHall.name}
				</td>
				<td>
					${rockHall.status}
				</td>
				<td>
					${rockHall.type}
				</td>
				<td>
					<fmt:formatDate value="${rockHall.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${rockHall.remarks}
				</td>
				<shiro:hasPermission name="sys:rockHall:edit"><td>
    				<a href="${ctx}/sys/rockHall/form?id=${rockHall.id}">修改</a>
					<a href="${ctx}/sys/rockHall/delete?id=${rockHall.id}" onclick="return confirmx('确认要删除该岩馆管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
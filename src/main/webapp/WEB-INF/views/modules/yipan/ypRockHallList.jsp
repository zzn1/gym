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
		<li class="active"><a href="${ctx}/yipan/ypRockHall/">岩馆管理列表</a></li>
		<shiro:hasPermission name="yipan:ypRockHall:edit"><li><a href="${ctx}/yipan/ypRockHall/form">岩馆管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypRockHall" action="${ctx}/yipan/ypRockHall/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>结构id：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>岩馆编号：</label>
				<form:input path="rockNo" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>地区：</label>
				<form:input path="region" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>岩馆名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>地址：</label>
				<form:input path="add" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>10次卡价格：</label>
				<form:input path="priceV10" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>20次卡价格：</label>
				<form:input path="priceV20" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>结构id</th>
				<th>岩馆编号</th>
				<th>地区</th>
				<th>岩馆名称</th>
				<th>地址</th>
				<th>10次卡价格</th>
				<th>20次卡价格</th>
				<th>状态</th>
				<th>岩馆类型</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypRockHall:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypRockHall">
			<tr>
				<td><a href="${ctx}/yipan/ypRockHall/form?id=${ypRockHall.id}">
					${ypRockHall.id}
				</a></td>
				<td>
					${ypRockHall.rockNo}
				</td>
				<td>
					${ypRockHall.region}
				</td>
				<td>
					${ypRockHall.name}
				</td>
				<td>
					${ypRockHall.add}
				</td>
				<td>
					${ypRockHall.priceV10}
				</td>
				<td>
					${ypRockHall.priceV20}
				</td>
				<td>
					${ypRockHall.status}
				</td>
				<td>
					${ypRockHall.type}
				</td>
				<td>
					<fmt:formatDate value="${ypRockHall.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypRockHall.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypRockHall:edit"><td>
    				<a href="${ctx}/yipan/ypRockHall/form?id=${ypRockHall.id}">修改</a>
					<a href="${ctx}/yipan/ypRockHall/delete?id=${ypRockHall.id}" onclick="return confirmx('确认要删除该岩馆管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
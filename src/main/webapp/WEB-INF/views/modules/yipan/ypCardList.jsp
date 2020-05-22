<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>卡种管理管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypCard/">卡种管理列表</a></li>
		<shiro:hasPermission name="yipan:ypCard:edit"><li><a href="${ctx}/yipan/ypCard/form">卡种管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypCard" action="${ctx}/yipan/ypCard/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>卡号：</label>
				<form:input path="cardnum" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>卡类型：</label>
				<form:input path="cardtype" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>卡名称：</label>
				<form:input path="cardname" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>储值金额：</label>
				<form:input path="stored" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>次卡类型：</label>
				<form:input path="fretype" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>地区：</label>
				<form:input path="region" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>卡号</th>
				<th>卡类型</th>
				<th>卡名称</th>
				<th>储值金额</th>
				<th>次卡类型</th>
				<th>地区</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypCard:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypCard">
			<tr>
				<td><a href="${ctx}/yipan/ypCard/form?id=${ypCard.id}">
					${ypCard.cardnum}
				</a></td>
				<td>
					${ypCard.cardtype}
				</td>
				<td>
					${ypCard.cardname}
				</td>
				<td>
					${ypCard.stored}
				</td>
				<td>
					${ypCard.fretype}
				</td>
				<td>
					${ypCard.region}
				</td>
				<td>
					<fmt:formatDate value="${ypCard.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypCard.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypCard:edit"><td>
    				<a href="${ctx}/yipan/ypCard/form?id=${ypCard.id}">修改</a>
					<a href="${ctx}/yipan/ypCard/delete?id=${ypCard.id}" onclick="return confirmx('确认要删除该卡种管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
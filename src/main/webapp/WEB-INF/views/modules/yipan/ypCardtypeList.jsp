<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>卡种表方案管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypCardtype/">卡种表方案列表</a></li>
		<shiro:hasPermission name="yipan:ypCardtype:edit"><li><a href="${ctx}/yipan/ypCardtype/form">卡种表方案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypCardtype" action="${ctx}/yipan/ypCardtype/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>地区：</label>
				<form:input path="area" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>卡种：</label>
				<form:input path="cardtype" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>储值金额：</label>
				<form:input path="sstored" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>期限：</label>
				<form:input path="term" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>权益：</label>
				<form:input path="equity" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>卡种</th>
				<th>储值金额</th>
				<th>期限</th>
				<th>权益</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypCardtype:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypCardtype">
			<tr>
				<td><a href="${ctx}/yipan/ypCardtype/form?id=${ypCardtype.id}">
					${ypCardtype.area}
				</a></td>
				<td>
					${ypCardtype.cardtype}
				</td>
				<td>
					${ypCardtype.sstored}
				</td>
				<td>
					${ypCardtype.term}
				</td>
				<td>
					${ypCardtype.equity}
				</td>
				<td>
					<fmt:formatDate value="${ypCardtype.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypCardtype.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypCardtype:edit"><td>
    				<a href="${ctx}/yipan/ypCardtype/form?id=${ypCardtype.id}">修改</a>
					<a href="${ctx}/yipan/ypCardtype/delete?id=${ypCardtype.id}" onclick="return confirmx('确认要删除该卡种表方案吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
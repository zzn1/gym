<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员管理管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypMember/">会员管理列表</a></li>
		<shiro:hasPermission name="yipan:ypMember:edit"><li><a href="${ctx}/yipan/ypMember/form">会员管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypMember" action="${ctx}/yipan/ypMember/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>openid  ：</label>
				<form:input path="openid" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="carduser" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:input path="sex" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>年龄：</label>
				<form:input path="age" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li><label>手机号：</label>
				<form:input path="phone" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idcard" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>openid</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机号</th>
				<th>身份证号</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypMember:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypMember">
			<tr>
				<td><a href="${ctx}/yipan/ypMember/form?id=${ypMember.id}">
					${ypMember.openid}
				</a></td>
				<td>
					${ypMember.carduser}
				</td>
				<td>
					${ypMember.sex}
				</td>
				<td>
					${ypMember.age}
				</td>
				<td>
					${ypMember.phone}
				</td>
				<td>
					${ypMember.idcard}
				</td>
				<td>
					<fmt:formatDate value="${ypMember.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypMember.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypMember:edit"><td>
    				<a href="${ctx}/yipan/ypMember/form?id=${ypMember.id}">修改</a>
					<a href="${ctx}/yipan/ypMember/delete?id=${ypMember.id}" onclick="return confirmx('确认要删除该会员管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
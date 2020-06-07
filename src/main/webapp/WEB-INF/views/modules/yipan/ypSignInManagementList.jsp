<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>打卡记录管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypSignInManagement/">打卡记录列表</a></li>
		<shiro:hasPermission name="yipan:ypSignInManagement:edit"><li><a href="${ctx}/yipan/ypSignInManagement/form">打卡记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypSignInManagement" action="${ctx}/yipan/ypSignInManagement/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>卡号：</label>
				<form:input path="cardNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>卡种：</label>
				<form:input path="cardType" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
<%--			<li><label>openid：</label>
				<form:input path="openid" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>--%>
			<li><label>持卡人姓名：</label>
				<form:input path="carduser" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
<%--			<li><label>岩馆编号：</label>
				<form:input path="rockNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>--%>
<%--			<li><label>岩馆名称：</label>
				<form:input path="rockName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>--%>
<%--			<li><label>签到时间：</label>
				<input name="signInTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${ypSignInManagement.signInTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>--%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>卡号</th>
				<th>卡种</th>
<%--				<th>openid</th>--%>
				<th>持卡人姓名</th>
<%--				<th>岩馆编号</th>--%>
				<th>岩馆名称</th>
				<th>签到时间</th>
				<th>更新时间</th>
<%--				<th>备注信息</th>--%>
				<shiro:hasPermission name="yipan:ypSignInManagement:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypSignInManagement">
			<tr>
				<td><a href="${ctx}/yipan/ypSignInManagement/form?id=${ypSignInManagement.id}">
					${ypSignInManagement.cardNo}
				</a></td>
				<td>
					${fns:getDictLabel(ypSignInManagement.cardType, 'card_type', '')}
				</td>
<%--				<td>
					${ypSignInManagement.openid}
				</td>--%>
				<td>
					${ypSignInManagement.carduser}
				</td>
<%--				<td>
					${ypSignInManagement.rockNo}
				</td>--%>
				<td>
					${ypSignInManagement.rockName}
				</td>
				<td>
					<fmt:formatDate value="${ypSignInManagement.signInTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${ypSignInManagement.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
<%--				<td>
					${ypSignInManagement.remarks}
				</td>--%>
				<shiro:hasPermission name="yipan:ypSignInManagement:edit"><td>
    				<a href="${ctx}/yipan/ypSignInManagement/form?id=${ypSignInManagement.id}">修改</a>
					<a href="${ctx}/yipan/ypSignInManagement/delete?id=${ypSignInManagement.id}" onclick="return confirmx('确认要删除该打卡记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
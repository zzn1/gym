<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>持卡信息管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypCardHolder/">持卡信息列表</a></li>
		<shiro:hasPermission name="yipan:ypCardHolder:edit"><li><a href="${ctx}/yipan/ypCardHolder/form">持卡信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypCardHolder" action="${ctx}/yipan/ypCardHolder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>卡号：</label>
				<form:input path="cardNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>卡类型：</label>
				<form:input path="cardType" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>openid：</label>
				<form:input path="openid" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>持卡人姓名：</label>
				<form:input path="carduser" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>剩余次数：</label>
				<form:input path="remainingTimes" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>易豆：</label>
				<form:input path="beans" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>失效日期：</label>
				<input name="expirationDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${ypCardHolder.expirationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>购卡日期：</label>
				<input name="buyDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${ypCardHolder.buyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>openid</th>
				<th>持卡人姓名</th>
				<th>剩余次数</th>
				<th>易豆</th>
				<th>失效日期</th>
				<th>购卡日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypCardHolder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypCardHolder">
			<tr>
				<td><a href="${ctx}/yipan/ypCardHolder/form?id=${ypCardHolder.id}">
					${ypCardHolder.cardNo}
				</a></td>
				<td>
					${ypCardHolder.cardType}
				</td>
				<td>
					${ypCardHolder.openid}
				</td>
				<td>
					${ypCardHolder.carduser}
				</td>
				<td>
					${ypCardHolder.remainingTimes}
				</td>
				<td>
					${ypCardHolder.beans}
				</td>
				<td>
					<fmt:formatDate value="${ypCardHolder.expirationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${ypCardHolder.buyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${ypCardHolder.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypCardHolder.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypCardHolder:edit"><td>
    				<a href="${ctx}/yipan/ypCardHolder/form?id=${ypCardHolder.id}">修改</a>
					<a href="${ctx}/yipan/ypCardHolder/delete?id=${ypCardHolder.id}" onclick="return confirmx('确认要删除该持卡信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
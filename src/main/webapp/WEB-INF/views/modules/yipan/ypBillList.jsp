<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流水记账管理</title>
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
		<li class="active"><a href="${ctx}/yipan/ypBill/">流水记账列表</a></li>
		<shiro:hasPermission name="yipan:ypBill:edit"><li><a href="${ctx}/yipan/ypBill/form">流水记账添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ypBill" action="${ctx}/yipan/ypBill/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>卡号：</label>
				<form:input path="cardNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>扣卡次数：</label>
				<form:input path="signInNum" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>原价：</label>
				<form:input path="originalPrice" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>实际扣费价格：</label>
				<form:input path="deductionPrice" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>易豆补偿数量：</label>
				<form:input path="beansNum" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>岩馆编号：</label>
				<form:input path="rockNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>扣费类型：</label>
				<form:input path="deductionType" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>扣卡次数</th>
				<th>原价</th>
				<th>实际扣费价格</th>
				<th>易豆补偿数量</th>
				<th>岩馆编号</th>
				<th>扣费类型</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="yipan:ypBill:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ypBill">
			<tr>
				<td><a href="${ctx}/yipan/ypBill/form?id=${ypBill.id}">
					${ypBill.cardNo}
				</a></td>
				<td>
					${ypBill.signInNum}
				</td>
				<td>
					${ypBill.originalPrice}
				</td>
				<td>
					${ypBill.deductionPrice}
				</td>
				<td>
					${ypBill.beansNum}
				</td>
				<td>
					${ypBill.rockNo}
				</td>
				<td>
					${ypBill.deductionType}
				</td>
				<td>
					<fmt:formatDate value="${ypBill.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${ypBill.remarks}
				</td>
				<shiro:hasPermission name="yipan:ypBill:edit"><td>
    				<a href="${ctx}/yipan/ypBill/form?id=${ypBill.id}">修改</a>
					<a href="${ctx}/yipan/ypBill/delete?id=${ypBill.id}" onclick="return confirmx('确认要删除该流水记账吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
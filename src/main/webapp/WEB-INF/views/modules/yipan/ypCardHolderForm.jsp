<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>持卡信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
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
		<li><a href="${ctx}/yipan/ypCardHolder/">持卡信息列表</a></li>
		<li class="active"><a href="${ctx}/yipan/ypCardHolder/form?id=${ypCardHolder.id}">持卡信息<shiro:hasPermission name="yipan:ypCardHolder:edit">${not empty ypCardHolder.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="yipan:ypCardHolder:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ypCardHolder" action="${ctx}/yipan/ypCardHolder/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">卡号：</label>
			<div class="controls">
				<form:input path="cardNo" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">卡类型：</label>
			<div class="controls">
				<form:input path="cardType" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">openid：</label>
			<div class="controls">
				<form:input path="openid" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">持卡人姓名：</label>
			<div class="controls">
				<form:input path="carduser" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">剩余次数：</label>
			<div class="controls">
				<form:input path="remainingTimes" htmlEscape="false" maxlength="255" class="input-xlarge  digits"/>
			</div>
		</div>
<%--		<div class="control-group">--%>
<%--			<label class="control-label">易豆：</label>--%>
<%--			<div class="controls">--%>
<%--				<form:input path="beans" htmlEscape="false" maxlength="255" class="input-xlarge "/>--%>
<%--			</div>--%>
<%--		</div>--%>
		<div class="control-group">
			<label class="control-label">失效日期：</label>
			<div class="controls">
				<input name="expirationDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${ypCardHolder.expirationDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">购卡日期：</label>
			<div class="controls">
				<input name="buyDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${ypCardHolder.buyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="yipan:ypCardHolder:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>岩馆管理管理</title>
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
		<li><a href="${ctx}/yipan/ypRockHall/">岩馆管理列表</a></li>
		<li class="active"><a href="${ctx}/yipan/ypRockHall/form?id=${ypRockHall.id}">岩馆管理<shiro:hasPermission name="yipan:ypRockHall:edit">${not empty ypRockHall.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="yipan:ypRockHall:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ypRockHall" action="${ctx}/yipan/ypRockHall/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		

		<div class="control-group">
			<label class="control-label">地区：</label>
			<div class="controls">
				<form:input path="region" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
	<%--	<div class="control-group">
			<label class="control-label">岩馆名称：</label>
			<div class="controls">
				<form:input path="rockName" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">岩馆名称：</label>

			<div class="controls">
				<sys:treeselect id="office" name="rockNo" value="${ypRockHall.rockNo}" labelName="rockName"
                                labelValue="${ypRockHall.rockName}"
                                title="岩馆名称" url="/sys/office/treeData?type=2" cssClass="" allowClear="true"
								notAllowSelectParent="true"/>
			</div>
		</div>
<%--		<div class="control-group">
			<label class="control-label">岩馆名称:</label>
			<div class="controls">
				<sys:treeselect id="office" name="rockNo" value="${ypRockHall.rockNo}" labelName="rockName" labelValue="${ypRockHall.rockName}"
								title="岩馆名称" url="/sys/office/treeData?type=2" cssClass="required" notAllowSelectParent="true"/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">10次卡价格：</label>
			<div class="controls">
				<form:input path="priceV10" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">20次卡价格：</label>
			<div class="controls">
				<form:input path="priceV20" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">岩馆类型：</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="yipan:ypRockHall:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
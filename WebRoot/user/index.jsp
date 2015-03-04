<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/usersList.css">
<div class="content">
	<div class="header">
		<h1 class="page-title">用户信息列表</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<div id="addUser">
					<a
						href="${pageContext.request.contextPath}/Servlet/UserAction?method=getAllUsers"
						class="btn btn-primary">打印所有用户</a><a style="width:5px;">&nbsp;</a><a
						href="${pageContext.request.contextPath}/Servlet/UserAction?method=addInput"
						class="btn btn-primary">增加用户</a>&nbsp;
				</div>
				<form>
					<table class="table table-bordered table-hover"
						contenteditable="false">
						<thead>
							<tr>
								<th>用户名</th>
								<th>真实名</th>
								<th>电话</th>
								<th>邮件</th>
								<th>所属部门</th>
								<th>地址</th>
								<th>修改</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list }" var="data">
								<tr>
									<td>${data.username }</td>
									<td>${data.name }</td>
									<td>${data.phone }</td>
									<td>${data.email }</td>
									<td>${data.aid.name }</td>
									<td>${data.address }</td>
									<td><a
										href="${pageContext.request.contextPath}/Servlet/UserAction?method=updateInput&username=${data.username}">修改</a>
									</td>
									<td><a href="#"
										onclick="isDel('${pageContext.request.contextPath}/Servlet/UserAction?method=del&username=${data.username}')">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
				<div class="paging"><%@include file="/common/page.jsp"%></div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
<!--
	function isDel(str) {
		var istrue = window.confirm("是否删除");
		if (istrue) {
			window.open(str);
		}
	}
//-->
</script>
<%@include file="/common/foot.jsp"%>

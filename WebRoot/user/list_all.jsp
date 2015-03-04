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
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users }" var="data">
								<tr>
									<td>${data.username }</td>
									<td>${data.name }</td>
									<td>${data.phone }</td>
									<td>${data.email }</td>
									<td>${data.aid.name }</td>
									<td>${data.address }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/stylesheets/person_input.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">用户信息编辑</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form action="${pageContext.request.contextPath}/Servlet/UserAction"
					method="post">
					<input type="hidden" name="method" value="updateBySelf">
					<table id="counUserInf" class="table table-bordered table-hover"
						contenteditable="false">
						<tbody>
							<tr>
								<td>用户名</td>
								<td>${user.username }</td>
							</tr>
							<tr>
								<td>密码</td>
								<td><input type="password" name="password" id="label3" value="${user.password }" /></td>
							</tr>

							<tr>
								<td>真实姓名</td>
								<td><input type="text" name="name" id="label3"
									value="${user.name }" />
								</td>
							</tr>
							<tr>
								<td>电话</td>
								<td><input type="text" name="phone" id="label4"
									value="${user.phone}" />
								</td>
							</tr>
							<tr>
								<td>所属的市局</td>
								<td>${user.aid.name}</td>
							</tr>
							<tr>
								<td>电子邮件</td>
								<td><input type="text" name="email" id="label5"
									value="${user.email }" />
								</td>
							</tr>
							<tr>
								<td>地址</td>
								<td><input type="text" name="address" id="label5"
									value="${user.address}" maxlength="50" />
								</td>
							</tr>
							<tr>
								<td colspan="2" class="submitTd"><input class="btn btn-primary"
									type="submit">
								</td>
							</tr>
						<tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/counPersInp.js"></script>
<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
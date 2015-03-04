<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp" %>
<%@include file="/common/left.jsp" %>
<div class="content">
	<div class="header">
		<h1 class="page-title">修改用户</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">编辑用户信息</p>
				<div class="block-body">
	<form
		action="${pageContext.request.contextPath}/Servlet/UserAction" method="post">
		<input type="hidden" name="method" value="update">
		<input type="hidden" name="aid" value="${user2.aid.aid }">
		<table  class="table table-bordered table-hover"
						contenteditable="false">
			<tr>
				<td><div align="right">用户名：</div>
				</td>
				<td><label for="textfield"></label> <input
					type="text" name="username" id="textfield"  value="${user2.username }" />
				</td>
			</tr>
			<tr>
				<td><div align="right">密码：</div>
				</td>
				<td><label for="label"></label> <input type="password"
					name="password" id="label" value="${user2.password }"/>
				</td>
			</tr>
			
			<tr>
				<td><div align="right">真实姓名：</div>
				</td>
				<td><label for="label3"></label> <input type="text" name="name"
					id="label3" value="${user2.name }" />
				</td>
			</tr>
			<tr>
				<td><div align="right">电话：</div>
				</td>
				<td><label for="label4"></label> <input type="text"
					name="phone" id="label4" value="${user2.phone}"/>
				</td>
			</tr>
			<tr>
				<td><div align="right">所属市县或高校：</div>
				</td>
				<td>
				<input type="text"
					id="label4"  value="${user2.aid.name}"  disabled="disabled"/>
				</tr>
			<tr>
				<td><div align="right">电子邮件：</div>
				</td>
				<td><label for="label5"></label> <input type="text"
					name="email" id="label5"  value="${user2.email }"/>
				</td>
			</tr>
			<tr>
				<td><div align="right">地址：</div>
				</td>
				<td><label for="label5"></label> <input type="text"
					name="address" id="label5"  value="${user2.email }"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" >
				<input type="submit" class="btn btn-primary pull-right">
				</td>
			</tr>
		</table>
	</form>

			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>

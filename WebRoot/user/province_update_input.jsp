<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp" %>
<%@include file="/common/left.jsp" %>
<div class="content">
	<div class="header">
		<h1 class="page-title">增加用户</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">填写新用户信息</p>
				<div class="block-body">
	<form action="${pageContext.request.contextPath}/Servlet/UserAction" method="post">
		<input type="hidden" name="method" value="updateBySelf">
		<table width="782" border="1" align="center"class="table table-bordered table-hover"
						contenteditable="false">
			<tr>
				<td width="228"><div align="right">用户名：</div>
				</td>
				<td width="538"><label for="textfield"></label> 
				${user.username }
				</td>
			</tr>
			<tr>
				<td width="228"><div align="right">密码：</div>
				</td>
				<td width="538"><label for="textfield"></label> 
				
					<input type="password" name="password" id="label3" value="${user.password }" />
				</td>
			</tr>
			
			<tr>
				<td><div align="right">真实姓名：</div>
				</td>
				<td><label for="label3"></label> 
				<input type="text" name="name" id="label3" value="${user.name }" />
				</td>
			</tr>
			<tr>
				<td><div align="right">电话：</div>
				</td>
				<td><label for="label4"></label> 
				<input type="text" 	name="phone" id="label4" value="${user.phone}"/>
				</td>
			</tr>
			<tr>
				<td><div align="right">所属的市局：</div>
				</td>
				<td>
				
			${user.aid.name}
				</td>
			</tr>
			<tr>
				<td><div align="right">电子邮件：</div>
				</td>
				<td><label for="label5"></label> <input type="text"
					name="email" id="label5"  value="${user.email }"/>
				</td>
			</tr>
			<tr>
				<td><div align="right">地址：</div>
				</td>
				<td><label for="label5"></label> 
				<input type="text"	name="address" id="label5"  value="${user.address}" maxlength="50"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit">
				</td>
			</tr>
		</table>
	</form>

			</div>
		</div>
	</div>
</div>

<%@include file="/common/foot.jsp" %></td></tr>

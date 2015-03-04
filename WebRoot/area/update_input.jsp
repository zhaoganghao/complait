<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp" %>
<%@include file="/common/left.jsp" %>
<div class="content">
	<div class="header">
		<h1 class="page-title">更新区域</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">更新区域信息</p>
				<div class="block-body">
	<form
		action="${pageContext.request.contextPath}/Servlet/AreaAction" method="post">
		<input type="hidden" name="method" value="update">
		<input type="hidden" name="aid" value="${area.aid }">
		<table class="table table-bordered table-hover"
						contenteditable="false">
			<tr>
				<td ><div align="right">区域名：</div>
				</td>
				<td ><label for="textfield"></label> <input
					type="text" name="name" id="textfield"  value="${area.name }" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit">
				</td>
			</tr>
		</table>
	</form>
</div>
			</div>
		</div>
	</div>
</div>

<%@include file="/common/foot.jsp" %></td></tr>

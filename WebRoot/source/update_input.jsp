<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp" %>
<%@include file="/common/left.jsp" %>
<div class="content">
	<div class="header">
		<h1 class="page-title">更新举报方式</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">更新举报方式信息</p>
				<div class="block-body">
	<form
		action="${pageContext.request.contextPath}/Servlet/SourceAction" method="post">
		<input type="hidden" name="method" value="update">
		<input type="hidden" name="id" value="${category.sid }">
		<table width="782" border="1" align="center" class="table table-bordered table-hover"
						contenteditable="false">
			<tr>
				<td width="228"><div align="right"></div>
				</td>
				<td width="538"><label for="textfield">举报方式名</label> <input
					type="text" name="name" id="textfield"  value="${category.name }" />
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

<%@include file="/common/foot.jsp" %></td></tr>

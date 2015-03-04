<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<div class="content ">
		<div class="header">
		<h1 class="page-title">投诉列表</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
		<table width="807" border="1" align="center" class="table table-bordered" contenteditable="false">
		<tr>
			<td width="176">投诉编号</td>

			<td width="103">来问单位</td>
			<td width="136">被举报单位</td>
			<td width="176">投诉时间</td>
			<td width="182">所限回复日期</td>
			<td width="182">是否回复</td>
			<td width="182">查看</td>
		</tr>
		<c:forEach items="${page.list }" var="information">
			<tr>
				<td>${information.encode }</td>
				<td>${information.ifrom }</td>
				<td>${information.department }</td>
				<td>${information.curr_date }</td>
				
				<td>
				
				${information.limit_time }</td>
				<td>
				<c:if test="${information.rid==null }">
						<a href="${pageContext.request.contextPath}/Servlet/CollegeAction?method=addInput&iid=${information.iid}">回复</a>
						
						</c:if>
						<c:if test="${ !empty(information.rid )}">
										已回复
										
										</c:if>
										
										</td>
				<td width="182"><a
					href="${pageContext.request.contextPath}/Servlet/CollegeAction?method=getInformation&iid=${information.iid}">查看</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
							<td colspan="9"><%@include file="/common/page.jsp" %></td>
						</tr>
	</table>

</div>
</div>
</div>
</div>

<%@include file="/common/foot.jsp"%>

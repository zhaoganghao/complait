<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/reply.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/pikaday.css">
<div class="content">
	<div class="header">
		<h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<table class="table table-bordered table-hover"
					contenteditable="false">
					<thead>
						<tr>
							<th colspan="10" class="seachTitle">投诉情况</th>
						</tr>
						<tr>
							<th>序号</th>
							<th>投诉编号</th>
							<th>被举报单位</th>
							<th>违规类别</th>
							<th>举报类别</th>
							<th>单位类别</th>
							<th>所属区域</th>
							<th>投诉时间</th>
							<th>所限时间</th>
							<th>市是否回复</th>
							<th>查看</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${informations!=null}">
				<% int id=0; %>
					<c:forEach items="${informations }" var="information">
						<tr>
							<%  id=id+1; %>
							<td>	<%= id %></td>
							<td>${information.encode }</td>
							 <td>${information.department }</td>
							<td>${information.cid.name }</td>
							<td>${information.sid.name }</td>
							<td>${information.did.name }</td>
							<td>
							<c:if test="${information.aid!=null }">
							
							${information.aid.name }
							</c:if>
							<c:if test="${information.caid!=null }">
							
							${information.caid.name }
							</c:if>
							</td>
							<td>${information.curr_date }</td>
							<td>
								${information.limit_time}
							</td>
							<td>
								<c:if test="${information.rid==null }">
								<font color="#FF0000">市未回复</font>
								</c:if>
								 <c:if test="${ !empty(information.rid )}">
												市已回复
								</c:if>
							</td>
							<td>
							<a
								href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=getInformation&iid=${information.iid}">查看</a>
							</td>
						</tr>
						</c:forEach>
						</c:if>
						<c:if test="${informations==null}">
							<tr>
							<th>无数据</th>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/pikaday.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/inputTime.js"
	type="text/javascript"></script>
<%@include file="/common/foot.jsp"%>

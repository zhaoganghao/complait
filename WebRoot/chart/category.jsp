<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/chartSource.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/pikaday.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">各个类别报表</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form
					action="${pageContext.request.contextPath}/Servlet/ChartAction"
					method="post">
					<input type="hidden" name="method" value="query">
					
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="6" class="seachTitle">输入查询条件</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>选择类别</td>
								<td><select name="type">
										<c:if test="${param.type==1 }">
										<option value="1" selected="selected">市</option>
										</c:if>
										<c:if test="${param.type!=1 }">
										<option value="1">市</option>
										</c:if>
										<c:if test="${param.type==2 }">
										<option value="2" selected="selected">县</option>
										</c:if>
										<c:if test="${param.type!=2 }">
										<option value="2" >县</option>
										</c:if>
										
										<c:if test="${param.type==3 }">
										<option value="3" selected="selected">高校</option>
										</c:if>
										<c:if test="${param.type!=3 }">
										<option value="3" >高校</option>
										</c:if>
										
										<c:if test="${param.type==4 }">
										<option value="4" selected="selected">举报方式</option>
										</c:if>
										<c:if test="${param.type!=4 }">
										<option value="4" >举报方式</option>
										</c:if>
										
										<c:if test="${param.type==5 }">
										<option value="5" selected="selected">违规类别</option>
										</c:if>
										<c:if test="${param.type!=5 }">
										<option value="5" >违规类别</option>
										</c:if>
										<c:if test="${param.type==6 }">
										<option value="6" selected="selected">单位类别</option>
										</c:if>
										<c:if test="${param.type!=6 }">
										<option value="6" >单位类别</option>
										</c:if>
								</select>
								</td>
								<td>起始时间</td>
								<td><input type="text" name="startdate" id="index_p_s"  value="${param.startdate }"/>
								</td>
								<td>结束时间</td>
								<td><input type="text" name="enddate" id="index_p_e" value="${param.enddate }" />
								</td>
							</tr>
							<tr>
								<td colspan="6" class="seachsub"><input type="submit"
									class="btn btn-primary" value="查询">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
					<c:if test="${datas!=null}">
				<table class="table table-bordered table-hover"
					contenteditable="false">
					<thead>
						<tr>
							<th colspan="10" class="seachTitle">${pagetitle}</th>
						</tr>
						<tr>
							<th>序号</th>
							<th>所属类别</th>
							<th>被举报次数</th>
						</tr>
					</thead>
					<tbody>
					<% int id=0; %>
						<c:forEach items="${datas }" var="data">
							<tr>
								<%  id=id+1; %>
							    <td><%= id %></td>
								<td>${data.name}</td>
								<td>${data.number }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/pikaday.min.js"
	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/source.js"
	type="text/javascript"></script>
<%@include file="/common/foot.jsp"%>
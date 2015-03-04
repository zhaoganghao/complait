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
	<script type="text/javascript">
<!--
	function isDel(str){
	var istrue=window.confirm("是否删除");
	if(istrue){
		window.open(str);
	}
	}
//-->
</script>
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
							<th colspan="10" class="seachTitle">${pagetitle}</th>
						</tr>
						<tr>
							<th>投诉编号</th>
							<th>被举报单位</th>
							<th>违规类别</th>
							<th>举报方式</th>
							<th>单位类别</th>
							<th>所属区域</th>
							<th>投诉时间</th>
							<th>所限回复日期</th>
							<th>修改</th>
							<th>删除</th>
							<th>查看</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${Copys==null }">
						<tr>
						<th colspan="11">无</th>
						</tr>
					
					</c:if>
					<c:forEach items="${Copys }" var="copy">
						<tr>
							<td>${copy.encode }</td>
							 <td>${copy.department }</td>
							<td>${copy.cid.name }</td>
							<td>${copy.sid.name }</td>
							<td>${copy.did.name }</td>
							<td>
							<c:if test="${copy.aid!=null }">
							
							${copy.aid.name }
							</c:if>
							<c:if test="${copy.caid!=null }">
							
							${copy.caid.name }
							</c:if>
							</td>
							<td>${copy.curr_date }</td>
							<td>
								${copy.limit_time}
							</td>
							<th><a
								href="${pageContext.request.contextPath}/Servlet/InformationAction?method=copyUpdateInput&id=${copy.id}">修改</a></th>
							<th>								
								<a href="#" onclick="isDel('${pageContext.request.contextPath}/Servlet/InformationAction?method=copyDel&id=${copy.id}')">删除</a>
								
								</th>
							<td><a
								href="${pageContext.request.contextPath}/Servlet/InformationAction?method=getCopy&id=${copy.id}">查看</a>
							</td>
						</tr>
						</c:forEach>
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

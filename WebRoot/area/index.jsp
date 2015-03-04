<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/usersList.css">
<div class="content">
	<div class="header">
		<h1 class="page-title">区域管理</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<div id="addUser">
					<a href="${pageContext.request.contextPath}/Servlet/AreaAction?method=addInput&pid=${pid}<c:if test="${flag!=null }">&state=3</c:if>"
						class="btn btn-primary">增加区域</a>
				</div>
					<table class="table table-bordered table-hover"
						contenteditable="false">
						<thead>
							<tr>
								<th>编号</th>
								<th>区域名</th>
								<th>修改</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${areas}" var="area">
								<tr>
									<td>${area.aid }</td>
									<td>
									<c:if test="${ area.state==1}">
									<a href="${pageContext.request.contextPath}/Servlet/AreaAction?method=getChildren&pid=${area.aid}"
						>${area.name }</a></c:if>
						<c:if test="${ area.state!=1}">${area.name }</c:if>
						</td>
									<td><a
										href="${pageContext.request.contextPath}/Servlet/AreaAction?method=updateInput&aid=${area.aid}">修改</a>
									</td>
									<td>
										<a href="#" onclick="isDel('${pageContext.request.contextPath}/Servlet/AreaAction?method=del&aid=${area.aid}')">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>

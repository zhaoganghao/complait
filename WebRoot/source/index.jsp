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
		<h1 class="page-title">举报方式管理</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<div id="addUser">
					<a href="${pageContext.request.contextPath}/Servlet/SourceAction?method=addInput"
						class="btn btn-primary">添加举报方式</a>
				</div>
					<table class="table table-bordered table-hover"
						contenteditable="false">
						<thead>
							<tr>
								<th>编号</th>
								<th>举报方式名</th>
								<th>修改</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categorys}" var="category">
								<tr>
									<td>${category.sid }</td>
									<td>
									${category.name }
						</td>
									<td><a
										href="${pageContext.request.contextPath}/Servlet/SourceAction?method=updateInput&id=${category.sid}">修改</a>
									</td>
									<td>
										<a href="#" onclick="isDel('${pageContext.request.contextPath}/Servlet/SourceAction?method=del&id=${category.sid}')">删除</a>
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

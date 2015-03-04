<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<div class="content">
	<div class="header">
		<h1 class="page-title">添加违规类别</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">违规类别信息</p>
				<div class="block-body">
					<form id="addUserForm" action="${pageContext.request.contextPath}/Servlet/ComplaintAction"
						method="post">
						<input type="hidden"  name="method" value="add"> 
						<label>违规名</label> 
						<input  id="weigui"type="text" class="span5"
							name="name" onblur="strValidate('weigui',15)"/><span>不能为空，字符不能超过15个</span>
						<br> <input type="submit" class="btn btn-primary "
							value="增加"> <label class="remember-me"></label>
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>
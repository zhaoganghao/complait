<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>

<div class="content">
	<div class="header">
		<h1 class="page-title">添加单位类别</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">单位类别信息</p>
				<div class="block-body">
					<form id="addUserForm" action="${pageContext.request.contextPath}/Servlet/DiplomaAction"
						method="post">
						<input type="hidden"  name="method" value="add"> 
						<label>违规名</label> 
						<input  id="weiguis"type="text" class="span5"
							name="name"onblur="strValidate('weiguis',11)"/><span>不能为空，字符不能超过11个</span>
						<br> <input type="submit" class="btn btn-primary "
							value="增加"> <label class="remember-me"></label>
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
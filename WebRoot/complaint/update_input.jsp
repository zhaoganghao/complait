<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<div class="content">
	<div class="header">
		<h1 class="page-title">更新违规类别</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">更新违规类别信息</p>
				<div class="block-body">
					<form
						action="${pageContext.request.contextPath}/Servlet/ComplaintAction"
						method="post">
						<input type="hidden" name="method" value="update"> <input
							type="hidden" name="id" value="${category.cid }">
						<table class="table table-bordered table-hover"
							contenteditable="false">
							<tr>
								<td><div align="right"></div>
								</td>
								<td><label for="textfield">违规类别名</label> <input
									type="text" name="name" id="textfield"
									value="${category.name }" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit" class="btn btn-primary">
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	$("[rel=tooltip]").tooltip();
	$(function() {
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>

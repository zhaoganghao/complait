<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/stylesheets/forward_input.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">转发下级</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form
					action="${pageContext.request.contextPath}/Servlet/ReplyAction"
					method="post">
					<input type="hidden" name="iid" value="${iid }"> <input
						type="hidden" name="method" value="addForward">
					<table id="forwCompInf" class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tabTitle">转发表</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>选择县</td>
								<td><select name="aid">
										<c:forEach items="${area }" var="data">
											<option value="${ data.aid}">${data.name }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>建议：</td>
								<td><label for="textarea"></label> <textarea name="remark" id="remark"
										cols="40" rows="10" id="textarea" onblur="nullValidate('remark',10)"></textarea><span>不能为空</span></td>
							</tr>
							<tr>
								<td>转发人：</td>
								<td><label for="textfield"></label> <input type="text"
									name="name" id="name" onblur="strValidate('name',6)"/><span>不能为空，字符不能超过6个</span></td>
							</tr>
							<tr>
								<td>联系人电话：</td>
								<td><label for="textfield"></label> <input type="text"
									name="phone"  id="phone"   onblur="phoneValidate('phone',15)" /><span >不能为空，字符不能超过15个</span></td>
							</tr>
							<tr>
								<td>联系人邮件：</td>
								<td><label for="textfield"></label> <input type="text"
									name="email" id="email" onblur="emailValidate('email',20)"/><span>不能为空，字符不能超过20个,格式要正确</span></td>
							</tr>
							<tr>
								<td colspan="2" class="submitTd"><input class="btn btn-primary"
									type="submit" /></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/forward_input.js"></script>
<%@include file="/common/foot.jsp"%>
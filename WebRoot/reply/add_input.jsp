<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/stylesheets/addInputRep.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">编辑回复信息</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form
					action="${pageContext.request.contextPath}/Servlet/ReplyAction"
					method="post">
					<input type="hidden" name="iid" value="${iid }"> <input
						type="hidden" name="method" value="add">
					<table id="editCompTab" class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tabTitle">回复表单</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>是否属实：</td>
								<td><input class="selTrueFalse" type="radio"
									name="isBoolean" value="1" id="radiobutton" checked="checked"/>属实<input
									class="selTrueFalse" type="radio" name="isBoolean" value="0"
									id="radio" />不属实</td>
							</tr>
							<tr>
								<td>回复内容：</td>
								<td><label for="textarea"></label> <textarea id="content"name="content"
										cols="40" rows="10" id="textarea"onblur="nullValidate('content',10)"></textarea><span>不能为空</span>
								</td>
							</tr>
							<tr>
								<td>回复人：</td>
								<td><label for="textfield"></label> <input id="name" type="text"
									name="name"  onblur="strValidate('name',6)"/><span>不能为空，字符不能超过6个</span>
								</td>
							</tr>
							<tr>
								<td>回复人电话：</td>
								<td><label for="textfield"></label> <input id="phone"type="text"
									name="phone"   onblur="phoneValidate('phone',15)" /><span >不能为空，字符不能超过15个</span>
								</td>
							</tr>
							<tr>
								<td>回复人电子邮件：</td>
								<td><label for="textfield"></label> <input type="text"
									name="email" id="email" onblur="emailValidate('email',20)"/><span>不能为空，字符不能超过20个,格式要正确</span>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="submitTd"><input class="btn btn-primary"
									type="submit" />
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/addInputRep.js"></script>
<%@include file="/common/foot.jsp"%>
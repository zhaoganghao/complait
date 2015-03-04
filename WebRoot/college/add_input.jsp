<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<link href="${pageContext.request.contextPath}/css/frameStyle.css"
	type="text/css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/input.css"
	type="text/css" rel="stylesheet">
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">高校回复</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form
					action="${pageContext.request.contextPath}/Servlet/CollegeAction"
					method="post">
					<input type="hidden" name="iid" value="${iid }"> <input
						type="hidden" name="method" value="add">
					<table class="table table-bordered" contenteditable="false">
						<tr>
							<td colspan="2"><div align="center">
									<span class="STYLE1">回复表单</span>
								</div></td>
						</tr>
						<tr>
							<td>是否属实：</td>
							<td><input class="selTrueFalse" type="radio"
								name="isBoolean" value="1" id="radiobutton" checked="checked" />属实<input
								class="selTrueFalse" type="radio" name="isBoolean" value="0"
								id="radio" />不属实</td>
						</tr>
						<tr>
							<td>回复内容：</td>
							<td><label for="textarea"></label> <textarea id="content"
									name="content" cols="40" rows="10" id="textarea"
									onblur="nullValidate('content',10)"></textarea><span>不能为空</span>
							</td>
						</tr>
						<tr>
							<td>回复人：</td>
							<td><label for="textfield"></label> <input id="name"
								type="text" name="name" onblur="strValidate('name',6)" /><span>不能为空，字符不能超过6个</span>
							</td>
						</tr>
						<tr>
							<td>回复人电话：</td>
							<td><label for="textfield"></label> <input id="phone"
								type="text" name="phone" onblur="phoneValidate('phone',15)" /><span>不能为空，字符不能超过15个</span>
							</td>
						</tr>
						<tr>
							<td>回复人电子邮件：</td>
							<td><label for="textfield"></label> <input type="text"
								name="email" id="email" onblur="emailValidate('email',20)" /><span>不能为空，字符不能超过20个,格式要正确</span>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" class="btn btn-primary" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>
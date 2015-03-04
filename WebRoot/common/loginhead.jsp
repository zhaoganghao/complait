<%@ page language="java" import="java.util.*,cn.e21.hbjyhf.model.User"
	pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>投诉系统</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/main.css">
<script src="${pageContext.request.contextPath}/lib/jquery-1.7.2.min.js"
	type="text/javascript"></script>
</head>
<body class="">
	<div class="navbar">
		<div class="navbar-inner">
			<c:if test="user==null">
				<ul class="nav pull-right">
					<li class="display"><a href="#"
						class="hidden-phone visible-tablet visible-desktop" role="button">设置</a>
					</li>
					<li id="fat-menu" class="dropdown"><a href="#" role="button"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-user"></i> 省级用户 <i class="icon-caret-down"></i> </a>
						<ul class="dropdown-menu">
							<li><a tabindex="-1" href="#">我的账号</a>
							</li>
							<li class="divider"></li>
							<li><a tabindex="-1" class="visible-phone" href="#">设置</a>
							</li>
							<li class="divider visible-phone"></li>
							<li><a tabindex="-1" href="sign-in.jsp">退出</a>
							</li>
						</ul>
					</li>
				</ul>
			</c:if>
			<a class="brand" href="${pageContext.request.contextPath}/information/index.jsp"><span
				class="first"><img class="logo"
					src="${pageContext.request.contextPath}/imgs/logo.png"> </span> <span
				class="second"><img
					src="${pageContext.request.contextPath}/imgs/logoTextTop.png">
			</span><span class="second"><img
					src="${pageContext.request.contextPath}/imgs/logoTextBottom.png">
			</span> </a>
		</div>
	</div>

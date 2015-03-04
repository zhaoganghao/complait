<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<script type="text/javascript">
//创建ajax引擎
	function getXmlHttpObject(){
		
		var xmlHttpRequest;
		//不同的浏览器获取对象xmlhttprequest 对象方法不一样
		if(window.ActiveXObject){
			
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
			
		}else{

			xmlHttpRequest=new XMLHttpRequest();
		}

		return xmlHttpRequest;

	}

	var myXmlHttpRequest="";

function check1(){

	myXmlHttpRequest=getXmlHttpObject();

	if(myXmlHttpRequest){
		
		var url="${pageContext.request.contextPath}/Servlet/UserAction";//post
		var data="method=checkUserName&username="+$('username').value;
		myXmlHttpRequest.open("post",url,true);//异步方式
		myXmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

		//指定回调函数
		myXmlHttpRequest.onreadystatechange=chuli;

		//发送
		myXmlHttpRequest.send(data);
	}
}

	function chuli(){
		if(myXmlHttpRequest.readyState==4){
			
			if(myXmlHttpRequest.status==200){
				
				//取出服务器回送的数据

				var cont=myXmlHttpRequest.responseText;
				
				$('span1').innerHTML=cont;
			}
		}
	}


	//这里我们写一个函数
	function $(id){
		return document.getElementById(id);
	}

</script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/addUser.css">
<div class="content">
	<div class="header">
		<h1 class="page-title">增加用户</h1>
	</div>
	<div class="row-fluid">
		<div class="dialog">
			<div class="block">
				<p class="block-heading">填写新用户信息</p>
				<div class="block-body">
					<form id="addUserForm" action="${pageContext.request.contextPath}/Servlet/UserAction"
						method="post">
						<input   type="hidden"  name="method" value="add"> 
						<label>用户名</label>
						
						<input id="username" type="text" class="span6"
							name="username"  onchange="check1()" onblur="strValidate('username',20)" ><span>不能为空，字符不能超过16个</span>
						<font color='#FF0000'>	<span id="span1"></span></font>
							
							<label>密码</label> <input id="password" type="password"
							class="span6" name="password" onblur="strValidate('password',16)"/><span>不能为空，字符不能超过16个</span> 
							
							<label>真实姓名</label>
						<input id="realname" type="text" class="span6" name="name"> <label>联系电话</label>
						<input id="phone" type="text" class="span6" name="phone"><label>电子邮件</label>
						<input id="email" type="text" class="span6" name="email"> <label>通信地址</label>
						<input id="address" type="text" class="span6" name="address"><label>部门</label> 
						<select id="department" name="aid" class="span6"
							name="department">
							${areas }
							<c:forEach items="${areas}" var="one">
								<option value="${one.aid}">${one.name}</option>
							</c:forEach>
						</select> <br><input type="submit" class="btn btn-primary"
							value="增加"> <label class="remember-me"></label>
						<div class="clearfix"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/js/register_input.js"></script>
<%@include file="/common/foot.jsp"%>
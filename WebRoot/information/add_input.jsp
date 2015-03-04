<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/input.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/pikaday.css">

<script type="text/javascript">
	function submit1() {
		var myInput = document.createElement("input");
		myInput.type = "hidden";
		myInput.name = "label";
		myInput.value = "save";
		$("a_i_form").appendChild(myInput);
		var istrue = isvalidate();
		if (istrue) {
			$("a_i_form").submit();
		} else {
			alert("保存失败");
		}
	}
	function submit2() {
		var myInput = document.createElement("input");
		myInput.type = "hidden";
		myInput.name = "label";
		myInput.value = "submit";
		$("a_i_form").appendChild(myInput);
		var istrue = isvalidate();
		if (istrue) {
			$("a_i_form").submit();
		} else {
			alert("保存失败");
		}
	}
	//创建ajax引擎
	function getXmlHttpObject() {

		var xmlHttpRequest;
		//不同的浏览器获取对象xmlhttprequest 对象方法不一样
		if (window.ActiveXObject) {

			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");

		} else {

			xmlHttpRequest = new XMLHttpRequest();
		}

		return xmlHttpRequest;

	}

	var myXmlHttpRequest = "";

	function getCities() {

		myXmlHttpRequest = getXmlHttpObject();

		if (myXmlHttpRequest) {

			var url = "${pageContext.request.contextPath}/Servlet/InformationAction";//post
			var data = "method=getCountry&" + "pid=" + $('aid').value;
			myXmlHttpRequest.open("post", url, true);//异步方式

			myXmlHttpRequest.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");

			//指定回调函数
			myXmlHttpRequest.onreadystatechange = chuli;

			//发送
			myXmlHttpRequest.send(data);
		}
	}

	function chuli() {
		if (myXmlHttpRequest.readyState == 4) {

			if (myXmlHttpRequest.status == 200) {

				//取出服务器回送的数据

				var countrys = myXmlHttpRequest.responseXML
						.getElementsByTagName("mess");

				$('caid').length = 0;
				var myOption = document.createElement("option");
				myOption.value = "";
				myOption.innerText = "--县局--";
				//添加到
				$('caid').appendChild(myOption);

				//遍历并取出城市
				for ( var i = 0; i < countrys.length; i++) {

					var country_id = countrys[i].childNodes[0].childNodes[0].nodeValue;
					var country_name = countrys[i].childNodes[1].childNodes[0].nodeValue;
					//创建新的元素option

					var myOption = document.createElement("option");
					myOption.value = country_id;
					myOption.innerText = country_name;
					//添加到
					$('caid').appendChild(myOption);
				}
			}
		}
	}

	//这里我们写一个函数
	function $(id) {
		return document.getElementById(id);
	}
</script>

<div class="content">
	<div class="header">
		<h1 class="page-title">编辑投诉信息</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form id="a_i_form"
					action="${pageContext.request.contextPath}/Servlet/InformationAction"
					method="post">
					<input type="hidden" name="method" value="add">
					<table id="tabComInf" class="table table-bordered"
						contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tabtitle">投诉信息登记表</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>地区
									<div class="infIntr"></div></td>
								<td class="selectArea"><input type="radio"
									name="selectArea" value="0" checked="checked">只下达到市级 <input
									type="radio" name="selectArea" value="1">只下达到县级 <input
									type="radio" name="selectArea" value="2">同时下达到市级和县级<br>
									<select id="aid" name="aid" onchange="getCities();"
									onclick="getCities();">
										<option value="">---市局---</option>
										<c:forEach items="${citys}" var="city">
											<option value="${city.aid}">${city.name}</option>
										</c:forEach>
								</select> <select id="caid" name="caid">
										<option value="">---县局---</option>
								</select><span></span>
								</td>
							</tr>
							<tr>
								<td>或选择高校
									<div class="infIntr"></div>
								</td>
								<td class="selectArea"><input type="radio"
									name="selectArea" value="3">选择高校 <select id="college"
									name="collegeaid">
										<option value="">---高校---</option>
										<c:forEach items="${colleges}" var="college">
											<option value="${college.aid}">${college.name}</option>
										</c:forEach>
								</select><span></span>
								</td>
							</tr>
							<tr>
								<td>举报方式
									<div class="infIntr"></div>
								</td>
								<td><select id="sid" name="sid" id="label">
										<c:forEach items="${sourceList}" var="source">
											<option value="${source.sid}">${source.name}</option>
										</c:forEach>
								</select><span></span>
								</td>
							</tr>
							<tr>
								<td>单位类别
									<div class="infIntr"></div>
								</td>
								<td><select id="did" name="did" id="label2">
										<c:forEach items="${diplomaList}" var="diploma">
											<option value="${diploma.did}">${diploma.name}</option>
										</c:forEach>
								</select><span></span>
								</td>
							</tr>
							<tr>
								<td>违规类别
									<div class="infIntr"></div>
								</td>
								<td><select id="cid" name="cid" id="label3">
										<c:forEach items="${ccList}" var="cc">
											<option value="${cc.cid}">${cc.name}</option>
										</c:forEach>
								</select><span></span>
								</td>
							</tr>
							<tr>
								<td>来文单位
									<div class="infIntr"></div>
								</td>
								<td><input id="ifrom" name="ifrom" type="text"
									id="textfield" value="省教育厅" onblur="strValidate('ifrom',10)" /><span>不能为空，字符不能超过10个</span>
								</td>
							</tr>
							<tr>
								<td>编号
									<div class="infIntr"></div>
								</td>
								<td><input id="encode" name="encode" type="text"
									id="textfield" onblur="strValidate('encode',5)" /><span>不能为空，字符不能超过5个</span>
								</td>
							</tr>
							<tr>
								<td>被举报单位(或学校)
									<div class="infIntr"></div>
								</td>
								<td><input id="department" name="department" type="text"
									onblur="strValidate('department',20)" /><span>不能为空，字符不能超过20个</span>
								</td>
							</tr>
							<tr>
								<td>内容摘要
									<div class="infIntr"></div>
								</td>
								<td><textarea id="content1" name="content"
										onblur="nullValidate('content1',10)"></textarea><span>不能为空</span>
								</td>
							</tr>
							<tr>
								<td>处理意见和建议
									<div class="infIntr"></div>
								</td>
								<td><textarea id="content2" name="remarks"
										onblur="nullValidate('content2',10)"></textarea><span>不能为空</span>
								</td>
							</tr>
							<tr>
								<td>所限回复日期
									<div class="infIntr"></div>
								</td>
								<td><input type="text" name="limit_time"
									id="l_picker_start" onblur="dateValidate('l_picker_start',10)" /><span>格式为：2013-01-01</span>
								</td>
							</tr>
							<tr>
								<td>经办人
									<div class="infIntr"></div>
								</td>
								<td><input id="operater" name="operater" type="text"
									onblur="strValidate('operater',5)" /><span>不能为空，字符不能超过5个</span>
								</td>
							</tr>
							<tr>
								<td>回复电话
									<div class="infIntr"></div>
								</td>
								<td><input id="replyphone" name="replyphone" type="text"
									onblur="phoneValidate('replyphone',15)" /><span>不能为空，字符不能超过15个</span>
								</td>
							</tr>
							<tr>
								<td>回复邮箱
									<div class="infIntr"></div>
								</td>
								<td><input id="replyemail" name="replyemail" type="text"
									onblur="emailValidate('replyemail',20)" /><span>不能为空，字符不能超过20个,格式要正确</span>
								</td>
							</tr>
							<tr>
								<td colspan="2"><input type="button" value="保存"
									onclick=" submit1()" class="btn btn-primary">&nbsp;<input type="button" value="提交"
									onclick="submit2()" class="btn btn-primary"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/information_input.js"></script>
<script src="${pageContext.request.contextPath}/js/area/define.js"></script>
<script src="${pageContext.request.contextPath}/js/area.js"></script>
<script src="${pageContext.request.contextPath}/js/pikaday.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/inputTime1.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/input.js"></script>
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
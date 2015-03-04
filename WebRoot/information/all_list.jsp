<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/reply.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/pikaday.css">
	<script type="text/javascript">
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
                myOption.value="";
				myOption.innerText = "--县局--";
				myOption.value = "0";
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
		<h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form action="${pageContext.request.contextPath}/Servlet/ProvinceAction" method="post">
				<input type="hidden" name="method" value="query">
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="6" class="seachTitle">输入查询条件</th>
							</tr>
						</thead>
						<tbody>
						<tr>
								<td>市局</td>
								<td><select id="aid" name="aid" onchange="getCities();">
										<option value="0">---市局---</option>
										<c:forEach items="${citys}" var="city">
											<option value="${city.aid}">${city.name}</option>
										</c:forEach>
								</select>
								</td>
								<td>县局</td>
								<td><select id="caid" name="caid">
										<option value="0">---县局---</option>
								</select>
								</td>
								<td>或高校</td>
								<td class="selectArea"><select id="college"
									name="collegeaid">
										<option value="0">--高校--</option>
										<c:forEach items="${colleges}" var="college">
											<option value="${college.aid}">${college.name}</option>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td>起始时间</td>
								<td><input type="text" name="datestart" id="d_picker_start" />
								</td>
								<td>结束时间</td>
								<td><input type="text" name="dateend" id="d_picker_end" />
								</td>
									<td>举报方式</td>
								<td><select name="sid" id="label">
										<option value="">不选</option>
										<c:forEach items="${sourceList}" var="source">
											<option value="${source.sid}">${source.name}</option>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
							
								<td>单位类别</td>
								<td><select name="did" id="label2">
										<option value="">不选</option>
										<c:forEach items="${diplomaList}" var="diploma">
											<option value="${diploma.did}">${diploma.name}</option>
										</c:forEach>
								</select></td>
								<td>违规类别</td>
								<td><select name="cid" id="label3">
										<option value="">不选</option>
										<c:forEach items="${ccList}" var="cc">
											<option value="${cc.cid}">${cc.name}</option>
										</c:forEach>
								</select>
								</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="6" class="seachsub"><input type="submit"
									class="btn btn-primary" value="查询"></td>
							</tr>
						</tbody>
					</table>
				</form>
				<table class="table table-bordered table-hover"
					contenteditable="false">
					<thead>
						<tr>
							<th colspan="10" class="seachTitle">${pagetitle}</th>
						</tr>
						<tr>
							<th>投诉编号</th>
							<th>被举报单位</th>
							<th>违规类别</th>
							<th>举报方式</th>
							<th>单位类别</th>
							<th>所属区域</th>
							<th>投诉时间</th>
							<th>所限回复日期</th>
							<th>市是否回复</th>
							<th>县是否回复</th>
							<th>查看</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${page.list }" var="information">
						<tr>
							<td>${information.encode }</td>
							 <td>${information.department }</td>
							<td>${information.cid.name }</td>
							<td>${information.sid.name }</td>
							<td>${information.did.name }</td>
							<td>
							<c:if test="${information.aid!=null }">
							
							${information.aid.name }
							</c:if>
							<c:if test="${information.caid!=null }">
							
							${information.caid.name }
							</c:if>
							</td>
							<td>${information.curr_date }</td>
							<td>
								${information.limit_time}
							</td>
							<td>
								<c:if test="${information.rid==null }">
								<font color="#FF0000">市未回复</font>
								</c:if>
								 <c:if test="${ !empty(information.rid )}">
												市已回复
								</c:if>
							</td>
							<td>
								<c:if test="${information.drid==null }">
								<font color="#FF0000">县未回复</font>
								</c:if> 
								<c:if test="${ !empty(information.drid )}">
														县已回复
								</c:if>
							</td>
							<td><a
								href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=getInformation&iid=${information.iid}">查看</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<%@include file="/common/page.jsp"%>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/pikaday.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/inputTime.js"
	type="text/javascript"></script>
<%@include file="/common/foot.jsp"%>

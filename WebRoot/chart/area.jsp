<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<script src="../js/Chart.js"></script>
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
		<h1 class="page-title">地区报表</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<form
					action="${pageContext.request.contextPath}/Servlet/ChartAction"
					method="post">
					<input type="hidden" name="method" value="findByArea1">
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="6" class="seachTitle">输入查询条件</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>市局</td>
								<td><select id="aid" name="aid" onchange="getCities();" onclick="getCities();">
										<option value="0">---市局---</option>
										<c:forEach items="${citys}" var="city">
											<c:if test="${param.aid==city.aid }">
											<option value="${city.aid}" selected="selected">${city.name}</option>
											</c:if>
											<c:if test="${param.aid!=city.aid }">
											<option value="${city.aid}">${city.name}</option>
											</c:if>
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
										<c:if test="${param.collegeaid==college.aid }">
											<option value="${college.aid}" selected="selected">${college.name}</option>
											</c:if>
										<c:if test="${param.collegeaid!=college.aid }">
											<option value="${college.aid}" >${college.name}</option>
											</c:if>
										</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<td>年份</td>
								<td>
								<input type="text" name="year" value="${param.year }">
								</td>
								<td>起始月</td>
								<td><select name="month1">
										<option value="01" selected="selected">1</option>
										<option value="02">2</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
								</select>
								</td>
								<td>结束月</td>
								<td><select name="month2">
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12" selected="selected">12</option>
								</select>
								</td>
							</tr>
							<tr>
								<td colspan="6" class="seachsub"><input type="submit"
									class="btn btn-primary" value="查询"></td>
							</tr>
						</tbody>
					</table>
				</form>
					<c:if test="${datas!=null}">
				<table class="table table-bordered table-hover"
					contenteditable="false">
					<thead>
						<tr>
							<th colspan="10" class="seachTitle"><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?aid=${area2.aid}&method=list&startdate=<fmt:formatDate value="${startdate}" pattern="yyyy-MM-dd"/>&enddate=<fmt:formatDate value="${enddate}" pattern="yyyy-MM-dd"/>">${area2.name}</a>
							</th>
						</tr>
						<tr>
							<th>月份<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=startdate">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=startdate">
									降序</a></th>
							<th>被举报次数<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=number">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=number">
									降序</a></th>
							<th>回复量<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=replyednumber">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=replyednumber">
									降序</a></th>
							<th>未回复量<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=noreplynumber">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=noreplynumber">
									降序</a></th>
							<th>逾期回复量<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=overduenumber">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=overduenumber">
									降序</a></th>
							<th>查实量<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=checknumber">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=checknumber">
									降序</a></th>
							<th>查实率<br><a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=true&comparefield=checkpercent">
									升序</a> <a
								href="${pageContext.request.contextPath}/Servlet/ChartAction?collegeaid=${param.collegeaid}
							&method=findByArea1&caid=${param.caid}&aid=${param.aid}&month1=${param.month1}&month2=${param.month2}&year=${param.year}&isreverse=false&comparefield=checkpercent">
									降序</a></th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${datas }" var="data">
							<tr>
								<td><a
									href="${pageContext.request.contextPath}/Servlet/ChartAction?method=list&aid=${data.aid}&startdate=<fmt:formatDate value="${data.startdate}" pattern="yyyy-MM-dd"/>
							&enddate=<fmt:formatDate value="${data.enddate}" pattern="yyyy-MM-dd"/>"><fmt:formatDate
											value="${data.startdate}" pattern="yyyy.MM" />-<fmt:formatDate
											value="${data.enddate}" pattern="yyyy.MM" /> </a></td>
								<td>${data.number }</td>
								<td>${data.replyednumber }</td>
								<td>${data.noreplynumber }</td>
								<td>${data.overduenumber }</td>
								<td>${data.checknumber }</td>

								<td><fmt:formatNumber value="${data.checkpercent*100}"
										pattern="#0.00"></fmt:formatNumber>%</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</c:if>
			</div>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/js/pikaday.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/inputTime.js"
	type="text/javascript"></script>
<%@include file="/common/foot.jsp"%>

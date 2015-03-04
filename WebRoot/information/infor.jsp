<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/infor.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
<!-- ------------------------------------------------------------------------------------------------ -->
				<table id="proCompInf" class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="2" class="tab_title">投诉内容</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>投诉编号</td>
							<td>${information.encode }</td>
						</tr>
						<tr>
							<td>违规类别</td>
							<td>${information.cid.name }</td>
						</tr>
						<tr>
							<td>举报方式</td>
							<td>${information.sid.name}</td>
						</tr>
						<tr>
							<td>单位类别</td>
							<td>${information.did.name }</td>
						</tr>
						<tr>
							<td>投诉地区</td>
							<td>${information.aid.name }</td>
						</tr>
						<tr>
							<td>投诉时间</td>
							<td>${information.curr_date }</td>
						</tr>
						<tr>
							<td>来问单位</td>
							<td>${information.ifrom }</td>
						</tr>
						<tr>
							<td>被举报单位</td>
							<td>${information.department }</td>
						</tr>
						<tr>
							<td>投诉内容</td>
							<td>${information.content }</td>
						</tr>

						<tr>
							<td>处理意见和建议</td>
							<td>${information.remarks}</td>
						</tr>
						<tr>
							<td>经办人</td>
							<td>${information.operater }</td>
						</tr>
						<tr>
							<td>回复传真</td>
							<td>${information.replyphone }</td>
						</tr>
						<tr>
							<td>并请将回复件发电子邮件</td>
							<td>${information.replyemail }</td>
						</tr>
						<tr>
							<td>所限回复日期</td>
							<td>${information.limit_time}</td>
						</tr>
					</tbody>
				</table>
<!-- ------------------------------------------------------------------------------------------------ -->
				<c:if test="${ information.aid !=null&&information.aid.state==1}">
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tab_title">市回复的内容</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${ information.rid !=null}">
								<tr>
									<td>是否属实</td>
									<td><c:if test="${information.rid.isBoolean==1}">属实</c:if>
										<c:if test="${information.rid.isBoolean==0}">不属实</c:if></td>
								</tr>

								<tr>
									<td>回复的内容</td>
									<td>${information.rid.content }</td>
								</tr>
								<tr>
									<td>回复的时间</td>
									<td>${information.rid.date }</td>
								</tr>
								<tr>
									<td>回复人</td>
									<td>${information.rid.name }</td>
								</tr>
								<tr>
									<td>回复人电话</td>
									<td>${information.rid.phone }</td>
								</tr>
								<tr>
									<td>回复人电子邮件</td>
									<td>${information.rid.email }</td>
								</tr>
							</c:if>
							<c:if test="${ information.rid ==null}">

								<tr>
									<td>未回复 <a href="${pageContext.request.contextPath}/Servlet/InformationAction?method=sendMail&aid=${information.aid.aid}&iid=${information.iid}">发邮件通知</a></td>

								</tr>
							</c:if>
						</tbody>
					</table>
				</c:if>
<!-- ------------------------------------------------------------------------------------------------ -->				
				<c:if test="${ information.aid !=null&&information.aid.state==3}">
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tab_title">高校回复的内容</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${ information.rid !=null}">
								<tr>
									<td>是否属实</td>
									<td><c:if test="${information.rid.isBoolean==1}">属实</c:if>
										<c:if test="${information.rid.isBoolean==0}">不属实</c:if></td>
								</tr>

								<tr>
									<td>回复的内容</td>
									<td>${information.rid.content }</td>
								</tr>
								<tr>
									<td>回复的时间</td>
									<td>${information.rid.date }</td>
								</tr>
								<tr>
									<td>回复人</td>
									<td>${information.rid.name }</td>
								</tr>
								<tr>
									<td>回复人电话</td>
									<td>${information.rid.phone }</td>
								</tr>
								<tr>
									<td>回复人电子邮件</td>
									<td>${information.rid.email }</td>
								</tr>
							</c:if>
							<c:if test="${ information.rid ==null}">
								<tr>
									<td>未回复 <a href="${pageContext.request.contextPath}/Servlet/InformationAction?method=sendMail&aid=${information.aid.aid}&iid=${information.iid}">发邮件通知</a></td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</c:if>
<!-- ------------------------------------------------------------------------------------------------ -->
				<c:if test="${ information.caid !=null}">
					<table class="table table-bordered" contenteditable="false">
						<thead>
							<tr>
								<th colspan="2" class="tab_title">县回复的内容</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${ information.drid !=null}">
								<tr>
									<td>是否属实</td>
									<td><c:if test="${information.drid.isBoolean==1}">属实</c:if>
										<c:if test="${information.drid.isBoolean==0}">不属实</c:if></td>
								</tr>

								<tr>
									<td>回复的内容</td>
									<td>${information.drid.content }</td>
								</tr>
								<tr>
									<td>回复的时间</td>
									<td>${information.drid.date }</td>
								</tr>
								<tr>
									<td>回复人</td>
									<td>${information.drid.name }</td>
								</tr>
								<tr>
									<td>回复人电话</td>
									<td>${information.drid.phone }</td>
								</tr>
								<tr>
									<td>回复人电子邮件</td>
									<td>${information.drid.email }</td>
								</tr>
							</c:if>
							<c:if test="${ information.drid ==null}">
								<tr>
									<td>未回复 <a href="${pageContext.request.contextPath}/Servlet/InformationAction?method=sendMail&aid=${information.caid.aid}&iid=${information.iid}">发邮件通知</a></td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/infor.js"></script>
<%@include file="/common/foot.jsp"%>
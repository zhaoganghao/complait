<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/stylesheets/repInf.css">
<div class="content ">
	<div class="header">
		<h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<table id="tab1" class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="2" class="tabTitle">投诉内容</th>
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
							<td>投诉方式</td>
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
							<td>省级对下级处理意见和建议</td>
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
							<td>${information.limit_time }</td>
						</tr>
					<tbody>
				</table>

				<table id="tab2" class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="2" class="tabTitle">对上级回复的内容</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ information.rid !=null}">
							<tr>
								<td>是否属实</td>
								<td><c:if test="${information.rid.isBoolean==1}">属实</c:if>
									<c:if test="${information.rid.isBoolean==0}">不属实</c:if>
								</td>
							</tr>

							<tr>
								<td>回复的内容</td>
								<td>${information.rid.content }</td>
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
						<c:if test="${information.rid ==null}">
							<tr>
								<td colspan="2"><a
									href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=addInput&iid=${information.iid}">回复</a>
								</td>
							</tr>
						</c:if>
					<tbody>
				</table>
				<!-- --------------------------------------------------- -->
				<c:if test="information.fid!=null">
				<table id="tab3" class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="2" class="tabTitle">下级回复的内容</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ information.coid !=null}">
							<tr>
								<td>是否属实</td>
								<td><c:if test="${information.coid.isBoolean==1}">属实</c:if>
									<c:if test="${information.coid.isBoolean==0}">不属实</c:if>
								</td>
							</tr>
							<tr>
								<td>回复的内容</td>
								<td>${information.coid.content }</td>
							</tr>
							<tr>
								<td>回复人</td>
								<td>${information.coid.name }</td>
							</tr>
							<tr>
								<td>回复人电话</td>
								<td>${information.coid.phone }</td>
							</tr>
							<tr>
								<td>回复人电子邮件</td>
								<td>${information.coid.email }</td>
							</tr>
						</c:if>
						<c:if test="${information.coid ==null}">
							<tr>
								<td colspan="2">下级未回复</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				</c:if>
				<table id="tab4" class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="2" class="tabTitle">转发的内容</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ information.fid !=null}">
							<tr>
								<td>转发人建议</td>
								<td>${information.fid.remarks }
							<tr>
								<td>转发人</td>
								<td>${information.fid.name }</td>
							</tr>
							<tr>
								<td>转发时间</td>
								<td>${information.fid.date }</td>
							</tr>
							<tr>
								<td>转发人电话</td>
								<td>${information.fid.phone}</td>
							</tr>
							<tr>
								<td>转发人邮箱</td>
								<td>${information.fid.email}</td>
							</tr>
						</c:if>
						<c:if test="${information.fid ==null}">
							<tr>
								<td colspan="2"><a
									href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=addForwardInput&iid=${information.iid}">转发</a>
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath }/js/repInf.js"></script>
<%@include file="/common/foot.jsp"%>
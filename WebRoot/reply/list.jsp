<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<div class="content ">
	<div class="header">
		<h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
				<table class="table table-bordered" contenteditable="false">
					<thead>
						<tr>
							<th colspan="9">${message}</th>
						</tr>
						<tr>
							<th>投诉编号</th>
							<th>来文单位</th>
							<th>被举报单位</th>
							<th>投诉时间</th>
							<th>所限回复日期</th>
							<th>是否回复上级</th>
							<th>转发下级</th>
							<th>下级是否回复</th>
							<th>查看</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list }" var="information">
							<tr>
								<td>${information.encode }</td>
								<td>${information.ifrom }</td>
								<td>${information.department }</td>
								<td>${information.curr_date }</td>
								<td>${information.limit_time}</td>
								<td><c:if test="${information.rid==null }">
										<a
											href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=addInput&iid=${information.iid}">回复</a>
									</c:if> <c:if test="${ !empty(information.rid )}">
										已回复
										</c:if>
								</td>
								<td><c:if test="${information.fid==null }">
										<a
											href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=addForwardInput&iid=${information.iid}">转发</a>

									</c:if> <c:if test="${ !empty(information.fid )}">
										已转发
										</c:if>
								</td>
								<td><c:if test="${ information.coid ==null}">
										<font color="#FF0000">下级未回复</font>
									</c:if> <c:if test="${ !empty(information.coid )}">
										下级已回复
										</c:if>
								</td>
								<td><a
									href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=getInformation&iid=${information.iid}">查看</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="9"><%@include file="/common/page.jsp" %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/common/foot.jsp"%>

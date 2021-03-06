<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<div class="content ">
<div class="header">
		<h1 class="page-title">${pagetitle }</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
		<table width="807" border="1" align="center" class="table table-bordered" contenteditable="false">
		<tr>
			<td colspan="6">${message}</td>


		</tr>
		<tr>
			<td width="176">投诉编号</td>

			<td width="103">来文单位</td>
			<td width="136">被举报单位</td>
			<td width="176">投诉时间</td>
			<td width="182">所限回复日期</td>
			<td width="182">是否回复市级</td>
			<td width="182">是否回复省级</td>
			<td width="182">查看</td>
		</tr>
		
		<c:forEach items="${page.list }" var="information">
			<tr>
				<td>${information.encode }</td>
				<td>${information.ifrom }</td>
				<td>${information.department }</td>
				<td>${information.curr_date }</td>
				<td>
				${information.limit_time}
				</td>
				
				
					<td>
					<c:if test="${information.aid!=null}">
							
							<c:if test="${information.fid!=null&&information.coid==null}">
							<a href="${pageContext.request.contextPath}/Servlet/CountryAction?method=addInput&iid=${information.iid}">回复市级</a>
							</c:if>
							<c:if test="${ !empty(information.coid )}">
											已回复市级
							</c:if>
							<c:if test="${information.fid==null}">
							空
							</c:if>
							
					</c:if>		
					<c:if test="${information.aid==null}">
								不用
							</c:if>			
					</td>
		
				
					<td><c:if test="${information.caid!=null}">
							<c:if test="${information.drid==null}">
							<a href="${pageContext.request.contextPath}/Servlet/CountryAction?method=addDirectInput&iid=${information.iid}">回复省级</a>
							</c:if>
							<c:if test="${ !empty(information.drid )}">
											已回复省级
							</c:if>
						</c:if>			
						<c:if test="${information.caid==null}">
						不用
						</c:if>
					</td>
				
				<td width="182"><a
					href="${pageContext.request.contextPath}/Servlet/CountryAction?method=getInformation&iid=${information.iid}">查看</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
							<td colspan="9"><%@include file="/common/page.jsp" %></td>
						</tr>
	</table>
</div>
</div>
</div>
</div>
<%@include file="/common/foot.jsp"%>

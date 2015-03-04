<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<div class="sidebar-nav">
<c:if test="${user.aid.state==0 }">  
		<a href="${pageContext.request.contextPath}/information/index.jsp"
			class="nav-header"><i class="icon-home"></i>首页</a>
		<a
			href="${pageContext.request.contextPath}/Servlet/InformationAction?method=addInput"
			class="nav-header"><i class="icon-dashboard"></i>新建投诉</a>
			<a
			href="${pageContext.request.contextPath}/Servlet/InformationAction?method=getCopys"
			class="nav-header"><i class="icon-dashboard"></i>未下达投诉</a>
		<a href="#menu01" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-briefcase"></i>市级投诉管理<i class="icon-chevron-up"></i> </a>
		<ul id="menu01" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=noReply">未回复投诉</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=replyed">已回复投诉</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=overdue">逾期回复投诉</a>
			</li>
		</ul>
		<a href="#menu02" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-briefcase"></i>县级投诉管理<i class="icon-chevron-up"></i>
		</a>
		<ul id="menu02" class="nav nav-list collapse">
		<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=noCountryReply">未回复</a> 
			</li>
			<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=countryReplyed">已回复</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=countryOverdue">逾期回复</a>
			</li>
		</ul>
		<a href="#menu03" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-briefcase"></i>市县级投诉<i class="icon-chevron-up"></i>
		</a>
		<ul id="menu03" class="nav nav-list collapse">
		<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=cityAndCountry">查看市县投诉</a> 
		</li>
		</ul>
		<a href="#menu04" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-briefcase"></i>高校投诉管理<i class="icon-chevron-up"></i>
		</a>
		<ul id="menu04" class="nav nav-list collapse">
		<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=noCollegeReply">未回复</a> 
			</li>
			<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=collegeReplyed">已回复</a>
			</li>
			<li><a href="${pageContext.request.contextPath}/Servlet/ProvinceAction?method=collegeOverdue">逾期回复</a>
			</li>
		</ul>
		<a href="#menu05" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-exclamation-sign"></i>查看报表<i class="icon-chevron-up"></i>
		</a>
		<ul id="menu05" class="nav nav-list collapse">
		<li><a
				href="${pageContext.request.contextPath}/Servlet/ChartAction?method=areaNoMethodInput">地区报表</a>
			</li>
			 <li><a
				href="${pageContext.request.contextPath}/Servlet/ChartAction?method=areaInput">地区月份报表</a>
			</li> 
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ChartAction?method=categoryInput">类别报表</a>
			</li>
		</ul>
		<a href="#menu06" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>用户管理<i class="icon-chevron-up"></i> </a>
		<ul id="menu06" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/UserAction">所有用户</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/user/province_update_input.jsp">省级用户资料</a>
			</li>
		</ul>
		<a href="#menu07" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>类别管理<i class="icon-chevron-up"></i> </a>
		<ul id="menu07" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/AreaAction">区域管理</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/AreaAction?method=getCollege">高校管理</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ComplaintAction">违规类别管理</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/DiplomaAction">单位类别管理</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/SourceAction">举报方式管理</a>
			</li>
		</ul>
</c:if>		
	<c:if test="${user.aid.state==1}">
	<a href="${pageContext.request.contextPath}/reply/index.jsp"
			class="nav-header"><i class="icon-home"></i>首页</a>
		<a href="#menu11" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>查看投诉<i class="icon-chevron-up"></i> </a>
		<ul id="menu11" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/ReplyAction?method=execute2">查看投诉</a>
			</li>
		</ul>
		<a href="#menu12" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>个人信息<i class="icon-chevron-up"></i> </a>
		<ul id="menu12" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/reply/person_input.jsp">编辑资料</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${user.aid.state==2}">
	<a href="${pageContext.request.contextPath}/country/index.jsp"
			class="nav-header"><i class="icon-home"></i>首页</a>
		<a href="#menu21" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>查看投诉<i class="icon-chevron-up"></i> </a>
		<ul id="menu21" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/CountryAction?method=execute2">来自省的投诉</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/CountryAction?method=execute3">来自市的投诉</a>
			</li>
			<li><a
				href="${pageContext.request.contextPath}/Servlet/CountryAction?method=execute4">来自省市投诉</a>
			</li>
		</ul>
		<a href="#menu22" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>个人信息<i class="icon-chevron-up"></i> </a>
		<ul id="menu22" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/country/person_input.jsp">编辑资料</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${user.aid.state==3}">
	<a href="${pageContext.request.contextPath}/college/index.jsp"
			class="nav-header"><i class="icon-home"></i>首页</a>
		<a href="#menu31" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>查看投诉<i class="icon-chevron-up"></i> </a>
		<ul id="menu31" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/Servlet/CollegeAction?method=execute2">查看投诉</a>
			</li>
			
		</ul>
		<a href="#menu32" class="nav-header collapsed" data-toggle="collapse"><i
			class="icon-legal"></i>个人信息<i class="icon-chevron-up"></i> </a>
		<ul id="menu32" class="nav nav-list collapse">
			<li><a
				href="${pageContext.request.contextPath}/college/person_input.jsp">编辑资料</a>
			</li>
		</ul>
	</c:if>
</div>
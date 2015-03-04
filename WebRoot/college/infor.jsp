<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/main.css">
<div class="content ">
	<div class="header"><h1 class="page-title">投诉情况</h1>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="comInfBox">
<table width="327" border="1" align="center"class="table table-bordered" contenteditable="false">
  <tr>
    <td width="65" colspan="2">
    <h3>投诉内容</h3></td>
    
  </tr>
  <tr>
    <td width="65">投诉编号</td>
    <td width="246">${information.encode }</td>
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
    <td>来文单位</td>
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
    <td>省级经办人</td>
    <td>${information.operater }</td>
  </tr>
 
  <tr>
    <td>所限回复日期</td>
    <td>${information.limit_time}</td>
  </tr>

</table>






<c:if test="${ information.rid !=null}">
<table width="327" border="1" align="center"class="table table-bordered" contenteditable="false">
  <tr>
    <td colspan="2"><h3>回复的内容</h3></td>
  </tr>
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
    <td>回复人</td>
    <td>${information.rid.name }</td>
  </tr>
 <tr>
    <td>回复人联系方式</td>
    <td>${information.rid.phone }</td>
  </tr>
  <tr>
    <td>回复人电子邮件</td>
    <td>${information.rid.email }</td>
  </tr>
</table>
</c:if>
<table width="327" border="1" align="center"class="table table-bordered" contenteditable="false">



<c:if test="${information.rid ==null}">
 <tr><td><a href="${pageContext.request.contextPath}/Servlet/CollegeAction?method=addInput&iid=${information.iid}">回复</a>
 </td></tr>
</c:if>
</table>

</div>
</div>
</div>
</div>

<%@include file="/common/foot.jsp"%>
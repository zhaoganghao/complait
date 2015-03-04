<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/left.jsp"%>

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
    <td>省级经办人</td>
    <td>${information.operater }</td>
  </tr>
 
  <tr>
    <td>所限回复日期</td>
    <td>${information.limit_time }"</td>
  </tr>

</table>








<c:if test="${ information.fid !=null}">
<table width="327" border="1" align="center" class="table table-bordered" contenteditable="false">
  <tr>
    <td colspan="2"><h3>市局对下级的建议</h3></td>
  </tr>
  <tr>
    <td>建议内容</td>
 <td>
 ${ information.fid.remarks}
  </tr>
  
  <tr>
    <td>建议人</td>
    <td>${ information.fid.name}</td>
  </tr>
  <tr>
    <td>建议人联系方式</td>
    <td>${information.fid.phone }</td>
  </tr>
  <tr>
    <td>建议人联系邮箱</td>
    <td>${information.fid.email }</td>
  </tr>
</table>
</c:if>
<c:if test="${ information.drid!=null}">
<table width="327" border="1" align="center" class="table table-bordered" contenteditable="false">
  <tr>
    <td colspan="2"><h3>县级对省级的回复</h3></td>
  </tr>
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
    <td>回复人</td>
    <td>${information.drid.name }</td>
  </tr>
 
  <tr>
    <td>回复人联系方式</td>
    <td>${information.drid.phone }</td>
  </tr>
  <tr>
    <td>回复人联系邮箱</td>
    <td>${information.drid.email }</td>
  </tr>
</table>
</c:if>
<c:if test="${ information.coid !=null}">
<table width="327" border="1" align="center" class="table table-bordered" contenteditable="false" >
  <tr>
    <td colspan="2"><h3>回复市级的内容</h3></td>
  </tr>
  <tr>
    <td>是否属实</td>
 <td><c:if test="${information.coid.isBoolean==1}">属实</c:if>
 <c:if test="${information.coid.isBoolean==0}">不属实</c:if></td>
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
    <td>回复人联系方式</td>
    <td>${information.coid.phone }</td>
  </tr>
  <tr>
    <td>回复人电子邮件</td>
    <td>${information.coid.email }</td>
  </tr>
</table>
</c:if>
<table width="327" border="1" align="center" class="table table-bordered" contenteditable="false">


<c:if test="${information.fid!=null&&information.coid ==null}">
 <tr><td><a href="${pageContext.request.contextPath}/Servlet/CountryAction?method=addInput&iid=${information.iid}">回复市级</a>
 </td></tr>
</c:if>
<c:if test="${information.caid!=null&&information.drid ==null}">
 <tr><td><a href="${pageContext.request.contextPath}/Servlet/CountryAction?method=addDirectInput&iid=${information.iid}">回复省级</a>
 </td></tr>
</c:if>
</table>

</div>
</div>
</div>
</div>


<%@include file="/common/foot.jsp"%>
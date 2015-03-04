<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/paging.css">
<div id="paging">
	<span>当前第[${page.pagenum }]页</span> <span><c:if
			test="${page.pagenum>1}">
			<a href="${page.url }?pagenum=${page.pagenum-1 }&method=${methodname}">上一页</a>
		</c:if> </span> <span> <c:forEach var="pagenum" begin="${page.startPage}"
			end="${page.endPage}">
		[<a href="${page.url }?pagenum=${pagenum}&method=${methodname}">${pagenum }</a>]
	</c:forEach> </span> <span> <c:if test="${page.pagenum<page.totalpage}">
			<a href="${page.url }?pagenum=${page.pagenum+1 }&method=${methodname}">下一页</a>
		</c:if> </span> <span>共[${page.totalpage }]页</span> <span>共[${page.totalrecord}]纪录</span>
	<span><input class="i_text" type="text" id="pagenum"> </span> <span><input
		class="i_submit" type="button" value="GO"
		onclick="goWhich(document.getElementById('pagenum'))"> </span>
</div>
 <script type="text/javascript">
 ${pageContext.request.contextPath}/Servlet/UserAction?method=del&username=${data.username}
		function goWhich(input){
			var pagenum = input.value;
			if(pagenum==null || pagenum==""){
				alert("请输入页码！");
				return;
			}
			
			if(!pagenum.match("\\d+")){
				alert("请输入数字！");
				input.value="";
				return;
			}
			
			if(pagenum<1 || pagenum>${page.totalpage}){
				alert("无效的页码！");
				input.value="";
				return;
			}
			window.location.href="${page.url }?pagenum=" + pagenum+"&method=${methodname}";
		}
	</script>

<%@ page language="java" import="java.util.*,cn.e21.hbjyhf.model.User" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
	
<div id="footer" style=" width:100%; text-align: right; background: #4d5b76">
      <div class="container" >
        <p class="muted credit">By &nbsp;&nbsp;<a href="#">千里IT工坊</a>.</p>
      </div>
    </div>	  
<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
   
  </body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>支付_AIDASHOP</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		.pubwrap {width: 1200px;margin: 20px auto;}
		table {
			width:60%;
			border: none;
			border-spacing: 0px;
		}
		table td {
			 padding: 3px 5px;text-align: left;
		}
		#paybtn {
			display: block;background: #872222;width: 120px;height: 36px;
		line-height: 36px;text-align: center;color: #fff;font-size: 18px;font-weight: 500;
			margin-left: 20px;
		}
		#paybtn:HOVER {
	text-decoration: none;
}
	</style>
  </head>
  
  <body>
  	<!-- 头部 -->
    <jsp:include page="../reuse/header.jsp"></jsp:include>
    <div class="pubwrap">
    <form action="${pageContext.request.contextPath }/bank.jsp" method="post">
    	 您的订单是:<input type="text" name="orderid">
    	订单的金额是:<input type="text" name="money">
    	<input type="submit" value="支付">
    </form>
    </div>
   	<!-- 底部 -->
    <jsp:include page="../reuse/footer.jsp"></jsp:include>
  </body>
</html>

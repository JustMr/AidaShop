<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/searchresult.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

	<style type="text/css">
		#res_wrap {
			width: 1200px;
			margin: 0 auto;
		}
		.shop_btn {
			display: block;
			margin: 20px auto;
			width: 200px;
		    height: 50px;
		    color: #fff;
		    background: #e50122;
		    line-height: 50px;
		    text-align: center;
		    font: 700 18px/50px "microsoft yahei";
		    letter-spacing: 1px;
		    border: none;
		}
		.shop_btn:HOVER {
			text-decoration: none;
			color: #fff;
		}
	</style>
	<script type="text/javascript">
		function bacnpage() {
			window.history.back();
		}
	</script>
  </head>
  
  <body>
    <!-- 头部 -->
    <jsp:include page="../reuse/detailheader.jsp"></jsp:include>
    
    <!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div id="res_wrap">
    	<a class="shop_btn" href="javascript:void(0);" onclick="bacnpage()">返回该商品</a>
    	<a class="shop_btn" href="home.jsp">继续购物</a>
    	<a class="shop_btn" href="vishopcarOrderAction">查看购物车</a>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
    
  </body>
</html>

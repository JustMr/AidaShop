<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<style type="text/css">
		#prismWrap {display: none;}
		#iframeWarp {width: 1200px;margin: 20px auto;}
		#shopcar {width: 100%;overflow: hidden;min-height: 400px;border: none;}
		#jiesuan {display: block;background: #872222;width: 120px;height: 36px;
		line-height: 36px;text-align: center;color: #fff;font-size: 18px;font-weight: 500;float: right;}
		#jiesuan:HOVER {
			text-decoration: none;
		}
		.paytotal {width: 1200px;margin: 20 auto;height: 36px;}
	</style>
	<script type="text/javascript">
		function setIframeHeight(iframe) {
		if (iframe) {
		var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
		if (iframeWin.document.body) {
		iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
		}
		}
		};
		
		window.onload = function () {
		setIframeHeight(document.getElementById('shopcar'));
		};
	</script>

  </head>
  
  <body>
     <!-- 头部 -->
    <jsp:include page="../reuse/detailheader.jsp"></jsp:include>
    
    <!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div id="iframeWarp">
    	<iframe name="shopcar" id="shopcar" src="vishopcarOrderAction" scrolling="no" marginheight="0" marginwidth="0"></iframe>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心_AidaShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-grzx.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		function setIframeHeight(iframe) {
		if (iframe) {
		var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
		if (iframeWin.document.body) {
		iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
		}
		}
		};
		
		function sizeiframe() {
		setIframeHeight(document.getElementById('reexwarp'));
		};
	</script>
	
  </head>
  
  <body>
  <!-- 头部 -->
   <jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
   <!-- 导航栏 -->
   <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
   <!-- 个人中心导航栏 -->
   <div class="grzx_tit">
   	<div id="grzx_tit_main">
   		<a class="grzx_mainA" href="javascript:void(0);">首页</a>
   		<a class="grzx_mainA" href="javascript:void(0);">账户设置</a>
   		<a class="grzx_mainA" href="javascript:void(0);">社区</a>
   		<a class="grzx_mainA" href="javascript:void(0);">消息</a>
   	</div>
   </div>
    <!-- 个人中心主体 -->
   <div class="grzx_warp">
   	<div class="grzxLeft">
   		<dl id="firstDL">
   			<dt>订单中心</dt>
   			<dd><a href="listOrderAction" target="grzxFrame">我的订单</a></dd>
   			<dd><a href="javascript:void(0);">组合订单记录</a></dd>
   			<dd class="lastDd"><a href="javascript:void(0);">取消订单记录</a></dd>
   		</dl>
   		<dl>
   			<dt>文章中心</dt>
   			<dd class="lastDd"><a href="listownDesignerAction" target="grzxFrame">我的文章</a></dd>
   		</dl>
   		<dl>
   			<dt>关注中心</dt>
   			<dd><a href="javascript:void(0);">关注的商品</a></dd>
   			<dd><a href="javascript:void(0);">关注的店铺</a></dd>
   			<dd><a href="javascript:void(0);">关注的品牌</a></dd>
   			<dd class="lastDd"><a href="javascript:void(0);">关注的造型师</a></dd>
   		</dl>
   		<dl>
   			<dt>客户服务</dt>
   			<dd><a href="exrepersonOrderAction" target="grzxFrame">返修退换货</a></dd>
   			<dd><a href="javascript:void(0);">购买咨询</a></dd>
   			<dd><a href="authCenterStoreAuthAction" target="grzxFrame">申请中心</a></dd>
   			<dd class="lastDd"><a href="javascript:void(0);">举报中心</a></dd>
   		</dl>
   		<dl>
   			<dt>设置</dt>
   			<dd><a href="ordinaryCustomerAction?messageCenter=" target="grzxFrame">个人信息</a></dd>
   			<dd><a href="addresslistOrderAction" target="grzxFrame">收货地址</a></dd>
   		</dl>
   	</div>
   	<div class="grzxRight">
   		<iframe id="grzxFrame" name="grzxFrame" src="" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"  onload="sizeiframe()"></iframe>
   	</div>
   	<div class="clear"></div>
   </div>
   <!-- 尾部 -->
   <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
  </body>
</html>

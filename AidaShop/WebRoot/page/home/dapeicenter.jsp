<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搭配中心_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	


  </head>
  
  <body>
  	<!-- 头部 start -->
  	<jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
  	<!-- 头部 end -->
  	
  	<!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div class="mainContent">
    	<div class="leftContent">
    		<div class="personInfo">
    			<div><span id="perName"></span></div>
    			<div><span id="perLevel"></span></div>
    			<div><span>点赞数:</span><span id="likecount"></span></div>
    			<div><span>不满意数:</span><span id="hatecount"></span></div>
    			<div><span>文章总数:</span><span id="artcount"></span></div>
    		</div>
    		<div class="pubArticle">
    			<a id="pubArcBtn">搭配发表</a>
    		</div>
    		<div class="desginerList">
    			<div class="desListTit">
    				<span id="desTitName" class="desTit">造型师</span>
    				<span id="desTitlike" class="desTit">点赞数</span>
    			</div>
    			<div class="desginerItem">
    				<a class="desName"></a>
    				<span class="deLike"></span>
    			</div>
    		</div>
    	</div>
    	<div class="rightContent">
    		<div class="artItem">
    			<div class="artTit"></div>
    			<div class="artMain"></div>
    			<div class="artGoods">
    				<div class="goodsItem">
    					<a class="goodImg" href=""><img alt="" src=""></a> 
    					<a class="goodName" href=""></a>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    
  </body>
</html>

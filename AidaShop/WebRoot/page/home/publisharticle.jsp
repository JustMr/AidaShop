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
    
    <title>搭配发表_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-dpcenter.css">
	<link rel="stylesheet" type="text/css" href="css/input/input.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/FastJson.js"></script>
	<script type="text/javascript" src="js/js-publish.js"></script>
	
	
  </head>
  
  <body>
  
 	<!-- 头部 start -->
  	<jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
  	<!-- 头部 end -->
  	
  	<!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
  
    <div>
    	<div id="pubWarp" class="mainContent">
    		<div class="firstline">
    			<label class="firTil">标题:</label>
    			<input id="arTitle" name="arTitle" type="text" autocomplete="off" />
    			<a id="pubtn" class="upBrBtn pubArcBtn" href="javascript:void(0);">发表</a>
    		</div>
    		<div class="mainBody">
    			<iframe id="fulltext" name="fulltext" scrolling="no" src="page/reuse/fulltext.jsp"></iframe>
    		</div>
    		<div class="goodChoice choiceWarp">
    		</div>
    		<div class="noChoice choiceWarp">
    			<h3>还没有任何商品，快去搜索添加吧!</h3>
    		</div>
    		<div class="secline">
    			<input id="PName" name="PName" placeholder="商品名称" />
    			<a id="seachBth" class="upBrBtn pubArcBtn" href="javascript:void(0);">搜索</a>
    			<a id="deleteBth" class="upBrBtn pubArcBtn" href="javascript:void(0);">删除所选</a>
    		</div>
    		<div class="searchResult choiceWarp">
    			<div class="searchItem">
    				<div class="imgWarp"><img class="" alt="" src=""></div>
    				<div class="goodInfo">
    					<label class="goodName"> </label>
    					<label class="goodStore"></label>
    					<label class="yunLab">&yen;</label>
    					<label class="price"></label>
    					<label class="yunChinese">元</label>
    				</div>
    			</div>
    		</div>
    		<div class="noResult choiceWarp">
    			<h3>没有结果!</h3>
    		</div>
    		<div class="allResult choiceWarp">
    			<h3>已全被选中!</h3>
    		</div>
    	</div>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
  </body>
</html>

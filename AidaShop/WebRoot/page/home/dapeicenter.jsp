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
    
    <title>搭配中心_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-dpcenter.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	

  </head>
  
  <body>
  	<!-- 头部 start -->
  	<jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
  	<!-- 头部 end -->
  	
  	<!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <input id="msg" type="hidden" value='<s:property value="#request.msg"/>' />
    <div class="mainContent">
    	<div class="leftContent">
    		<div class="personInfo infobox">
    			<div><span id="perName"><s:property value="cusNickName"/> </span></div>
    			<div><span id="perLevel"><s:property value="styleName"/> </span></div>
    			<div><span>点赞数:</span><span id="likecount"><s:property value="desinfo.diLikeCount" /> </span></div>
    			<div><span>不满意数:</span><span id="hatecount"><s:property value="desinfo.diHateCount" /></span></div>
    			<div><span>文章总数:</span><span id="artcount"><s:property value="desinfo.diArticleCount" /></span></div>
    		</div>
    		<div class="personInfoUnlog infobox">
    			<h3 id="unlogH3"><s:property value="styleName"/></h3>
    		</div>
    		<div class="pubArticle">
    			<a id="pubArcBtn" href="page/home/publisharticle.jsp">搭配发表</a>
    		</div>
    		<div class="desginerList">
    			<div id="desTitBar">
    				<span id="destitone">造型师排行</span>
    				<a id="desMore" href="###">more</a>
    			</div>
    			<div class="desListTit">
    				<span id="desTitName" class="desTit">造型师</span>
    				<span id="desTitlike" class="desTit">点赞数</span>
    			</div>
    			<s:iterator value="desinfos">
    				<div class="desginerItem">
	    				<a href='<s:url action="viDesignDesignerAction"><s:param  name="UId" value="UId" /></s:url>' class="desName"><s:property value="nickName"/> </a>
	    				<span class="deLike"><s:property value="diLikeCount"/> </span>
	    			</div>
    			</s:iterator>
    		</div>
    	</div>
    	<div class="rightContent">
    		<s:iterator value="articles" var="a">
	    		<div class="artItem">
	    			<div class="artTit">
	    				<a class="artTitA" href='<s:url action="viArticleDesignerAction"><s:param  name="arId" value="#a.arId" /></s:url>'><s:property value="#a.arTitle"/></a>
	    			</div>
	    			<div class="artMain">
	    				<s:property value="#a.digest"/>
	    			</div>
	    			<div class="artGoods" data-show="on">
	    				<s:iterator status="st" value="#a.good" id="g">
		    				<div class="goodsItem">
		    					<a class="goodImg" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><img class="goodItem" alt='<s:property value="#g.PName"/>' src='<s:property value="#a.path[#st.index]"/>'></a> 
		    					<a class="goodName" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><s:property value="#g.PName"/> </a>
		    				</div>
	    				</s:iterator>
	    				<div class="clear"></div>
	    			</div>
	    		</div>
    		</s:iterator>
    	</div>
   		<div class="clear"></div>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
  </body>
  <script type="text/javascript">
  	var msg = $("#msg").val().trim();
  	if (msg=="unlog") {
		$(".personInfoUnlog").show();
		$(".personInfo").hide();
	}else if (msg=="one") {
		alert("这是您第一次来到这里，您可以寻找不同的想法，也可以留下自己的想法!");
	}
	
	$(".goodItem").each(function(){
		//加载图片至内存，完成后执行
		//获得原始图片高宽
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		//重新设置img的width和height
		$(this).height((50*imgHeight)/imgWidth);
		$(this).width(50);
	});
	
	
	$(".artItem").click(function() {
	//每行文章商品的显示和隐藏
		var index = $(this).index();
		var item = $(".artGoods").eq(index);
		if (item.css("display")=="block") {
			item.hide();
			item.attr("data-show","off");
		}else if (item.css("display")=="none") {
			item.show();
			item.attr("data-show","on");
		}
	});
  </script>
</html>

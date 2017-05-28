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
    
    <title>搭配详情_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-dpcenter.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/js-articledetail.js"></script>

  </head>
  
  <body>
      	<!-- 头部 start -->
  	<jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
  	<!-- 头部 end -->
  	
  	<!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div id="arc_detail_warp" class="mainContent">
    	<div class="arctilte">
    		<input id="arId" name="arId" value='<s:property value="article.arId"/>' type="hidden"/>
    		<s:property value="article.arTitle"/>
    	</div>
    	<div class="author" style="text-align: center;margin: 10px;">
    		作者: &nbsp;<s:property value="cust.UNickName"/>&nbsp;
    		<s:if test="cust.UStylingDesigner==2">国家认证</s:if>
		  	<s:elseif test="cust.UStylingDesigner==1">平台认证</s:elseif>
		  	<s:elseif test="cust.UStylingDesigner==3">国家认证审核中</s:elseif>
		  	<s:elseif test="cust.UStylingDesigner==4">平台认证审核中</s:elseif>
		  	<s:else>非认证</s:else>
    	</div>
    	<div class="article">
    		<s:property value="article.arMain" escapeHtml="false"/>
    	</div>
    	<s:form action="" method="post">
	    	<div class="arc_good">
	    		<s:iterator status="st" value="article.good" id="g">
		    		<div class="arc_good_item" >
		    			<input type="hidden" name="Pids" value='<s:property value="#g.PId"/>'/>
		    			<a class="goodImg" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><img class="goodItem" alt='<s:property value="#g.PName"/>' src='<s:property value="article.path[#st.index]"/>'></a> 
			    		<a class="goodNameArc" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><s:property value="#g.PName"/> </a>
			    		<label class="yunLab">&yen;</label>
			    		<label class="goodPrice"><s:property value="#g.PSellprice"/> </label>
			    		<label class="yunChinese">元</label>
		    		</div>
		    	</s:iterator>
	    	</div>
    		<s:submit id="shopAll" cssClass="upBrBtn" value="全部购买"></s:submit>
    	</s:form>
    	<div class="icon_warp">
    		<a id="like_icon" class="arcicon" href="javascript:void(0);" title="点赞"></a>
    		<a id="hate_icon" class="arcicon" href="javascript:void(0);" title="不满意"></a>
    	</div>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
  </body>
  <script type="text/javascript">
  	$(".goodItem").each(function(){
		//加载图片至内存，完成后执行
		//获得原始图片高宽
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		//重新设置img的width和height
		$(this).height((50*imgHeight)/imgWidth);
		$(this).width(50);
	});
	
	var count = $(".arc_good_item").length;
	if (count==0) {
		$("#shopAll").hide();
	}
  </script>
</html>

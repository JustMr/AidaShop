<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品搜索-AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/searchresult.css">
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
		
		window.onload = function () {
		setIframeHeight(document.getElementById('searchresult'));
		};
	</script>
  
  </head>
  
  <body>
    <!-- 头部 start -->
  	<jsp:include page="/page/reuse/detailheader.jsp"></jsp:include>
  	<!-- 头部 end -->
  	
  	<!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div class="mainContent">
    	<table class="cate" cellspacing="0">
    		<tr>
    			<td id="brandcate" class="cateitem">
    				<strong>品牌：</strong>
    			</td>
    			<td id="brandname">
    				<ul id="brand_ul" class="J_valueLis">
    					
    				</ul>
    			</td>
    		</tr>
    		<tr>
    			<td id="catecate" class="cateitem">
    				<strong>分类：</strong>
    			</td>
    			<td id="catename">
    				<ul id="cate_ul" class="J_valueLis">
    					
    				</ul>
    			</td>
    		</tr>
    		<tr>
    			<td id="pricecate" class="cateitem">
    				<strong>价格：</strong>
    			</td>
    			<td id="privatename">
    			
    				<input id="preprice" class="priceInput" name="preprice" type="text" autocomplete="off" placeholder="￥" />
    				<em>-</em>
    				<input id="nextprice" class="priceInput" name="nextprice" type="text" autocomplete="off" placeholder="￥" />
    				<a class="priceBtn" href="javascript:void(0);"></a>
    			</td>
    		</tr>
    	</table>
    </div>
    <div id="iframewrap">
    <%
    	String cgId = request.getParameter("cgId");
    	if(cgId!=null){
	    	String lv = request.getParameter("lv");
	    	if(lv.equals("1")) {
	%>
	    <iframe id="searchresult" scrolling="no" name="searchresult" src="onesearchGoodAction?cgId=<%=cgId%>&brId=0&preprice=0&nextprice=0"></iframe>
	<%
	    	}else if(lv.equals("2")) {
	    	
	%>
	    <iframe id="searchresult" scrolling="no" name="searchresult" src="twosearchGoodAction?cgId=<%=cgId%>&brId=0&preprice=0&nextprice=0"></iframe>
	<%
	    	}else if(lv.equals("3")) {
	    	
	%>
	     <iframe id="searchresult" scrolling="no" name="searchresult" src="threesearchGoodAction?cgId=<%=cgId%>&brId=0&preprice=0&nextprice=0"></iframe>
	<%
	    	}
    	
    	}else {
    		String PName = request.getParameter("PName");
    		PName = java.net.URLDecoder.decode(PName, "utf-8"); 
    		
	%>
		<input id="newpname" type="hidden" value="<%=PName%>">
	    <iframe id="searchresult" scrolling="no" name="searchresult" src=""></iframe>
	<%
	     }
	%>
		<script type="text/javascript">
			var  pname = $("#newpname").val().trim();
			var url = "allsearchGoodAction?PName="+encodeURI(encodeURI(pname))+"&cgId=0&brId=0&preprice=0&nextprice=0";
			$("#searchresult").attr("src",url);
		</script>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
  </body>
</html>

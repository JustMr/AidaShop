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
    
    <link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/searchresult.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
  
  	<style type="text/css">
  		#result_wrap {
  			width: 100%;
  			margin: 20px auto;
  		}
  	</style>
  	
  </head>
  
  <body>
    <div id="result_wrap">
    	<div class="noresule">
    		<h2>暂时没有你想要的商品!</h2>
    	</div>
    	<div class="haveresule">
    		<ul class="gl-warp">
    			<s:iterator value="goods" status="st">
    			<li class="gl-item">
    				<div class="gl-i-wrap">
    					<div class="p-img">
    						<a target="_blank"  href='detailGoodAction?PId=<s:property value="PId" />'>
    							<img class="err-product" alt='<s:property value="PName"/>' src='<s:property value="#request.pathList[#st.index]" />'>
    						</a>
    						<div data-pid='<s:property value="PId" />' data-price='<s:property value="PSellCount" />'></div>
    					</div>
    					<div class="p-price">
    						<strong class="J_strong">
    							<em>&yen;</em>
    							<i><s:property value="PSellprice" /></i>
    						</strong>
    					</div>
    					<div class="p-name">
    						<a target="_blank" title='<s:property value="PName" />' href='detailGoodAction?PId=<s:property value="PId" />'>
    							<em><s:property value="PName" /></em>
    						</a>
    					</div>
    					<div class="p-shop">
    						<s:property value="#request.storName[#st.index]" />
    					</div>
    				</div>
    			</li>
    			</s:iterator>
    		</ul>
    	</div>
    </div>
  </body>
  <script type="text/javascript">
  	var count = $(".gl-item").length;
  	if(count==0) {
  		$(".noresule").show();
  	}else {
		$(".haveresule").show();
	}
	$(".err-product").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).height((220*imgHeight)/imgWidth);
	$(this).width(220);
	});
  </script>
</html>

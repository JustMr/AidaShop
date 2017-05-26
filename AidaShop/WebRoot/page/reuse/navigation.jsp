<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<link rel="stylesheet" type="text/css" href="css/style-homecontent.css">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-nav.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/js-nav.js"></script>
		
  </head>
  
  <body>
    <!-- 导航栏 -->
  	<div class="homeNav">
  		<div class="homeNavMain">
  			<ul class="homeNavUl">
  				<li class="homeNavFirst">
  					所有商品分类
  					<em class="bias"></em>
  					<ul class="fistMenu">
  						
  					</ul>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">首页</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱搭</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱家居</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">电器城</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="dapeiCenterDesignerAction">搭配中心</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱搭排行</a>
  				</li>
  			</ul>
  		</div>
  	</div>
  </body>
</html>

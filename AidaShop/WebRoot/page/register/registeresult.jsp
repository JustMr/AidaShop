<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册_AidaShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/style-clear.css">
    
  </head>
  
  <body>
  	<% 
  		String data = request.getParameter("data");
  		System.out.println("registeresult.jsp data:"+data);
  		if(data.equals("0")) {
  			%>
  			<h1>邮箱尚未激活，现在去激活</h1>
  			<%
  		}else if(data.equals("1")) {
  			%>
  			<h1>邮箱已激活，现在去<a href="login.html">登录</a></h1>
  			<%
  		}else {
  			%>
  			<h1>激活失败，重新去激活</h1>
  			<%
  		}
  	 %>
    <a href="#">完善个人信息</a>
    <a href="home.jsp">进入主页</a>
    <input type="hidden" value="${data}">
  </body>
</html>

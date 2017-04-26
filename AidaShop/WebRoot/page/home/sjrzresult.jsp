<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商家入驻_AidaShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/sjrz.css">

  </head>
  
  <body>
  	<jsp:include page="/page/reuse/header.jsp"></jsp:include>
  	
    <h1 id="sjrz_resH1">${message}</h1>
    <p id="sjrz_resP">您可以登录<a href="page/home/gerenzhongxin.jsp">个人中心</a> 查看申请结果</p>
    
    
    <jsp:include page="/page/reuse/footer.jsp"></jsp:include>
  </body>
</html>

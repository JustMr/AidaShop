<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

  </head>
  
  <body>
    <div class="panel panel-primary">
		<div class="panel-heading" style="height: 10%">销售统计图</div>
		<div class="panel-body" style="height: 80%">
	<%  
   	/* String fileName=request.getParameter("filename");  
    System.out.println(fileName);  */
    String url = "D:/Program Files/Apache Software Foundation/Tomcat 7.0/temp/";
	%> 
	<img src="<%=url%>${filename}" width="800" height="600">
		</div>
		<div class="panel-footer" style="height: 10%"></div>
	</div>
	<script src="jQuery/jquery-3.2.1.js"></script>
	<script src="dist/js/bootstrap.min.js"></script>
  </body>
</html>

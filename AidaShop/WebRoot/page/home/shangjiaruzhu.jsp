<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>店铺入驻_AidaShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

  </head>
  
  <body>
    <jsp:include page="/page/reuse/header.jsp"></jsp:include>
    
	<div id="cs_wrap">
		<h1>免费开店</h1>
		<div>
			<span>申请店铺完全免费; 一个身份只能开一家店; 开店后店铺无法注销; 申请到正式开通预计需1~3个工作日。</span>
		</div>
		<div id="cs_main">
			<div id="cs_tit">
				<ul>
					<li>
						<div>1</div>
						<div>
							<p>选择开店类型</p>
							<span>个人店铺、企业店铺</span>
						</div>
					</li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</div>
    
    <jsp:include page="/page/reuse/footer.jsp"></jsp:include>
  </body>
</html>

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
    
    <title>购物车_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上超市，网上商城，网络购物，进口食品，美容护理，母婴玩具，厨房清洁用品，家用电器，手机数码，电脑软件办公用品，家居生活，服饰内衣，营养保健，钟表珠宝，饰品箱包，汽车生活，图书音像，礼品卡，药品，医疗器械，隐形眼镜等，AidaLShop">
	<meta http-equiv="description" content="AidaLShop，在线搭配平台，在搭配中改变为更好的我">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<style type="text/css">
		#shop_wrap {
			width: 1200px;
			margin: 20px auto;
		}
		.wrap-input {
			border:1px solid #d9d9d9;
			position:relative;
			width: 94px;
			height: 24px;
			overflow:hidden;
		}
		.wrap-input a {
			display:inline-block;
			height:24px;
			line-height:24px;
			padding:0 9px;
			color:#666;
			font-size:22px;
			background:#f8f8f8;
			
		}
		.wrap-input a:hover {
			color:#666;
			text-decoration: none;
		}
		.btn_add {
			position:absolute;
			left:62px;
		}
		#buy-num {
			width: 38px;
			border: none;
			border: 0;
			border-left: solid 1px #d9d9d9;
			border-right: solid 1px #d9d9d9;
			padding: 0;
			height: 24px;
			line-height: 26px;
			font-family: Arial;
			font-size: 16px;
			position: absolute;
			left: 24px;
			text-align: center;
		}
	</style>
	<script type="text/javascript">
		function addcount(PId) {
		
		}
		function reducecount(PId) {
			
		}
		function deleteGood(PId) {
		}
	</script>

  </head>
  
  <body>
     <!-- 头部 -->
    <jsp:include page="../reuse/detailheader.jsp"></jsp:include>
    
    <!-- 导航栏 start -->
    <jsp:include page="/page/reuse/navigation.jsp"></jsp:include>
    <!-- 导航栏 end -->
    
    <div id="shop_wrap">
    	<table>
    		<thead>
    			<tr><td>商品</td></tr>
    			<tr><td>单价</td></tr>
    			<tr><td>数量</td></tr>
    			<tr><td>小计</td></tr>
    			<tr><td>操作</td></tr>
    		</thead>
    		<tbody>
    			<s:iterator value="order.orderitems" id="it">
    			<tr>
    				<td><s:property value="#it.adProductInfo.PName" /></td>
    			</tr>
    			<tr>
    				<td><s:property value="#it.adProductInfo.PSellprice" /></td>
    			</tr>
    			<tr>
    				<td><s:property value="#it.OAmount" /></td>
    			</tr>
    			<tr>
    				<td>
						<div class="wrap-input">
  							<a class="btn_reduce" href="javascript:void(0);" onclick='reducecount(<s:property value="#it.adProductInfo.PId" />)'>-</a>
  							<a class="btn_add" href="javascript:void(0);" onclick='addcount(<s:property value="#it.adProductInfo.PId" />)'>+</a>
  							<input id="buy-num" name="OAmount" class="text" value='<s:property value="#it.OAmount" />' type="text" autocomplete="off"  readonly="true">
  						</div>
					</td>
    			</tr>
    			<tr>
    				<td><a class="deleteshop" onclick='deleteGood(<s:property value="#it.adProductInfo.PId" />)'>删除</a> </td>
    			</tr>
    			</s:iterator>
    		</tbody>
    	</table>
    </div>
    
    <jsp:include page="/page/reuse/detailfooter.jsp"></jsp:include>
    
  </body>
</html>

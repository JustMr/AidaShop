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
		#shopcartd td {padding: 5px;}
		#shoptab {margin: 0 auto;width: 100%;}
		.deleteshop {cursor: pointer;}
		.deleteshop:HOVER {
			text-decoration: none;
			color: red;
		}
	</style>
	
  </head>
  
  <body>
    <div id="shop_wrap">
    	<table id="shoptab">
    		<thead>
    			<tr>
    			<th colspan="2">商品</th>
    			<th>单价</th>
    			<th>数量</th>
				<th>小计</th>
    			<th>操作</th></tr>
    		</thead>
    		<tbody id="shopcartd">
    			<s:iterator status="st" value="order.orderitems" id="it">
    			<tr>
    				<td><img class="shoppicture" alt='<s:property value="#it.adProductInfo.PName" />' src='<s:property value="#request.pathList[#st.index]" />'> </td>
    				<td><s:property value="#it.adProductInfo.PName" /></td>
    				<td><s:property value="#it.adProductInfo.PSellprice" /></td>
    				<td><s:property value="#it.OAmount" /></td>
    				<td>
						<div class="wrap-input">
  							<a class="btn_reduce" href='<s:url action="reduceoneOrderAction"><s:param  name="PId" value="#it.adProductInfo.PId" /></s:url>'>-</a>
  							<a class="btn_add" href='<s:url action="addoneOrderAction"><s:param  name="PId" value="#it.adProductInfo.PId" /></s:url>'>+</a>
  							<input id="buy-num" name="OAmount" class="text" value='<s:property value="#it.OAmount" />' type="text" autocomplete="off"  readonly="true">
  						</div>
					</td>
    				<td><a class="deleteshop" href='<s:url action="deleteoiOrderAction"><s:param  name="PId" value="#it.adProductInfo.PId" /></s:url>'>删除</a> </td>
    			</tr>
    			</s:iterator>
    		</tbody>
    	</table>
    	<div class="paytotal">
    		<a id="jiesuan" href="javascript:void(0);" >去结算</a>
    	</div>
    </div>
    <script type="text/javascript">
	$(".shoppicture").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).height((70*imgHeight)/imgWidth);
	$(this).width(70);
	});
  </script> 
  </body>
</html>

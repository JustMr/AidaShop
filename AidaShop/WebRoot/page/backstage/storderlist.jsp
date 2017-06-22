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
    <link rel="stylesheet" type="text/css" href="css/style-table.css">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

  </head>
  
  <body>
  	<div class="ordertab tabshow">
   	<table class="bordered">  
		<thead>  
		 <tr>  
		  <th>订单编号</th> 
		  <th>商品</th> 
		  <th>创建时间</th>
		  <th>单价</th>  
		  <th>买家</th>
		  <th>状态</th>
		 </tr>  
		</thead>  
		<tbody>
			<s:iterator id="it" status="st" value="orderitems">
			<tr>
				<td>
					<a href='<s:url action="stviOrderAction"><s:param name="OId" value="#it.OId"></s:param></s:url>'><s:property value="#it.adOrder.coName"/></a>
				</td>
				<td>
					<img class="shoppicture" alt='<s:property value="#it.adProductInfo.PName" />' src='<s:property value="#request.pathList[#st.index]" />'>
				  	<s:property value="#it.adProductInfo.PName"/>
				</td>  
				<td><s:date name="#it.adOrder.coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"></s:date></td>
				<td>&yen;<s:property value="#it.adProductInfo.PSellprice"/> </td>
				<td><s:property value="#request.nicknames[#st.index]" /></td>
				<td>
					<s:if test='#it.OState=="finished"'>已收货</s:if>
					<s:elseif test='#it.OState=="sending"'>发货中</s:elseif>
					<s:elseif test='#it.OState=="nonpay"'>未付款</s:elseif>
				</td>
			</tr>	
			</s:iterator>  
	 	</tbody>  
	</table>
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

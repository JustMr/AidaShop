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
    <style type="text/css">
    	.ordera {display: inline-block;height: 24px;line-height: 24px;padding: 3px 5px;text-align: center;}
    	.ashow {border-bottom: 2px solid red;}
    	.ordertab {display: none;}
    	.tabshow {display: block;}
    </style>
	<script type="text/javascript">
		$(function() {
			$(".ordera").click(function() {
				$(".ordera").removeClass("ashow");
				$(this).addClass("ashow");
				var index = $(this).index(".ordera");
				$(".ordertab").removeClass("tabshow");
				$(".ordertab").eq(index).addClass("tabshow");
			});
		});
	</script>
  </head>
  
  <body>
    <div>
    	<a class="ordera ashow" href="javascript:void(0);">已完成</a>
    	<a class="ordera" href="javascript:void(0);">待付款</a>
    	<a class="ordera" href="javascript:void(0);">待收货</a>
    </div>
    <div class="ordertab tabshow">
    	<table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>订单编号</th>  
			  <th>创建时间</th> 
			  <th>总价格</th>  
			  <th>实付</th> 
			  <th>状态</th>
			 </tr>  
			</thead>  
			<tbody>  
			<s:iterator value="finishOrders">
			 <tr class="bhover">  
			  <td>
			  	<s:hidden name="coId"></s:hidden>
			  	<a href='<s:url action="viorderOrderAction"><s:param  name="coId" value="coId" /></s:url>'><s:property value="coName"/> </a>
			  </td>  
			  <td class="introBh"><s:date name="coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"/> </td>  
			  <td class="introBh"><s:property value="coTotalPrice" /></td>  
			  <td class="introBh"><s:property value="coRealPrice" /></td>  
			  <td>
		  		<s:if test='coOrderState=="nonpay"'>待付款</s:if>
			  	<s:elseif test='coOrderState=="paid"'>待收货</s:elseif>
			  	<s:elseif test='coOrderState=="finished"'>已完成</s:elseif>
			  </td> 
			 </tr>
			 </s:iterator>
		 	</tbody>  
		</table>
    </div>
    <div class="ordertab">
    	<table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>订单编号</th>  
			  <th>创建时间</th> 
			  <th>总价格</th>  
			  <th>实付</th> 
			  <th>状态</th>
			 </tr>  
			</thead>  
			<tbody>  
			<s:iterator value="nopayOrders">
			 <tr class="bhover">  
			  <td>
			  	<s:hidden name="coId"></s:hidden>
			  	<a href='<s:url action=""><s:param  name="coId" value="coId" /></s:url>'><s:property value="coName"/> </a>
			  </td>  
			  <td class="introBh"><s:date name="coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"/> </td>  
			  <td class="introBh"><s:property value="coTotalPrice" /></td>  
			  <td class="introBh"><s:property value="coRealPrice" /></td>  
			  <td>
		  		<s:if test='coOrderState=="nonpay"'>待付款</s:if>
			  	<s:elseif test='coOrderState=="paid"'>待收货</s:elseif>
			  	<s:elseif test='coOrderState=="finished"'>已完成</s:elseif>
			  </td> 
			 </tr>
			 </s:iterator>
		 	</tbody>  
		</table>
    </div>
    <div class="ordertab">
    	<table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>订单编号</th>  
			  <th>创建时间</th> 
			  <th>总价格</th>  
			  <th>实付</th> 
			  <th>状态</th>
			 </tr>  
			</thead>  
			<tbody>  
			<s:iterator value="paidOrders">
			 <tr class="bhover">  
			  <td>
			  	<s:hidden name="coId"></s:hidden>
			  	<a href='<s:url action=""><s:param  name="coId" value="coId" /></s:url>'><s:property value="coName"/> </a>
			  </td>  
			  <td class="introBh"><s:date name="coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"/> </td>  
			  <td class="introBh"><s:property value="coTotalPrice" /></td>  
			  <td class="introBh"><s:property value="coRealPrice" /></td>  
			  <td>
		  		<s:if test='coOrderState=="nonpay"'>待付款</s:if>
			  	<s:elseif test='coOrderState=="paid"'>待收货</s:elseif>
			  	<s:elseif test='coOrderState=="finished"'>已完成</s:elseif>
			  </td> 
			 </tr>
			 </s:iterator>
		 	</tbody>  
		</table>
    </div>
  </body>
</html>

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

<style type="text/css">
		.pubwrap {width: 1200px;margin: 20px auto;}
		table {
			width:60%;
			border: none;
			border-spacing: 0px;
		}
		table td {
			 padding: 3px 5px;text-align: left;
		}
		#paybtn {
			display: block;background: #872222;width: 120px;height: 36px;
		line-height: 36px;text-align: center;color: #fff;font-size: 18px;font-weight: 500;
			margin-left: 20px;
		}
		#paybtn:HOVER {
	text-decoration: none;
}
	</style>
  </head>
  
  <body>
     <div class="pubwrap">
    	<table>
    		<tr>
    			<td width="300px;">订单号：</td>
    			<td><s:property value="order.coName"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">收货地址</td>
    		</tr>
			<tr>
				<td>姓名：</td>
				<td><s:property value="address.shName"/> </td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:property value="address.shPhone"/></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:property value="address.shPhone"/></td>
			</tr>
			<tr>
				<td colspan="2">商品列表</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%">
						<s:iterator status="st" value="order.orderitems" id="it">
						<tr>
							<td><img class="shoppicture" alt='<s:property value="#it.adProductInfo.PName" />' src='<s:property value="#request.pathList[#st.index]" />'> </td>
		    				<td><s:property value="#it.adProductInfo.PName" /></td>
		    				<td><s:property value="#it.adProductInfo.PSellprice" /></td>
		    				<td><s:property value="#it.OAmount" /></td>
							<td>&yen;<s:property value="#request.pricelist[#st.index]" /></td>
						</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td>总价：</td>
				<td>&yen;<s:property value="order.coTotalPrice"/></td>
			</tr>
			<tr>
				<td>运费：</td>
				<td>&yen;<s:property value="order.coFreightCharge"/></td>
			</tr>
			<tr>
				<td>折扣：</td>
				<td>&yen;<s:property value="order.coDiscountPrice"/></td>
			</tr>
			<tr>
				<td>实付：</td>
				<td>&yen;<s:property value="order.coRealPrice"/></td>
			</tr>
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

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
    	.loghide {display: none;}
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
			  	<a href='<s:url action="suborderOrderAction"><s:param  name="coId" value="coId" /></s:url>' target="_parent"><s:property value="coName"/> </a>
			  </td>  
			  <td class="introBh"><s:date name="coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"/> </td>  
			  <td class="introBh">&yen;<s:property value="coTotalPrice" /></td>  
			  <td class="introBh">&yen;<s:property value="coRealPrice" /></td>  
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
    	<table class="bordered">  
			<thead>  
			 <tr>  
			  <th>订单编号</th> 
			  <th>商品</th> 
			  <th>创建时间</th>
			  <th>单价</th>  
			  <th>状态</th>
			  <th>操作</th>
			 </tr>  
			</thead>  
			<tbody>
				<s:iterator id="it" status="st" value="orderitems">
				<tr>
					<td><a href='<s:url action=""><s:param name="" value=""></s:param></s:url>'><s:property value="#it.adOrder.coName"/></a></td>
					<td>
						<img class="shoppicture" alt='<s:property value="#it.adProductInfo.PName" />' src='<s:property value="#request.pathList[#st.index]" />'>
					  	<s:property value="#it.adProductInfo.PName"/>
					</td>  
					<td><s:date name="#it.adOrder.coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"></s:date></td>
					<td>&yen;<s:property value="#it.adProductInfo.PSellprice"/> </td>
					<td>
						<s:if test='#it.OState=="finished"'>已收货</s:if>
						<s:elseif test='#it.OState=="sending"'>发货中</s:elseif>
						<s:elseif test='#it.OState=="nonpay"'>未付款</s:elseif>
					</td>
					<td>
						<a href='vilogitcs(<s:property value="#it.OId" />)'>查看物流</a>
						<a href='grfinishOrderAction?OId=<s:property value="#it.OId" />'>确定收货</a>
						<div class="loghide">
							<p><label>物流公司：</label><label id="company"></label> </p>	
							<p><label>物流单号：</label><label id="nmber"></label> </p>	
						</div>
					</td>
				</tr>	
				</s:iterator>  
		 	</tbody>  
		</table>
    </div>
  </body>
   <script type="text/javascript">
   	function vilogitcs(OId){
   		var OId = OId;
   		$.ajax({
   			url: "vilogticsOrderAction",
   			type: "post",
   			dataType: "json",
   			success: function(data) {
   				if (data.success!=null) {
					$(".loghide").show();
					$("#company").append(data.lgCompaby);
					$("#nmber").append(data.lgNumber);
				}else {
					alert("还没有物流信息!");
				}
   			}
   		});
   	}
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
</html>

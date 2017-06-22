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
    	#viordertab {width: 100%;}
    	#viordertab td{border-left: 1px solid #666;border-top: 1px solid #666;padding: 3px;}
    	#viordertab tr:last-child td {border-bottom: 1px solid #666;}
    	#viordertab tr td:last-child {border-right: 1px solid #666;}
    	.upBrBtn { width:66px;height:32px;background: #fd6d37;color:#fff;border-radius:5px;border:none;outline: none;cursor: pointer;margin: 20px auto;display: inline-block;
    	line-height: 32px;text-align: center;text-decoration: none;}
		.upBrBtn:hover { -webkit-filter:brightness(.9); color: #fff;text-decoration: none;}
		.inputLogtics {width: 40%;}
    </style>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#visub").click(function() {
			var OId = $("#oidinput").val();
			var lgCompaby = $("#lgCompaby").val().trim();
			var lgNumber = $("#lgNumber").val().trim();
			$.ajax({
				url: "updatalogticsOrderAction",
				type: "post",
				dataType: "json",
				data: {
					OId: OId,
					lgCompaby: lgCompaby,
					lgNumber: lgNumber,
				},
				success: function(data){
					if (data.success==true) {
						$(".subtip").empty();
						$(".subtip").append("修改成功!");
					}else {
						$(".subtip").empty();
						$(".subtip").append("修改失败");
					}
				},
				error: function(){
					alert("something wrong!");
				}
			});
		});		
	});
	</script>
  </head>
  
  <body>
    <table id="viordertab" class="bordered">  
		<tr>
			<td>订单编号</td> 
			<td>
				<s:hidden id="oidinput" name="orderitem.OId"></s:hidden>
				<s:property value="orderitem.adOrder.coName"/>
			</td>
		</tr>
		<tr>
			<td>商品</td> 
			<td>
				<img class="shoppicture" alt='<s:property value="orderitem.adProductInfo.PName" />' src='<s:property value="#request.path" />'>
			  	<s:property value="orderitem.adProductInfo.PName"/>
			</td> 
		</tr>
		<tr> 
			<td>创建时间</td>
			<td><s:date name="orderitem.adOrder.coCreateTime" format="MM/dd/yy hh:mm:ss" nice="false"></s:date></td>
		</tr>
		<tr>
			<td>单价</td>  
			<td>&yen;<s:property value="orderitem.adProductInfo.PSellprice"/> </td>
		</tr>
		<tr>
			<td>买家</td>
			<td><s:property value="orderitem.adOrder.adCustomer.UNickName" /></td>
		</tr>
		<tr>
			<td>状态</td>
			<td>
				<s:if test='orderitem.OState=="finished"'>已收货</s:if>
				<s:elseif test='orderitem.OState=="sending"'>发货中</s:elseif>
				<s:elseif test='orderitem.OState=="nonpay"'>未付款</s:elseif>
			</td>
		</tr>
		<tr>
			<td>物流公司</td>
			<td>
				<s:if test='orderitem.OState=="sending"'>
					<s:textfield id="lgCompaby" cssClass="inputLogtics" name="logistics.lgCompaby"></s:textfield>
				</s:if>
				<s:else>
					<s:property value="logistics.lgCompaby"/>
				</s:else>
			</td>
		</tr>
		<tr>
			<td>物流单号</td>
			<td>
				<s:if test='orderitem.OState=="sending"'>
					<s:textfield id="lgNumber" cssClass="inputLogtics" name="logistics.lgNumber"></s:textfield>
				</s:if>
				<s:else>
					<s:property value="logistics.lgNumber"/>
				</s:else>
			</td>
		</tr>	
		<tr>
			<s:if test='orderitem.OState=="sending"'>
				<td colspan="2">
					<a id="visub" class="upBrBtn" href="javascript:void(0);">提交</a><label class="subtip"></label>
				</td>
			</s:if>
		</tr>
	</table>
  </body>
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
</html>

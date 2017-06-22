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
    <table id="brandListTAb" class="bordered">  
		<thead>  
		 <tr>  
		  	<th colspan="2">商品</th>
			<th style="text-align: left;">单价</th>
			<th style="text-align: left;padding-left: 30px;">数量</th>
			<th style="text-align: left;">申请</th>
			<th style="text-align: left;">状态</th>
			<th style="text-align: left;">反馈</th>
		 </tr>  
		</thead>  
		<tbody>  
		<s:iterator id="it" value="exres" status="st">
		 <tr class="bhover">  
		 <td><img class="shoppicture" alt='<s:property value="#it.good.PName" />' src='<s:property value="#request.pathList[#st.index]" />'></td>
		  <td>
		  	<s:hidden name="#it.erId"></s:hidden>
		  	<s:property value="#it.good.PName"/>
		  </td>  
		  <td class="introBh"><s:property value="#it.good.PSellprice" /></td>  
		  <td class="introBh"><s:property value="#it.erAmount" /></td>  
		  <td>
		  	<s:if test='#it.erAuth=="refund"'>退货</s:if>
		  	<s:else>换货</s:else>
		  </td>
		  <td>
	  		<s:if test='#it.erState==0'>处理中</s:if>
		  	<s:elseif test='#it.erState==1'>失败</s:elseif>
		  	<s:elseif test='#it.erState==2'>成功
		  	</s:elseif>
		  </td> 
		  <td><s:property value="#it.erFeedback" /></td>
		 </tr>
		 </s:iterator>
	 	</tbody>  
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

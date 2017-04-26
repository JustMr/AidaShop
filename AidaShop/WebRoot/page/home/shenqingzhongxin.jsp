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
    <script type="text/javascript" src="js/img.js"></script>
	
  </head>
  
  <body>
    <form  id="myForm">
	    <table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>申请类型</th>  
			  <th>申请人</th> 
			  <th>店铺名称</th>  
			  <th>店铺标签</th> 
			  <th>证件照正面</th>  
			  <th>证件照反面</th>  
			  <th>状态</th>
			 </tr>  
			</thead>  
			<tbody>  
			 <tr class="bhover">  
			 <td class="introBh">店铺申请</td>  
			  <td>
			  	<s:hidden name="storeAuth.saId"></s:hidden>
			  	<a href='<s:url action="sqviStoreAuthAction"><s:param  name="saId" value="storeAuth.saId" /></s:url>'>${cusNickName}</a>
			  </td>  
			  <td class="introBh"><s:property value="storeAuth.saName" /></td>  
			  <td class="introBh"><s:property value="storeAuth.saTag" /></td>  
			  <td class="introBh">
			  	<s:hidden id="front_hide" name="storeAuth.saIdcardFront"></s:hidden>
			  	<img id="front_img" title="证件照正面" alt="证件照正面" src="">
			  </td>  
			  <td class="introBh">
			  	<s:hidden id="back_hide" name="storeAuth.saIdcardBack"></s:hidden>
			  	<img id="back_img" title="证件照反面" alt="证件照反面" src="">
			  </td>  
			  <td>
		  		<s:if test="storeAuth.saStatu==0">未通过</s:if>
			  	<s:elseif test="storeAuth.saStatu==1">申请中</s:elseif>
			  	<s:elseif test="storeAuth.saStatu==2">已通过</s:elseif>
			  </td> 
		 	</tbody>  
		</table>
	</form>
  </body>
</html>

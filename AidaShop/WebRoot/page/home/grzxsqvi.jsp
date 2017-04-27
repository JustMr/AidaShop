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
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/grzx.js"></script>
	<link rel="stylesheet"  type="text/css" href="css/style-grzx.css">
  </head>
  
  <body>
  <div id="sqzxvi">
    <table id="brandListTAb">
    	<tr>
			<td width="25%" align="left"><label>状态:</label><input id="pageCheck" type="hidden" value="sqzxvi" /> </td>
			<td class="upBrFont" width="25%" align="left">
				<s:if test="storeAuth.saStatu==0">未通过</s:if>
			  	<s:elseif test="storeAuth.saStatu==1">申请中</s:elseif>
			  	<s:elseif test="storeAuth.saStatu==2">已通过</s:elseif>
			</td>
			<td width="25%" align="left"><label>店铺名称:</label><input id="pageCheck" type="hidden" value="sqzxvi" /> </td>
			<td class="upBrFont" width="25%" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="storeAuth.saName" label="店铺名称" /></td>
		</tr> 
		<tr>
			<td align="left" width="25%"><label>店铺标签:</label></td>
	   		<td class="upBrFont" align="left" colspan="3"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="storeAuth.saTag" label="店铺标签" /></td>
	   	</tr>  
	   	<tr>
	   		<td align="left" width="50%" colspan="2"><label>证件照正面:</label></td>
	   		<td align="left" colspan="2"><label>证件照背面:</label></td>
	   	</tr> 
	   	<tr>
	   		<td class="upBrFont" align="right" colspan="2">
	   			<s:hidden id="front_hide" name="storeAuth.saIdcardFront"></s:hidden>
			  	<img id="front_img" title="证件照正面" alt="证件照正面" src="">
			</td>
	   		<td class="upBrFont" align="right" colspan="2">
	   			<s:hidden id="back_hide" name="storeAuth.saIdcardBack"></s:hidden>
			  	<img id="back_img" title="证件照反面" alt="证件照反面" src="">
			</td>
	   	</tr> 
    </table>
    <script type="text/javascript">
		var srcF = $("#front_hide").val();
		var srcB = $("#back_hide").val();
		var imgF = $("#front_img");
		var imgB = $("#back_img");
		console.log("srcF:"+srcF);
		var indexF = srcF.indexOf("\\upload\\");
		var indexB = srcB.indexOf("\\upload\\");
		console.log("indexF:"+indexF);
		var reg=/\\/g;//g,表示全部替换
		srcF = "."+srcF.substr(indexF).replace(reg,"/");
		srcB = "."+srcB.substr(indexF).replace(reg,"/");
		console.log("srcF now:"+srcF);
		imgF.attr("src",srcF);
		imgB.attr("src",srcB);
		
		$("#brandListTAb img").each(function(){
		//加载图片至内存，完成后执行
		//获得原始图片高宽
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		//重新设置img的width和height
		$(this).height((200*imgHeight)/imgWidth);
		$(this).width(200);
		});
    </script>
    <div id="nopass">
    	<h5 class="nopass_tit">您的申请未通过，可能是您申请的店铺所提交的内容不符合规定或个人信息不够完整或真实</h5>
    	<h5 class="nopass_tit">您可以通过如下修改店铺申请内容或在 设置——个人中心 修改个人信息</h5>
    	<form action="${pageContext.request.contextPath }/updateStoreAuthAction" enctype="multipart/form-data" method="post" >
			<table id="formTab" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>店铺名称：</td>
					<td>
						<s:hidden name="storeAuth.saId"></s:hidden>
						<s:hidden name="storeAuth.UId"></s:hidden>
						<s:hidden id="statuGRZXSQVi" name="storeAuth.saStatu"></s:hidden>
						<s:textfield name="storeAuth.saName" label="店铺名称" />
					</td>
				</tr>
				<tr>
					<td>店铺标签：</td>
					<td><s:textfield name="storeAuth.saTag" label="店铺标签" /> </td>
				</tr>
				<tr>
					<td id="tipTD" colspan="2"><span id="tipTr2">请以“**/**/**”的形式书写，如“上衣/衬衫/裤子”</span></td>
				</tr>
				<tr>
					<td>身份证正面上传：</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td>身份证背面上传：</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="upBrBtn" type="submit" value="提交">
					</td>
				</tr>
			</table>
	    </form>
    </div>
    </div>
  </body>
</html>

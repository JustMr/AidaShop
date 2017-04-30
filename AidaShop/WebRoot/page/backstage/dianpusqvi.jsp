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
	<link rel="stylesheet" type="text/css" href="css/style-pinpaiguanli.css">
	
  </head>
  
  <body>
    <span class="frameH3">店铺申请信息查看、修改</span>
    <div>
    	<s:form action="upAllStoreAuthAction" method="POST">  
    		<s:hidden name="cust.UId" />  
	  		<table id="upBrtable" border="1">
	  			<tr>
	  				<td width="15%" align="right"><label>用户名:</label></td>
	  				<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.UName" label="用户名" /></td>
	  				<td width="15%" align="right"><label>昵称:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.UNickName" label="昵称" /></td>
			   	</tr>  
			   	<tr>
			   		<td width="15%" align="right"><label>真实姓名:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.URelaname" label="真实姓名" /></td>
			   		<td width="15%" align="right"><label>性别:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; " name="cust.USex" label="性别" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>生日:</label></td>
			   		<td class="upBrFont" align="left"><s:date name="cust.UBirthday" format="yyyy-MM-dd" nice="false" /><s:hidden name="cust.UBirthday"></s:hidden> </td>
			   		<td width="15%" align="right"><label>住址:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.UAddress" label="住址" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>身份证:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; " name="cust.UCardId" label="身份证" /></td>
			   		<td width="15%" align="right"><label>电子邮箱:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.UEmail" label="电子邮箱" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>手机:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="cust.UMobile" label="手机" /></td>
			   		<td><label>状态VIP:</label></td>
			   		<td class="upBrFont_1">
			   			<s:if test="cust.UState==0">正常</s:if>
			   			<s:elseif test="cust.UState==1">禁用</s:elseif>
					  	<s:elseif test="cust.UState==2">VIP1</s:elseif>
					  	<s:elseif test="cust.UState==3">VIP2</s:elseif>
					  	<s:elseif test="cust.UState==4">VIP3</s:elseif>
					  	<s:else>激活中</s:else>
			   		</td>
			   	</tr>  
			   	<!-- 店铺申请表信息 -->
 				<tr>
 					<s:hidden name="storeAuth.saId"></s:hidden>
					<s:hidden name="storeAuth.UId"></s:hidden>
					<td width="25%" align="left"><label>店铺名称:</label> </td>
					<td class="upBrFont" width="25%" align="left"><s:textfield readonly="true" style= "background:transparent;border-style:none;width:100%; "  name="storeAuth.saName" label="店铺名称" /></td>
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
					  	<td width="25%" align="left"><label>申请状态:</label><input id="pageCheck" type="hidden" value="spsqvi" /> 
					</td>
				</tr> 
			   	<tr>
					<td class="upBrFont" width="25%" align="left">
						<s:if test="storeAuth.saStatu==0">未通过</s:if>
					  	<s:elseif test="storeAuth.saStatu==1">申请中</s:elseif>
					  	<s:elseif test="storeAuth.saStatu==2">已通过</s:elseif>
					  	<s:radio id="saStatu" name="storeAuth.saStatu" list="#{'未通过':0,'申请中':1,'已通过':2}" listKey="value" listValue="key" value="storeAuth.saStatu"></s:radio>
					</td>
			   	</tr> 
			   	<tr>
			   		<td align="center" colspan="2">
				   		<s:submit cssClass="upBrBtn" value="提交" />  
						<s:reset cssClass="upBrBtn" value="重置"/>  
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
					$(this).height((350*imgHeight)/imgWidth);
					$(this).width(350);
					});
		   	 	</script> 
  		</s:form>  
    </div>
  </body>
</html>

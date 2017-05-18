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
    <span class="frameH3">品牌申请</span>
    <div>
    	<s:form action="updateBrandAuth" method="POST">  
 			<s:hidden name="brandAD.brId" />  
	  		<table class="upBrtable" border="1">
	  			<tr><td><label>中文名称:</label></td><td class="upBrFont"><s:label name="brandAD.brName" label="中文名称" /></td>
	  			</tr> 
	  			<tr><td><label>英文名称:</label></td>
			   		<td class="upBrFont"><s:label name="brandAD.brEngName" label="英文名称" /></td>
			   	</tr>  
			   	<tr><td colspan="2"><label>简介:</label></td></tr>
			   	<tr>
			   		<td class="upBrFont" colspan="2"><s:label id="upBrText" name="brandAD.brDiscription" label="简介"/></td>
			   	</tr> 
			   	<tr><td><label>申请时间:</label></td><td><s:date name="brandAD.brApplyTime" format="yyyy-MM-dd HH:mm:ss" nice="false" /></td>
			   	</tr>  
			   	<tr><td><label>申请店铺ID:</label></td>
			   		<td>
			   			<s:if test="brandAD.stId==0">
			   				自营
			   			</s:if> 
			   			<s:else>
			   				<a href='<s:url action="viStoreAction"><s:param  name="stId" value="brandAD.stId" /></s:url>'><s:property value="brandAD.stId" /></a>
			   			</s:else>
			   		</td>
			   	</tr> 
			   	<tr><td><label>状态:</label></td>
			   		<td><s:radio name="brandAD.brState" list="#{'停售':0,'正常':1,'促销':2,'开通中':3,'未通过':4}" label="状态" listKey="value" listValue="key"/></td>
			   	</tr>  
			   	<tr>
			   		<td align="center" colspan="2">
				   		<s:submit cssClass="upBrBtn" value="提交" />  
						<s:reset cssClass="upBrBtn" value="重置"/>  
				    </td>
				</tr>
			</table>  
  		</s:form> 
  		 <h3 style="padding:10px 20px;">相似已通过审核品牌</h3>
  		 <s:if test="listBrands==null">
  		 	<h5 style="padding: 0 30px;color: red;">没有相似的已通过品牌</h5>
  		 </s:if>
  		 <s:else>
  		 	<s:iterator value="listBrands">
  		 		<table class="upBrtable" border="1">
		  			<tr><td><label>中文名称:</label></td><td class="upBrFont"><s:label name="brName" label="中文名称" /></td>
		  			</tr> 
		  			<tr><td><label>英文名称:</label></td>
				   		<td class="upBrFont"><s:label name="brEngName" label="英文名称" /></td>
				   	</tr>  
				   	<tr><td colspan="2"><label>简介:</label></td></tr>
				   	<tr>
				   		<td class="upBrFont" colspan="2"><s:label id="upBrText" name="brDiscription" label="简介"/></td>
				   	</tr> 
				   	<tr><td><label>申请时间:</label></td><td><s:date name="brApplyTime" format="yyyy-MM-dd HH:mm:ss" nice="false" /></td>
				   	</tr>  
				   	<tr><td><label>入驻时间:</label></td><td><s:date name="brEnterTime" format="yyyy-MM-dd HH:mm:ss" nice="false" /></td>
				   	</tr>
				   	<tr><td><label>申请店铺ID:</label></td>
				   		<td>
				   			<s:if test="brandAD.stId==0">
				   				自营
				   			</s:if> 
				   			<s:else>
				   				<a href='<s:url action="viStoreAction"><s:param  name="stId" value="brandAD.stId" /></s:url>'><s:property value="brandAD.stId" /></a>
				   			</s:else>
				   		</td>
				   	</tr> 
				   	<tr><td><label>状态:</label></td>
				   		<td>
				   			<s:if test="brState==0">停售</s:if>
				   			<s:elseif test="brState==1">正常</s:elseif>
				   			<s:elseif test="brState==2">促销</s:elseif>
				   			<s:elseif test="brState==3">开通中</s:elseif>
				   			<s:elseif test="brState==4">未通过</s:elseif>
				   		</td>
				   	</tr>
				 </table>
  		 	</s:iterator>
  		 </s:else>
    </div>
  </body>
</html>

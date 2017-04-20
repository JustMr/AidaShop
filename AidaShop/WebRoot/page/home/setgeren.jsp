<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<link rel="stylesheet" type="text/css" href="css/style-pinpaiguanli.css">

  </head>
  
  <body>
    <span class="frameH3">基本信息</span>
    <div class="messageCenter">${messageCenter }</div>
    <div>
    	<s:form action="upCustomerAction" method="POST">  
 			<s:hidden name="viCust.UId" />  
	  		<table id="upBrtable">
	  			<tr>
	  				<td width="15%" align="right"><label>用户名:</label></td>
	  				<td class="upBrFont" align="left"><s:textfield  name="viCust.UName" label="用户名" /></td>
	  			</tr> 
	  			<tr>
	  				<td width="15%" align="right"><label>昵称:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield  name="viCust.UNickName" label="昵称" /></td>
			   	</tr>  
			   	<tr>
			   		<td width="15%" align="right"><label>真实姓名:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield  name="viCust.URelaname" label="真实姓名" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>性别:</label></td>
			   		<td class="upBrFont" align="left">
			   			<s:radio list="#{'男':'男','女':'女'}" listKey="key" listValue="value" name="viCust.USex"></s:radio>
			   		</td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>生日:</label></td>
			   		<td class="upBrFont" align="left">
			   			<sx:datetimepicker name="viCust.UBirthday" displayFormat="yyyy-MM-dd"></sx:datetimepicker>
			   		</td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>住址:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield  name="viCust.UAddress" label="住址" /></td>
			   	</tr> 
			   		<tr>
			   		<td width="15%" align="right"><label>身份证:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield name="viCust.UCardId" label="身份证" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>电子邮箱:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield  name="viCust.UEmail" label="电子邮箱" /></td>
			   	</tr> 
			   	<tr>
			   		<td width="15%" align="right"><label>手机:</label></td>
			   		<td class="upBrFont" align="left"><s:textfield  name="viCust.UMobile" label="手机" /></td>
			   	</tr> 
			   	<tr>
			   		<td align="center" colspan="2">
				   		<s:submit cssClass="upBrBtn" value="提交" />  
						<s:reset cssClass="upBrBtn" value="重置"/>  
				    </td>
				</tr>
			</table>  
  		</s:form>  
    </div>
  </body>
</html>

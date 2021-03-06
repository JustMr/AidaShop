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
    <sx:head />
    
	<link rel="stylesheet" type="text/css" href="css/style-pinpaiguanli.css">
	<link rel="stylesheet" type="text/css" href="css/style-grzx.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/grzx.js"></script>

  </head>
  
  <body>
  	<div class="setBar">
	  	<span class="frameH3 spanHover">基本信息</span>
	    <span class="frameH3">修改密码</span>
		<div style="clear:both;"></div>
  	</div>
    <div id="base_info">
    	<div class="messageCenter">${messageCenter }</div>
    	<s:form action="upCustomerAction" method="POST">  
 			<s:hidden name="viCust.UId" />  
	  		<table class="upBrtable">
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
			   		<td align="left" colspan="2" style="padding-left: 80px;">
				   		<s:submit cssClass="upBrBtn" cssStyle="margin-left:5%;" value="提交" />  
						<s:reset cssClass="upBrBtn" cssStyle="margin-left:5%;" value="重置"/>  
				    </td>
				</tr>
			</table> 
  		</s:form>  
    </div>
    <div id="setPwd">
    	<div id="msgPwd" class="messageCenter"></div>
   		<table class="upBrtable">
   			<tr><td width="15%" align="right"><label>旧密码:</label><input id="uidHide" type="hidden" value='<s:property value="viCust.UId" />' /> </td>
		   		<td class="upBrFont" align="left"><input type="password" name="oldPwd" id="oldPwd" /></td>
		   	</tr> 
   			<tr><td width="15%" align="right"><label>新密码:</label></td>
		   		<td class="upBrFont" align="left"><input type="password" name="newPwd" id="newPwd" /></td>
		   	</tr> 
   			<tr><td width="15%" align="right"><label>确认密码:</label></td>
		   		<td class="upBrFont" align="left"><input type="password" name="newPwd1" id="newPwd1" /></td>
		   	</tr> 
   			<tr><td align="left" colspan="2" style="padding-left: 40px;">
		   		<input id="subPwd" class="upBrBtn" type="button" style="margin-left:15%;" value="提交"/>
			</tr>
   		</table>
    </div>
    <div id="only_info">
		<div>
			<span>用户名：</span>
			<s:label name="viCust.UName"></s:label>
		</div>	
		<div>
			<span>会员类型：</span>
			<s:if test="viCust.UState==0">普通会员</s:if>
		  	<s:elseif test="viCust.UState==2">VIP1</s:elseif>
		  	<s:elseif test="viCust.UState==1">已被禁用</s:elseif>
		  	<s:elseif test="viCust.UState==3">VIP2</s:elseif>
		  	<s:elseif test="viCust.UState==4">VIP3</s:elseif>
		  	<s:else>激活中</s:else>
		</div>	
	</div> 
  </body>
</html>

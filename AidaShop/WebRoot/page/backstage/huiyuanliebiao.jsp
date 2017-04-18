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
	<link rel="stylesheet" type="text/css" href="css/style-huiyuanguanli.css">
	<link rel="stylesheet" type="text/css" href="css/button/buttons.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/js-huiyuanguanli.js"></script>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	//全选
	function selectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "UIds") {
				x.elements[i].checked = true;
			}
		}
	}
	//取消全选
	function unselectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "UIds") {
				if (x.elements[i].checked == true)
					x.elements[i].checked = false;
			}
		}
	}
	</script>
  </head>
  
  <body>
  	<table class="headTab bg-1" width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
		<tr> 
			<td width="15%">
				<span class="newfont07">选择：
					<a href="javascript:void(0);" class="right-font08" onclick="selectAll();">全选</a> -
					<a href="javascript:void(0);" class="right-font08" onclick="unselectAll();">取消全选</a>
				</span> 
			</td>
			<td>
				<button name="Submit" class="button button--winona button--border-thin button--round-s" data-text="删除所选事项"><span>禁用所选用户</span></button>
				<button id="addBtn" name="Submit2" class="button button--winona button--border-thin button--round-s" data-text="添加"><span>添加</span></button>
			</td>
		</tr>  	
  	</table>
  	<form  id="myForm">
	    <table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>选择</th>  
			  <th>所属ID</th>  
			  <th>昵称</th>  
			  <th>真实姓名</th>  
			  <th>性别</th>  
			  <th>造型师认证</th>  
			  <th>权限</th>
			  <th>状态(VIP)</th>
			  <th>操作</th>
			 </tr>  
			</thead>  
			<tbody>  
			 <s:iterator value="listCuses">  
			 <tr class="bhover">  
			  <td>
			  		<input id="UId" type="checkbox" name="UIds" value='<s:property value="UId" />' />
			  </td>  
			  <td><a href='<s:url action="viCustomerAction"><s:param  name="UId" value="UId" /></s:url>'><s:property value="UId" /></a></td>  
			  <td id="UNickName" class="introBh"><s:property value="UNickName" /></td>  
			  <td id="URelaname" class="introBh"><s:property value="URelaname" /></td>  
			  <td id="USex" class="introBh"><s:property value="USex" /></td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="UStylingDesigner==2">国家认证</s:if>
				  	<s:elseif test="UStylingDesigner==1">平台认证</s:elseif>
				  	<s:elseif test="UStylingDesigner==3">国家认证审核中</s:elseif>
				  	<s:elseif test="UStylingDesigner==4">平台认证审核中</s:elseif>
				  	<s:else>非认证</s:else>
			  	</div>
			  	<div class="chage">
			  		<s:select id='UStylingDesigner' name="UStylingDesSelect" list="#{'非认证':0,'平台认证':1,'国家认证':2,'国家认证审核中':3,'平台认证审核中':4}"  listKey="value" listValue="key" value="UStylingDesigner"></s:select>
			  	</div>
			  </td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="UAdmin==2">超级管理员</s:if>
				  	<s:elseif test="UAdmin==1">店铺管理员</s:elseif>
				  	<s:else>普通</s:else>
			  	</div>
			  	<div class="chage">
			  		<s:select id='UAdmin' name="UAdminSelect" list="#{'普通':0,'店铺管理员':1,'超级管理员':2}"  listKey="value" listValue="key" value="UAdmin"></s:select>
			  	</div>
			  </td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="UState==0">正常</s:if>
				  	<s:elseif test="UState==2">VIP1</s:elseif>
				  	<s:elseif test="UState==1">禁用</s:elseif>
				  	<s:elseif test="UState==3">VIP2</s:elseif>
				  	<s:elseif test="UState==4">VIP3</s:elseif>
				  	<s:else>激活中</s:else>
			  	</div>
			  	<div class="chage">
			  		<s:select id="UState" name="UStateSelect" list="#{'正常':0,'禁用':1,'VIP1':2,'VIP2':3,'VIP3':4,'激活中':5}"  listKey="value" listValue="key" value="UState" ></s:select>
			  	</div>
			  </td> 
			  <td>  
			   <div class="nochage"><a class="listEdit" title="编辑" href="javascript:void(0);"></a></div>
			   <div class="chage">
			   		<a class="subEdit" title="提交" href="javascript:void(0);"></a>
			   		<a class="cancelEdit" title="取消" href="javascript:void(0);"></a>
			   	</div>
			  </td> 
			 </tr>  
			</s:iterator>  
		 	</tbody>  
		</table>
	</form>
	<table class="footTab" width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
		<tr>
			<td width="50%">第 
				<span id="cpage" class="right-text09">1</span> 页 | 共
				<span id="page" class="right-text09">1</span> 页
			</td>
			<td width="49%" align="right">[
				<a id="firstpage" href="javascript:void(0);" class="right-font08">首页</a>|
				<a id="lastpage" href="javascript:void(0);" class="right-font08">上一页</a>|
				<a id="nextpage" href="javascript:void(0);" class="right-font08">下一页</a>|
				<a id="endpage" href="javascript:void(0);" class="right-font08">末页</a>] 转至：
			</td>
			<td width="1%">
				<table width="20" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="1%">
							<input id="curPage" name="textfield3" type="text" class="right-textfield03" size="1" />
						</td>
						<td width="87%">
							<input id="npage" name="Submit23222" type="button" class="right-button06" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table> 
  </body>
</html>

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
	<link rel="stylesheet" type="text/css" href="css/button/buttons.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/dpsq.js"></script>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	//全选
	function selectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "stIds") {
				x.elements[i].checked = true;
			}
		}
	}
	//取消全选
	function unselectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "stIds") {
				if (x.elements[i].checked == true)
					x.elements[i].checked = false;
			}
		}
	}
	</script>
  </head>
  
  <body style="height: auto;">
     <table class="headTab bg-1" width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
		<tr> 
			<td width="15%">
				<span class="newfont07">选择：
					<a href="javascript:void(0);" class="right-font08" onclick="selectAll();">全选</a> -
					<a href="javascript:void(0);" class="right-font08" onclick="unselectAll();">取消全选</a>
				</span> 
			</td>
			<td>
				<button name="Submit" class="button button--winona button--border-thin button--round-s" data-text="删除所选事项"><span>禁用所选店铺</span></button>
			</td>
		</tr>  	
  	</table>
  	<form  id="myForm">
	    <table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th>选择</th>  
			  <th>所属ID</th>  
			  <th>申请人ID</th>  
			  <th>店铺名称</th>  
			  <th>店铺标签</th>  
			  <th>状态</th>
			  <th>操作</th>
			 </tr>  
			</thead>  
			<tbody>  
			 <s:iterator value="storeAuths">  
			 <tr class="bhover">  
			  <td>
			  		<input id="saId" type="checkbox" name="saId" value='<s:property value="saId" />' />
			  </td>  
			  <td><a href='<s:url action="viAllStoreAuthAction"><s:param  name="saId" value="saId" /></s:url>'><s:property value="saId" /></a></td>  
			  <td id="UId" class="introBh"><s:property value="UId" /></td>  
			  <td id="saName" class="introBh"><s:property value="saName" /></td>  
			  <td id="saTag" class="introBh"><s:property value="saTag" /></td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="saStatu==0">未通过</s:if>
				  	<s:elseif test="saStatu==1">申请中</s:elseif>
				  	<s:elseif test="saStatu==2">已通过</s:elseif>
			  	</div>
			  	<div class="chage">
			  		<s:select id="saStatu" name="saStatu" list="#{'未通过':0,'申请中':1,'已通过':2}"  listKey="value" listValue="key" value="saStatu" ></s:select>
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

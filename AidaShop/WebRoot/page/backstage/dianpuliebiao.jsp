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
	<script type="text/javascript" src="js/js-dianpuguanli.js"></script>
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
			  <th>店铺名称</th>  
			  <th>店铺标签</th>  
			  <th>好评率</th>  
			  <th>服务态度</th>  
			  <th>服务质量</th>  
			  <th>发货速度</th>
			  <th>星级</th>
			  <th>状态</th>
			  <th>操作</th>
			 </tr>  
			</thead>  
			<tbody>  
			 <s:iterator value="stores">  
			 <tr class="bhover">  
			  <td>
			  		<input id="stId" type="checkbox" name="stIds" value='<s:property value="stId" />' />
			  </td>  
			  <td><a href='<s:url action="viStoreAction"><s:param  name="stId" value="stId" /></s:url>'><s:property value="stId" /></a></td>  
			  <td id="stName" class="introBh"><s:property value="stName" /></td>  
			  <td id="stTag" class="introBh"><s:property value="stTag" /></td>  
			  <td id="stFavorablerate" class="introBh"><s:property value="stFavorablerate" /></td>  
			  <td id="stServiceManner" class="introBh"><s:property value="stServiceManner" /></td>  
			  <td id="stServiceQuality" class="introBh"><s:property value="stServiceQuality" /></td>  
			  <td id="stSpeed" class="introBh"><s:property value="stSpeed" /></td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="stLevel==0">0星</s:if>
				  	<s:elseif test="stLevel==1">1星</s:elseif>
				  	<s:elseif test="stLevel==2">2星</s:elseif>
				  	<s:elseif test="stLevel==3">3星</s:elseif>
				  	<s:elseif test="stLevel==4">4星</s:elseif>
				  	<s:elseif test="stLevel==5">5星</s:elseif>
			  	</div>
			  	<div class="chage">
			  		<s:select id="stLevel" name="stLevel" list="#{'0星':0,'1星':1,'2星':2,'3星':3,'4星':4,'5星':5}"  listKey="value" listValue="key" value="stLevel" ></s:select>
			  	</div>
			  </td> 
			  <td>
			  	<div class="nochage">
			  		<s:if test="stState==0">正常</s:if>
				  	<s:elseif test="stState==1">禁用</s:elseif>
				  	<s:elseif test="stState==2">推广中</s:elseif>
				  	<s:elseif test="stState==3">问题店铺</s:elseif>
				  	<s:else>开通中</s:else>
			  	</div>
			  	<div class="chage">
			  		<s:select id="stState" name="stState" list="#{'正常':0,'禁用':1,'推广中':2,'问题店铺':3}"  listKey="value" listValue="key" value="stState" ></s:select>
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

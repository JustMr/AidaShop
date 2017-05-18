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
	<script type="text/javascript" src="js/editsub.js"></script>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
	//全选
	function selectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "brIds") {
				x.elements[i].checked = true;
			}
		}
	}
	//取消全选
	function unselectAll() {
		var x = document.getElementById("myForm");
		for ( var i = 0; i < x.length; i++) {
			if (x.elements[i].name == "brIds") {
				if (x.elements[i].checked == true)
					x.elements[i].checked = false;
			}
		}
	}
	</script>
    <style type="text/css">
	    #brandListTAb {
		    text-align: center;
		    width: 100%;
		    table-layout: fixed;
		}
    	#brandListTAb tr td {
		    border-top: 1px solid #fff;
		    height: 28px;
		    overflow: hidden;
		    text-overflow: ellipsis;
		    white-space: nowrap;
		    padding: 10px;
		    font-size: 14px;
		}
    </style>
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
				<button name="Submit" class="button button--winona button--border-thin button--round-s" data-text="停售所选品牌"><span>停售所选品牌</span></button>
				<button id="addBrBtn" name="Submit2" class="button button--winona button--border-thin button--round-s" data-text="添加"><span>添加</span></button>
			</td>
		</tr>  	
  	</table>
  	<form  id="myForm">
	    <table id="brandListTAb" class="bordered">  
			<thead>  
			 <tr>  
			  <th width="5%">选择</th>  
			  <th width="5%">编号</th>  
			  <th width="10%">中文名称</th>  
			  <th width="10%">英文名称</th>  
			  <th width="30%">简介</th>  
			  <th width="10%">申请时间</th>  
			  <th width="10%">开通时间</th>
			  <th width="10%">状态</th>
			  <th width="10%">操作</th>
			 </tr>  
			</thead>  
			<tbody>  
			 <s:iterator value="listBrands">  
			 <tr class="bhover">  
			  <td>
			   <input id="brId" type="checkbox" name="brIds" value='<s:property value="brId" />' />  
			  </td>  
			  <td>  
			   <a href='<s:url action="viBrandAuth"><s:param  name="brId" value="brId" /></s:url>'><s:property value="brId" /></a>  
			  </td>  
			  <td class="introBh"><s:property value="brName" /></td>  
			  <td class="introBh"><s:property value="brEngName" /></td>  
			  <td class="introBh"><s:property value="brDiscription" /></td>  
			  <td><s:date name="brApplyTime"  format="yyyy-MM-dd hh:mm" nice="false" /></td>  
			  <td><s:date name="brEnterTime"  format="yyyy-MM-dd hh:mm" nice="false" /></td>  
			  <td>
			  	<div class="nochage">
			  		<s:if test="brState==0">停售</s:if>
				  	<s:elseif test="brState==1">正常</s:elseif>
				  	<s:elseif test="brState==2">促销</s:elseif>
				  	<s:elseif test="brState==3">开通中</s:elseif>
				  	<s:elseif test="brState==4">未通过</s:elseif>
			  	</div>
			  	<div class="chage">
			  		<s:select id="brState" name="brState" list="#{'停售':0,'正常':1,'促销':2,'开通中':3,'未通过':4}"  listKey="value" listValue="key" value="brState" ></s:select>
			  	</div>
			  </td> 
			  <td>  
			   <div class="nochage"><a class="listEdit" title="编辑" href="javascript:void(0);"></a></div>
			   <div class="chage">
			   		<a class="subEdit subEditBrand" title="提交" href="javascript:void(0);" style="margin-left: 10px;"></a>
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

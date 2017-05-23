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
    <link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/input/input.css">
	<link rel="stylesheet" type="text/css" href="css/css-table1.css">
	<link rel="stylesheet" type="text/css" href="css/button/buttons.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/page.js"></script>
	<script type="text/javascript">
		//全选
		function selectAll() {
			var x = document.getElementById("myForm");
			for ( var i = 0; i < x.length; i++) {
				if (x.elements[i].name == "PIds") {
					x.elements[i].checked = true;
				}
			}
		}
		//取消全选
		function unselectAll() {
			var x = document.getElementById("myForm");
			for ( var i = 0; i < x.length; i++) {
				if (x.elements[i].name == "PIds") {
					if (x.elements[i].checked == true)
						x.elements[i].checked = false;
				}
			}
		}
	</script>
  </head>
  
  <body>
  	<table class="headTab" width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
		<tr> 
			<td width="15%">
				<span class="newfont07">选择：
					<a href="javascript:void(0);" class="right-font08" onclick="selectAll()">全选</a> -
					<a href="javascript:void(0);" class="right-font08" onclick="unselectAll()">取消全选</a>
				</span> 
			</td>
			<td>
				<button name="Submit" class="button button--winona button--border-thin button--round-s" data-text="删除所选事项"><span>删除所选事项</span></button>
				<button id="addBtn" name="Submit2" class="button button--winona button--border-thin button--round-s" data-text="添加"><span>添加</span></button>	
			</td>
		</tr>  	
  	</table>
  	<form  id="myForm">
		 <table id="travel" class="simpleTable">
		    <thead>    
		        <tr>
		        	<th scope="col">选择</th>
		        	<th scope="col" width="50px">商品图片</th>
		            <th scope="col" width="20%">商品名称</th>
		            <th scope="col">商品标签</th>
		            <th scope="col" width="40%">商品描述</th>
		            <th scope="col" width="12%">上架时间</th>
		            <th scope="col">售价</th>
		            <th scope="col" width="48px">操作</th>
		        </tr>        
		    </thead>
		    <tbody>
		   	 	<s:iterator value="goods">
			    	<tr class="bhover">
			    		<td>
			    			<input type="checkbox" name="PIds" value='<s:property value="PId" />' />  
			    		</td>
			    		<td>
			    			<img class="imgShow" alt='<s:property value="PName"/>' src="">	
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

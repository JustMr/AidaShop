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
	<script type="text/javascript" src="js/page.js"></script>

  </head>
  
  <body>
    <table id="brandListTAb" class="bordered">  
		<thead>  
		 <tr>  
		  <th>标题</th>  
		  <th>内容</th>  
		  <th>作者</th>
		  <th>状态</th>
		  <th>操作</th>
		 </tr>  
		</thead>  
		<tbody>  
		 <s:iterator status="st" value="articles">  
		 <tr class="bhover">  
		  <td><a href='<s:url action="superviDesignerAction"><s:param  name="arId" value="arId" /></s:url>'><s:property value="arTitle" /></a></td>  
		  <td id="digest" class="introBh"><s:property value="digest" /></td>  
		  <td id="unames" class="introBh"><s:property value="#request.unames[#st.index]" /></td>  
		  <td>
		  	<s:if test="arState==0">
    			新发表
    		</s:if>
    		<s:elseif test="arState==1">
    			审阅后修改
    		</s:elseif>
    		<s:elseif test="arState==2">
    			已审阅
    		</s:elseif>
		  </td>
		  <td>  
		   <div><a class="listEdit" title="编辑" href='<s:url action="superviDesignerAction"><s:param  name="arId" value="arId" /></s:url>'></a></div>
		  </td> 
		 </tr>  
		</s:iterator>  
	 	</tbody>  
	</table>
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

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
	<style type="text/css">
		#viGoodtab td {
			white-space:normal;
		}
	</style>
  </head>
  
  <body>
  	<s:form action="superUpdateGoodAction" method="POST">
	  	<table id="viGoodtab" class="simpleTable">
			<caption>商品详情:</caption>
			<tr>
				<th scope="row" colspan="1">
					商品名称：
				</th>
				<td colspan="3">
					<s:hidden id="PId" name="good.PId" />
					<s:label id="PName" name="good.PName" cssStyle="width: 50%;" ></s:label>
				</td>
			</tr>
			<tr>
				<th scope="row">
					品牌：
				</th>
				<td>
					<s:label name="good.brandAD.brName" ></s:label>
				</td>
				<th scope="row">
					标签：
				</th>
				<td>
					<s:label name="good.adProductcategory.cgName"></s:label>
				</td>
			</tr>
			<tr>
				<th scope="row" colspan="4">
					商品描述
				</th>
			</tr>
			<tr>
				<td colspan="4">
					<s:label id="PDescription" name="good.PDescription"></s:label>
				</td>
			</tr>
			<tr>
				<th scope="row" style="vertical-align: top;" colspan="1">商品轮转展示图:</th>
				<td colspan="3">
					<s:iterator id="it" value="#request.lzpath" status="st">
						<img class="imgShow" src='<s:property value="#it"/>'>
					</s:iterator>
				 </td>
			</tr>
			<tr>
				<th scope="row" style="vertical-align: top;" colspan="1">商品详情展示图:</th>
				<td colspan="3">
					<s:iterator id="it" value="#request.xqpath">
						<img class="imgShow" src='<s:property value="#it"/>'>
					</s:iterator>
				 </td>
			</tr>
			<tr>
				<th scope="row">
					库存
				</th>
				<td>
					<s:label id="PCount" name="good.PCount" />
				</td>
				<th scope="row">
					进价
					<p></p>
				</th>
				<td>
					<label class="yuan">&yen;</label>
					<s:label id="PBaseprice" name="good.PBaseprice"></s:label> <label>(元)</label>
				</td>
			</tr>
			<tr>
				<th scope="row">
					市场价<p></p>
				</th>
				<td>
					<label class="yuan">&yen;</label>
					<s:label id="PMarketprice" name="good.PMarketprice"/> <label>(元)</label>
				</td>
				<th scope="row">
					售价<p></p>
				</th>
				<td>
					<label class="yuan">&yen;</label>
					<s:label id="PSellprice" name="good.PSellprice"/> <label>(元)</label>
				</td>
			</tr>
			<tr>
				<th scope="row">商品对应性别:</th>
				<td>
					<s:if test='good.PSexrequest=="male"'>男</s:if>
					<s:elseif test='good.PSexrequest=="female"'>女</s:elseif>
					<s:elseif test='good.PSexrequest=="both"'>全部</s:elseif>
				</td>
				<th scope="row">
					推荐等级
					<p></p>
				</th>
				<td>
					<s:if test='good.PCommend==0'>普通</s:if>
					<s:elseif test='PCommend==1'>一级</s:elseif>
					<s:elseif test='PCommend==2'>二级</s:elseif>
					<s:elseif test='PCommend==3'>三级</s:elseif>
				</td>
			</tr>
			<tr>
				<th scope="row">
					点击量
				</th>
				<td>
					<s:label id="PClickcount" name="good.PClickcount"></s:label>
				</td>
				<th scope="row">
					销售量
					<p></p>
				</th>
				<td>
					<s:label id="PSellCount" name="good.PSellCount" cssStyle="margin-left: 10px;"></s:label>
				</td>
			</tr>
			<tr>
				<th scope="row">
					上架时间
				</th>
				<td>
					<s:date name="good.PCreateTime" format="yyyy-MM-dd HH:mm:ss" nice="false" ></s:date>
				</td>
				<th scope="row">
					状态
				</th>
				<td>
					<s:if test="good.PState==0">
						<s:select name="good.PState" list="#{'未通过':0,'申请中':1,'通过':2}" listKey="value" listValue="key"></s:select>
					</s:if>
					<s:elseif test="good.PState==1">
						<s:select name="good.PState" list="#{'未通过':0,'申请中':1,'通过':2}" listKey="value" listValue="key"></s:select>
					</s:elseif>
					<s:elseif test="good.PState==2">
						<s:select name="good.PState" list="#{'普通':2,'停售':3}" listKey="value" listValue="key"></s:select>
					</s:elseif>
					<s:else>
						<s:select name="good.PState" list="#{'普通':2,'停售':3}" listKey="value" listValue="key"></s:select>
					</s:else>
				</td>
			</tr>
			<tr>
				<td colspan="1">
					所属店铺
				</td>
				<td colspan="3">
					<a href='<s:url action="viStoreAction"><s:param  name="stId" value="store.stId" /></s:url>'><s:property value="store.stName"/> </a>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<s:submit cssClass="upBrBtn" value="提交" /> 
					<s:reset cssClass="upBrBtn" value="重置" ></s:reset>
				</td>
			</tr>
		</table>
	</s:form>
  </body>
  <script type="text/javascript">
	$(".imgShow").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).height((120*imgHeight)/imgWidth);
	$(this).width(120);
	});
  </script> 
</html>

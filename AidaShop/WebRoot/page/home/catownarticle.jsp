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
	<link rel="stylesheet" type="text/css" href="css/style-dpcenter.css">
	<link rel="stylesheet" type="text/css" href="css/input/input.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/FastJson.js"></script>
	<script type="text/javascript" src="js/js-publish.js"></script>

  </head>
  
  <body>
    <div id="pubWarp" class="mainContent">
   		<div class="firstline">
   			<label class="firTil">标题:</label>
   			<s:hidden id="arId" name="article.arId"></s:hidden>
   			<s:textfield id="arTitle" name="article.arTitle" autocomplete="off"></s:textfield>
   			<a id="editpubtn" class="upBrBtn pubArcBtn" href="javascript:void(0);">修改</a>
   			<a id="deletebtn" class="upBrBtn pubArcBtn" href='deleteDesignerAction?arId=<s:property value="article.arId"/>'>删除文章</a>
   		</div>
   		<div class="mainBody">
   			<input id="arMain" name="arMain" type="hidden" value='<s:property value="article.arMain"/>' />
   			<iframe id="fulltext" name="fulltext" scrolling="no" src='page/reuse/fulltext.jsp?text=${article.arMain}'></iframe>
   		</div>
   		<div class="goodChoice choiceWarp">
   			<s:iterator status="st" value="article.good" id="g">
   				<div class='choiceItem'>
					<a class='searcha' data-id='<s:property value="#g.PId"/>' href='javascript:void(0);' onclick='wantGood();'>
						<div class='imgWarp'>
							<img class="goodList" alt='<s:property value="#g.PName"/>' src='<s:property value="article.path[#st.index]"/>'>
						</div>
						<div class="goodInfo">
							<label class='goodName'><s:property value="#g.PName"/></label>
							<label class='goodStore'><s:property value="#request.storName[#st.index]"/></label>
							<label class='yunLab'>&yen;</label>
							<label class='price'><s:property value="#g.PSellCount"/></label>
							<label class='yunChinese'>元</label>
						</div>
					</a>
				</div>
   			</s:iterator>
   		</div>
   		<div class="noChoice choiceWarp">
   			<h3>还没有任何商品，快去搜索添加吧!</h3>
   		</div>
   		<div class="secline">
   			<input id="PName" name="PName" placeholder="商品名称" />
   			<a id="seachBth" class="upBrBtn pubArcBtn" href="javascript:void(0);">搜索</a>
   			<a id="deleteBth" class="upBrBtn pubArcBtn" href="javascript:void(0);">删除所选</a>
   		</div>
   		<div class="searchResult choiceWarp">
   		</div>
   		<div class="noResult choiceWarp">
   			<h3>没有结果!</h3>
   		</div>
   		<div class="allResult choiceWarp">
   			<h3>已全被选中!</h3>
   		</div>
   	</div>
  </body>
  <script type="text/javascript">
  	var va = $("#arMain").val();
  	console.log(va);
  	/* $(window.frames["fulltext"].document).find("#ptext").attr("value",va); */
  	
  	var count = $(".choiceItem").length;
  	if (count>0) {
		$(".goodChoice").show();
		$(".noChoice").hide();
	}else {
		$(".goodChoice").hide();
		$(".noChoice").show();
	}
  </script>
</html>

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

	<style type="text/css">
		#arcdelBtu {display: inline-block;text-align: center;vertical-align: middle;line-height: 32px;}
		#arcdelBtu:HOVER {
			color: #fff;
		}
		#arc_detail_warp {width: 95%;}
		.icon_warp {
		    margin-left: 40%;
		}
	</style>
  </head>
  
  <body style="height: auto;">
  <s:form action="stateupdateDesignerAction" method="post">
    <div id="arc_detail_warp" class="mainContent">
    	<div class="arctilte">
    		<input id="arId" name="arId" value='<s:property value="article.arId"/>' type="hidden"/>
    		<s:property value="article.arTitle"/>
    	</div>
    	<div class="article">
    		<s:property value="article.arMain" escapeHtml="false"/>
    	</div>
    	<div class="arc_good">
    		<s:iterator status="st" value="article.good" id="g">
	    		<div class="arc_good_item" >
	    			<input type="hidden" name="Pids" value='<s:property value="#g.PId"/>'/>
	    			<a class="goodImg" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><img class="goodItem" alt='<s:property value="#g.PName"/>' src='<s:property value="article.path[#st.index]"/>'></a> 
		    		<a class="goodNameArc" href='page/detail/detail.jsp?PId=<s:property value="#g.PId" />'><s:property value="#g.PName"/> </a>
		    		<label class="yunLab">&yen;</label>
		    		<label class="goodPrice"><s:property value="#g.PSellprice"/> </label>
		    		<label class="yunChinese">元</label>
	    		</div>
	    	</s:iterator>
    	</div>
    	<div style="padding: 0 20px;">
    		<label>状态:</label>
    		<s:if test="article.arState==0">
    			新发表
    		</s:if>
    		<s:elseif test="article.arState==1">
    			审阅后修改
    		</s:elseif>
    		<s:elseif test="article.arState==2">
    			已审阅
    		</s:elseif>
    	</div>
    	<div style="padding: 0 20px;">
    		<label>作者:</label>
    		<a href='<s:url action="viCustomerAction"><s:param value="cust.UId" name="UId"></s:param></s:url>'><s:property value="cust.UNickName"/></a>
    	</div>
    	<div class="icon_warp">
    		<s:if test="article.arState==0">
    			<s:submit cssClass="upBrBtn" value="已审阅" />
    			<p>点击审阅按钮确认审阅通过</p>
    		</s:if>  
    		<s:elseif test="article.arState==1">
    			<s:submit cssClass="upBrBtn" value="已审阅" />
    			<p>点击审阅按钮确认审阅通过</p>
    		</s:elseif>
			<a id="arcdelBtu" class="upBrBtn" href='<s:url action="superdeleteDesignerAction"><s:param value="article.arId" name="arId"></s:param></s:url>'>删除</a>
    	</div>
    </div>
    </s:form>
  </body>
  <script type="text/javascript">
  	$(".goodItem").each(function(){
		//加载图片至内存，完成后执行
		//获得原始图片高宽
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		//重新设置img的width和height
		$(this).height((50*imgHeight)/imgWidth);
		$(this).width(50);
	});
	
	var count = $(".arc_good_item").length;
	if (count==0) {
		$("#shopAll").hide();
	}
  </script>
</html>

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
    <link rel="stylesheet" type="text/css" href="css/style-table.css">
    <link rel="stylesheet" type="text/css" href="css/input/input.css">
    <link rel="stylesheet" type="text/css" href="css/button/buttons.css">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/page.js"></script>
	<style type="text/css">
		.bhover {
			border: 1px solid #e5e5e5;padding: 10px;margin: 2px 0;
		}
		.own_arc_tit {
			margin-bottom: 10px;
		}
		.own_arc_main {
			max-height: 40px;overflow: hidden;text-overflow:ellipsis;
		}
		.nothing {display: none;width: 100%;height: 100%;}
		.nothing h3 {color: #ccc;text-align: center;padding-top: 20%;}
	</style>
  </head>
  
  <body>
    <div class="nothing">
    	<h3>还没有发表任何文章，赶紧去搭配中心发表吧!</h3>
    </div>
    <div class="havething">
	  	<s:iterator value="articles">
	  	<div class="bhover">
	  		<div class="own_arc_tit"><a href='<s:url action="viownarticleDesignerAction"><s:param name="arId" value="arId"></s:param></s:url>'><s:property value="arTitle"/></a> </div>
	  		<div class="own_arc_main"><s:property value="digest"/></div>
	  	</div>
	  	</s:iterator>
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
    </div>
  </body>
  <script type="text/javascript">
	var count = $(".bhover").length;
	if (count==0) {
		$(".nothing").show();
		$(".havething").hide();
	}
  </script>
</html>

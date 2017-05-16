<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/style-clear.css">
    <link rel="stylesheet" type="text/css" href="css/dhcd.css">
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/dhcd.js"></script>
	
  </head>
  
  <body>
    <div>
    	<!-- tips start -->
    	<div id="dhcdtips">
    		<p>1.商品分类级别最多三层</p>
    		<p>2.第一级菜单分类每行应避免存在过多 </p>
    		<p>3.以下商品分类显示的顺序即位在商品导航菜单显示的顺序</p>
    		<p>4.删除高级别的分类，其所包含的下级一直到低级的分类都会被删除</p>
    		<p>5.当第一级分类中非最后一行上移时，如果该行仅有一个分类，则必须先向该行移进分类确保该行非空</p>
    	</div>
    	<!-- tips end -->
    	<!-- main start -->
    	<div id="menuFrameWarp">
    		<!-- 三级分类显示框 -->
    		<div id="finstFrame" class="menuFrame">
    			<!-- button start -->
    			<div class="frameTit">
    				<span>一级商品分类</span>
    				<div class="contA">
    					<input id="hidePosition1" type="hidden"/>
    					<input id="hideState1" type="hidden"/>
	    				<a id="firstAdd" class="cateAdd" href="javascript:void(0);">添加</a>
	    				<a onclick="deleteSub(1);" href="javascript:void(0);">删除</a>
	    				<a onclick="renameSub(1);" href="javascript:void(0);">重命名</a>
	    				<a onclick="upwardSub(1);" href="javascript:void(0);">上移</a>
	    				<a onclick="downwardSub(1);" href="javascript:void(0);">下移</a>
	    			</div>
    			</div>
    			<!-- button end -->
    			<div id="menuFirst" class="menuWarp"></div>
    		</div>
    		<div class="menuFrame">
    			<!-- button start -->
    			<div class="frameTit">
    				<span>二级商品分类</span>
    				<div class="contA">
    					<input id="hidePosition2" type="hidden"/>
	    				<a id="secondAdd" class="cateAdd" href="javascript:void(0);">添加</a>
	    				<a onclick="deleteSub(2);" href="javascript:void(0);">删除</a>
	    				<a onclick="renameSub(2);" href="javascript:void(0);">重命名</a>
	    				<a onclick="upwardSub(2);" href="javascript:void(0);">上移</a>
	    				<a onclick="downwardSub(2);" href="javascript:void(0);">下移</a>
	    			</div>
    			</div>
    			<!-- button end -->
    			<div id="menuSecond" class="menuWarp"></div>
    		</div>
    		<div class="menuFrame">
    			<!-- button start -->
    			<div class="frameTit">
    				<span>三级商品分类</span>
    				<div class="contA">
    					<input id="hidePosition3" type="hidden"/>
	    				<a id="thirdAdd" class="cateAdd" href="javascript:void(0);">添加</a>
	    				<a onclick="deleteSub(3);" href="javascript:void(0);">删除</a>
	    				<a onclick="renameSub(3);" href="javascript:void(0);">重命名</a>
	    				<a onclick="upwardSub(3);" href="javascript:void(0);">上移</a>
	    				<a onclick="downwardSub(3);" href="javascript:void(0);">下移</a>
    				</div>
    			</div>
    			<!-- button end -->
    			<div id="menuThird" class="menuWarp"></div>
    		</div>
    		<div class="clear"></div>
    	</div>
    	<!-- main end -->
    </div>
  </body>
</html>

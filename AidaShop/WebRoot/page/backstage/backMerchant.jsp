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
    
    <title>商户中心_AidaShop</title>
    <s:head/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style-back-merchant.css"> 
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/js-back.merchant.js"></script>
  </head> 
  
  <body>
    <div class="back_mer_wrap">
    	<div class="list_wrap">
    		<div class="list_title">
    			<div class="span_name_con">
    				<span id="merchant_name">aidaL</span>
    				<span> 商户中心</span>
    			</div>
    		</div>
    		<div class="list_main">
    			<div id="list_main_tit">
    				<div id="head_portrait">
    					<img alt="" src="images/store/ChEi1lgpT3yAU019AAAfbkO0yGk13000.jpg">
    				</div>
    				<span id="mer_name">KOOL男装旗舰店</span>
    			</div>
    			<div class="mer_list_item">
    				<ul class="list_item_wrap">
    					<li id="list_home" class="list_item mer_list_selected"><em></em><span>店铺首页</span></li>
    					<li id="list_good" class="list_item"><em></em><span>商品管理</span></li>
    					<li id="list_brand" class="list_item"><em></em><span>品牌管理</span></li>
    					<li id="list_order" class="list_item"><em></em><span>订单管理</span></li>
    					<li id="list_comment" class="list_item"><em></em><span>评价管理</span></li>
    					<li id="list_ad" class="list_item"><em></em><span>广告管理</span></li>
    					<li id="list_fiance" class="list_item"><em></em><span>财务管理</span></li>
    					<li id="list_refund" class="list_item"><em></em><span>急速退款</span></li>
    					<li id="list_set" class="list_item"><em></em><span>店铺设置</span></li>
    				</ul>
    			</div>
    		</div>
    	</div>
    	<div class="mer_left_content">
    		<div class="mer_bar">
    			<div class="addGood">
    				<i></i>
    				<span>添加商品</span>
    			</div>
    			<ul id="mer_bar_ul">
    				<li id="bar_mes">
    					<i></i>
    					<span>系统消息</span>
    				</li>
    				<li id="bar_exit">
    					<a href="loginout">
    						<i></i>
    						<span>退出</span>
    					</a>
    				</li>
    			</ul>
    			<div class="clear"></div>
    		</div>
    		<div class="mer_left">
	    		<div class="home_show mer_left_wrap">
		    		  <div class="data_show">
		    			<div class="show_content">
		    				<div id="xiaoShouJinE" class="show_icon">
		    					<i></i>
		    				</div>
		    				<div class="show_main">
		    					<span class="show_word">累计销售金额</span>
		    					<span class="show_xiaoshoujine">¥</span>
		    					<span class="show_xiaoshoujine" class="show_number">215,100</span>
		    				</div>
		    			</div>
		    			<div class="show_content">
		    				<div id="LeiJiDingDan" class="show_icon">
		    					<i></i>
		    				</div>
		    				<div class="show_main">
		    					<span class="show_word">累计订单数</span>
		    					<span id="show_dindanshu" class="show_number">2,100</span>
		    				</div>
		    			</div>
		    			<div class="show_content">
		    				<div id="JiaoYiZhong" class="show_icon">
		    					<i></i>
		    				</div>
		    				<div class="show_main">
		    					<span class="show_word">交易中订单</span>
		    					<span id="show_xszdingdan" class="show_number">215</span>
		    				</div>
		    			</div>
		    			<div class="show_content">
		    				<div id="ChengGongXiangMu" class="show_icon">
		    					<i></i>
		    				</div>
		    				<div class="show_main">
		    					<span class="show_word">发布成功的项目</span>
		    					<span id="show_cgxiangmu" class="show_number">21</span>
		    				</div>
		    			</div>
		    			<div class="show_content">
		    				<div id="PingJunPingFen" class="show_icon">
		    					<i></i>
		    				</div>
		    				<div class="show_main">
		    					<span class="show_word">店铺平均评分</span>
		    					<span id="show_pjpinfen" class="show_number">4.9</span>
		    				</div>
		    			</div>
		    			<div class="clear"></div>
		    		</div>
		    		<div class="name_card" style="border:1px solid black; margin:10px 0;">
		    			<div class="card_data">
		    				<dl>
		    					<dt>店铺名称：</dt>
		    					<dd>KOOL男装旗舰店</dd>
		    					<dt>店铺到期时间：</dt>
		    					<dd>2019年10月1日</dd>
		    					<dt>店铺等级：</dt>
		    					<dd>普通店铺</dd>
		    					<dt>店铺名称：</dt>
		    					<dd>2016年1月1日 19时20分</dd>
		    				</dl>
		    			</div>
		    			<div class="shop_numData">
		    				<ul class="numData_name">
		    					<li>好评率</li>
		    					<li>服务态度</li>
		    					<li>服务质量</li>
		    					<li>速度</li>
		    				</ul>
		    				<ul class="numData_num">
		    					<li>100%</li>
		    					<li>5.0</li>
		    					<li>5.0</li>
		    					<li>5.0</li>
		    				</ul>
		    			</div>
		    		</div>
		    		<div class="newComment" style="border:1px solid black; margin:10px 0;">
		    			<a href="***">最新评论</a>
		    			<dl>
		    				<dt></dt>
		    				<dd></dd>
		    			</dl>
		    		</div>
		    		<div class="record_login" style="border:1px solid black; margin:10px 0;">
		    			<a href="***">登录记录</a>
		    			<ul>
		    				<li>时间</li>
		    				<li>IP地址</li>
		    				<li>地点</li>
		    			</ul>
		    		</div>
		    	</div>
		    	<div class="manage_good mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">商品管理</span>
		    			<div id="good_add" class="add_bar"><i></i><span>添加</span></div>
		    			
		    		</div>
		    	</div>
		    	<div class="manage_brand mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">品牌管理</span>
		    			<div id="brand_add" class="add_bar"><i></i><span>添加</span></div>
		    		</div>
		    	</div>
		    	<div class="manage_order mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">订单管理</span>
		    		</div>
		    	</div>
		    	<div class="manage_comment mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">评论管理</span>
		    		</div>
		    	</div>
		    	<div class="manage_ad mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">广告管理</span>
		    			<div id="advert_add" class="add_bar"><i></i><span>添加</span></div>
		    		</div>
		    	</div>
		    	<div class="manage_finance mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">财务管理</span>
		    		</div>
		    	</div>
		    	<div class="manage_refund mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">退款管理</span>
		    		</div>
		    	</div>
		    	<div class="manage_set mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">店铺设置</span>
		    			<div id="set_edit" class="edit_bar"><i></i><span>编辑</span></div>
		    		</div>
		    		
		    		<div class="manage_set_main">
		    			<dl id="manage_set_dl">
		    				<dt>店铺名称</dt>
		    				<dd id="storeName"></dd>
		    				<dt>店铺标签</dt>
		    				<dd id="storeTag"></dd>
		    				<dt>店铺创建日期</dt>
		    				<dd id="storeStart"></dd>
		    				<dt>店铺租期至</dt>
		    				<dd id="storeEnd"></dd>
		    			</dl>
		    			<dl id="manage_set_dlSet">
		    				<dt>店铺名称</dt>
		    				<dd>
		    					<input id="storeName_edit" type="text" >
		    				</dd>
		    				<dt>店铺标签</dt>
		    				<dd>tip:每个输入框内输入一种标签</dd>
		    				<dd>
		    					<div class="storeTagBox">
		    						<input class="storeTag_edit" type="text">
		    						<i></i>
		    					</div>
		    					<i id="addStoreTag"></i>
		    					<input id="countStoreTag" type="hidden" value="0">
		    				</dd>
		    				<dd><input id="setFinishBtn" type="button" value="完成"></dd>
		    			</dl>
		    			<input id="storeName_value" type="hidden"  value="">
		    			<input id="storeTag_value" type="hidden" value="">
		    			<input id="storeStart_value" type="hidden" value="">
		    			<input id="storeEnd_value" type="hidden" value="">
		    		</div>
		    		<div class="clear"></div>
		    	</div>
	    	</div>
    	</div>
    	<div class="clear"></div>
    </div>
  </body>
</html>

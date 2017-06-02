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
    <link rel="stylesheet" type="text/css" href="css/button/buttons.css">
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <style type="text/css">
    	.sh_add_warp {display: none;}
    	.sh_item_active {border: 1px solid #f5f5f5;}
    	.sh_list_line {padding: 5px 10px;width: 90%;}
    	#sh_cancel {display: inline-block;vertical-align: middle;text-align: center;line-height: 32px;}
    	#sh_cancel:HOVER {
			color: #fff;text-decoration: none;
		}
		.sh_item {border: 1px solid #ddd;margin: 3px auto;width: 95%;}
		.sh_item_active {border: 1px solid red;}
		#sh_default {color: red;}
		#setdefault {display: none;}
		.sh_title {height: 72px;line-height: 72px;}
    </style>

  </head>
  
  <body style="height: auto;">
    <div class="addresswarp">
    	<div class="sh_title">
    		<span>收货地址管理</span>
    		<button id="setdefault" class="upBrBtn" value="默认">默认</button>
    	</div>
    	<div class="sh_pic">
    		<button class="sh_add upBrBtn" value="添加">添加</button>
    	</div>
    	<s:form action="addAddressOrderAction" method="POST" onsubmit="return judValue();">
    		<div class="sh_add_warp">
    				<p class="sh_list_name sh_list_line">
    					<span class="sh_dt">收货人姓名：</span>
    					<span class="sh_dd"><s:textfield id="sh_name" name="shName" label="收货人姓名"></s:textfield> </span>
    				</p>
    				<p class="sh_list_phone sh_list_line">
    					<span class="sh_dt">收货人电话：</span>
    					<span class="sh_dd"><s:textfield id="sh_phone" name="shPhone" label="收货人电话"></s:textfield> </span>
    				</p> 
    				<p class="sh_list_shAddress sh_list_line">
    					<span class="sh_dt">收货人地址：</span>
    					<span class="sh_dd"><s:textarea id="sh_address" name="shAddress" label="收货人地址"></s:textarea> </span>
    				</p>
    				<p  class="sh_list_line">
    					<s:submit cssClass="upBrBtn" value="提交"></s:submit>
    					<a id="sh_cancel" class="upBrBtn" href="javascript:void(0);">取消</a>
    				</p>
    			</div>
    	</s:form>
    	<div class="sh_list">
    		<s:iterator value="adresses">
    			<div class="sh_item">
    				<s:hidden id="sh_id" name="shId"></s:hidden>
    				<p class="sh_list_name sh_list_line">
    					<span class="sh_dt">收货人姓名：</span>
    					<span class="sh_dd"><s:property value="shName"/></span>
    				</p>
    				<p class="sh_list_phone sh_list_line">
    					<span class="sh_dt">收货人电话：</span>
    					<span class="sh_dd"><s:property value="shPhone"/></span>
    				</p>
    				<p class="sh_list_shAddress sh_list_line">
    					<span class="sh_dt">收货人地址：</span>
    					<span class="sh_dd"><s:property value="shAddress"/></span>
    				</p>
    				<s:if test="shState==1">
    					<p id="sh_default" class="sh_list_line">已设为默认收货地址</p>
    				</s:if>
    			</div>
    		</s:iterator>
    	</div>
    </div>
  </body>
  <script type="text/javascript">
  	$(".sh_add").click(function() {
  		$(".sh_add_warp").show();
  		$(".sh_list").hide();
  		$(".sh_pic").hide();
  		$("#setdefault").hide();
  		$(".sh_item").removeClass("sh_item_active");
  	});
  	$("#sh_cancel").click(function() {
  		$(".sh_add_warp").hide();
  		$(".sh_list").show();
  		$(".sh_pic").show();
  	});
  	$(".sh_item").click(function() {
  		$(".sh_item").removeClass("sh_item_active");
  		$(this).addClass("sh_item_active");
  		$("#setdefault").show();
  	});
  	function judValue() {
  		var name = $("#sh_name").val().trim();
  		var phone = $("#sh_phone").val().trim();
  		var address = $("#sh_address").val().trim();
  		if (name==""||phone==""||address=="") {
			alert("请填写所有内容!");
			return false;
		}
  	}
  	$("#setdefault").click(function() {
  		var shId =$(".sh_item_active #sh_id").val().trim();
  		$.ajax({
  			url: "setdefaultOrderAction",
  			type: "POST",
  			data: {
  				shId: shId,
  			},
  			dataType: "json",
  			success: function(data) {
  				if (data.success==true) {
					location.reload();
				}else{
					alert("something wrong!");
				}
  			},
  			error: function() {
  				alert("something wrong!");
  			}
  		});
  	});
  </script>
</html>

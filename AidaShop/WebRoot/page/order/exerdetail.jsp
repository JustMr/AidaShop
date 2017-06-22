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
    <style type="text/css">
    	#viexertab {width: 100%;}
    	#viexertab td{border-left: 1px solid #666;border-top: 1px solid #666;padding: 3px;}
    	#viexertab tr:last-child td {border-bottom: 1px solid #666;}
    	#viexertab tr td:last-child {border-right: 1px solid #666;}
    	.upBrBtn { width:66px;height:32px;background: #fd6d37;color:#fff;border-radius:5px;border:none;outline: none;cursor: pointer;margin: 20px;display: block;
    	line-height: 32px;text-align: center;text-decoration: none;}
		.upBrBtn:hover { -webkit-filter:brightness(.9); color: #fff;text-decoration: none;}
		#erFeedbackinput {width: 60%;}
    </style>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#exersub").click(function() {
			var erId = $("#erIdinput").val();
			var erState = $("input[name='erState']:checked").val();
			var erFeedback = $("#erFeedbackinput").val().trim();
			console.log(erId);
			console.log(erState);
			console.log(erFeedback);
			$.ajax({
				url: "updatexerOrderAction",
				type: "post",
				dataType: "json",
				data: {
					erId: erId,
					erState: erState,
					erFeedback: erFeedback,
				},
				success: function(data){
					if (data.success==true) {
						$(".subtip").empty();
						$(".subtip").append("修改成功!");
					}else {
						$(".subtip").empty();
						$(".subtip").append("修改失败");
					}
				},
				error: function(){
					alert("something wrong!");
				}
			});
		});		
	});
	</script>
  </head>
  
  <body>
    <table id="viexertab" cellspacing="0" >
    	<tr>
    		<td style="width: 10%">商品:</td>
    		<td>
    			<img class="shoppicture" alt='<s:property value="good.PName" />' src='<s:property value="#request.path" />'>
    			<s:property value="good.PName"/>
    			<s:hidden id="erIdinput" name="exre.erId"></s:hidden>
    		</td>
    	</tr>
    	<tr>
    		<td>单价:</td>
    		<td><s:property value="good.PSellprice"/></td>
    	</tr>
    	<tr>
    		<td>数量:</td>
    		<td><s:property value="exre.erAmount"/></td>
    	</tr>
    	<tr>
    		<td>申请:</td>
    		<td>
    			<s:if test='exre.erAuth=="refund"'>退货</s:if>
		  		<s:else>换货</s:else>
    		</td>
    	</tr>
    	<tr>
    		<td>申请:</td>
    		<td>
    			<s:if test='exre.erAuth=="refund"'>退货</s:if>
		  		<s:else>换货</s:else>
    		</td>
    	</tr>
    	<tr>
    		<td>理由:</td>
    		<td>
    			<s:property value="exre.erReason"/>
    		</td>
    	</tr>
    	<tr>
    		<td>处理:</td>
    		<td>
    			<s:radio name="erState" list="#{'拒绝':1,'通过':2}" listKey="value" listValue="key" value="exre.erState"></s:radio>
    		</td>
    	</tr>
    	<tr>
    		<td>反馈:</td>
    		<td>
    			<s:textfield id="erFeedbackinput" cssClass="erFeedback" name="erFeedback"></s:textfield>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">
    			<a id="exersub" class="upBrBtn" href="javascript:void(0);">提交</a><label class="subtip"></label>
    		</td>
    	</tr>
    </table>
  </body>
  <script type="text/javascript">
	$(".shoppicture").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).height((70*imgHeight)/imgWidth);
	$(this).width(70);
	});
  </script> 
</html>

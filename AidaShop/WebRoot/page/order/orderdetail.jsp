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
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="js/FastJson.js"></script>
	<style type="text/css">
		.pubwrap {width: 1200px;margin: 20px auto;}
		table {
			width:60%;
			border: none;
			border-spacing: 0px;
		}
		table td {
			 padding: 3px 5px;text-align: left;border: 1px solid;
		}
		#paybtn {
			display: block;background: #872222;width: 120px;height: 36px;
		line-height: 36px;text-align: center;color: #fff;font-size: 18px;font-weight: 500;
			margin-left: 20px;
		}
		#paybtn:HOVER {
			text-decoration: none;
		}
		html {width: auto;}
		.editauth,.exauth {display: block;margin: 3px auto;text-align: center;}
		.back {height:100%;width:100%;display:none;z-index:100;position:absolute;background-color:gray;filter:alpha(opacity=50); top:0px;left:0px;"
			/* older safari/Chrome browsers */  
		    -webkit-opacity: 0.5;  
		    /* Netscape and Older than Firefox 0.9 */  
		    -moz-opacity: 0.5;  
		    /* Safari 1.x (pre WebKit!) 老式khtml内核的Safari浏览器*/  
		    -khtml-opacity: 0.5;  
		    /* IE9 + etc...modern browsers */  
		    opacity: .5;  
		}
		.edithide {
			position: fixed;
			padding: 0 10px 20px;
			top: 50%;
			left: 50%;
			width: 30%;
			max-width: 630px;
			min-width: 320px;
			height: auto;
			z-index: 2000;
			visibility: hidden;
			-webkit-backface-visibility: hidden;
			-moz-backface-visibility: hidden;
			backface-visibility: hidden;
			-webkit-transform: translateX(-50%) translateY(-50%);
			-moz-transform: translateX(-50%) translateY(-50%);
			-ms-transform: translateX(-50%) translateY(-50%);
			transform: translateX(-50%) translateY(-50%);
			-webkit-perspective: 1300px;
			-moz-perspective: 1300px;
			perspective: 1300px;
			background: #fff;border: 1px solid #d6d6d6;border-radius: 5px;
		}
		.shadowShow {-webkit-backface-visibility: visible;
		-moz-backface-visibility: visible;
		backface-visibility: visible;
		opacity: 1;visibility: visible;}
		.shadowShow .goodinfo {
			-webkit-transform: rotateY(0deg);
			-moz-transform: rotateY(0deg);
			-ms-transform: rotateY(0deg);
			transform: rotateY(0deg);
			opacity: 1;
		}
		.closeIcon {display: block;width:18px;height:18px;
			background: url("./images/guanbi.png");background-size: 18px 18px;position: absolute; top: 8px;right: -3px;cursor: pointer;}
		.goodinfo {
			-webkit-transform-style: preserve-3d;
			-moz-transform-style: preserve-3d;
			transform-style: preserve-3d;
			-webkit-transform: rotateY(-70deg);
			-moz-transform: rotateY(-70deg);
			-ms-transform: rotateY(-70deg);
			transform: rotateY(-70deg);
			-webkit-transition: all 0.3s;
			-moz-transition: all 0.3s;
			transition: all 0.3s;
			opacity: 0;
		}
		.titedit {width: 90%; margin: 0 auto;border-bottom: 1px solid #d6d6d6;}
		.titedit h2 {padding: 10px 0;}
		.wrapedit {width: 90%; margin: 10px auto;}
		.upBrBtn { display: block;width:66px;height:32px;line-height:32px;
		background: #fd6d37;color:#fff;border-radius:5px;border:none;outline: none;cursor: pointer;margin: 20px auto;text-align: center;}
		.upBrBtn:hover { -webkit-filter:brightness(.9);text-decoration: none;color: #fff; }
		.reasontext {margin: 10px 0 0 0;}
		.reason,.exreason {margin-left: 3px;vertical-align: middle;margin-right: 3px;}
		.radiocount {margin-left: 10px;vertical-align: middle;margin-right: 3px;}
		#retip,#extip {display: block;text-align: center;}
	</style>
  </head>
  
  <body style="width: auto;height: auto;">
     <div class="pubwrap">
    	<table>
    		<tr>
    			<td width="10%;">状态：</td>
    			<td>
    				<s:if test='order.coOrderState=="nonpay"'>待付款</s:if>
			  		<s:elseif test='order.coOrderState=="paid"'>待收货</s:elseif>
			  		<s:elseif test='order.coOrderState=="finished"'>已完成</s:elseif>
			  	</td>
    		</tr>
    		<tr>
    			<td width="10%;">订单号：</td>
    			<td><s:property value="order.coName"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">收货地址</td>
    		</tr>
			<tr>
				<td>姓名：</td>
				<td><s:property value="address.shName"/> </td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:property value="address.shPhone"/></td>
			</tr>
			<tr>
				<td>电话：</td>
				<td><s:property value="address.shPhone"/></td>
			</tr>
			<tr>
				<td colspan="2">商品列表</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%">
						<tr>
							<td colspan="2">商品</td>
		    				<td style="min-width: 30px;text-align: center;">售价</td>
		    				<td style="min-width: 30px;text-align: center;">数量</td>
							<td style="min-width: 30px;text-align: center;">小计</td>
							<td style="min-width: 60px;text-align: center;">操作</td>
						</tr>
						<s:iterator status="st" value="order.orderitems" id="it">
						<tr>
							<td><img class="shoppicture" alt='<s:property value="#it.adProductInfo.PName" />' src='<s:property value="#request.pathList[#st.index]" />'> </td>
		    				<td class="pnametd" style="text-align: center;"><s:property value="#it.adProductInfo.PName" /></td>
		    				<td style="text-align: center;">&yen;<label class="psellpricetd"><s:property value="#it.adProductInfo.PSellprice" /></label></td>
		    				<td class="amounttd" style="text-align: center;"><s:property value="#it.OAmount" /></td>
							<td class="litcount" style="text-align: center;">&yen;<s:property value="#request.pricelist[#st.index]" /></td>
							<td>
								<a class="editauth" data-id='<s:property value="#it.OId" />' href="javascript:void(0);">退货申请</a>
								<a class="exauth" data-id='<s:property value="#it.OId" />' href="javascript:void(0);">换货申请</a>
							</td>
						</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr>
				<td>总价：</td>
				<td>&yen;<s:property value="order.coTotalPrice"/></td>
			</tr>
			<tr>
				<td>运费：</td>
				<td>&yen;<s:property value="order.coFreightCharge"/></td>
			</tr>
			<tr>
				<td>折扣：</td>
				<td>&yen;<s:property value="order.coDiscountPrice"/></td>
			</tr>
			<tr>
				<td>实付：</td>
				<td>&yen;<s:property value="order.coRealPrice"/></td>
			</tr>
    	</table>
    </div>
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
	<div class="back"></div>
  	<div class="regood edithide">
  		<div class="goodinfo">
	  		<div class="titedit">
	  			<h2>退货申请</h2>
	  			<i class="closeIcon"></i>
	  		</div>
	  		<div class="wrapedit">
	  			<table style="width: 100%;">
	  				<tr>
	  					<td width="25%">商品名称:</td>
	  					<td id="reauname"></td>
	  				</tr>
	  				<tr>
	  					<td width="20%">单价:</td>
	  					<td>&yen;<label class="reprice"></label> </td>
	  				</tr>
	  				<tr>
	  					<td width="20%">退货数量:</td>
	  					<td class="recount"></td>
	  				</tr>
	  				<tr>
	  					<td>退货原因:</td>
	  					<td>
	  						<div>
			  					<input class="reason" name="reason" type="radio" value="0"/><label>尺寸不合适</label>
			  					<input class="reason" name="reason" type="radio" value="1"/><label>样式或颜色不喜欢</label>
			  					<input class="reason" name="reason" type="radio" value="2"/><label>质量问题</label>
			  					<div></div>
			  					<input class="reason" name="reason" type="radio" value="3"/><label>其它</label>
			  					<input id="reasontext" name="reasontext" class="reasontext" type="text" />
			  					<input id="reOID" name="reOID" type="hidden" />
	  						</div>
		  				</td>
		  			</tr>
	  				<tr>
		  				<td colspan="2">
		  					<a id="resub" class="upBrBtn">提交申请</a>
		  					<span id="retip"></span>
		  				</td>
	  				</tr>
	  			</table>
	  		</div>
  		</div>
  	</div>
  	<div class="exgood edithide">
	  	<div class="goodinfo">
	  		<div class="titedit">
	  			<h2>换货申请</h2>
	  			<i class="closeIcon"></i>
	  		</div>
	  		<div class="wrapedit">
	  			<table style="width: 100%;">
	  				<tr>
	  					<td width="25%">商品名称:</td>
	  					<td id="exauname"></td>
	  				</tr>
	  				<tr>
	  					<td width="20%">单价:</td>
	  					<td>&yen;<label class="exprice"></label> </td>
	  				</tr>
	  				<tr>
	  					<td width="20%">换货数量:</td>
	  					<td class="excount"></td>
	  				</tr>
	  				<tr>
	  					<td>换货原因:</td>
	  					<td>
	  						<div>
		  						<input class="exreason" name="exreason" type="radio" value="0"/><label>尺寸不合适</label>
			  					<input class="exreason" name="exreason" type="radio" value="1"/><label>样式或颜色不喜欢</label>
			  					<input class="exreason" name="exreason" type="radio" value="2"/><label>质量问题</label>
			  					<div></div>
			  					<input class="exreason" name="exreason" type="radio" value="3"/><label>其它</label>
			  					<input id="exreasontext" name="exreasontext" class="reasontext" type="text" />
			  					<input id="exOID" name="exOID" type="hidden" />
	  						</div>
		  				</td>
		  			</tr>
	  				<tr>
		  				<td colspan="2">
		  					<a id="exsub" class="upBrBtn">提交申请</a>
		  					<span id="extip"></span>
		  				</td>
	  				</tr>
	  			</table>
	  		</div>
	  	</div>
  	</div>
  	<script type="text/javascript">
  		$("#resub").click(function() {
  			var oid = $("#reOID").val();
  			var count = $("input[name='recount']:checked").val();
  			var reason = $("input[name='reason']:checked").val();
  			if (reason=="0") {
				reason = "尺寸不合适";
			}else if (reason=="1") {
				reason = "样式或颜色不喜欢";
			}else if (reason=="2") {
				reason="质量问题";
			}else if (reason=="3") {
				reason=$("#reasontext").val().trim();
			}
  			var auth = "refund";
  			$.ajax({
  				url: "exreauthOrderAction",
  				type: "post",
  				dataType: "json",
  				data: {
  					auth: auth,
  					OId: oid,
  					OAmount: count,
  					erReason: reason,
  				},
  				success: function(data){
  					FastJson.format(data);
  					if (data.success==true) {
  						$("#retip").empty();
						$("#retip").append("申请成功,请去返修退换货查看!");
					}else {
						$("#retip").empty();
						$("#retip").append("您您的申请已更新,请去返修退换货查看!");
					}
  				}
  			});
  		});
  		$("#exsub").click(function() {
  			var oid = $("#exOID").val();
  			var count = $("input[name='excount']:checked").val();
  			var reason = $("input[name='exreason']:checked").val();
  			var auth = "exchange";
  			if (reason=="0") {
				reason = "尺寸不合适";
			}else if (reason=="1") {
				reason = "样式或颜色不喜欢";
			}else if (reason=="2") {
				reason="质量问题";
			}else if (reason=="3") {
				reason=$("#exreasontext").val().trim();
			}
  			$.ajax({
  				url: "exreauthOrderAction",
  				type: "post",
  				dataType: "json",
  				data: {
  					auth: auth,
  					OId: oid,
  					OAmount: count,
  					erReason: reason,
  				},
  				success: function(data){
  					FastJson.format(data);
  					if (data.success==true) {
  						$("#extip").empty();
						$("#extip").append("申请成功,请去返修退换货查看!");
					}else {
						$("#extip").empty();
						$("#extip").append("您的申请已更新,请去返修退换货查看!");
					}
  				}
  			});
  		});
  		$(".editauth").click(function() {
  			$(".back").show();
  			$(".exgood").removeClass("shadowShow");
  			$(".regood").addClass("shadowShow");
  			var oid=$(this).data("id");
  			var index = $(this).index(".editauth");
  			var pname = $(".pnametd").eq(index).text();
  			var psellpricetd = $(".psellpricetd").eq(index).text();
  			var amounttd = $(".amounttd").eq(index).text();
  			$("#reOID").val(oid);
  			$("#reauname").empty();
  			$("#reauname").append(pname);
  			$(".reprice").empty();
  			$(".reprice").append(psellpricetd);
  			$(".recount").empty();
  			for ( var i = 0; i < amounttd; i++) {
  				var count = i+1;
  				$option = "<input class='radiocount' name='recount' type='radio' value='"+count+"'/>"+count;
				$(".recount").append($option);
			}
  		});
  		$(".exauth").click(function() {
  			$(".back").show();
  			$(".regood").removeClass("shadowShow");
  			$(".exgood").addClass("shadowShow");
  			var oid=$(this).data("id");
  			var index = $(this).index(".exauth");
  			var pname = $(".pnametd").eq(index).text();
  			var psellpricetd = $(".psellpricetd").eq(index).text();
  			var amounttd = $(".amounttd").eq(index).text();
  			$("#exOID").val(oid);
  			$("#exauname").empty();
  			$("#exauname").append(pname);
  			$(".exprice").empty();
  			$(".exprice").append(psellpricetd);
  			$(".excount").empty();
  			for ( var i = 0; i < amounttd; i++) {
  				var count = i+1;
  				$option = "<input class='radiocount' name='excount' type='radio' value='"+count+"'/>"+count;
				$(".excount").append($option);
			}
  		});
  		$(".closeIcon").click(function() {
  			$(".edithide").removeClass("shadowShow");
  			$(".back").hide();
  		});
  	</script>
  </body>
</html>

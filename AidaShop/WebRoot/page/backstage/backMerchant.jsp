<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商户中心_AidaShop</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="shortcut icon" href="images/icon/favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/style-back-merchant.css"> 
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/input/input.css">
	<link rel="stylesheet" type="text/css" href="css/css-table1.css">
	<link rel="stylesheet" type="text/css" href="css/style-table.css">
	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
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
    					<li id="list_brand" class="list_item"><em></em><span>品牌申请</span></li>
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
		    		<div id="goodNavWarp">
		    			<a class="goodNavA goodNavFocus" href="javascript:void(0);">所有商品</a>
		    			<a class="goodNavA" href="javascript:void(0);">上架申请</a>
		    			<a class="goodNavA" href="javascript:void(0);">销售统计</a>
		    			<a class="goodNavA" href="javascript:void(0);">上架商品</a>
		    			<div class="clear"></div>
		    		</div>
		    		<div>
		    			<div id="allGood" class="goodNavContain goodNavContainShow">
		    				<div id="noGood">
		    					<h1>还没有任何商品，赶紧点击添加按钮添加去！</h1>
		    				</div>
		    				<table id="travel" class="simpleTable">
							    <thead>    
							        <tr>
							        	<th scope="col" width="50px">商品图片</th>
							            <th scope="col" width="20%">商品名称</th>
							            <th scope="col">商品标签</th>
							            <th scope="col" width="40%">商品描述</th>
							            <th scope="col" width="12%">上架时间</th>
							            <th scope="col">售价</th>
							            <th scope="col" width="48px">查看</th>
							        </tr>        
							    </thead>
							    <tbody>
							    	
							    </tbody>
							</table>
							<div id="viGood" class="XQGood">
								<div>
									<a id="viGoodBack" href="javascript:void(0);"></a>
								</div>
								<form action="" enctype="multipart/form-data">
									<table id="viGoodtab" class="simpleTable">
										<caption>商品详情</caption>
										<tr>
											<th scope="row" colspan="1">
												商品名称：
											</th>
											<td colspan="3">
												<input id="pidG" name="pidG" type="hidden" />
												<input id="pnameG" name="pnameG" type="text" style="width: 50%;" />
											</td>
										</tr>
										<tr>
											<th scope="row">
												品牌：
											</th>
											<td>
												<label id="brandG"></label>
											</td>
											<th scope="row">
												标签：
											</th>
											<td>
												<label id="cateG"></label>
											</td>
										</tr>
										<tr>
											<th scope="row" colspan="4">
												商品描述
											</th>
										</tr>
										<tr>
											<td colspan="4">
												<textarea id="descriptionG" name="descriptionG"></textarea>
											</td>
										</tr>
										<tr>
				    						<th scope="row" style="vertical-align: top;" colspan="1">商品轮转展示图:</th>
				    						<td colspan="3">
				    							<div id="LZtdGExist"></div>
				    							<p>第一张轮转显示图即为商品列表展示时的图片;</p>
				    							<p>添加的顺序即为显示的顺序.</p>
				    							<div class='LZtdG'>
					    							<input id="fileLZG1" name="fileLZG" type="file"/>
					    							<input id="addLunzhuanG" class="insideBtn" type="button" value="还有图片"/>
				    							</div>
				    						 </td>
				    					</tr>
										<tr>
				    						<th scope="row" style="vertical-align: top;" colspan="1">商品详情展示图:</th>
				    						<td colspan="3">
				    							<div id="XQtdGExist"></div>
				    							<p>添加的顺序即为显示的顺序.</p>
				    							<div class='XQtdG'><input id="fileXQG1" name="fileXQG" type="file"/>
				    							<input id="addXiangQingG" class="insideBtn" type="button" value="还有图片"/></div>
				    						 </td>
				    					</tr>
				    					<tr>
				    						<td colspan="2">
				    							<input id="spckBtnG" type="button" class="upBrBtn" value="提交" /> 
				    							<p>提交后商品将变为上架申请状态，谨慎提交</p> 
				    						</td>
				    						<td colspan="2">
				    							<input id="spscBtnG" type="button" class="upBrBtn" value="删除" /> 
				    							<p>删除将删除本条商品的所有信息，谨慎删除</p> 
				    						</td>
				    					</tr>
				    				</table>
				    			</form>
				    			<table class="simpleTable">
				    				<caption>其他商品信息修改查看</caption>
				    				<tr>
										<th scope="row">
											库存<p></p>
										</th>
										<td>
											<input id="countG" name="countG" type="text" /><p id="countGP" class="PriChiness"></p>
										</td>
										<th scope="row">
											进价
											<p></p>
										</th>
										<td>
											<label class="yuan">&yen;</label>
											<input id="baseG" name="baseG" type="text"/> <label>(元)</label>
											<p id="baseGP" class="PriChiness"></p>
										</td>
									</tr>
									<tr>
										<th scope="row">
											市场价<p></p>
										</th>
										<td>
											<label class="yuan">&yen;</label>
											<input id="marketG" type="text"/> <label>(元)</label>
											<p id="marketGP" class="PriChiness"></p>
										</td>
										<th scope="row">
											售价<p></p>
										</th>
										<td>
											<label class="yuan">&yen;</label>
											<input id="sellG" type="text"/> <label>(元)</label>
											<p id="sellGP" class="PriChiness"></p>
										</td>
									</tr>
									<tr>
										<th scope="row">商品对应性别:</th>
										<td>
			    							<select id="PSexrequestG" name="PSexrequestG" style="margin-left: 10px;">
			    								<option value="male">男</option>
			    								<option value="female">女</option>
			    								<option value="both">全部</option>
			    							</select>
			    						</td>
			    						<th scope="row">
											推荐等级
											<p></p>
										</th>
										<td>
											<select id="commendG" name="commendG" style="margin-left: 10px;">
												<option value="0">普通</option>
												<option value="1">一级</option>
												<option value="2">二级</option>
												<option value="3">三级</option>
											</select>
										</td>
			    					</tr>
									<tr>
										<th scope="row">
											点击量
										</th>
										<td>
											<label id="cilckCountG"></label>
										</td>
										<th scope="row">
											销售量
											<p></p>
										</th>
										<td>
											<label id="sellCountG" style="margin-left: 10px;"></label>
										</td>
									</tr>
									<tr>
				    					<th scope="row">
											上架时间
										</th>
										<td>
											<label id="createTimeG"></label>
										</td>
										<th scope="row">
											状态
										</th>
										<td>
											<select id="pStateG" name="pStateG">
												<option value="2">正常</option>
												<option value="3">停售</option>
											</select>
										</td>
									</tr>
									<tr>
			    						<td colspan="4">
			    							<input id="spxgG" type="button" class="upBrBtn" value="提交" /> 
			    							<p>提交不会改变申请状态</p> 
			    						</td>
			    					</tr>
				    			</table>
							</div>
		    			</div>
		    			<div id="goodAuth" class="goodNavContain">
		    				<div id="noGoodAuth" class="nothing">
		    					<h1>还没有任何商品商品申请，点击添加按钮添加去！</h1>
		    				</div>
		    				<table id="goodAuthtab" class="simpleTable">
		    					<thead>    
							        <tr>
							        	<th scope="col" width="50px">商品图片</th>
							            <th scope="col" width="20%">商品名称</th>
							            <th scope="col">商品标签</th>
							            <th scope="col" width="40%">商品描述</th>
							            <th scope="col" width="12%">上架时间</th>
							            <th scope="col">状态</th>
							            <th scope="col" width="48px">查看</th>
							        </tr>        
							    </thead>
							    <tbody>
							    	
							    </tbody>
		    				</table>
		    				<div id="viGoodAuth" class="XQGood">
								<table class="simpleTable">
									<caption>申请修改</caption>
								</table>
							</div>
		    			</div>
		    			<div id="goodSales" class="goodNavContain"></div>
		    			<div id="goodPut" class="goodNavContain">
		    				<form action="" enctype="multipart/form-data">
			    				<table id="goodPutTab">
			    					<tr>
			    						<th scope="row">商品名称:</th>
			    						<td><input id="PNameTJ" type="text" name="PName" style="margin-left: 7px;width: 50%;"/> </td>
			    					</tr>
			    					<tr>
			    						<th scope="row" style="vertical-align: top;">商品描述: </th>
			    						<td><textarea id="PDescriptionTJ" name="PDescription" style="margin-left: 7px;"></textarea></td>
			    					</tr>
			    					<tr>
			    						<th scope="row" style="vertical-align: top;">商品标签: </th>
			    						<td>
			    							<select id="cateFir" class="cataSelect">
			    								<option value="0">...</option>
			    							</select>
			    							<select id="cateSec" class="cataSelect">
			    								<option value="0">...</option>
			    							</select>
			    							<select id="cateTrd" class="cataSelect">
			    								<option value="0">...</option>
			    							</select>
			    							<p></p>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th scope="row" style="vertical-align: top;">所属品牌: <p>(没有可以去申请添加)</p></th>
			    						<td>
			    							<select id="brandSelect">
			    								<option value="0">...</option>
			    							</select>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th scope="row">商品进价:<p></p></th>
			    						<td>
			    							<label class="yuan">&yen;</label>
			    							<input id="PBasepriceTJ" type="text" name="PBaseprice"  autoComplete='off'/> <label>(元)</label>
			    							<p class="PriChiness"><label id="BasePri" class="chinessyuan"></label></p>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th scope="row">商品市场价:<p></p></th>
			    						<td>
			    							<label class="yuan">&yen;</label>
			    							<input id="PMarketpriceTJ" type="text" name="PMarketprice"  autoComplete='off'/> <label>(元)</label>
			    							<p class="PriChiness"><label id="MktPri" class="chinessyuan"></label></p>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th scope="row">商品售价:<p></p></th>
			    						<td>
			    							<label class="yuan">&yen;</label>
			    							<input id="PSellpriceTJ" type="text" name="PSellprice"  autoComplete='off'/> <label>(元)</label>
			    							<p class="PriChiness"><label id="SellPri" class="chinessyuan"></label></p>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th scope="row">商品对应性别:</th>
			    						<td>
			    							<select id="PSexrequestTJ" name="PSexrequest" style="margin-left: 10px;">
			    								<option value="male">男</option>
			    								<option value="female">女</option>
			    								<option value="both">全部</option>
			    							</select>
			    						</td>
			    					</tr>
			    					<tr>
			    						<th id="LZth" scope="row" style="vertical-align: top;" >商品轮转展示图:</th>
			    						<td>
			    							<p>第一张轮转显示图即为商品列表展示时的图片;</p>
			    							<p>添加的顺序即为显示的顺序.</p>
			    							<div class='LZtd'>
				    							<input id="fileLZ1" name="fileLZ" type="file"/>
				    							<input id="addLunzhuan" class="insideBtn" type="button" value="还有图片"/>
			    							</div>
			    						 </td>
			    					</tr>
			    					<tr>
			    						<th id="XQth" scope="row" style="vertical-align: top;">商品详情展示图:</th>
			    						<td>
			    							<p>添加的顺序即为显示的顺序.</p>
			    							<div class='XQtd'><input id="fileXQ1" name="fileXQ" type="file"/>
			    							<input id="addXiangQing" class="insideBtn" type="button" value="还有图片"/></div>
			    						 </td>
			    					</tr>
			    					<tr>
			    						<td colspan="2">
			    							<input id="sptjBtn" type="button" class="upBrBtn" value="提交" onclick="return ShangPinTianjia();" />  
			    						</td>
			    					</tr>
			    				</table>
		    				</form>
		    			</div>
		    		</div>
		    	</div>
		    	<div class="manage_brand mer_left_wrap">
		    		<div class="manger_bar_tit">
		    			<span class="mer_left_wrap_name">品牌申请</span>
		    			<div id="brand_add" class="add_bar"><i></i><span>添加</span></div>
		    		</div>
		    		<div id="ppsqlb">
		    			<table class="bordered">  
							<thead>  
							 <tr>  
							  <th>中文名称</th>  
							  <th>英文名称</th>  
							  <th>简介</th>  
							  <th>申请时间</th>
							  <th>状态</th>
							  <th>编辑</th>
							 </tr>  
							</thead>  
							<tbody id="brandAuthWrap">  
						 	</tbody>  
						</table>
		    		</div>
		    		<!-- 编辑品牌 start -->
		    		<div id="ppsqbj" class="topFrame">
		    			<i class="closeIcon"></i>
						<table class="upBrtable">
							<tr>
								<td>
									<h1>品牌申请修改</h1><input type="hidden" id="brIdXG" name="brId" />
								</td>
							</tr>
				  			<tr><td><label>中文名称:</label><input type="text" id="brNameXG" class="upBrtextfield" name="brName" /></td>
				  			</tr> 
				  			<tr><td><label>英文名称:</label><input type="text" id="brEngNameXG" class="upBrtextfield" name="brEngName" /></td>
						   	</tr>  
						   	<tr><td><label>简介:</label></td></tr>
						   	<tr>
						   		<td class="upBrFont"><textarea id="upBrTextXG" name="brDiscription"></textarea> </td>
						   	</tr> 
						   	<tr>
						   		<td align="center" colspan="2">
							   		<input id="ppsqBtnXG" type="button" class="upBrBtn" value="提交" />  
									<input type="button" class="upBrBtn ppsqCanel" value="取消"/>  
							    </td>
							</tr>
						</table>   
		    		</div>
		    		<!-- 编辑品牌 end -->
		    		<!-- 添加品牌 start -->
		    		<div class="shadow"></div>
		    		<div id="ppsqtj" class="topFrame">
		    			<i class="closeIcon"></i>
						<table class="upBrtable">
							<tr>
								<td>
									<h1>品牌添加申请</h1>
								</td>
							</tr>
				  			<tr><td><label>中文名称:</label><input type="text" id="brNameTJ" class="upBrtextfield" name="brName" /></td>
				  			</tr> 
				  			<tr><td><label>英文名称:</label><input type="text" id="brEngNameTJ" class="upBrtextfield" name="brEngName" /></td>
						   	</tr>  
						   	<tr><td><label>简介:</label></td></tr>
						   	<tr>
						   		<td class="upBrFont"><textarea id="upBrText" name="brDiscription"></textarea> </td>
						   	</tr> 
						   	<tr>
						   		<td align="center" colspan="2">
							   		<input id="ppsqBtn" type="button" class="upBrBtn" value="提交" />  
									<input type="button" class="upBrBtn ppsqCanel" value="取消"/>  
							    </td>
							</tr>
						</table>   
		    		</div>
		    		<!-- 添加品牌 end -->
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

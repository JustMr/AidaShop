<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<link rel="stylesheet" type="text/css" href="css/style-homecontent.css">
	<link rel="stylesheet" type="text/css" href="css/style-clear.css">
	<link rel="stylesheet" type="text/css" href="css/style-nav.css">
		
  </head>
  
  <body>
    <!-- 导航栏 -->
  	<div class="homeNav">
  		<div class="homeNavMain">
  			<ul class="homeNavUl">
  				<li class="homeNavFirst">
  					所有商品分类
  					<em class="bias"></em>
  					<ul class="fistMenu">
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe743;</i>
  								<a href="###">进口食品</a>、
  								<a href="###">生鲜</a>、
  								<a href="###">海购</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt>
  										<a href="###">进口零食</a>
  										<em>/</em>
  										<a href="###">干果</a>
  										<em>/</em>
  										<a href="###">零食</a>
  									</dt>
  									<dd><a href="###">海苔</a></dd>
  									<dd><a href="###">肉干肉脯</a></dd>
  									<dd><a href="###">鱼类海味</a></dd>
  									<dd><a href="###">果冻布丁</a></dd>
  									<dd><a href="###">薯片</a></dd>
  									<dd><a href="###">膨化</a></dd>
  									<dd><a href="###">坚果</a></dd>
  									<dd><a href="###">开心果</a></dd>
  									<dd><a href="###">什锦坚果</a></dd>
  									<dd><a href="###">腰果</a></dd>
  									<dd><a href="###">蜜饯</a></dd>
  									<dd><a href="###">芒果干</a></dd>
  									<dd><a href="###">蔓越莓干</a></dd>
  									<dd><a href="###">榴莲干</a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe618;</i>
  								<a href="###">食品</a>、
  								<a href="###">饮料</a>、
  								<a href="###">酒</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe73f;</i>
  								<a href="###">母婴</a>、
  								<a href="###">玩具</a>、
  								<a href="###">童装</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a>1</a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe608;</i>
  								<a href="###">厨卫清洁</a>、
  								<a href="###">纸</a>、
  								<a href="###">清洁剂</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe681;</i>
  								<a href="###">家居</a>、
  								<a href="###">家装</a>、
  								<a href="###">宠物</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a>2</a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe639;</i>
  								<a href="###">美妆</a>、
  								<a href="###">个人护理</a>、
  								<a href="###">洗护</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe600;</i>
  								<a href="###">女装内衣</a>、
  								<a href="###">男装</a>、
  								<a href="###">珠宝</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe73c;</i>
  								<a href="###">鞋靴</a>、
  								<a href="###">箱包</a>、
  								<a href="###">户外运动</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe60f;</i>
  								<a href="###">手机</a>、
  								<a href="###">数码</a>、
  								<a href="###">电脑办公</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe610;</i>
  								<a href="###">大家电</a>、
  								<a href="###">小家电</a>、
  								<a href="###">汽车</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  						<li class="firstMenuItem">
  							<h3>
  								<i class="iconFirstMenu iconfont">&#xe634;</i>
  								<a href="###">礼品卡</a>、
  								<a href="###">旅游</a>、
  								<a href="###">图书</a>
  							</h3>
  							<div class="secondMenu">
  								<dl class="secondMenuItem">
  									<dt><a></a></dt>
  									<dd><a></a></dd>
  								</dl>
  							</div>
  						</li>
  					</ul>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">首页</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱搭</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱家居</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">电器城</a>
  				</li>
  				<li class="homeNavLi">
  					<a href="###">爱搭排行</a>
  				</li>
  			</ul>
  		</div>
  	</div>
  </body>
</html>

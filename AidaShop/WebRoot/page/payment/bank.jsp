<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线支付_AIDASHOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		.pubwrap {width: 1200px;margin: 20px auto;}
		table {
			width:60%;
			border: none;
			border-spacing: 0px;
		}
		table td {
			 padding: 3px 5px;text-align: left;
		}
		#paybtn {
			display: block;background: #872222;width: 120px;height: 36px;
		line-height: 36px;text-align: center;color: #fff;font-size: 18px;font-weight: 500;
			margin-left: 20px;
		}
		#paybtn:HOVER {
	text-decoration: none;
}
	</style>
  </head>
  
  <body>
  	<!-- 头部 -->
    <jsp:include page="../reuse/header.jsp"></jsp:include>
    <div class="pubwrap">
        <form action="${pageContext.request.contextPath }/payrequestOrderAction" method="post">
      	<table width="60%">
			<tr><td><br/><input type="hidden" name="orderid" value="${param.orderid }">
    		<input type="hidden" name="money" value="${param.money }"></td></tr>
			<tr>
				<td>请您选择在线支付银行</td>
			</tr>
			<tr>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBCHINA-NET">招商银行 </td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ICBC-NET">工商银行</td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ABC-NET">农业银行</td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CCB-NET">建设银行 </td>
			</tr>
			<tr>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBC-NET">中国民生银行总行</td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CEB-NET" >光大银行 </td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BOCO-NET">交通银行</td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SDB-NET">深圳发展银行</td>
			</tr>
			<tr>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BCCB-NET">北京银行</td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CIB-NET">兴业银行 </td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SPDB-NET">上海浦东发展银行 </td>
			  <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ECITIC-NET">中信银行</td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
			  <td><INPUT TYPE="submit" value="确定支付"></td>
			</tr>
     	</table>
   		</form>
   	</div>
   		 <!-- 底部 -->
    <jsp:include page="../reuse/footer.jsp"></jsp:include>
  </body>
</html>

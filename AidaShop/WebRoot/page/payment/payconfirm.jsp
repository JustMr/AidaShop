<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>确认支付_AIDASHOP</title>
    
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
    <form action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
    	<input type="hidden" name="p0_Cmd" value='<s:property value="#request.p0_Cmd"/>'>
    	<input type="hidden" name="p1_MerId" value='<s:property value="#request.p1_MerId"/>'>
    	<input type="hidden" name="p2_Order" value='<s:property value="#request.p2_Order"/>'>
    	<input type="hidden" name="p3_Amt" value='<s:property value="#request.p3_Amt"/>'>
    	<input type="hidden" name="p4_Cur" value='<s:property value="#request.p4_Cur"/>'>
    	<input type="hidden" name="p5_Pid" value='<s:property value="#request.p5_Pid"/>'>
    	<input type="hidden" name="p6_Pcat" value='<s:property value="#request.p6_Pcat"/>'>
    	<input type="hidden" name="p7_Pdesc" value='<s:property value="#request.p7_Pdesc"/>'>
    	<input type="hidden" name="p8_Url" value='<s:property value="#request.p8_Url"/>'>
    	<input type="hidden" name="p9_SAF" value='<s:property value="#request.p9_SAF"/>'>
    	<input type="hidden" name="pa_MP" value='<s:property value="#request.pa_MP"/>'>
    	<input type="hidden" name="pd_FrpId" value='<s:property value="#request.pd_FrpId"/>'>
    	<input type="hidden" name="pr_NeedResponse" value='<s:property value="#request.pr_NeedResponse"/>'>
    	<input type="hidden" name="hmac" value='<s:property value="#request.hmac"/>'>
    	<input type="submit" value="确认支付">
    </form>
    </div>
   	<!-- 底部 -->
    <jsp:include page="../reuse/footer.jsp"></jsp:include>
  </body>
</html>

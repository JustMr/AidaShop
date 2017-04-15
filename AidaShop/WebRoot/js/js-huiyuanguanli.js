$(document).ready(function() {
	$(".subEdit").on("click",postCust);
}); 
function postCust() {
	var record = $("#record").attr("value");
	console.log("record:"+record);
	var tr = $(".bhover").eq(record);
	var uid= tr.find("#UId").attr("value");
//	var UNickName = tr.find("#UNickName").text();
//	var UName = tr.find("#UName").attr("value");
//	var USex = tr.find("#USex").text();
//	var URelaname = tr.find("#URelaname").text();
//	var UPassword = tr.find("#UPassword").attr("value");
//	var UBirthday = tr.find("#UBirthday").attr("value");
//	console.log("UBirthday:"+UBirthday);
//	var UAddress = tr.find("#UAddress").attr("value");
//	var UCardId = tr.find("#UCardId").attr("value");
//	var UEmail = tr.find("#UEmail").attr("value");
//	var UMobile = tr.find("#UMobile").attr("value");
//	var stId = tr.find("#stId").attr("value");
	var styleDes = tr.find("#UStylingDesigner").val();
	var uadmin = tr.find("#UAdmin").val();
	var ustate = tr.find("#UState").val();
	console.log("postCust:"+uid+","+styleDes+","+uadmin+","+ustate);
	window.location.href="editCustomerAction?UId="+uid+"&UStylingDesigner="+styleDes+"&UState="+ustate+"&UAdmin="+uadmin;
}
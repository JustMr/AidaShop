$(document).ready(function() {
	$(".subEdit").on("click",postCust);
}); 
function postCust() {
	var record = $("#record").attr("value");
	console.log("record:"+record);
	var tr = $(".bhover").eq(record);
	var uid= tr.find("#UId").attr("value");
	var styleDes = tr.find("#UStylingDesigner").val();
	var uadmin = tr.find("#UAdmin").val();
	var ustate = tr.find("#UState").val();
	console.log("postCust:"+uid+","+styleDes+","+uadmin+","+ustate);
	window.location.href="editCustomerAction?UId="+uid+"&UStylingDesigner="+styleDes+"&UState="+ustate+"&UAdmin="+uadmin;
}
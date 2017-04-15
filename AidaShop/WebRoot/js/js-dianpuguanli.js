$(document).ready(function() {
	$(".subEdit").on("click",postCust);
}); 
function postCust() {
	var record = $("#record").attr("value");
	console.log("record:"+record);
	var tr = $(".bhover").eq(record);
	var stId= tr.find("#stId").attr("value");
	var stLevel = tr.find("#stLevel").val();
	var stState = tr.find("#stState").val();
	console.log("postCust:"+uid+","+styleDes+","+uadmin+","+ustate);
	window.location.href="updateStoreAction?stId="+stId+"&stLevel="+stLevel+"&stState="+stState;
}
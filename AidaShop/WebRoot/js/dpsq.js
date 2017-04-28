$(document).ready(function() {
	$(".subEdit").on("click",postCust);
}); 
function postCust() {
	var record = $("#record").attr("value");
	console.log("record:"+record);
	var tr = $(".bhover").eq(record);
	var stId= tr.find("#saId").attr("value");
	var stState = tr.find("#saStatu").val();
	window.location.href="upsaStoreAuthAction?saId="+saId+"&saStatu="+saStatu;
}
$(document).ready(function() {
	$(".subEditBrand").on("click",updateBrState);
}); 
function updateBrState() {
	var record = $("#record").attr("value");
	console.log("record:"+record);
	var tr = $(".bhover").eq(record);
	var brId= tr.find("#brId").attr("value");
	var brState = tr.find("#brState").val();
	window.location.href="updateBrState?brId="+brId+"&brState="+brState;
}
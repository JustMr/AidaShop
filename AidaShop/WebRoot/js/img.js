$(function() {
	var pageCheck = $("#pageCheck").val();
	if(pageCheck=="sqzx") {
		sehnqingList();
		resizeImageHeight(55);
	} else if(pageCheck=="sqzxvi") {
		sehnqingList();
		resizeImageWidth(200);
	}
});
function sehnqingList() {
	var srcF = $("#front_hide").val();
	var srcB = $("#back_hide").val();
	var imgF = $("#front_img");
	var imgB = $("#back_img");
	console.log("srcF:"+srcF);
	var indexF = srcF.indexOf("\\upload\\");
	var indexB = srcB.indexOf("\\upload\\");
	console.log("indexF:"+indexF);
	var reg=/\\/g;//g,表示全部替换
	srcF = "."+srcF.substr(indexF).replace(reg,"/");
	srcB = "."+srcB.substr(indexF).replace(reg,"/");
	console.log("srcF now:"+srcF);
	imgF.attr("src",srcF);
	imgB.attr("src",srcB);
}
function resizeImageHeight(height){
	$("#brandListTAb img").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).width((height*imgWidth)/imgHeight);
	$(this).height(height);
	});
} 
function resizeImageWidth(width){
	$("#brandListTAb img").each(function(){
	//加载图片至内存，完成后执行
	//获得原始图片高宽
	var imgWidth = $(this).width();
	var imgHeight = $(this).height();
	//重新设置img的width和height
	$(this).height((width*imgHeight)/imgWidth);
	$(this).width(width);
	});
} 
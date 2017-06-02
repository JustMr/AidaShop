$(document).ready(function() {
	deatilMenuFix();
	$(".minipicture").each(function(){
		//加载图片至内存，完成后执行
		//获得原始图片高宽
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		//重新设置img的width和height
		$(this).height((58*imgHeight)/imgWidth);
		$(this).width(58);
	});
	$("#J_proImg").each(function() {
		var imgWidth = $(this).width();
		var imgHeight = $(this).height();
		$(this).height((330*imgHeight)/imgWidth);
		$(this).width(330);
	});
	$(".minipicture").click(function() {
		var src = $(this).attr("src");
		$("#J_proImg").attr("src",src);
	});
	var top = 0;
	var bottom = $("#mbox1").height();
	var father = $(".hideBox").height();
	var height = father-bottom;
	$(".prev").click(function() {
		/*e.preventDefault();
        $('.mBox').animate({
            scrollTop: $(this.hash).offset().top - 60
        }, 1500);*/
		if (height<0) {
			if (top>height) {
				top = top-10;
				$(".mBox").animate({ "top": top }, 30);
				console.log(top);
			}
		}
	});
	$(".next").click(function() {
		/*e.preventDefault();
        $('.mBox').animate({
            scrollTop: $(this.hash).offset().top - 60
        }, 1500);*/
		if (height<0) {
			if (top<0) {
				top = top+10;
	//			$(".mBox").css("top",top+"px");
				$(".mBox").animate({ "top": top }, 30);
				console.log(top);
			}
		}
	});
	$(".btn_add").click(function () {
		var count = parseInt($("#buy-num").val()) + 1;
		$("#buy-num").val(count);
	});
	$(".btn_reduce").click(function () {
		var count = parseInt($("#buy-num").val()) - 1;
		if (count>=0) {
			$("#buy-num").val(count);
		}
	});
});
function deatilMenuFix() {
	var dMenu = $(".title_wrap li");
	for(var i=0; i<dMenu.length; i++) {
		dMenu[i].onclick = function() {
			dMenu.removeClass("current");
			this.className += (this.className.length>0?" ":"") + "current";
			if(this.id=="title1") {
				$(".speci_package").css("display","none");
				$(".good_introduce").css("display","block");
			}else if(this.id=="title2") {
				$(".good_introduce").css("display","none");
				$(".speci_package").css("display","block");
			}else if(this.id=="title3") {
				$(".good_introduce").css("display","none");
				$(".speci_package").css("display","none");
			}else {
				$(".good_introduce").css("display","none");
				$(".speci_package").css("display","none");
			}
		};
	}
}
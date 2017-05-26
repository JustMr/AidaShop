$(document).ready(function() {
	$("#seachBth").on("click",SearchGoods);
	$("#deleteBth").on("click",removeChoiceItme);
	$("#pubtn").on("click",publlishArticle);
});
function SearchGoods() {
	//搜素商品
	var PName = $("#PName").val().trim();
	$.ajax({
		url: "searchGoodAction",
		type: "post",
		dataType: "json",
		data: {
			PName: PName,
		},
		success: function(data) {
			FastJson.format(data);
			console.log(data);
			if (data.success==true) {
				$(".noResult").hide();
				$(".allResult").hide();
				$(".searchResult").show();
				$(".searchResult").empty();
				var l = data.obj.length;
				for ( var i = 0; i < l; i++) {
					var t = data.obj[i];
					var s = data.obj1[i];
					var r = data.obj2[i];
					
					var $div = "<div class='searchItem'>" +
							"<a class='searcha' data-id='"+t.pId+"' href='javascript:void(0);' onclick='wantGood();'><div class='imgWarp'>" +
							"<img class='goodList' alt='"+t.pName+"' src='"+s+"'></div>" +
							"<div class='goodInfo'><label class='goodName'>"+t.pName+"</label>" +
							"<label class='goodStore'>"+r+"</label>" +
							"<label class='yunLab'>&yen;</label>" +
							"<label class='price'>"+t.pSellprice+"</label>" +
							"<label class='yunChinese'>元</label></div></a></div>";
					$(".searchResult").append($div);
				}
				
				$(".goodList").each(function(){
					//加载图片至内存，完成后执行
					//获得原始图片高宽
					var imgWidth = $(this).width();
					var imgHeight = $(this).height();
					//重新设置img的width和height
					$(this).height((50*imgHeight)/imgWidth);
					$(this).width(50);
				});
				
			}else {
				$(".noResult").show();
				$(".searchResult").hide();
				$(".allResult").hide();
			}
			
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function wantGood() {
	
	var html = $(".searcha:focus").prop("outerHTML");
	
	var className = $(".searcha:focus").parent().attr("class");
	if (className=="searchItem") {
		//判断是否有相同商品已经添加
		var flag=0;
		var id = $(".searcha:focus").data("id");

		var count = $(".choiceItem").length;
		for ( var i = 0; i < count; i++) {
			var idSelect = $(".choiceItem").eq(i).find(".searcha").data("id");

			if (idSelect==id) {
				flag=1;
			}
		}
		
		if (flag==1) {
			alert("已经添加该商品!");
		}else {
			//移除搜索列表中商品，添加到选中列表中
			var $div = "<div class='choiceItem'>"+html+"</div>";
			$(".goodChoice").append($div);
			
			var choiceCount = $(".choiceItem").length;
			if (choiceCount==1) {
				$(".noChoice").hide();
				$(".goodChoice").show();
			}
			
			$(".searcha:focus").parent().remove();
			var length = $(".searchItem").length;
			
			if (length==0) {
				$(".allResult").show();
				$(".searchResult").hide();
			}
		}
	}else if(className=="choiceItem") {
		//选中已添加列表的商品列表项
		$(".choiceItem").removeClass("removeItem");
		$(".searcha:focus").parent().addClass("removeItem");
		$("#deleteBth").css("display","inline-block");
	}
	
}
function removeChoiceItme() {
	//从已添加商品列表移除商品
	
	var html = $(".removeItem").html();
	var $div = "<div class='searchItem'>"+html+"</div>";
	var id = $(".removeItem .searcha").data("id");
	
	
	$(".removeItem").remove();
	
	var flag = 0;
	var length = $(".searchItem").length;
	for ( var i = 0; i < length; i++) {
		var idSelect = $(".searchItem").eq(i).find(".searcha").data("id");
		if (idSelect==id) {
			flag=1;
		}
	}
	if (flag==0) {
		$(".searchResult").prepend($div);
	}
	
	length = $(".searchItem").length;
	if (length==1) {
		$(".searchResult").show();
		$(".noResult").hide();
		$(".allResult").hide();
	}
	
	var choiceCount = $(".choiceItem").length;
	if (choiceCount==0) {
		$(".noChoice").show();
		$(".goodChoice").hide();
	}
	
	$("#deleteBth").css("display","none");
}
function publlishArticle() {
	var arTitle = $("#arTitle").val();
	var mainText = $(window.frames["fulltext"].document).find("#textarea").val();
	var ids = "";
	
	var choiceCount = $(".choiceItem").length;
	for ( var i = 0; i < choiceCount; i++) {
		var id = $(".choiceItem").eq(i).find(".searcha").data("id");
		ids = ids + "," +id;
	}
	
	ids = ids.substr(1);
	console.log(ids);

	var flag=0;
	if (arTitle==""||arTitle==null||mainText==""||mainText==null) {
		flag=1;
		alert("请填写标题或正文保持文章完整!");
	}
	if (flag==0) {
		$.ajax({
			url: "pubArticleDesignerAction",
			data: {
				arTitle: arTitle,
				arMain: mainText,
				ids: ids,
			},
			type: "post",
			dataType: "json",
			success: function(data) {
				if (data.success==true) {
					alert("发表成功!");
					location.reload();
				}else {
					alert("发表失败!");
				}
				
			},
			error: function() {
				alert("something wrong!");
			}
		});
	}
	
}
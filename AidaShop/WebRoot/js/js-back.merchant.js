var listItem;
var setClickNum = 0;
$(document).ready(function(){
	
	
	/*侧边栏*/
	$("#list_home").on("click",selected1);
	$("#list_good").on("click",selected2);
	$("#list_order").on("click",selected3);
	$("#list_comment").on("click",selected4);
	$("#list_ad").on("click",selected5);
	$("#list_fiance").on("click",selected6);
	$("#list_refund").on("click",selected7);
	$("#list_set").on("click",selected8);
	$("#list_brand").on("click",selected9);
	$(document).on("scroll",scrollTOLeft);
	loadLeft();
	
	
	/*设置栏，标题栏*/
	$(".edit_bar").on("mouseover",editOver);
	$(".edit_bar").on("mouseout",editOut);
	$(".add_bar").on("mouseover",addOver);
	$(".add_bar").on("mouseout",addOut);
	
	
	/*编辑*/
	$("#set_edit").on("click",setClick);
	$("#setFinishBtn").on("click",finishClick);
	$("#addStoreTag").on("click",addStoreTag);
	$(".storeTagBox i").on("click",closeStoreTag);
	
	
	//品牌申请
	$("#brand_add").on("click",PinPaiTianJia);
	$(".closeIcon").on("click",TopHide);
	$(".ppsqCanel").on("click",TopHide);
	$("#ppsqBtn").on("click",PinPaiSub);
	$("#ppsqBtnXG").on("click",PPEditSub);
	
	
	//商品管理
	$(".goodNavA").each(function() {
		$(this).click(function (){
			$(".goodNavA").removeClass("goodNavFocus");
			$(this).addClass("goodNavFocus");
			var i = $(this).index(".goodNavA");
			$(".goodNavContain").removeClass("goodNavContainShow");
			$(".goodNavContain").eq(i).addClass("goodNavContainShow");
		});
	});
	$(".goodNavA").eq(0).on("click",allGoodShwo);
	$(".goodNavA").eq(1).on("click",allGoodAuthShwo);
	$("#good_add").on("click", ShangPinTianjiaShow);
	$("#PBasepriceTJ").on("input propertychange", PBasepriceTJToChese);
	$("#PMarketpriceTJ").on("input propertychange", PMarketpriceTJToChese);
	$("#PSellpriceTJ").on("input propertychange", PSellpriceTJToChese);
	$("#baseG").on("input propertychange", baseGToChese);
	$("#marketG").on("input propertychange", marketGToChese);
	$("#sellG").on("input propertychange", sellGToChese);
	$("#countG").on("input propertychange", countNumJud);
	$("#addLunzhuan").on("click",addLunzhuan);
	$("#addXiangQing").on("click",addXiangQing);
	$("#addLunzhuanG").on("click",addLunzhuanG);
	$("#addXiangQingG").on("click",addXiangQingG);
	$("#spscBtnG").on("click", deleteGood);
	$("#viGoodBack").on("click",GoodBack);
	$("#spxgG").on("click",spxgqtG);
	$("#spckBtnG").on("click",spckqtBtnG);
	
	
	//添加商品显示标签和品牌
	GoodTJCategory();
	$("#cateFir").on("input propertychange", GoodTJCategorySec);
	$("#cateSec").on("input propertychange", GoodTJCategoryTrd);
	BrandTJShow();
	
	
});
function spckqtBtnG() {
	var pId = $("#pidG").val().trim();
	var pnameG = $("#pnameG").val().trim();
	var descriptionG = $("#descriptionG").val().trim();
	var flag=0;
	var files="";
	var countLZg = 0;
	var countXQg = 0;
	
	if (pId==""||pnameG==""||descriptionG=="") {
		alert("请保证所有信息完整!");
		flag=1;
	}
	
	
	if (flag==0) {
		$("input[name=fileLZG]").each(function(){
			if (flag==0) {
				   
				var location=$(this).val(); 
				if (location!=""&&location!=null) {
					var point = location.lastIndexOf("."); 
					var type = location.substr(point); 
					if(type!=".jpg"&&type!=".gif"&&type!=".JPG"&&type!=".GIF"&&type!=".jpeg"&&type!=".JPEG"&&type!=".bmp"&&type!=".BMP"&&type!=".png"&&type!=".PNG"){ 
						flag=2;
					} 
					if (flag==0) {
						files = files + $(this).attr("id")+",";
					}
				}
			}
			
		});
	}
	
	if (flag==0) {
		$("input[name=fileXQG]").each(function(){
			
			if (flag==0) {
				var location=$(this).val(); 
				if (location!=""&&location!=null) {
					var point = location.lastIndexOf("."); 
					   
					var type = location.substr(point); 
					if(type!=".jpg"&&type!=".gif"&&type!=".JPG"&&type!=".GIF"&&type!=".jpeg"&&type!=".JPEG"&&type!=".bmp"&&type!=".BMP"&&type!=".png"&&type!=".PNG"){ 
						flag=2;
					} 
					
					files = files + $(this).attr("id")+",";
				}
				
			}
		});
		
	}
	
	if (flag==2) {
		alert("请保证上传的文件都为图片!");
	}	
	
	if (flag==0) {
		files = files.substring(0,files.length-1);
		console.log(files);
	}
	
	if (flag==0) {
		countLZg = $(".imgGoodLZG").length;
		countXQg = $(".imgGoodXQG").length;
		console.log(countLZg+","+countXQg);
		
		$.ajaxFileUpload( {
			url : 'mianEditGoodAction',     //用于文件上传的服务器端请求地址  
			secureuri : false,            //一般设置为false  
			fileElementId : files,        //文件上传空间的id属性  <input type="file" id="file" name="file" />  
			data: {
				PId: pId,
				PName: pnameG,
				PDescription: descriptionG,
				countXQg: countXQg,
				countLZg: countLZg
			},
			dataType : 'JSON',            //返回值类型 一般设置为json  
			success : function(data, status) {
				console.log(data);
				allGoodShwo();
			},
			error : function(data, status, e) {
				console.log(data);
				alert("something wrong!");
			}
		});
		
	}
}
function spxgqtG() {
	//查看已通过商品详情
	var pId = $("#pidG").val().trim();
	var countG = $("#countG").val().trim();
	var baseG = $("#baseG").val().trim();
	var marketG = $("#marketG").val().trim();
	var sellG = $("#sellG").val().trim();
	var PSexrequestG = $("#PSexrequestG").val().trim();
	var commendG = $("#commendG").val().trim();
	var PState = $("#pStateG").val().trim();
	
	var flag = 0;
	
	if (!/^\d*(\.\d*)?$/.test(baseG)||!/^\d*(\.\d*)?$/.test(marketG)||!/^\d*(\.\d*)?$/.test(sellG)) {
		alert("请保证输入的价格合法!");
		flag=1;
	}
	
	if (flag == 0) {
		if (!/^[1-9]d*|0$/.test(countG)) {
			alert("请保证库存量输入格式合法!");
			flag=1;
		}
	}
	
	
	if (flag == 0) {
		$.ajax({
			url: "qtEditGoodAction",
			data: {
				PId: pId,
				PCount: countG,
				PBaseprice: baseG,
				PMarketprice: marketG,
				PSellprice: sellG,
				PSexrequest: PSexrequestG,
				PCommend: commendG,
				PState: PState
			},
			dataType: "json",
			type: "post",
			success: function(data) {
				
				if (data.success==true) {
					catGood(pId);
				}else {
					alert("something wrong!");
				}
			},
			error: function() {
				alert("something wrong!");
			}
		});
	}
	
}
function deleteGood() {
	var pId = $("#pidG").val().trim();
	$.ajax({
		url: "deleteGoodAction",
		data: {
			PId: pId,
		},
		dataType: "json",
		type: "post",
		success: function(data) {
			if (data.success==true) {
				allGoodShwo();
				
			}else {
				alert("something wrong!");
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function BrandTJShow() {
	$.ajax({
		url: "listBrandSt",
		type: "post",
		dataType: "json",
		success: function(data) {
			if (data.success==true) {
				var l = data.obj.length;
				for ( var int = 0; int < l; int++) {
					var $option = "<option value='"+data.obj[int].brId+"'>"+data.obj[int].brName+"</option>";
					$("#brandSelect").append($option);
				}
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function GoodTJCategoryTrd() {
	var pid = $("#cateSec").val();
//	console.log(typeof(pid));
	$.ajax({
		url: "listLvTowOrThreePCategoryAction",
		type: "post",
		data: {cgId:pid},
		dataType: "json",
		success: function(data) {
			$("#cateTrd option:gt(0)").remove();
			if (data.success==true) {
				var length = data.obj.length;
				for ( var int = 0; int < length; int++) {
					var $option = "<option value='"+data.obj[int].cgId+"'>"+data.obj[int].cgName+"</option>";
					$("#cateTrd").append($option);
				}
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function GoodTJCategorySec() {
	var pid = $("#cateFir").val();
	$.ajax({
		url: "listLvTowOrThreePCategoryAction",
		type: "post",
		data: {cgId:pid},
		dataType: "json",
		success: function(data) {
			$("#cateSec option:gt(0)").remove();
			if (data.success==true) {
				var length = data.obj.length;
				for ( var int = 0; int < length; int++) {
					var $option = "<option value='"+data.obj[int].cgId+"'>"+data.obj[int].cgName+"</option>";
					$("#cateSec").append($option);
				}
			}else {
				$("#cateTrd option:gt(0)").remove();
			}
			
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function GoodTJCategory() {
	$.ajax({
		url: "listLvOnePCategoryAction",
		dataType: "json",
		type: "post",
		success: function(data) {
			$("#cateFir option:gt(0)").remove();
			if (data.success==true) {
				var length = data.obj.length;
				for ( var int = 0; int < length; int++) {
					var $option = "<option value='"+data.obj[int].cgId+"'>"+data.obj[int].cgName+"</option>";
					$("#cateFir").append($option);
				}
			}else {
				$("#cateSec option:gt(0)").remove();
				$("#cateTrd option:gt(0)").remove();
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function ShangPinTianjia() {
	var flag = 0;
	var PName = $("#PNameTJ").val().trim();
	var PDescription = $("#PDescriptionTJ").val().trim();
	var PBaseprice = $("#PBasepriceTJ").val().trim();
	var PMarketprice = $("#PMarketpriceTJ").val().trim();
	var PSellprice = $("#PSellpriceTJ").val().trim();
	var PSexrequest = $("#PSexrequestTJ").val().trim();
	var cate = $("#cateTrd").val();
	var brId = $("#brandSelect").val();

	
	if (flag==0) {
		if (PName==""||PDescription==""||PBaseprice==""||PMarketprice==""||PSellprice =="") {
			flag=3;
		}
	}
	
	var files = "";
	$("input[name=fileLZ]").each(function(){
		if (flag==0) {
			if($(this).val()=="") {
				flag=1;
			}
			
			   
			if (flag==0) {
				var location=$(this).val(); 
				var point = location.lastIndexOf("."); 
				var type = location.substr(point); 
				if(type!=".jpg"&&type!=".gif"&&type!=".JPG"&&type!=".GIF"&&type!=".jpeg"&&type!=".JPEG"&&type!=".bmp"&&type!=".BMP"&&type!=".png"&&type!=".PNG"){ 
					flag=2;
				} 
			}
		}
		if (flag==0) {
			files = files + $(this).attr("id")+",";
		}
	});
	
	if (flag==0) {
		$("input[name=fileXQ]").each(function(){
			if($(this).val()=="") {
				flag=1;
			}
			
			if (flag==0) {
				var location=$(this).val(); 
				var point = location.lastIndexOf("."); 
				   
				var type = location.substr(point); 
				if(type!=".jpg"&&type!=".gif"&&type!=".JPG"&&type!=".GIF"&&type!=".jpeg"&&type!=".JPEG"&&type!=".bmp"&&type!=".BMP"&&type!=".png"&&type!=".PNG"){ 
					flag=2;
				} 
				
				files = files + $(this).attr("id")+",";
			}
		});
		
	}
	
	if (flag==0) {
		files = files.substring(0,files.length-1);
		console.log(files);
	}
	
	
	if (flag==0) {
		if (!/^\d*(\.\d*)?$/.test(PMarketprice) || !/^\d*(\.\d*)?$/.test(PSellprice) || !/^\d*(\.\d*)?$/.test(PBaseprice)) {
			flag=4;
		}
	}
	
	
	if (flag==0) {
		if(cate=="0") {
			flag=5;
		}
	}
	
	
	if (flag==0) {
		if (brId=="0") {
			flag=6;
		}
	}
	
	
	if (flag==1) {
		alert("请保证所有的图片上传不为空!");
	}else if(flag==2) {
		alert("请保证所有的文件为jpg,gif,jpeg,bmp,png等格式!");
	}else if (flag==3) {
		alert("请保证所有的选项完整!");
	}else if (flag==4) {
		alert("价格输入有误，不能提交!");
	}else if (flag==5) {
		alert("请选择第三季分类!");
	}else if (flag==6) {
		alert("请选择所属品牌!");
	}
	
	if (flag==0) {
		$.ajaxFileUpload( {
			url : 'addGoodGoodAction',     //用于文件上传的服务器端请求地址  
			secureuri : false,            //一般设置为false  
			fileElementId : files,        //文件上传空间的id属性  <input type="file" id="file" name="file" />  
			data: {
				PName: PName,
				PDescription: PDescription,
				PBaseprice: PBaseprice,
				PMarketprice: PMarketprice,
				PSellprice: PSellprice,
				PSexrequest: PSexrequest,
				cgId: cate,
				brId: brId
			},
			dataType : 'JSON',            //返回值类型 一般设置为json  
			success : function(data, status) {
				console.log(data);
				if (data.success==false) {
					if (data.msg=="exist") {
						alert("该商品已经上架!");
					}else {
						alert("something wrong!");
					}
				}else {
					alert("上架成功!");
					$("#PNameTJ").val("");
					$("#PDescriptionTJ").val("");
					$("#PBasepriceTJ").val("");
					$("#PMarketpriceTJ").val("");
					$("#PSellpriceTJ").val("");
					$(".XQtd:gt(0)").remove();
					$(".LZtd:gt(0)").remove();
					$("#fileLZ1").val("");
					$("#fileXQ1").val("");
				}
			},
			error : function(data, status, e) {
				console.log(data);
				alert("something wrong!");
			}
		});
	}
	
}
function deleteLZBtn() {
	var l = $(".LZtd").length;
	var p = l-2;
	if (l>2) {
		var $input = "<input id='deleteLZ' type='button' value='删除' onclick='deleteLZBtn();'/>";
		$(".LZtd").eq(p).append($input);
	}
	$(".LZtd:last").remove();
}
function deleteXQBtn() {
	var l = $(".XQtd").length;
	var p = l-2;
	if (l>2) {
		var $input = "<input id='deleteXQ' type='button' value='删除' onclick='deleteXQBtn();'/>";
		$(".XQtd").eq(p).append($input);
	}
	$(".XQtd:last").remove();
}
function deleteLZGBtn() {
	var l = $(".LZtdG").length;
	var p = l-2;
	if (l>2) {
		var $input = "<input id='deleteLZG' type='button' value='删除' onclick='deleteLZGBtn();'/>";
		$(".LZtdG").eq(p).append($input);
	}
	$(".LZtdG:last").remove();
}
function deleteXQGBtn() {
	var l = $(".XQtdG").length;
	var p = l-2;
	if (l>2) {
		var $input = "<input id='deleteXQG' type='button' value='删除' onclick='deleteXQGBtn();'/>";
		$(".XQtdG").eq(p).append($input);
	}
	$(".XQtdG:last").remove();
}
function addXiangQing() {
	$("#deleteXQ").remove();
	var l = $(".XQtd").length;
	var p = l + 1;
	var $input = "<div class='XQtd'><input id='fileXQ"+p+"' name='fileXQ' type='file' />" +
			"<input id='deleteXQ' type='button' value='删除' onclick='deleteXQBtn();'/></div>";
	$(".XQtd:last").after($input);
}
function addLunzhuan() {
	$("#deleteLZ").remove();
	var l = $(".LZtd").length;
	var p = l + 1;
	var $input = "<div class='LZtd'><input id='fileLZ"+p+"' name='fileLZ' type='file' />" +
			"<input id='deleteLZ' type='button' value='删除' onclick='deleteLZBtn();'/></div>";
	$(".LZtd:last").after($input);
}
function addLunzhuanG() {
	$("#deleteLZG").remove();
	var l = $(".LZtdG").length;
	var p = l + 1;
	var $input = "<div class='LZtdG'><input id='fileLZG"+p+"' name='fileLZG' type='file' />" +
			"<input id='deleteLZG' type='button' value='删除' onclick='deleteLZGBtn();'/></div>";
	$(".LZtdG:last").after($input);
}
function addXiangQingG() {
	$("#deleteXQG").remove();
	var l = $(".XQtdG").length;
	var p = l + 1;
	var $input = "<div class='XQtdG'><input id='fileXQG"+p+"' name='fileXQG' type='file' />" +
			"<input id='deleteXQG' type='button' value='删除' onclick='deleteXQGBtn();'/></div>";
	$(".XQtdG:last").after($input);
}
function countNumJud() {
	var num = $("#countG").val().trim();
	if (!/^[1-9]d*|0$/.test(num)) {
		$("#countGP").text("请输入非负整数!");
	}else {
		$("#countGP").empty();
	}
	
}
function sellGToChese() {
	var num = $("#sellG").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#sellGP").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#sellGP").text(total);
		}
	}else {
		$("#sellGP").empty();
	}
	
}
function marketGToChese() {
	var num = $("#marketG").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#marketGP").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#marketGP").text(total);
		}
	}else {
		$("#marketGP").empty();
	}
	
}
function baseGToChese() {
	var num = $("#baseG").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#baseGP").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#baseGP").text(total);
		}
	}else {
		$("#baseGP").empty();
	}
}
function PSellpriceTJToChese() {
	var num = $("#PSellpriceTJ").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#SellPri").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#SellPri").text(total);
		}
	}else {
		$("#SellPri").empty();
	}
	
}
function PMarketpriceTJToChese() {
	var num = $("#PMarketpriceTJ").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#MktPri").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#MktPri").text(total);
		}
	}else {
		$("#MktPri").empty();
	}
}
function PBasepriceTJToChese() {
	var num = $("#PBasepriceTJ").val().trim();
	if (num!="") {
		var chiness = NoToChinese(num);
		if (chiness=="wrong") {
			$("#BasePri").text("输入的价格不合法!");
		}else {
			var total = chiness + "圆";
			$("#BasePri").text(total);
		}
	}else {
		$("#BasePri").empty();
	}
}
//JS控制阿拉伯数字转为中文大写
function NoToChinese(num) {
	if (!/^\d*(\.\d*)?$/.test(num)) { return "wrong"; }
	var AA = new Array("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖");
	var BB = new Array("", "拾", "佰", "仟", "萬", "億", "点", "");
	var a = ("" + num).replace(/(^0*)/g, "").split("."), k = 0, re = "";
	for (var i = a[0].length - 1; i >= 0; i--) {
	switch (k) {
	case 0: re = BB[7] + re; break;
	case 4: if (!new RegExp("0{4}\\d{" + (a[0].length - i - 1) + "}$").test(a[0]))
	re = BB[4] + re; break;
	case 8: re = BB[5] + re; BB[7] = BB[5]; k = 0; break;
	}
	if (k % 4 == 2 && a[0].charAt(i + 2) != 0 && a[0].charAt(i + 1) == 0) re = AA[0] + re;
	if (a[0].charAt(i) != 0) re = AA[a[0].charAt(i)] + BB[k % 4] + re; k++;
	}

	if (a.length > 1) //加上小数部分(如果有小数部分)
	{
	re += BB[6];
	for (var i = 0; i < a[1].length; i++) re += AA[a[1].charAt(i)];
	}
	return re;
} 
function ShangPinTianjiaShow() {
	$(".goodNavA").removeClass("goodNavFocus");
	$(".goodNavA").eq(3).addClass("goodNavFocus");
	$(".goodNavContain").removeClass("goodNavContainShow");
	$("#goodPut").addClass("goodNavContainShow");
}
function catGoodAut(pId) {
	//编辑商品申请表
	
	
}
function allGoodAuthShwo() {
	//获得所有的商品申请列表
	$.ajax({
		url: "listGoodAuthGoodAction",
		type: "post",
		dataType: "json",
		success: function(data) {
			if (data.success==true) {
				//有申请表
				$("#noGoodAuth").hide();
				$("#goodAuthtab").show();
				
				
				$("#goodAuthtab tbody").empty();
				var l = data.obj.length;
				for ( var i = 0; i < l; i++) {
					t = data.obj[i];
					s = data.obj1[i];
					console.log(s);
					
					
					//转化图片地址
					var index = s.indexOf("\\upload\\");
					var reg=/\\/g;//g,表示全部替换
					s = "."+s.substr(index).replace(reg,"/");
					
					
					
					//转化时间格式
					var time = new Date(t.pCreateTime).Format("yyyy-MM-dd hh:mm");
					
					
					//判断pState状态显示内容
					var state = "申请中";
					if (t.pState==0) {
						state = "未通过";
					}else if(t.pState==2) {
						state = "已通过";
					}else if (t.pState==3) {
						state = "停售";
					}
					
					
					//添加每行数据
					$tr = "<tr><td><a href='javascript:void(0);' onclick='catGoodAut("+t.pId+");'><img class='goodAthImg' src='"+s+"' alt='"+t.pName+"' title='"+t.pName+"' ></a></td>" +
							"<td>"+t.pName+"</td>" +
									"<td>"+t.adProductcategory.cgName+"</td>" +
											"<td>"+t.pDescription+"</td>" +
													"<td>"+time+"</td>" +
															"<td>"+state+"</td>" +
																	"<td><a class='listEdit catGoodBtn' title='编辑' href='javascript:void(0);' onclick='catGoodAut("+t.pId+");'></a></td></tr>";
					$("#goodAuthtab tbody").append($tr);
				}
				var h = 80;
				$(".goodAthImg").each(function(){
					//加载图片至内存，完成后执行
					//获得原始图片高宽
					var imgWidth = $(this).width();
					var imgHeight = $(this).height();
					//重新设置img的width和height
					$(this).height((50*imgHeight)/imgWidth);
					$(this).width(50);
				});
				
				
			}else {
				$("#noGoodAuth").show();
				$("#goodAuthtab").hide();
			}
		},
		error: function() {
			alert("something wrong!");
			$("#noGoodAuth").show();
			$("#goodAuthtab").hide();
		}
	});
}
function GoodBack() {
	$("#viGood").hide();
	$("#travel").show();
}
function catGood(pId) {

	//查看并编辑商品
	$("#viGood").show();
	$("#travel").hide();
	$("#noGood").hide();
	$("#LZtdGExist").empty();
	$("#XQtdGExist").empty();
	$(".LZtdG:gt(0)").remove();
	$(".XQtdG:gt(0)").remove();
	$.ajax({
		url:"viGoodAndImageGoodAction",
		data: {
			PId: pId,
		},
		dataType: "json",
		type: "post",
		success: function(data) {
			console.log(data);
			if (data.success==true) {
				var t=data.obj;
				$("#pidG").val(t.pId);
				$("#pnameG").val(t.pName);
				$("#brandG").text(t.brandAD.brName);
				$("#cateG").text(t.adProductcategory.cgName);
				$("#descriptionG").val(t.pDescription);
				$("#countG").val(t.pCount);
				$("#baseG").val(t.pBaseprice);
				$("#marketG").val(t.pMarketprice);
				$("#sellG").val(t.pSellprice);
				$("#PSexrequestG").val(t.pSexrequest);
				$("#commendG").val(t.pCommend);
				$("#cilckCountG").text(t.pClickcount);
				$("#sellCountG").text(t.pSellCount);
				var time = new Date(t.pCreateTime).Format("yyyy-MM-dd hh:mm");
				$("#createTimeG").text(time);
				$("#pStateG").val(t.pState);
				
				
				//图片显示
				if (data.msg=="success") {
					l = data.obj1.length;
					for ( var i = 0; i < l; i++) {
						var s = data.obj1[i];
						
						//转化图片地址
						var src = s.ifFilepath;
						var index = src.indexOf("\\upload\\");
						var reg=/\\/g;//g,表示全部替换
						src = "."+src.substr(index).replace(reg,"/");

						
						if (s.ifPosition==0) {
							var $img = "<img data-id='"+s.ifId+"' class='imgGoodG imgGoodLZG' alt='"+t.pName+"' src='"+src+"'>";
							$("#LZtdGExist").append($img);
						}else {
							var $img = "<img data-id='"+s.ifId+"' class='imgGoodG imgGoodXQG' alt='"+t.pName+"' src='"+src+"'>";
							$("#XQtdGExist").append($img);
						}
						
						
					}
					
					$(".imgGoodG").each(function(){
						//加载图片至内存，完成后执行
						//获得原始图片高宽
						var imgWidth = $(this).width();
						var imgHeight = $(this).height();
						//重新设置img的width和height
						$(this).height((120*imgHeight)/imgWidth);
						$(this).width(120);
						console.log(imgWidth+","+imgHeight);
					});
					
				}
				
			}else {
				alert("something wrong!");
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
	
	
}
function allGoodShwo() {
	//获得所有的商品列表
	$.ajax({
		url: "stFindGoodAction",
		type: "post",
		dataType: "json",
		success: function(data) {
			console.log(data);
			if (data.success==true) {
				$("#travel tbody").empty();
				var l = data.obj.length;
				for ( var i = 0; i < l; i++) {
					t = data.obj[i];
					s = data.obj1[i];
					console.log(s);
					
					
					//转化图片地址
					var index = s.indexOf("\\upload\\");
					var reg=/\\/g;//g,表示全部替换
					s = "."+s.substr(index).replace(reg,"/");
					
					
					
					//转化时间格式
					var time = new Date(t.pCreateTime).Format("yyyy-MM-dd hh:mm");
					
					
					//添加每行数据
					$tr = "<tr><td><a href='javascript:void(0);' onclick='catGood("+t.pId+");'><img class='goodImg' src='"+s+"' alt='"+t.pName+"' title='"+t.pName+"' ></a></td>" +
							"<td>"+t.pName+"</td>" +
									"<td>"+t.adProductcategory.cgName+"</td>" +
											"<td>"+t.pDescription+"</td>" +
													"<td>"+time+"</td>" +
															"<td>"+t.pSellprice+"</td>" +
																	"<td><a class='listEdit catGoodBtn' title='编辑' href='javascript:void(0);' onclick='catGood("+t.pId+");'></a></td></tr>";
					$("#travel tbody").append($tr);
				}
				var h = 80;
				$(".goodImg").each(function(){
					//加载图片至内存，完成后执行
					//获得原始图片高宽
					var imgWidth = $(this).width();
					var imgHeight = $(this).height();
					//重新设置img的width和height
					$(this).height((50*imgHeight)/imgWidth);
					$(this).width(50);
				});
				
				$("#viGood").hide();
				$("#noGood").hide();
				$("#travel").show();
			}else {
				$("#viGood").hide();
				$("#noGood").show();
				$("#travel").hide();
			}
			
			//添加hover样式
			$('.simpleTable tbody tr').hover(function() {
			  $(this).addClass('odd');
			}, function() {
			  $(this).removeClass('odd');
			});
		},
		error: function() {
			alert("something wrong!");
		}
	});
	
}
//格式化Timestamp，转化为Date类型
Date.prototype.Format = function (fmt) { //
    var o = {
        "M+": this.getMonth() + 1, //Month
        "d+": this.getDate(), //Day
        "h+": this.getHours(), //Hour
        "m+": this.getMinutes(), //Minute
        "s+": this.getSeconds(), //Second
        "q+": Math.floor((this.getMonth() + 3) / 3), //Season
        "S": this.getMilliseconds() //millesecond
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + 

"").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, 

(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
function PPEditSub() {
	TopHide();
	var brId = $("#brIdXG").val();
	var brName =$("#brNameXG").val();
	var brEngName = $("#brEngNameXG").val();
	var brDiscription = $("#upBrTextXG").val();
	$.post("updateBrSt",{brId:brId,brName:brName,brEngName:brEngName,brDiscription:brDiscription},function() {
		brandListShow();
	});
}
function PinPaiEdit(int) {
	var brState = $(".brStateVal").eq(int).data("state");
	if (brState=="4") {
		$(".shadow").show();
		$("#ppsqbj").show();
		var brId = $(".srBrEdit").eq(int).attr("id");
		var brNameVal = $(".brNameVal").eq(int).text();
		var brEngNameVal = $(".brEngNameVal").eq(int).text();
		var brDiscriptionVal = $(".brDiscriptionVal").eq(int).text();
		$("#brIdXG").val(brId);
		$("#brNameXG").val(brNameVal);
		$("#brEngNameXG").val(brEngNameVal);
		$("#upBrTextXG").val(brDiscriptionVal);
	}else {
		alert("审核未通过才能编辑!");
	}
}
function PinPaiSub() {
	var brName = $("#brNameTJ").val();
	var brEngName = $("#brEngNameTJ").val();
	var brDiscription = $("#upBrText").val();
	$.post("addBrandStore",{brName:brName,brEngName:brEngName,brDiscription:brDiscription},function(data) {
		if(data.success==true) {
			brandListShow();
			TopHide();
		}else {
			alert("添加失败!");
		}
	},"json");
}
function TopHide() {
	$(".topFrame").hide();
	$(".shadow").hide();
}
function PinPaiTianJia() {
	$(".shadow").show();
	$("#ppsqtj").show();
}
function closeStoreTag(){
	if($(".storeTagBox").length==1){
		alert("标签数必须大于等于1！");
	}else {
		this.remove();
		var k = $(".storeTagBox").length;
		for(var i=0;i<k;i++) {
			if($(".storeTagBox").eq(i).children().length==1) {
				$(".storeTagBox").eq(i).remove();
			}
		}
	}
}
function addStoreTag() {
	$("#addStoreTag").before($(".storeTagBox").eq(0).clone(true));
	var last = $(".storeTagBox").length -1;
	$(".storeTag_edit").eq(last).val("");
}
function setClick() {
	setInfornation();
	$("#manage_set_dl").hide();
	$("#manage_set_dlSet").show();
}
//编辑完成发送信息
function finishClick() {
	var storeName = $.trim($("#storeName_edit").val());
	var StoreTag = "";
	for(var i=0;i<$(".storeTagBox").length;i++) {
		if($.trim($(".storeTag_edit").eq(i).val())==null || $.trim($(".storeTag_edit").eq(i).val())=="") {
			StoreTag = StoreTag;
		} else {
			if($.trim(StoreTag)==null||$.trim(StoreTag)==""){
				StoreTag = $.trim($(".storeTag_edit").eq(i).val());
			} else {
				StoreTag = StoreTag + "/" + $.trim($(".storeTag_edit").eq(i).val());
			}
		}
	}
	$.post("editStore",{storeName:storeName,StoreTag:StoreTag} ,function() {
		$("#storeName").empty();
		$("#storeName").append($("<p></p>").text(storeName));
		$("#storeTag").empty();
		$("#storeTag").append($("<p></p>").text(StoreTag));
	});
	$("#storeName_value").val("");
	$("#storeName_edit").val("");
	$("#storeTag_value").val("");
	$(".storeTagBox").eq(0).nextAll(".storeTagBox").remove();
	$("#storeName_value").val(storeName);
	$("#storeName_edit").val(storeName);
	$("#storeTag_value").val(StoreTag);
	$("#manage_set_dlSet").hide();
	$("#manage_set_dl").show();
	setInfornation();
}
function loadLeft() {
	var scrNum = $(window).scrollLeft();
	var scrNumFu = 0 - scrNum;
	$(".list_wrap").css("left",scrNumFu);
}
function scrollTOLeft() {
	var scrNum = $(window).scrollLeft();
	var scrNumFu = 0 - scrNum;
	$(".list_wrap").css("left",scrNumFu);
}
function addOut() {
	$(".add_bar").removeClass("addOver");
}
function addOver() {
	$(".add_bar").addClass("addOver");
}
function editOut() {
	$(".edit_bar").removeClass("editOver");
}
function editOver() {
	$(".edit_bar").addClass("editOver");
}
function selected1() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_home").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".home_show").show();
}
function selected2() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_good").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_good").show();
	allGoodShwo();
}
function selected3() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_order").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_order").show();
}
function selected4() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_comment").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_comment").show();
}
function selected5() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_ad").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_ad").show();
}
function selected6() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_fiance").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_finance").show();
}
function selected7() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_refund").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_refund").show();
}
function selected8() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_set").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_set").show();
	if($("#manage_set_dl").css("display")=="none") {
		$("#manage_set_dlSet").hide();
		$("#manage_set_dl").show();
		setInfornation();
	} else {
		setInfornation();
	}
}
function setInfornation () {
	$.post("selectStore", function (data){
		console.log(data);
		var text = $("<p></p>").text(data.store.stName);
		$("#storeName").empty();
		$("#storeName").append(text);
		$("#storeTag").empty();
		$("#storeTag").append($("<p></p>").text(data.store.stTag));
		$("#storeStart").empty();
		$("#storeStart").append($("<p></p>").text(data.store.stCreateTime.substr(0,10)));
		$("#storeEnd").empty();
		$("#storeEnd").append($("<p></p>").text(data.store.stEndTime.substr(0,10)));
		$("#storeName_value").val("");
		$("#storeName_edit").val("");
		$("#storeTag_value").val("");
		$("#storeStart_value").val("");
		$("#storeEnd_value").val("");
		$("#storeName_value").val(data.store.stName);
		$("#storeName_edit").val(data.store.stName);
		$("#storeTag_value").val(data.store.stTag);
		$("#storeStart_value").val(data.store.stCreateTime.substr(0,10));
		$("#storeEnd_value").val(data.store.stEndTime.substr(0,10));
		tagShow();
	});
}
//店铺标签显示
function tagShow() {
	var arr = new Array();
	arr = $("#storeTag_value").val().split("/");
	$("#countStoreTag").val(arr.length);
	var n = $(".storeTagBox").length;
	for (var i=0;i<arr.length;i++) {
		$("#addStoreTag").before($(".storeTagBox").eq(0).clone(true));
		var last = $(".storeTagBox").length -1;
		$(".storeTag_edit").eq(last).val(arr[i]);
	}
	$(".storeTagBox").eq(n).prevAll().remove();
}
function selected9() {
	$(".list_item").removeClass("mer_list_selected");
	$("#list_brand").addClass("mer_list_selected");
	$(".mer_left_wrap").hide();
	$(".manage_brand").show();
	brandListShow();
}
function brandListShow(){
	$.post("stListBr",function(data) {
		$("#brandAuthWrap").empty();
		if (data.success==true) {
			var length = data.obj.length;
			for ( var int = 0; int < length; int++) {
				var brState = "未通过";
				if (data.obj[int].brState==0) {
					brState = "停售";
				}else if (data.obj[int].brState==1) {
					brState = "正常";
				}else if (data.obj[int].brState==2) {
					brState = "促销";
				}else if (data.obj[int].brState==3) {
					brState = "开通中";
				}else if (data.obj[int].brState==4) {
					brState = "未通过";
				}
				var time = new Date(data.obj[int].brApplyTime).Format("yyyy-MM-dd hh:mm");
				var $tr = "<tr><td class='brNameVal'>"+data.obj[int].brName+"</td>" +
						"<td class='brEngNameVal'>"+data.obj[int].brEngName+"</td>" +
								"<td class='brDiscriptionVal'>"+data.obj[int].brDiscription+"</td>" +
										"<td class='brApplyTimeVal'>"+time+"</td>" +
											"<td data-state='"+data.obj[int].brState+"' class='brStateVal'>"+brState+"</td>" +
												"<td><a id='"+data.obj[int].brId+"' data-row='"+int+"' class='listEdit srBrEdit' title='编辑' href='javascript:void(0);' onclick='PinPaiEdit("+int+");'></a></td></tr>";
				$("#brandAuthWrap").append($tr);
			}
		}
	},"json");
}
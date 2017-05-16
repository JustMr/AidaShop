$(document).ready(function(){
	GetFirstMenu();
	$(".cateAdd").on("click",AddCate);
});
function GetFirstMenu() {
	//获取第一级菜单
	$.post("listLvOnePCategoryAction",function(data) {
		var length = data.obj.length;
		var position = 0;
		for ( var int = 0; int < length; int++) {
			//生成相应行
			position = data.obj[int].cgPosition;
			realpost = position-1;
			var row = $(".firstRow").length;
			if (row<position) {
				var newrow = position-row;
				for ( var int2 = 0; int2 < newrow; int2++) {
					var $div = "<div class='firstRow'></div>";
					$("#menuFirst").append($div);
				}
			}
			//在相应行生成相应列
			var col = $(".firstRow").eq(realpost).find(".firstRowItem").length;
			state = data.obj[int].cgState;
			realstate = state-1;
			if (state>0) {
				if(col<state) {
					var newcol = state-col;
					for ( var int3 = 0; int3 < newcol; int3++) {
						var $a = "<a  class='firstRowItem' href='javascript:void(0);' onclick='ShowSecond();'></a>";
						$(".firstRow").eq(realpost).append($a);
					}
				}
				$(".firstRow").eq(realpost).find(".firstRowItem").eq(realstate).text(data.obj[int].cgName);
				$(".firstRow").eq(realpost).find(".firstRowItem").eq(realstate).attr("id",data.obj[int].cgId);
			}
		}
	},"json");
}
function ShowSecond() {
	//显示二级商品分类内容
	var cgname = $(".firstRowItem:focus").text();
	$(".firstRowItem").removeClass("firstRowItemFocus");
	$(".firstRowItem:focus").addClass("firstRowItemFocus");
	$.post("listLvTowOrThreePCategoryAction",{cgName:cgname},function(data){
		if(data.success==true){
			var length = data.obj.length;
			$("#menuSecond").empty();
			$("#menuThird").empty();
			for ( var int = 0; int < length; int++) {
				var $a = "<a id='"+ data.obj[int].cgId +"' class='secondRowItem' href='javascript:void(0);' onclick='ShowThird();'>"+ data.obj[int].cgName +"</a>";
				$("#menuSecond").append($a);
			}
		}else {
			$("#menuSecond").empty();
			$("#menuThird").empty();
		}
		
	},"json");
}
function ShowThird() {
	//显示三级分类内容
	var cgname = $(".secondRowItem:focus").text();
	$(".secondRowItem").removeClass("secondRowItemFocus");
	$(".secondRowItem:focus").addClass("secondRowItemFocus");
	$.post("listLvTowOrThreePCategoryAction",{cgName:cgname},function(data){
		if(data.success==true){
			var length = data.obj.length;
			$("#menuThird").empty();
			for ( var int = 0; int < length; int++) {
				var $a = "<a id='"+ data.obj[int].cgId +"' class='thirdRowItem' href='javascript:void(0);' onclick='actThird();'>"+ data.obj[int].cgName +"</a>";
				$("#menuThird").append($a);
			}
		}else {
			$("#menuThird").empty();
		}
	},"json");
}
function actThird() {
	var cgname = $(".thirdRowItem:focus").text();
	$(".thirdRowItem").removeClass("thirdRowItemFocus");
	$(".thirdRowItem:focus").addClass("thirdRowItemFocus");
}
function AddCate() {
	//点击添加按钮，在相应位置添加input
	var id = $(this).attr("id");
	console.log(id);
	if(id=="firstAdd") {
		var menuFirInp = $("#menuFirInp");
		var foucs = $(".firstRowItemFocus");
		if(foucs.length>0) {
			//一级分类选中
			if(menuFirInp.length==0) {
				var $input = "<div id='firAddDiv'><input id='menuFirInp' name='cgName' />" +
						"<a id='addIcon1' class='addIcon' href='javascript:void(0);' onclick='addSub(1);'></a>" +
						"<a id='cancelIcon1' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(1);'></a></div>";
				//获取选中元素所在行，所在列
				var hidePosition1 = $(".firstRowItemFocus").parent().index(".firstRow");
				var hideState1 = $(".firstRowItemFocus").index();
				$("#hidePosition1").val(hidePosition1);
				$("#hideState1").val(hideState1);
				console.log("hide1:"+hidePosition1+","+hideState1);
				foucs.after($input);
			}
		}else {
			//一级分类未选中
			if(menuFirInp.length==0) {
				var row = $(".firstRow").length;
				if(row>0) {
					//一级分类非空
					var $input = "<div id='firAddDiv'><input id='menuFirInp' name='cgName' />" +
						"<a id='addIcon1' class='addIcon' href='javascript:void(0);' onclick='addSub(1);'></a>" +
						"<a id='cancelIcon1' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(1);'></a></div>";
					//获取选中元素所在行，所在列
					var hidePosition1 = $("#menuFirst").children(".firstRow").length-1;
					var hideState1 = $(".firstRow:last").children(".firstRowItem").length-1;
					$("#hidePosition1").val(hidePosition1);
					$("#hideState1").val(hideState1);
					console.log("hide1:"+hidePosition1+","+hideState1);
					$(".firstRowItem:last").after($input);
				}else {
					//一级分类为空
					var $div = "<div id='firAddDiv4' class='firstRow'>" +
						"<div id='firAddDiv'><input id='menuFirInp' name='cgName' />" +
						"<a id='addIcon1' class='addIcon' href='javascript:void(0);' onclick='addSub(1);'></a>" +
						"<a id='cancelIcon1' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(4);'></a></div></div>";
					$("#hidePosition1").val(0);
					$("#hideState1").val(0);
					$("#menuFirst").append($div);
				}
			}
		}
	}else if (id=="secondAdd") {
		var menuSecInp = $("#menuSecInp");
		var foucs = $(".firstRowItemFocus");
		var foucs1 = $(".secondRowItemFocus");
		if(foucs1.length>0 && foucs.length>0) {
			//一级、二级菜单就选中
			if(menuSecInp.length==0) {
				var $input1 = "<div id='secAddDiv'><input id='menuSecInp' name='cgName' />" +
						"<a id='addIcon2' class='addIcon' href='javascript:void(0);' onclick='addSub(2);'></a>" +
						"<a id='cancelIcon2' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(2);'></a></div>";
				var hidePosition2 = $(".secondRowItemFocus").index();
				$("#hidePosition2").val(hidePosition2);
				console.log("hide2:"+hidePosition2);
				foucs1.after($input1);
			}
		}else if(foucs1.length==0 && foucs.length>0) {
			//一级选中、二级未未选中
			if(menuSecInp.length==0) {
				var $input1 = "<div id='secAddDiv'><input id='menuSecInp' name='cgName' />" +
						"<a id='addIcon2' class='addIcon' href='javascript:void(0);' onclick='addSub(2);'></a>" +
						"<a id='cancelIcon2' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(2);'></a></div>";
				var hidePosition2 = $(".secondRowItem").length-1;
				$("#hidePosition2").val(hidePosition2);
				console.log("hide2:"+hidePosition2);
				$("#menuSecond").append($input1);
			}
		}else if(foucs.length==0) {
			//一级未选中
			alert("创建二级分类时请将一级分类选中！");
		}
	}else {
		var menuTrdInp = $("#menuTrdInp");
		var foucs = $(".firstRowItemFocus");
		var foucs1 = $(".secondRowItemFocus");
		var foucs2 = $(".thirdRowItemFocus");
		if (foucs2.length>0 && foucs1.length>0 && foucs.length>0) {
			//一、二、三级均选中
			if(menuTrdInp.length==0) {
				var $input2 = "<div id='thirdAddDiv'><input id='menuTrdInp' name='cgName' />" +
						"<a id='addIcon3' class='addIcon' href='javascript:void(0);' onclick='addSub(3)';></a>" +
						"<a id='cancelIcon3' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(3);'></a></div>";
				var hidePosition3 = $(".thirdRowItemFocus").index();
				$("#hidePosition3").val(hidePosition3);
				console.log("hide3:"+hidePosition3);
				foucs2.after($input2);
			}
		}else if(foucs2.length==0 && foucs1.length>0 && foucs.length>0) {
			//一、二级选中，三级未选中
			if(menuTrdInp.length==0) {
				var $input2 = "<div id='thirdAddDiv'><input id='menuTrdInp' name='cgName' />" +
						"<a id='addIcon3' class='addIcon' href='javascript:void(0);' onclick='addSub(3)';></a>" +
						"<a id='cancelIcon3' class='cancelIcon' href='javascript:void(0);' onclick='cancelSub(3);'></a></div>";
				var hidePosition3 = $(".thirdRowItem").length-1;
				$("#hidePosition3").val(hidePosition3);
				console.log("hide3:"+hidePosition3);
				$("#menuThird").append($input2);
			}
		}else if(foucs1.length==0 || foucs.length==0) {
			//一级或二级分类未选中
			alert("创建三级分类时请将一级或二级分类都选中！");
		}
	}
}
function upwardSub(i) {
	//上移
	if(i==1) {
		var foucs = $(".firstRowItemFocus");
		if(foucs.length>0) {
			var sib = foucs.siblings().length;
			var cow = $(".firstRow").length;
			var position = $(".firstRowItemFocus").parent().index(".firstRow")+1;
			console.log("sib,cow,position:"+sib+","+cow+","+position);
			var only = 0;
			if (sib==0&&cow>position) {
				//当前行仅剩一个且非最后一行
				only = 1;
			}
			var id = foucs.attr("id");
			$.post("upwardPCategoryAction",{cgId:id,count:1,only:only},function (data) {
				if (data.msg=="top") {
					alert("已经到达地第一个位置！");
				}else {
					$("#menuFirst").empty();
					GetFirstMenu();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}else if(i==2) {
		var foucs1 = $(".secondRowItemFocus");
		if(foucs1.length>0) {
			var id = foucs1.attr("id");
			$.post("upwardPCategoryAction",{cgId:id,count:2},function (data) {
				if (data.msg=="top") {
					alert("已经到达地第一个位置！");
				}else {
					showSecondNoActSecond();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}else if(i==3) {
		var foucs2 = $(".thirdRowItemFocus");
		if(foucs2.length>0) {
			var id = foucs2.attr("id");
			$.post("upwardPCategoryAction",{cgId:id,count:3},function (data) {
				if (data.msg=="top") {
					alert("已经到达地第一个位置！");
				}else {
					showThirdNoActSecond();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}
}
function downwardSub(i) {
	//下移
	if(i==1) {
		var foucs = $(".firstRowItemFocus");
		if(foucs.length>0) {
			var id = foucs.attr("id");
			$.post("downwardPCategoryAction",{cgId:id,count:1},function (data) {
				if (data.msg=="bottom") {
					alert("已经到达最后一个位置！");
				}else {
					$("#menuFirst").empty();
					GetFirstMenu();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}else if(i==2) {
		var foucs1 = $(".secondRowItemFocus");
		if(foucs1.length>0) {
			var id = foucs1.attr("id");
			$.post("downwardPCategoryAction",{cgId:id,count:2},function (data) {
				if (data.msg=="bottom") {
					alert("已经到达最后一个位置！");
				}else {
					showSecondNoActSecond();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}else if(i==3) {
		var foucs2 = $(".thirdRowItemFocus");
		if(foucs2.length>0) {
			var id = foucs2.attr("id");
			$.post("downwardPCategoryAction",{cgId:id,count:3},function (data) {
				if (data.msg=="bottom") {
					alert("已经到达最后一个位置！");
				}else {
					showThirdNoActSecond();
				}
			},"json");
		}else {
			alert("请选中需要移动的分类！");
		}
	}
}
function cancelSub(i) {
	//取消添加分类，移除input
	if(i==1) {
		$("#firAddDiv").remove();
	}else if(i==4) {
		$("#firAddDiv4").remove();
	}else if (i==2) {
		$("#secAddDiv").remove();
	}else if (i==3) {
		$("#thirdAddDiv").remove();
	}
}
function renameSub(i) {
	//重命名标签，添加重命名input
	if (i==1) {
		var foucs = $(".firstRowItemFocus");
		var menuFirInp = $("#menuFirInp");
		if(foucs.length>0) {
			if(menuFirInp.length==0) {
				var $input = "<div id='firAddDiv'><input id='menuFirInp' name='cgName' value='"+ foucs.text() +"'/>" +
						"<a id='addIcon1' class='addIcon' href='javascript:void(0);' onclick='ReNameCmit(1);'></a>" +
						"<a id='cancelIcon1' class='cancelIcon' href='javascript:void(0);' onclick='cancelCmit(1);'></a></div>";
				foucs.css("display","none");
				foucs.after($input);
			}
		}else {
			alert("请选中需要重命名的分类标签");
		}
	}else if (i==2) {
		var foucs1 = $(".secondRowItemFocus");
		var menuSecInp = $("#menuSecInp");
		if(foucs1.length>0) {
			if(menuSecInp.length==0) {
				var $input1 = "<div id='secAddDiv'><input id='menuSecInp' name='cgName' value='"+ foucs1.text() +"'/>" +
						"<a id='addIcon2' class='addIcon' href='javascript:void(0);' onclick='ReNameCmit(2);'></a>" +
						"<a id='cancelIcon2' class='cancelIcon' href='javascript:void(0);' onclick='cancelCmit(2);'></a></div>";
				foucs1.css("display","none");
				foucs1.after($input1);
			}
		}else {
			alert("请选中需要重命名的分类标签");
		}
	}else if (i==3) {
		var foucs2 = $(".thirdRowItemFocus");
		var menuTrdInp = $("#menuTrdInp");
		if(foucs2.length>0) {
			if(menuTrdInp.length==0) {
				var $input2 = "<div id='thirdAddDiv'><input id='menuTrdInp' name='cgName' value='"+ foucs2.text() +"'/>" +
						"<a id='addIcon3' class='addIcon' href='javascript:void(0);' onclick='ReNameCmit(3);'></a>" +
						"<a id='cancelIcon3' class='cancelIcon' href='javascript:void(0);' onclick='cancelCmit(3);'></a></div>";
				foucs2.css("display","none");
				foucs2.after($input2);
			}
		}else {
			alert("请选中需要重命名的分类标签");
		}
	}
}
function ReNameCmit(i) {
	//重命名标签提交新标签名
	if(i==1) {
		var id = $(".firstRowItemFocus").attr("id");
		var cgname = $("#menuFirInp").val().trim();
		$.post("renamePCategoryAction",{cgId:id,cgName:cgname},function(data) {
			if(data.success==true) {
				$("#menuFirst").empty();
				GetFirstMenu();
			}else {
				alert("插入失败");
			}
		},"json");
	}else if (i==2) {
		var id1 = $(".secondRowItemFocus").attr("id");
		var cgname = $("#menuSecInp").val().trim();
		$.post("renamePCategoryAction",{cgId:id1,cgName:cgname},function(data) {
			if(data.success==true) {
				showSecondNoActSecond();
			}else {
				alert("插入失败，该分类已存在或无需修改");
			}
		},"json");
	}else if (i==3) {
		var id2 = $(".thirdRowItemFocus").attr("id");
		var cgname = $("#menuTrdInp").val().trim();
		$.post("renamePCategoryAction",{cgId:id2,cgName:cgname},function(data) {
			if(data.success==true) {
				showThirdNoActSecond();
			}else {
				alert("插入失败，该分类已存在或无需修改");
			}
		},"json");
	}
}
function cancelCmit(i) {
	if(i==1) {
		$(".firstRowItemFocus").css("display","inline-block");
		$("#firAddDiv").remove();
	}else if (i==2) {
		$(".secondRowItemFocus").css("display","block");
		$("#secAddDiv").remove();
	}else if (i==3) {
		$(".thirdRowItemFocus").css("display","block");
		$("#thirdAddDiv").remove();
	}
}
function addSub(i) {
	//提交分类input内容
	if(i==1) {
		var text1 = $("#menuFirInp").val().trim();
		var position = parseInt($("#hidePosition1").val())+1;
		var state = parseInt($("#hideState1").val())+2;
		console.log("position:"+position);
		$.post("addPCategoryAction",{cgName:text1,count:1,cgPosition:position,cgState:state},function(data){
			if(data.success==true) {
				$("#menuFirst").empty();
				GetFirstMenu();
			}else {
				alert("添加失败！");
			}
		},"json");
	}else if (i==2) {
		var text2 = $("#menuSecInp").val().trim();
		var pid = $(".firstRowItemFocus").attr("id");
		var position = parseInt($("#hidePosition2").val())+2;
		console.log("position:"+position);
		$.post("addPCategoryAction",{cgName:text2,count:2,cgPid:pid,cgPosition:position},function(data) {
			if(data.success==true) {
				showSecondNoActSecond();
			}else {
				alert("添加失败！");
			}
		},"json");
	}else if(i==3) {
		var text3 = $("#menuTrdInp").val().trim();
		var pid = $(".secondRowItemFocus").attr("id");
		var position = parseInt($("#hidePosition3").val())+2;
		console.log("position:"+position);
		$.post("addPCategoryAction",{cgName:text3,count:3,cgPid:pid,cgPosition:position},function(data) {
			if(data.success==true) {
				showThirdNoActSecond();
			}else {
				alert("添加失败！");
			}
		},"json");
	}
}
function deleteSub(i) {
	console.log(i);
	//删除选中的标签
	if(i==1) {
		var firstItem = $(".firstRowItemFocus");
		if(firstItem.length>0) {
			var id = firstItem.attr("id");
			$.post("deletePCategoryAction",{count:1,cgId:id},function(data){
				if(data.success==true) {
					$("#menuFirst").empty();
					GetFirstMenu();
				}else {
					alert("删除失败！");
				}
			},"json");
		}else {
			alert("请选中需要删除的商品分类！");
		}
	}else if (i==2) {
		var secondItem = $(".secondRowItemFocus");
		if(secondItem.length>0) {
			var id = secondItem.attr("id");
			$.post("deletePCategoryAction",{count:2,cgId:id},function(data) {
				if (data.success==true) {
					showSecondNoActSecond();
				}else {
					alert("删除失败！");
				}
			},"json");
		}else {
			alert("请选中需要删除的商品分类！");
		}
	}else if(i==3) {
		var thirdItem = $(".thirdRowItemFocus");
		if(thirdItem.length>0) {
			var id = thirdItem.attr("id");
			$.post("deletePCategoryAction",{count:3,cgId:id},function(data) {
				if(data.success==true) {
					showThirdNoActSecond();
				}else {
					alert("删除失败！");
				}
			},"json");
		}else {
			alert("请选中需要删除的商品分类！");
		}
	}
}
function showSecondNoActSecond() {
	//无需再次点击第一级显示二级分类
	var pid = $(".firstRowItemFocus").attr("id");
	$.post("listLvTowOrThreeByPIDPCategoryAction",{cgPid:pid},function(data){
		if(data.success==true){
			var length = data.obj.length;
			$("#menuSecond").empty();
			$("#menuThird").empty();
			for ( var int = 0; int < length; int++) {
				var $a = "<a id='"+ data.obj[int].cgId +"' class='secondRowItem' href='javascript:void(0);' onclick='ShowThird();'>"+ data.obj[int].cgName +"</a>";
				$("#menuSecond").append($a);
			}
		}else {
			$("#menuSecond").empty();
			$("#menuThird").empty();
		}
		
	},"json");
}
function showThirdNoActSecond() {
	//无需再次点击第二级显示三级分类
	var pid = $(".secondRowItemFocus").attr("id");
	$.post("listLvTowOrThreeByPIDPCategoryAction",{cgPid:pid},function(data){
		if(data.success==true){
			var length = data.obj.length;
			$("#menuThird").empty();
			for ( var int = 0; int < length; int++) {
				var $a = "<a id='"+ data.obj[int].cgId +"' class='thirdRowItem' href='javascript:void(0);' onclick='actThird();'>"+ data.obj[int].cgName +"</a>";
				$("#menuThird").append($a);
			}
		}else {
			$("#menuThird").empty();
		}
	},"json");
}
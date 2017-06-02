$(function (){
	$.ajax({
		url: "listLvOnePCategoryAction",
		type: "post",
		dataType: "json",
		success: function(data) {
			var l = data.obj.length;
			var c = new Array("&#xe743;","&#xe618;","&#xe73f;","&#xe608;","&#xe681;","&#xe639;",
					"&#xe600;","&#xe73c;","&#xe60f;","&#xe610;","&#xe634;");
			for ( var i = 0; i < l; i++) {
				var t = data.obj[i];
				var m = $(".firstMenuItem").length;
				var n = t.cgPosition - m;
				//添加一级分类的行
				for ( var j = 0; j < n; j++) {
					var $li = "<li class='firstMenuItem'><h3>" +
					"<i class='iconFirstMenu iconfont'></i></h3>" +
							"<div class='secondMenu'></div></li>";
					$(".fistMenu").append($li);
				}
				//添加一级菜单里每一项添加到行中
				var o = t.cgPosition - 1;
				var p = $(".firstMenuItem").eq(o).find("h3 a").length;
				var q = t.cgState - p;
				for ( var k = 0; k < q; k++) {
					var $a = "<a class='firstMenuItemA' href='searchresult.jsp?cgId="+t.cgId+"&lv=1'>";
					$(".firstMenuItem").eq(o).find("h3").append($a);
				}
				//添加第一级具体项中内容
				var s = t.cgState - 1;
				$(".firstMenuItem").eq(o).find("h3 a").eq(s).attr("id",t.cgId);
				$(".firstMenuItem").eq(o).find("h3 a").eq(s).attr("data-id",t.cgId);
				$(".firstMenuItem").eq(o).find("h3 a").eq(s).text(t.cgName);
				//添加第二级菜单
				$.ajax({
					url:"listLvTowOrThreePCategoryAction",
					type:"post",
					data:{cgId:t.cgId},
					dataType: "json",
					async: false,
					success:function(data1){
						if(data1.success==true) {
							var l1 = data1.obj.length;
							for ( var i1 = 0; i1 < l1; i1++) {
								var t1 = data1.obj[i1];
								$div = "<div class='secondMenuItem'>" +
										"<a class='secondItemATit' data-id='"+t1.cgId+"' href='searchresult.jsp?cgId="+t1.cgId+"&lv=2'>"+t1.cgName+"<i>  &gt;</i></a></div>";
								$(".secondMenu").eq(o).append($div);
								//添加第三季菜单
								$.ajax({
									url: "listLvTowOrThreePCategoryAction",
									type: "post",
									data: {cgId:t1.cgId},
									dataType: "json",
									async: false,
									success:function(data2) {
										if(data2.success==true) {
											var l2 = data2.obj.length;
											for ( var i2 = 0; i2 < l2; i2++) {
												var t2 = data2.obj[i2];
												$a1 = "<a class='secondItemA' data-id='"+t2.cgId+"' href='searchresult.jsp?cgId="+t2.cgId+"&lv=3'>"+t2.cgName+"</a>";
												$(".secondMenu").eq(o).find(".secondMenuItem:last").append($a1);
											}
										}
									},
									error: function() {
										alert("something wrong!");
									}
								});
							}
						}
					},
					error:function(){
						alert("something wrong!");
					}
				});
			}
			//添加图标
			var b = $(".firstMenuItem").length;
			for ( var k = 0; k < b; k++) {
				$(".iconFirstMenu").eq(k).append(c[k]);
			}
			//添加顿号
			for ( var int = 0; int < l; int++) {
				var t = data.obj[int];
				var o = t.cgPosition - 1;
				var s = t.cgState - 1;
				var last = $(".firstMenuItem").eq(o).find("h3").children("a").length;
				if(last!=t.cgState) {
					$(".firstMenuItem").eq(o).find("h3 a").eq(s).after("、");
				}
			}
			//二级显示和隐藏
			$(".firstMenuItem").each(function (){
				$(this).mouseover(function(){
					$(this).addClass("listshow");
				});
				$(this).mouseout(function(){
					$(this).removeClass("listshow");
				});
			});
		},
		error: function() {
			alert("something wrong!");
		}
	});
});
var flag = 0;
$(document).ready(function() {
	$("#like_icon").on("click",likeSet);
	$("#hate_icon").on("click",hateSet);
	judLike();
	judHate();
});
function likeSet() {
	var arId = $("#arId").val().trim();
	if (flag==1) {
		flag=0;
		if ($(".arcicon:eq(0)").hasClass("likeActive")) {
			//已点赞,取消点赞
			$.ajax({
				url: "cancelikeDesignerAction",
				data: {
					arId: arId,
				},
				dataType: "json",
				type: "post",
				success: function(data) {
					if (data.success==true) {
						$("#like_icon").removeClass("likeActive");
					}
					flag=1;
				},
				error: function() {
					alert("something wrong!");
				}
			});
		}else {
			//未点赞,进行点赞
			$.ajax({
				url: "likeDesignerAction",
				data: {
					arId: arId,
				},
				dataType: "json",
				type: "post",
				success: function(data) {
					if (data.success==true) {
						$("#like_icon").addClass("likeActive");
					}
					flag=1;
				},
				error: function() {
					alert("something wrong!");
				}
			});
		}
	}else if (flag==2) {
		alert("请先登录!");
	}
	
}
function hateSet() {
	var arId = $("#arId").val().trim();
	if (flag==1){
		flag=0;
		if ($(".arcicon:eq(1)").hasClass("hateActive")) {
			//已hate,取消hate
			$.ajax({
				url: "cancelHateDesignerAction",
				data: {
					arId: arId,
				},
				dataType: "json",
				type: "post",
				success: function(data) {
					if (data.success==true) {
						$("#hate_icon").removeClass("hateActive");
					}
					flag=1;
				},
				error: function() {
					alert("something wrong!");
				}
			});
		}else {
			//未hate,进行hate
			$.ajax({
				url: "hateDesignerAction",
				data: {
					arId: arId,
				},
				dataType: "json",
				type: "post",
				success: function(data) {
					if (data.success==true) {
						$("#hate_icon").addClass("hateActive");
					}
					flag=1;
				},
				error: function() {
					alert("something wrong!");
				}
			});
		}
	}else if (flag==2) {
		alert("请先登录!");
	}
}
function judLike() {
	var arId = $("#arId").val().trim();
	$.ajax({
		url: "judLikeDesignerAction",
		data: {
			arId: arId,
		},
		dataType: "json",
		type: "post",
		success: function(data) {
			if (data.success==true) {
				$("#like_icon").addClass("likeActive");
				flag=1;
			}else {
				if (data.msg=="unfind") {
					flag=1;
				}else {
					flag=2;
				}
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
function judHate() {
	var arId = $("#arId").val().trim();
	$.ajax({
		url: "judHateDesignerAction",
		data: {
			arId: arId,
		},
		dataType: "json",
		type: "post",
		success: function(data) {
			if (data.success==true) {
				$("#hate_icon").addClass("hateActive");
				flag=1;
			}else {
				if (data.msg=="unfind") {
					flag=1;
				}else {
					flag=2;
				}
			}
		},
		error: function() {
			alert("something wrong!");
		}
	});
}
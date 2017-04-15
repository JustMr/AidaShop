$(document).ready(function() {
	$(document).on("keypress",keyEnter);
});
function keyEnter(event) {
	e = event?event:(window.event?windiw.event:null);
	var code = e.keyCode;
	if(13 == code) {
		logincheck();
	}
}
function logincheck() {
	var username = $("#loginname");
	var pwd = $("#signpwd");
	var meserrorul = $("#meserrorul");
	
	if(username.val()==""||username.val()==null) {
		var text = $("<li></li>").text("账号不能为空");
		meserrorul.empty();
		meserrorul.append(text);
		meserrorul.attr("display","block");
		
		return false;
	} else if(pwd.val()==""||pwd.val()==null) {
		var text1 = $("<li></li>").text("密码不能为空");
		meserrorul.empty();
		meserrorul.append(text1);
		meserrorul.attr("display","block");
		
		return false;
	} else {
		$.post("login",{username:username.val(),password:pwd.val()},function(data){
			var role = data;
			if(role=="success" || role=="superAdmin" || role=="storeAdmin") {
				//获取最近登录时间,写入session,添加本次日志
				$.post("setnearLogAction",function() {
					if(role=="success"){
						console.log(role);
						window.location=("home.jsp");
					}else if(role=="superAdmin") {
						console.log(role);
						window.location=("page/backstage/backHome.jsp");
					}else if(role=="storeAdmin"){
						console.log(role);
						window.location=("page/backstage/backMerchant.jsp");
					}else{
						console.log(role);
						var text2 = $("<li></li>").text("账号或密码错误");
						meserrorul.empty();
						meserrorul.append(text2);
						meserrorul.attr("display","block");
						console.log("ajax error");
						return false;
					}
				});
			}
		});
	}
}
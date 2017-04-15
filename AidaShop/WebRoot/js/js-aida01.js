/**
 * Created by Liu Shuangbo on 2016/11/21.
 */
/*register.jsp 邮箱、电话号码正则判断*/
var regidinp = document.getElementById("regidinp");
regidinp.onpropertychange = regidinp.oninput = regidinp.onchange = function () {
	var patt0 = /^\w+@\w+(\.\w+)+$/;	//邮箱正则判断
	var patt1 = /^1[3|4|5|7|8]\d{9}$/;	//手机号正则判断
	var patt2 = /^[0-9]*$/;				//包含非数字符号
	var regidinp1 = document.getElementById("regidinp");
	var span0 = document.getElementById("span0");
	var regmail = document.getElementById("regmail");
	var regphone = document.getElementById("regphone");
	var reghidden = document.getElementsByClassName("reghidden");
	var regbox = document.getElementById("reg_box");
	var regcheck0 = document.getElementById("regcheck0");
	var regcheck1 = document.getElementById("regcheck1");
	var phonecheck = document.getElementById("phonecheck");
	var emailcheck = document.getElementById("emailcheck");
	var name_input = document.getElementById("name_input");
	var pwd_input = document.getElementById("pwd_input");
	var pwd_input1 = document.getElementById("pwd_input1");
	
	if(!patt2.test(regidinp1.value)) {
		if(!patt0.test(regidinp1.value)) {
			span0.innerHTML = "<span>请输入正确的邮箱格式</span>";
			regbox.style.height = "300px";
			regmail.style.display = "none";
			regphone.style.display = "none";
			for(var i=0 ; i<reghidden.length ; i++) {
				reghidden[i].style.display = "none";
			}
			if(regidinp1.value.length == 0) {
				span0.innerHTML = "<span>请您输入QQ、163、126、gmail等常用邮箱，或者11位手机号。</span>";
			}
			regcheck0.type = "hidden";
			regcheck1.type = "hidden";
			phonecheck.type = "hidden";
			emailcheck.type = "hidden";
			name_input.type = "hidden";
			pwd_input.type = "hidden";
			pwd_input1.type = "hidden";
		}else {
			span0.innerHTML = "<span>邮箱可以使用</span>";
			regbox.style.height = "600px";
			regmail.style.display = "block";
			for(var i=0 ; i<reghidden.length ; i++) {
				reghidden[i].style.display = "block";
			}
			regcheck0.type = "text";
			regcheck1.type = "text";
			name_input.type = "text";
			phonecheck.type = "button";
			emailcheck.type = "button";
			pwd_input.type = "password";
			pwd_input1.type = "password";
		}
	} else {
		if(!patt1.test(regidinp1.value)) {
			span0.innerHTML = "<span>请输入正确的11位手机号码</span>";
			regbox.style.height = "300px";
			regmail.style.display = "none";
			regphone.style.display = "none";
			for(var i=0 ; i<reghidden.length ; i++) {
				reghidden[i].style.display = "none";
			}
			
			if(regidinp1.value.length == 0) {
				span0.innerHTML = "<span>请您输入QQ、163、126、gmail等常用邮箱，或者11位手机号。</span>";
			}
			regcheck0.type = "hidden";
			regcheck1.type = "hidden";
			phonecheck.type = "hidden";
			emailcheck.type = "hidden";
			name_input.type = "hidden";
			pwd_input.type = "hidden";
			pwd_input1.type = "hidden";
		} else {
			span0.innerHTML = "<span>当前手机号码可以使用</span>";
			regbox.style.height = "600px";
			regphone.style.display = "block";
			for(var i=0 ; i<reghidden.length ; i++) {
				reghidden[i].style.display = "block";
			}
			regcheck0.type = "text";
			regcheck1.type = "text";	
			name_input.type = "text";
			phonecheck.type = "button";
			emailcheck.type = "button";
			pwd_input.type = "password";
			pwd_input1.type = "password";
		}
	}
};
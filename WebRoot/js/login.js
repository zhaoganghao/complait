//引入校验函数库validate.js
document.write("<script language='javascript' src='js/validate.js'></script>");
window.onload = function() {
	//var username = document.getElementById("username").value居然得不到值???
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	loginForm.onsubmit = function() {
		if(isNull(trim(username.value))){
			alert("用户名为空");
			username.focus();
			return false;
		}
		if(isNull(password.value)){
			alert("密码为空");
			password.focus();
			return false;
		}
	};
};

//引入校验函数库validate.js
document
		.write("<script language='javascript' src='../js/validate.js'></script>");
/* 获取表格标题，并添加样式 */
/* 获取左边单元格中的所有div */
var divInfIntr = document.getElementById("tabComInf").getElementsByTagName(
		"div");

/* 给左边的单元格添加样式 */
var tabRows = document.getElementById("tabComInf").tBodies[0].rows;
for ( var i = 0; i < tabRows.length - 1; i++) {
	tabRows[i].cells[0].className = "leftTd";
	tabRows[i].cells[0].index = i;
}
/* 给提交按钮所在的单元格添加样式 */
tabRows[tabRows.length - 1].cells[0].className = "submitTd";
// 表单验证
var a_i_form = document.getElementById("a_i_form");
var ifrom = document.getElementById("ifrom");
var encode = document.getElementById("encode");
var department = document.getElementById("department");
var content1 = document.getElementById("content1");
var content2 = document.getElementById("content2");
var l_picker_start = document.getElementById("l_picker_start");
var operater = document.getElementById("operater");
var replyphone = document.getElementById("replyphone");
var replyemail = document.getElementById("replyemail");
function isvalidate() {
	if (isNull(trim(ifrom.value)) || !maxLength(trim(ifrom.value), 10)) {
		tabSpan[0].style.display = "block";
		ifrom.focus();
		return false;
	}
	if (isNull(trim(encode.value)) || !maxLength(trim(encode.value), 5)) {
		alert("编号单位不能为空,且字符不能超过5个字符");
		encode.focus();
		return false;
	}
	if (isNull(trim(department.value))
			|| !maxLength(trim(department.value), 20)) {
		alert("被举报单位不能为空,且字符不能超过30个字符");
		department.focus();
		return false;
	}
	if (isNull(trim(content1.value))) {
		alert("内容摘要不能为空");
		content1.focus();
		return false;
	}
	if (isNull(trim(content2.value))) {
		alert("处理意见和建议不能为空");
		content2.focus();
		return false;
	}
	if (isNull(trim(l_picker_start.value))|| !isDate(trim(l_picker_start.value))) {
		alert("最迟回复时间不能为空,请按照正确的日期格式填写");
		l_picker_start.focus();
		return false;
	}
	if (isNull(trim(operater.value)) || !maxLength(trim(operater.value), 5)) {
		alert("经办人不能为空,且名字不能超过4字符");
		operater.focus();
		return false;
	}
	if (isNull(trim(replyphone.value)) || !isPhoneNumb(trim(replyphone.value))) {
		alert("回复电话不能为空,请输入正确的电话号码或者的手机号码");
		replyphone.focus();
		return false;
	}
	if (isNull(trim(replyemail.value)) || !isEmail(trim(replyemail.value))) {
		alert("回复邮箱不能为空,请输入正确邮箱地址");
		replyemail.focus();
		return false;
	}
	return true;
};

//	长度是否为零
function isNull(str) {
	if (str.length == 0) {
		return true;
	} else {
		return false;
	}
};
// 去除空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
};
// 长度最小值
function minLength(str, length) {
	if (str.length >= length) {
		return true;
	} else {
		return false;
	}
};
// 长度最大值
function maxLength(str, length) {
	if (str.length <= length) {
		return true;
	} else {
		return false;
	}
};
// 时间验证
function isDate(date) {
	index1 = date.indexOf("-");
	if (index1 == -1) {
		return false;
	}
	year = date.substring(0, index1);
	date = date.substring(index1 + 1);
	index1 = date.indexOf("-");
	if (index1 == -1) {
		return false;
	}
	month = date.substring(0, index1);
	day = date.substring(index1 + 1);
	if (isNumber(year) && isNumber(month) && isNumber(day)) {
		if (year < 1900 || year > 9999 || month < 1 || month > 12 || day < 1) {
			return false;
		}
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
				&& day > 31) {
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			return false;
		}
		if (month == 2) {
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				if (day > 29) {
					return false;
				}
			} else {
				if (day > 28) {
					return false;
				}
			}
		}
	} else {
		return false;
	}
	return true;
};
// 数字验证
function isNumber(str) {
	for ( var i = 0; i < str.length; i++) {
		if (str.charAt(i) >= '0' && str.charAt(i) <= '9'
				|| str.charAt(i) == "-" && i == 0) {
			continue;
		} else {
			return false;
		}
	}
	return true;
};
// E-mail验证
function isEmail(email) {
	if (email.length == 0) {
		return false;
	}
	index1 = email.indexOf('@');
	index2 = email.indexOf('.');
	if (index1 < 1 || index2 < 1 || index2 - index1 < 2
			|| index2 + 1 == email.length) {
		return false;
	} else {
		return true;
	}
};
// 电话验证
function isPhoneNumb(phoneNumb) {
	var pattern = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/;
	if (pattern.test(phoneNumb)) {
		return true;
	} else {
		return false;
	}
};
// 检验两个字符串是否相同
function isSameStr(str1, str2) {
	if (str1 == str2) {
		return true;
	} else {
		return false;
	}
};


//封装一个添加类的函数
function addClass(str){
	var tabRows = document.getElementById(str).tBodies[0].rows;
	for ( var i = 0; i < tabRows.length; i++) {
		tabRows[i].cells[0].className = "leftRow";
	}  
};
//四个表格通过调用函数添加相应的类
addClass("tab1");
addClass("tab2");
addClass("tab3");
addClass("tab4");
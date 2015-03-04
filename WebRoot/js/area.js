//地区初始化模板
var f = function() {
	var _ = NEJ.P, _e = _('nej.e'), _p = _('nej.ut');

	var _region = _p._$$RegionSelector._$allocate({
		city : _e._$get('city'),
		province : _e._$get('province'),
		area : _e._$get('area'),
		data : {
			province : '浙江省',
			city : '杭州市',
			area : '滨江区'
		},
		onchange : onChange
	});
	function onChange(_type) {
		if (!!console)
			console.log(_type);
	}
};
define([ '{lib}util/region/region.zh.js', '{lib}util/data/region/zh.js' ], f);
//给每一个单选框添加事件
var areas = document.getElementsByName("selectArea");
var province=document.getElementById("province");
var city=document.getElementById("city");
var college=document.getElementById("college");
for ( var i = 0; i < areas.length; i++) {
	areas[i].onclick = function() {
		//只下达到市级，那么就让id="city"的下拉失效，这里有个级别错位，谨慎使用
		//如果只下达到县级或者市县同时下达，需要交给后台
		if(checked()=='city'){
			province.disabled='';
			city.disabled='disabled';
			college.disabled='disabled';
		}else if(checked()=='county'){
			province.disabled='';
			city.disabled='';
			college.disabled='disabled';
		}else if(checked()=='city_county'){
			province.disabled='';
			city.disabled='';
			college.disabled='disabled';
		}else if(checked()=='college'){
			college.disabled='';
			province.disabled='disabled';
			city.disabled='disabled';
		}
	};
}
//判断哪一个单选框被选中 
function checked(){
	for(var i=0;i<areas.length;i++){
		if(areas[i].checked){
			return areas[i].value;
		}
	}
}

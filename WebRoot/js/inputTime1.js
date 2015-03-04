
var picker = new Pikaday({
	field : document.getElementById('l_picker_start'),
	firstDay : 1,
	minDate : new Date('2010-01-01'),
	maxDate : new Date('2050-12-31'),
	yearRange : [ 2000, 2050 ]
});
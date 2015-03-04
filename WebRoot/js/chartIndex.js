var indexS = new Pikaday({
	field : document.getElementById('index_p_s'),
	firstDay : 1,
	minDate : new Date('2010-01-01'),
	maxDate : new Date('2050-12-31'),
	yearRange : [ 2000, 2050 ]
});
var indexE = new Pikaday({
	field : document.getElementById('index_p_e'),
	firstDay : 1,
	minDate : new Date('2010-01-01'),
	maxDate : new Date('2050-12-31'),
	yearRange : [ 2000, 2050 ]
});
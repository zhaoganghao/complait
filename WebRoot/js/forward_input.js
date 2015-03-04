var tabRows = document.getElementById("forwCompInf").tBodies[0].rows;
for ( var i = 0; i < tabRows.length - 1; i++) {
	tabRows[i].cells[0].className = "leftRow";
}

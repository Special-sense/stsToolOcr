function deleteFood() {

	document.form1.action = "inputText_delete";
	document.form1.submit();
}

function addfoodlist() {

	document.form1.action = "inputText_delete";
	document.form1.submit();
}

function lockeradd() {
	
		var tableRows = document.getElementsByTagName("tr");

	    for (var i = 1; i < tableRows.length; i++) {
	        var row = tableRows[i];
	        var cells = row.getElementsByTagName("input");
	        var rowData = {};

	        for (var j = 0; j < cells.length; j++) {
	            var cell = cells[j];
	            var fieldName = cell.getAttribute("name");
	            var fieldValue = cell.value;
	            rowData[fieldName] = fieldValue;
	        }

	        // rowData 객체에 현재 <tr>의 데이터가 저장됨
	        console.log(rowData);
	    
	    	document.form1.action = "locker_add";
	    	document.form1.submit();
	}
}

function add() {
	// post방식
	document.form1.action="add";
	document.form1.submit();
}

function viewopencheck() {
	// post방식
	document.form1.action="view_open";
	document.form1.submit();
}

function updatecheck() {
	// post방식
	document.form1.action="update";
	document.form1.submit();
}

function deletecheck() {
	result = confirm("정말로 삭제하시겠습니까 ?");

	if(result == true){
		
		// post방식
		document.form1.action="delete";
		document.form1.submit();
	}
	else
		return;
}

function backcheck() {
	// post방식
	document.form1.action="list";
	document.form1.submit();
	
}

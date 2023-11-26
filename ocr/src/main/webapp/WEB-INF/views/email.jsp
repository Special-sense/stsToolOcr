<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	String id = (String) session.getAttribute("id");

	String log = "";
	String help = "";
	if (id == null) {
		log = "<a href=login_open> 로그인 </a>";
	} else {
		log = "<a href=logout> 로그아웃 </a>";
	}

	if (id == null) {
		help = "<a href=list_open> 부탁해 </a>";
	} else {
		help = "<a href=list_open> 부탁해 </a>";
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- viewport 선언문 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Google Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800&display=swap"
	rel="stylesheet">

<!-- Font Awesome 아이콘 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<title>OCR 만들기</title>
<link href="css/ocr_list.css?var=1" rel="stylesheet">
<script type="text/javascript" src="js/ocr_list.js"></script>

<title>이메일 전송텝</title>
</head>
<body>
	<form action="noticeMail" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=id%>">
		<p>

			<button class="w-btn w-btn-indigo" type="submit" style="text-align: center">이메일 전송하기</button>

		</p>
	</form>
</body>
</html>
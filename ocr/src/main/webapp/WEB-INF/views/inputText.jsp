<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp" %>

<!-- taglib 지시어  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>데이터 확인창</title>
<!-- 아직 css , js 작업 전
  <link rel="stylesheet" href="css/accounttransfer.css" type="text/css" media="screen" />

	<script type="text/javascript" src="js/accounttransfer_list.js"></script>
-->	
</head>
<body>

	<div align=center>
	<H2>영수증 스캔 결과폼</H2>
	<HR>

	<!-- 영수증 스캔 결과 폼 -->
	<form name="form1" method="post" action="">

		<input type="hidden" name="mode" value=${mode}>
		<input type="hidden" name="id" value=0>
	
		<table border=1>

			
			<tr>
				<th>ID</th>
				<th>상품명</th>
				<th>구매 날짜</th>
				<th>유통기한</th>
			</tr>
			
			<c:forEach var="i" items="${foodlist}">
				<tr>
					<td>${i.no}</td>
					<td>${i.foodname}</td>
					<td>${i.buydate}</td>
					<td>${i.expirydate}</td>

				</tr>
			</c:forEach>			
			
		</table>
	</form>
	</div>

</body>
</html>
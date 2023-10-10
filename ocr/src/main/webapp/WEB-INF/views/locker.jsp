<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp" %>

<!-- taglib 지시어  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>locker</title>
<!-- 아직 css , js 작업 전
  <link rel="stylesheet" href="css/accounttransfer.css" type="text/css" media="screen" />
-->	
	<script type="text/javascript" src="js/locker.js?ver=1"></script>

</head>
<body>

	<div align=center>
	<H2>영수증 스캔 결과폼</H2>
	<HR>

	<!-- 영수증 스캔 결과 폼 -->
	<form name="form1" method="post" action="">


		<input type="hidden" name="id" value="<%=id%>">
	
		<table border=1>

			
			<tr>
				<th>ID</th>
				<th>상품명</th>
				<th>구매 날짜</th>
				<th>유통기한</th>
			</tr>
			
			<c:forEach var="i" items="${ocrFood}">
				<tr>
					<td><input type="text" name="no" value="${i.no}" size = "10" readonly></td>
					<td><input type="text" name="foodname" value="${i.foodname}" size = "20" readonly></td>
	 				<td><input type="date" name="buydate" value="${i.buydate}" size = "20" readonly></td>
					<td><input type="date" name="expirydate" value="${i.expirydate}" size = "20" readonly></td> 
				</tr>
			</c:forEach>			
			
		</table>
		
		<input type="button" value="수정하기" onClick="edit_open()"></input>
	</form>
	</div>

</body>
</html>
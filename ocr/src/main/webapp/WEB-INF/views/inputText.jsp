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
	<title>데이터 확인창</title>
<!-- 아직 css , js 작업 전
  <link rel="stylesheet" href="css/accounttransfer.css" type="text/css" media="screen" />
-->	
	<script type="text/javascript" src="js/inputText.js"></script>

</head>
<body>

	<div align=center>
	<H2>영수증 스캔 결과폼</H2>
	<HR>

	<!-- 영수증 스캔 결과 폼 -->
	<form name="form1" method="post" action="">

		<input type="hidden" name="mode" value=${mode}>
		<input type="hidden" name="checkbox" value="0"  size = "1" checked>
		<input type="hidden" name="id" value="<%=id%>" size = "10" readonly>
		<table border=1>

			
			<tr>
				<th>ID</th>
				<th>상품명</th>
				<th>구매 날짜</th>
				<th>유통기한</th>
				<th>삭제</th>
			</tr>
			
			<c:forEach var="i" items="${ocrFoodList}">

				<tr>
					<td><input type="text" name="no" value="${i.no}" size = "10" readonly></td>
					<td><input type="text" name="foodname" value="${i.foodname}" size = "20"></td>
	 				<td><input type="date" name="buydate" value="${i.buydate}" size = "20"></td>
					<td><input type="date" name="expirydate" value="${i.expirydate}" size = "20"></td> 
					<td><input type="checkbox" name="checkbox" value="${i.no}"  size = "20"></td> 
				</tr>
			</c:forEach>			
			
		</table>
		
		<input type="button" value="완료 " onClick="lockeradd()"></input>
		<input type="button" value="삭제하기 " onClick="deleteFood()"></input>
	</form>
	</div>

</body>
</html>
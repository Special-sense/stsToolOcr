<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 오류 페이지 정의  -->
<%@ page errorPage="accounttransfer_error.jsp" %>

<!-- taglib 지시어  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String id = (String)session.getAttribute("id");
	
	String log="";
	String help="";
	if(id == null){
		log ="<a href=login_open> 로그인 </a>";
	}else {
		log ="<a href=logout> 로그아웃 </a>";
	}
	
	if(id == null){
		help ="<a href=list_open> 부탁해 </a>";
	}else {
		help ="<a href=list_open> 부탁해 </a>";
	}

%>

<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <!-- viewport 선언문-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">
	<title>데이터 확인창</title>

  <link rel="stylesheet" href="css/inputText.css?var=1" type="text/css" media="screen" />

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/inputText.js?var=1"></script>

</head>
<body>

	<div class="container">
        
        <!-- 메인 -->
        <div class="main"> 
            
            <!-- 상단 메뉴바 -->
            <div class="nav">
                <ul>
                    <li class="nav-text">
                        <a href="index_open">
                            <img src="resources/img/logo_refrigerator.png" width="80px" alt="logo-main">
                        </a>
                    </li>
                    <li class="nav-text01"><%=help%></li>
                    <li class="nav-text02"><%=log%></li>
                </ul>
			</div>
        </div>
		<hr>

	<div style="text-align: center; ">
	<H2>영수증 스캔 결과</H2>
	<!-- 영수증 스캔 결과 폼 -->
	<form name="form1" method="post" action="" enctype="multipart/form-data">

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
					<td><input type="text" id="no"        		 name="no" value="${i.no}" size = "10" readonly></td>
					<td><input type="text" id="foodname"   	     name="foodname" value="${i.foodname}" size = "20"></td>
	 				<td><input type="date" id="buydate"   		 name="buydate" value="${i.buydate}" size = "20"></td>
					<td><input type="date" id="$expirydate"		 name="expirydate" value="${i.expirydate}" size = "20"></td> 
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
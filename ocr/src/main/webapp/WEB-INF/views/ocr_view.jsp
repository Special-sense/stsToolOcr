<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- taglib 지시어  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>변경!</title>
</head>
<body>
<h1>OCR Result</h1>
<ul>

	<c:forEach var="i" items="${ocrResult}">
		<tr>
			<td>${i}</td>

		</tr>
	</c:forEach>	
	
  <!-- Loop through the OCR result and display each item -->
  <li th:each="result : ${ocrResult}" th:text="${result}"></li>
</ul>
</body>
</html>
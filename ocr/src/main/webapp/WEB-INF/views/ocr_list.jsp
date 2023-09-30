<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String id = (String)session.getAttribute("id");
%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OCR 만들기</title>
  
  	<script type="text/javascript" src="js/ocr_list.js"></script>
</head>
<body>
<h1>Image Upload and OCR</h1>
<form action="/ocr_pjt/uploadAndOcr" method="post" enctype="multipart/form-data">
  <input type="file" name="file" accept=".jpg, .jpeg, .png">
  <button type="submit">Upload and OCR</button>
   <input type="button"  onClick="add()" value="<%=id%>">
</form>

<form name="form1" action="" method="post" >
 <input type="button"  onClick="add()" value="DB연결 확인">
</form>
</body>

</html>
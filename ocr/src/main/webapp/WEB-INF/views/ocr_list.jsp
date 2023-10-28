<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
<html lang="en" xmlns:th="http://www.thymeleaf.org">
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
</head>
<body>



	<div class="container">


		<!-- 상단 네비바 -->
		<div class="nav">
			<ul>
				<li class="nav-text"><a href="index_open"> <img
						src="resources/img/logo_refrigerator.png" width="70px"
						alt="logo-main">
				</a></li>
				<li class="nav-text01"><%=help%></li>
				<li class="nav-text02"><%=log%></li>
			</ul>
		</div>

		<hr>

		<!-- 메인 박스 -->
		<div class="main">


			<!-- ------------------- box02 -------------------- -->
			<div class="main-form01">
				<div class="box02"
					style="background-image: url(resources/img/img_refrigerator.png);">

					<form action="locker_open" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="id" value="<%=id%>">
						<p>

							<button class="w-btn w-btn-indigo" type="submit">내 냉장고
								보기</button>

						</p>
					</form>
				</div>
			</div>


			<div class="main-form">

				<p class="main-text">식품 등록하기</p>

				<!-- ------------------- box -------------------- -->
				<div class="box"
					style="background-image: url(resources/img/img_receipts.jpg);">
					<form class="box-form" action="/ocr_pjt/uploadAndOcr" method="post"
						enctype="multipart/form-data">
						<p>
							<!-- 업로드 버튼 -->

								<div class="upload-container">
									<input type="file" id="file" accept=".jpg, .jpeg, .png"
										style="display: none;"> <label for="file"
										class="upload-button"> <i
										class="fas fa-cloud-upload-alt"></i> 이미지 업로드
									</label>
								</div>
							<br>


							<!-- 서밋 버튼 -->
							<a href="#" class="box-btn">
								<button class="w-btn w-btn-indigo" type="submit">영수증
									스캔하기</button>
							</a>
						</p>
					</form>
				</div>

				<!-- ------------------- preview -------------------- -->
				<div class="preview">
					<img style="width: 20em;" id="image-preview" src="#">
					<p class="preview-text">이미지 미리보기</p>
				</div>

				<!-- ------------------- box01 -------------------- -->
				<div class="box01"
					style="background-image: url(resources/img/img_text.jpg);">
					<form action="edit_open" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="id" value="<%=id%>">
						<p>

							<button class="w-btn w-btn-indigo" type="submit">텍스트로
								입력하기</button>

						</p>
					</form>
				</div>



			</div>




		</div>




		<!-- 푸터 sty.2 -->
		<div class="bin-box01">
			<footer class="footer">
				<div class="footer-container">
					<div class="footer-social">
						<ul>
							<li><a href="#"><i class="fab fa-youtube"></i></a></li>
							<li><a href="#"><i class="fab fa-facebook"></i></a></li>
							<li><a href="#"><i class="fab fa-instagram"></i></a></li>
							<li><a href="#"><i class="fas fa-n"></i></a></li>
						</ul>
					</div>
					<div class="footer-list-bottom">
						<address class="footer-address">
							<p style="font-style: normal;">
								상호명: (주) 나만의 냉장고 | 공동대표: 이영선, 김종범, 최환석, 양홍섭 <br> 사업자 등록번호:
								103-xx-xxxxx | 본사: 인천광역시 연수구 송도교육로 111번길 15
							</p>
						</address>
					</div>
				</div>
			</footer>
		</div>
	</div>
</body>


<script>
	const imageUpload = document.getElementById('file');
	const imagePreview = document.getElementById('image-preview');

	imageUpload.addEventListener('change', function() {
		if (this.files && this.files[0]) {
			const reader = new FileReader();

			reader.onload = function(e) {
				imagePreview.src = e.target.result;
			};

			reader.readAsDataURL(this.files[0]);
		}
	});
</script>

</html>

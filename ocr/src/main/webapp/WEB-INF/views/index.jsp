<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">

    <!-- viewport 선언문-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">

    <link href="css/index.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="js/index.js?ver=1"></script>

</head>
<body>
<form name="form1" method="post" action="">
    <div class="container">
        
        <!-- 메인 -->
        <div class="main" style="background-image: url('resources/img/img_refrigerator.png')"> 
            
            <!-- 상단 메뉴바 -->
            <div class="nav">
                <ul>
                    <li class="nav-text">
                        <a href="index_open">
                            <img src="resources/img/logo_refrigerator_white.png" width="80px" alt="logo-main">
                        </a>
                    </li>
                    <li class="nav-text01"><a href="list_open">부탁해</a></li>
                    <li class="nav-text02"><a href="login_open">로그인</a></li>
                </ul>
            </div>

            <!-- 메인이미지 안 텍스트 -->
            <p class="main-text">
                냉장고를 부탁해 <br>
                온라인 냉장고 식품 관리 서비스 활용해보세요.
            </p>
        </div>

        <!-- 첫번째 박스 -->
        <div class="box">
            <video autoplay loop>
                <source src="resources/img/video_receipt.mp4">
            </video>
            <div class="box-text-container">
                <p class="box-text"><img src="resources/img/img_scan.png">가장 쉬운 상품 입력</p>
                <p class="box-text01">영수증을 통해 <a class="point">냉장고</a>에 들어갈<br> 식품을 쉽게 등록하세요.</p>
                <p class="box-text02">저희 <a class="point">냉장고를 부탁해</a>는 'OCR 문자 인식' 시스템을<br> 활용해 영수증을 스켄하여 냉장고에 들어갈 상품만<br> 추출 후 자동으로 상품을 입력합니다.</p>
            </div>
        </div>

        <!-- 두번째 박스 -->
        <div class="bin-box">
            <div class="box01">
                <p class="box01-main-text">Function</p>
                <div class="box01-text-container">
                    <div class="box01-function">
                        <img src="resources/img/icon_refrigerator.png">
                        <p>온라인으로 냉장고에 있는 식품들을 관리할 수 있습니다.</p>
                    </div>
                    <div class="box01-function01">
                        <img src="resources/img/icon_bell.png">
                        <p>유통기한이 지나기 전에 알림을 받아 음식물 쓰레기를 줄일 수 있습니다.</p>
                    </div>
                    <div class="box01-function02">
                        <img src="resources/img/icon_ai.png">
                        <p>냉장고 안에 있는 음식물들을 기반으로 AI가 추천하는 요리 레시피를 추천받을 수 있습니다.</p>
                    </div>
            </div>
        </div>

        <!-- 세번째 박스 -->
        <div class="box02"> 
            <p><a class="point">냉장고를 부탁해</a><br> 스마트한 냉장고를 만나보세요.</p>
            <button class="box02-btn"><a href="login_open">START !</a></button>
        </div>

        <!-- 푸터 -->
        <footer>
            <div class="footer-all">
                <div class="footer-container">
                    <div class="footer-front">
                    <ul class="footer-text">
                        <li class="footer-li1">
                            <ul>
                                <li>나만의 냉장고</li>
                                <li>영수증 스캔하기</li>
                                <li>텍스트로 입력하기</li> 
                                <li>내 냉장고 보기</li>
                            </ul>
                        </li>
                        <li class="footer-li2">
                            <ul>
                                <li>유통기한 알림</li>
                            </ul>
                        </li>
                        <li class="footer-li3">
                            <ul>
                                <li>AI 레시피 추천</li>
                            </ul>
                        </li>
                </div>
                    <div class="footer-social">
                    <ul>
                        <li><a href="">유튜브</a></li>
                        <li><a href="">페북</a></li>
                        <li><a href="">인스타</a></li>
                        <li><a href="">네이버 블로그</a></li>
                    </ul>
                    </div>
                </ul> 
            </div>
                <address class="footer-address">
                   <span class="bar"></span>
                   " 상호명(주) 나만의 냉장고"
                   <span class="bar-break"></span>
                   " 공동대표:이영선,김종범,최환석,양홍섭 "
                   <span class="bar-break"></span>
                   " 사업자 등록번호:103-xx-xxxxx "
                    <p class="">

                    </p>
                </address>
        </div>
        </footer>
    </div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
            <!-- google font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">
    
        <!-- 아이콘 -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <link href="css/register.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="js/register.js?var=1"></script>
    
    <title>sign up</title>
</head>
<body>

        <!-- 로고 -->
        <a href="index_open"><img class="Logo" src="resources/img/logo_refrigerator.png" alt="로고"></a>
        
        <div class="mem">
            <form id="mem_form"   name="register1" action="" method="post" autocomplete="off" >
                <input type="text" id="name" name="userName" placeholder="이름" required value=${OcrDto.userName}>
                <br>
                <span id="name-error-message"></span>
                <input type="text" id="username" name="id" placeholder="이메일" required value=${OcrDto.id}>
                <br>
                <div class="pw_container">
                    <input type="password" id="password" name="userPW" placeholder="비밀번호" required value=${OcrDto.userPW}>
                    <span class="pw_toggle" onclick="togglePasswordVisibility()"><i class="fas fa-eye"></i></span>
                </div>
                <div class="re_pw_container">
                    <input type="password" id="re_password" name="password" placeholder="비밀번호 재입력" required>
                </div>
                <span id="error-message"></span>
                <br>
                <button type="button"  class="btn" onClick="checkPasswordMatch()">회원가입</button>
            </form>
        </div>
        
                
</body>
</html>
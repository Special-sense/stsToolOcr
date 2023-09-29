<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="css/register.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="js/register.js?ver=1"></script>
    
    <title>sign up</title>
</head>
<body>
    <div class="res-all">
        <div class="res-logo">
            <img src="resources/img/logo_refrigerator.png">
        </div>
        <div class="res-form">
                <form name="register1" method="post" action="" autocomplete="off">
                    <fieldset class="login-border">
                        <ul class="inform">
                            <li>
                                <label for="userID">ID</label>
                                <input type="text" name="id"  class="res-ID" placeholder="아이디" value=${OcrDto.id}>
                            </li>
                            <li>
                                <label for="username">이름</label>
                                <input type="text" name="userName"  class="res-name" value=${OcrDto.userName}>
                            </li>
                            <li>
                                <label for="userPW">PW</label>
                                <input type="text" name="userPW" class="res-pw" placeholder="비밀번호" value=${OcrDto.userPW} >
                            </li>
                            <li>
                                <label for="userPW">PW 확인</label>
                                <input type="text" name="userok"   class="res-pwok" >
                            </li>
                        </ul>
                    </fieldset>                   
        			<input type="button" onClick="register()" value="회원가입" class="login-btn"></button>
                </form>
        </div>

                
            <div class="login-add">
            <ul class="add">
                <li>
                <a href="login_open">로그인</a>
                </li>
                <li>
                <a href="#">비밀번호 찾기</a>
                </li>
            </ul>
            </div>
        </div>
</body>
</html>
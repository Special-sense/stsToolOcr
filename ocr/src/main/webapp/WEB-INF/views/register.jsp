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
                                <input type="text" name="userID"  class="res-ID" placeholder="아이디" value=${Ocrdto.userID}>
                            </li>
                            <li>
                                <label for="username">이름</label>
                                <input type="text" name="username"  class="res-name" value=${Ocrdto.username}>
                            </li>
                            <li>
                                <label for="userPW">PW</label>
                                <input type="text" name="userPW" class="res-pw" placeholder="비밀번호" value=${Ocrdto.userPW} >
                            </li>
                            <li>
                                <label for="userPW">PW 확인</label>
                                <input type="text" name="userok"   class="res-pwok" >
                            </li>
                        </ul>
                    </fieldset>
                </form>
        </div>

        <input type="button" onClick="register()" value="회원가입" class="login-btn"></button>
                
            <div class="login-add">
            <ul class="add">
                <li>
                <a href="/register.html">회원가입</a>
                </li>
                <li>
                <a href="/비번찾는경로추가">비밀번호 찾기</a>
                </li>
            </ul>
            </div>
        </div>
</body>
</html>
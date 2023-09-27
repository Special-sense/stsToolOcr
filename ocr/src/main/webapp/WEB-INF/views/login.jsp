<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/login.css?ver=1" rel="stylesheet">
    <link href="js/login.js?ver=1" rel="stylesheet">

    <title>sign in</title>
</head>
<body>
    <div class="login-all">
        <div class="login-logo">
            <img src="resources//img/logo_refrigerator.png">
        </div>
            <div class="login-form">
                <form name="loginform" method="post" action="여기 경로" autocomplete="off">
                    <fieldset class="login-border">
                        <ul class="inform">
                            <li>
                                <label for="userID">ID</label>
                                <input type="text" name="userID" class="login-ID" placeholder="아이디">
                            </li>
                            <li>
                                <label for="userPW">PW</label>
                                <input type="text" name="userPW" class="login-pw" placeholder="비밀번호">
                            </li>
                        </ul>
                        <button type="submit" class="login-btn">로그인</button>
                
            <div class="login-add">
            <ul class="add">
                <li>
                <a href="register_open">회원가입</a>
                </li>
                <li>
                <a href="#">비밀번호 찾기</a>
                </li>
            </ul>
            </div>
                    </fieldset>        
                </form>
            </div>
    </div>
</body>
</html>
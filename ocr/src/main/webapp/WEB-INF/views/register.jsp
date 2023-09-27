<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/register.css?ver=1" rel="stylesheet">
    <link href="js/register.js?ver=1" rel="stylesheet">
    <title>sign up</title>
</head>
<body>
    <div class="res-all">
        <div class="res-logo">
            <img src="resources/img/logo_refrigerator.png">
        </div>
        <div class="res-form">
                <form>
                    <fieldset class="login-border">
                        <ul class="inform">
                            <li>
                                <label for="userID">ID</label>
                                <input type="text" name="userID" class="res-ID" placeholder="아이디">
                            </li>
                            <li>
                                <label for="username">이름</label>
                                <input type="text" name="username" class="res-name">
                            </li>
                            <li>
                                <label for="userPW">PW</label>
                                <input type="text" name="userPW" class="res-pw" placeholder="비밀번호">
                            </li>
                            <li>
                                <label for="userPW">PW 확인</label>
                                <input type="text" name="userok" class="res-pwok">
                            </li>
                        </ul>
                    </fieldset>
                </form>
        </div>

        <button type="submit" class="login-btn">로그인</button>
                
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
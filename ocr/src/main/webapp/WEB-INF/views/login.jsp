<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/login.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="js/login.js"></script>

    <title>sign in</title>
</head>
<body>
    <div class="login-all">
        <div class="login-logo">
         <a href="index_open"><img src="resources/img/logo_refrigerator.png"></a>
        </div>
            <div class="login-form">
                <form name="login1" method="post" action="" autocomplete="off">
                    <fieldset class="login-border">
                        <ul class="inform">
                            <li>
                                <label for="userID">ID</label>
                                <input type="text" name="id" class="login-ID" placeholder="아이디" value=${Ocrdto.id}>
                            </li>
                            <li>
                                <label for="userPW">PW</label>
                                <input type="text" name="userPW"  class="login-pw" placeholder="비밀번호" value=${Ocrdto.userPW}>
                            </li>
                        </ul>
                        <button type="submit" onClick="login()" class="login-btn">로그인</button>
                
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
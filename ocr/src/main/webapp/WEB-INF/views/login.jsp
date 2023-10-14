<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
            <!-- viewport 선언문-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
        
        <!-- google font -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800&display=swap" rel="stylesheet">
    
        <!-- 아이콘 -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
    <link href="css/login.css?ver=1" rel="stylesheet">
    <script type="text/javascript" src="js/login.js"></script>

    <title>sign in</title>
</head>
<body>
	      <!--로고-->
         <a href="index_open"><img class="Logo"  src="resources/img/logo_refrigerator.png"  alt="로고"></a>
      
        <div class="login">
        

            
          <form class="login_form" name="login_form"  method="post" action="#" autocapitalize="off">
               
         	   <input class="login-ID" type="text" id="id" name="id" placeholder="아이디" value=${Ocrdto.id}>
         	   
         	                          
	           <div class="pw_container">
	           	  <input class="password" type="password" id="userPW"  name="userPW"  placeholder="비밀번호" value=${Ocrdto.userPW}>
	              <span class="pw_toggle" onclick="togglePasswordVisibility()"><i class="fas fa-eye"></i></span>
	           </div>

            	<input class="login-button" type="submit" value="로그인" onclick="validateForm()">
     	  </form>
                
       <div class="links">
            <a href="register_open">회원가입</a>
          </div>
          <div class="links">
            <a href="#">비밀번호를 잊어버리셨나요?</a>
          </div>
          
        </div>
                
 
            
    </div>
	</body>
</html>
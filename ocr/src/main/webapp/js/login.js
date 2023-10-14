
function validateForm() {
    // 입력값 가져오기
    var id = document.getElementById("id").value;
    var userPW = document.getElementById("userPW").value;
  
    // 유효성 검사
    if (id === "" || userPW === "") {
        alert("아이디와 비밀번호를 모두 입력해주세요.");
        return false;
    }
  
	document.login_form.action="login";
	document.login_form.submit();
    return true;
  }



function togglePasswordVisibility() {
  var passwordInput = document.getElementById("userPW");
  var passwordToggle = document.querySelector(".pw_toggle");

  if (passwordInput.type === "password") {
    passwordInput.type = "text";
    passwordToggle.classList.add("visible");
  } else {
    passwordInput.type = "password";
    passwordToggle.classList.remove("visible");
  }
}

  
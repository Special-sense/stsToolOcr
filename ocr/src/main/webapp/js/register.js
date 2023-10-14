function register() {

	document.register1.action="registerInsert";
	document.register1.submit();
}

function togglePasswordVisibility() {
    var passwordInput = document.getElementById("password");
    var passwordToggle = document.querySelector(".pw_toggle");
  
    if (passwordInput.type === "password") {
      passwordInput.type = "text";
      passwordToggle.classList.add("visible");
    } else {
      passwordInput.type = "password";
      passwordToggle.classList.remove("visible");
    }
}

function checkPasswordMatch() {
  var password = document.getElementById("password").value;
  var rePassword = document.getElementById("re_password").value;
  var name = document.getElementById("name").value;
  var username = document.getElementById("username").value;
  var errorSpan = document.getElementById("error-message");
  var nameErrorSpan = document.getElementById("name-error-message");
  var regex = /^[가-힣]+$/;

  if (password !== rePassword) {
    errorSpan.textContent = "비밀번호가 일치하지 않습니다.";
    errorSpan.style.color = "red";
    return false;
  } else {
    errorSpan.textContent = "";

  }

  if (!regex.test(name)) {
    nameErrorSpan.textContent = "이름은 한글만 입력 가능합니다.";
    nameErrorSpan.style.color = "red";
    return false;
  } else {
    nameErrorSpan.textContent = "";
  }
	document.register1.action="registerInsert";
	document.register1.submit();
}

// 이벤트 리스너 추가
document.getElementById("password").addEventListener("input", checkPasswordMatch);
document.getElementById("re_password").addEventListener("input", checkPasswordMatch);
document.getElementById("name").addEventListener("input", checkPasswordMatch);
document.getElementById("username").addEventListener("input", checkPasswordMatch);


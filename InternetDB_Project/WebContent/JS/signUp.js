function form_check() {
  //let u_image = document.getElementById("u_image");
  let u_name = document.getElementById("u_name");
  let u_introduce = document.getElementById("u_introduce");
  let u_id = document.getElementById("u_id");
  let pwd = document.getElementById("pwd");
  let repwd = document.getElementById("repwd");
  let u_nickname = document.getElementById("u_nickname");
  
  let file = input.files[0];
  let newImage = document.createElement("img");
  newImage.src = URL.createObjectURL(file);

  let container = document.querySelector(".new-image");
  container.appendChild(newImage);
  container.style.display = "block";
  document.querySelector(".new-image-input").style.display = "none";
  
  function red_err_txt() { 
    err_txt.style.color = "red";
  }

  if (newImage.value == "") {
    var err_txt = document.querySelector(".err_image");
    red_err_txt();
    err_txt.textContent = "* 이미지를 넣어 주세요.";
    u_image.focus();
    return false;
  }
  if (u_name.value == "") {
    var err_txt = document.querySelector(".err_name");
    red_err_txt();
    err_txt.textContent = "* 이름을 입력 하세요.";
    u_name.focus();
    return false;
  }
  if (u_introduce.value == "") {
    var err_txt = document.querySelector(".err_introduce");
    red_err_txt();
    err_txt.textContent = "* 한줄 소개를 작성해 주세요.";
    u_introduce.focus();
    return false;
  }
  if (u_id.value == "") {
    var err_txt = document.querySelector(".err_id");
    red_err_txt();
    err_txt.textContent = "* 아이디를 입력 하세요";
    u_id.focus();
    return false;
  }
  const uid_len = u_id.value.length;
  if (uid_len < 4 || uid_len > 12) {
    var err_txt = document.querySelector(".err_id");
    red_err_txt();
    err_txt.textContent = "* 4~12글자까지만 입력 가능합니다.";
    u_id.focus();
    return false;
  }
  if (pwd.value == "") {
    var err_txt = document.querySelector(".err_pwd");
    red_err_txt();
    err_txt.textContent = "* 비밀번호를 입력 하세요";
    pwd.focus();
    return false;
  }
  var pwd_len = pwd.value.length;
  if (pwd_len < 4 || pwd_len > 12) {
    var err_txt = document.querySelector(".err_pwd");
    red_err_txt();
    err_txt.textContent = "* 4~12글자까지만 입력 가능합니다.";
    pwd.focus();
    return false;
  }
  if (pwd.value != repwd.value) {
    var err_txt = document.querySelector(".err_repwd");
    red_err_txt();
    err_txt.textContent = "* 비밀번호를 확인 해주세요.";
    repwd.focus();
    return false;
  }
  if (u_nickname.value == "") {
    var err_txt = document.querySelector(".err_nickname");
    red_err_txt();
    err_txt.textContent = "* 닉네임을 입력 하세요.";
    u_nickname.focus();
    return false;
  }
}
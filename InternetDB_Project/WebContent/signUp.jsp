<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user-servlet" method="post" id="login-form">
	<div class="board_wrap">
		<div class="board_title">
			<strong>Log in</strong>
		</div>
		<div class="board_login_wrap">
			<div class="board_login">
        <div class="id_wrap">
          <dl>
            <dt>E - mail :</dt> 
            <dd><input type="text" name="user_email"></dd>
          </dl>
        </div>
        <div class="pw_wrap">
          <dl>
            <dt>Password :</dt> 
            <dd><input type="password" name="user_pw"></dd>
          </dl>
        </div>
			</div>
			<div class="bt_wrap">
				<a href="#" class="on" onclick="document.getElementById('login-form').submit();">sign in</a>
          		<a href="signUp.html">sign up</a>
				<a href="index.jsp">cancel</a>
			</div>
		</div>
	</div>
</form>
</body>
</html>
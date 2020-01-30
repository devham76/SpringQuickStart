<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
@charset "UTF-8";
html,
body {
  height: 100%;
}

body {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-align: center;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
</head>
<body class="text-center">
	<!--form class="form-signin" method="post" action="login_proc.jsp"  == MVC1 -->
	<form class="form-signin" method="post" action="login.do">
		<h1 class="h3 mb-3 font-weight-normal"></h1>
		
		<label for="inputEmail" class="sr-only">아이디</label> 
		<input type="text" name="id" class="form-control" placeholder="아이디" requiredautofocus value="">
		
		<label for="inputPassword" class="sr-only">비밀번호</label> 
		<input type="password" name="password" class="form-control" placeholder="비밀번호" required>
		
		<button class="btn btn-primary btn-block" type="submit">로그인</button>
	</form>
</body>
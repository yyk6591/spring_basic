<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인페이지</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="loginOk.member" method="POST">
	이메일:  <input type="email" name="userEmail" id="userEmail"> <br/>
	이름:  <input type="text" name="userName" id="userName"> <br/>
	<input type="submit" value="로그인">
	
	
	</form>
	<a href="join.member">회원가입페이지</a> <br>
	<a href="memberList.member">회원목록조회</a> <br>
	
</body>
</html>
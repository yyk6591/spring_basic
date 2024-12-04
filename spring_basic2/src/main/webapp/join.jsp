<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>

<form action="joinOk.member" method="POST" id="joinForm" >   <!-- 회원가입: post -->
이메일:  <input type="email" name="userEmail" id="userEmail"> <br/>
이름:  <input type="text" name="userName" id="userName"> <br/>
나이:  <input type="text" name="age" id="age"> <br/>
<input type="submit" value="회원가입" > 

</form>
<a href="login.member">로그인페이지</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>

<form action="joinOk.member" method="POST" id="joinForm" >   <!-- ȸ������: post -->
�̸���:  <input type="email" name="userEmail" id="userEmail"> <br/>
�̸�:  <input type="text" name="userName" id="userName"> <br/>
����:  <input type="text" name="age" id="age"> <br/>
<input type="submit" value="ȸ������" > 

</form>
<a href="login.member">�α���������</a>


</body>
</html>
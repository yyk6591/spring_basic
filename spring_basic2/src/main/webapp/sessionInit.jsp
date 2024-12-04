<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session init 생성</title>
</head>
<body>
	<%
	//session,request,response,cookie : 전역객체
	
	//session 생성
	//name    value
	session.setAttribute("session1", "1111");
	session.setAttribute("session2", 2222);
	session.setAttribute("session3", "3333");
	
	%>
	
	<a href="sessionget.jsp">session get</a>

</body>
</html>
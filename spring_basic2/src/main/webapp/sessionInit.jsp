<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session init ����</title>
</head>
<body>
	<%
	//session,request,response,cookie : ������ü
	
	//session ����
	//name    value
	session.setAttribute("session1", "1111");
	session.setAttribute("session2", 2222);
	session.setAttribute("session3", "3333");
	
	%>
	
	<a href="sessionget.jsp">session get</a>

</body>
</html>
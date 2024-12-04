<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
</head>
<body>
<h1>이메일: <%=(String)request.getAttribute("userEmail") %></h1>
<h1>이메일: <%=(String)request.getAttribute("userName") %></h1>
</body>
</html>
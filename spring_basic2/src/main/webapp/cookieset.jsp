<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cookie set</title>
</head>
<body>

	<%
		//쿠키 생성
		Cookie cookie=new Cookie("jwtCookie1","1111");
		//쿠키 유지시간
		cookie.setMaxAge(60*60); //1시간
		//쿠키 response -> 전역객체 추가(서버가 동작하는 동안 저장/유지)
		response.addCookie(cookie);
		
		
	
	%>

	<a href="cookieget.jsp">cookie get</a>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cookie delete</title>
</head>
<body>

	<%
		Cookie[] cookies =request.getCookies();
	
	for(int i=0; i<cookies.length; i++){
		String str= cookies[i].getName();
		
		//특정쿠키삭제
/*		if(str.equals("jwtCookie1")){
			out.println("name: "+cookies[i].getName()+ "<br />");
			cookies[i].setMaxAge(0); //0이면 쿠키삭제 -> 로그아웃 -> JWT로그아웃기능
			response.addCookie(cookies[i]);
		}*/

			//모든쿠키 삭제
			cookies[i].setMaxAge(0); //0이면 쿠키삭제 -> 로그아웃 -> JWT로그아웃기능
			response.addCookie(cookies[i]);
	}
		
	
	%>
	
	<a href="cookietest.jsp">쿠키확인</a>

</body>
</html>
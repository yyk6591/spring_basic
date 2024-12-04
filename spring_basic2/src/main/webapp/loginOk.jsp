<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id= request.getParameter("id");
	String pw= request.getParameter("pw");

	//입력된 아이디,비변 쿠키값으로 설정
	if(id.equals("jwtCookie1") && pw.equals("1111")){
		Cookie cookie=new Cookie("id",id);
		cookie.setMaxAge(60);
		response.addCookie(cookie);  //request header 에 저장됨
		//페이지이동 -> 로그인 성공시
		response.sendRedirect("welcome.jsp");
	}else{
		//페이지이동 -> 로그인 실패시
		response.sendRedirect("testLogin.jsp");
	}


%>

</body>
</html>
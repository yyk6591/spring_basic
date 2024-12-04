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
    String id="";
    Cookie[] cookies=request.getCookies();
	
	
	for(int i=0; i<cookies.length; i++){
		id= cookies[i].getValue();
		
		if(id.equals("jwtCookie1")){
			out.println(id+"님 안녕하세요.");
			%>
			<a href="Logout.jsp">로그아웃</a>
			<%
		}
	}
	
	
    
    %>
    
    <a href="cookieset.jsp">쿠키 생성</a>
    
    
</body>
</html>
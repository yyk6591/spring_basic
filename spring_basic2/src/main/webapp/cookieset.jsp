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
		//��Ű ����
		Cookie cookie=new Cookie("jwtCookie1","1111");
		//��Ű �����ð�
		cookie.setMaxAge(60*60); //1�ð�
		//��Ű response -> ������ü �߰�(������ �����ϴ� ���� ����/����)
		response.addCookie(cookie);
		
		
	
	%>

	<a href="cookieget.jsp">cookie get</a>



</body>
</html>
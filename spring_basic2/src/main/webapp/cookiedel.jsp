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
		
		//Ư����Ű����
/*		if(str.equals("jwtCookie1")){
			out.println("name: "+cookies[i].getName()+ "<br />");
			cookies[i].setMaxAge(0); //0�̸� ��Ű���� -> �α׾ƿ� -> JWT�α׾ƿ����
			response.addCookie(cookies[i]);
		}*/

			//�����Ű ����
			cookies[i].setMaxAge(0); //0�̸� ��Ű���� -> �α׾ƿ� -> JWT�α׾ƿ����
			response.addCookie(cookies[i]);
	}
		
	
	%>
	
	<a href="cookietest.jsp">��ŰȮ��</a>

</body>
</html>
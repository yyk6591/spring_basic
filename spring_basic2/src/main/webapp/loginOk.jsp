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

	//�Էµ� ���̵�,�� ��Ű������ ����
	if(id.equals("jwtCookie1") && pw.equals("1111")){
		Cookie cookie=new Cookie("id",id);
		cookie.setMaxAge(60);
		response.addCookie(cookie);  //request header �� �����
		//�������̵� -> �α��� ������
		response.sendRedirect("welcome.jsp");
	}else{
		//�������̵� -> �α��� ���н�
		response.sendRedirect("testLogin.jsp");
	}


%>

</body>
</html>
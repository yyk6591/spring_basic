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
	String id=request.getParameter("id"); //session1
	String pw=request.getParameter("pw"); //1111
	
	if(id.equals("session1") && pw.equals("1111")){
		session.setAttribute("id", id);  //���� id�� session����
		session.setMaxInactiveInterval(60*60);
		response.sendRedirect("welcome2.jsp");
	}else{
		response.sendRedirect("testLogin2.jsp");
	}

%>



</body>
</html>
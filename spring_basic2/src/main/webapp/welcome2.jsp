<%@page import="java.util.Enumeration"%>
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
Enumeration enumeration =session.getAttributeNames();

while(enumeration.hasMoreElements()){
	String sName=enumeration.nextElement().toString();
	String sValue=(String)session.getAttribute(sName);
	if(sValue.equals("session1")){
		out.println(sValue+ "�� �ȳ��ϼ���!!!");
	}
}
%>

 <a href="sessiontest.jsp">sessionTest</a>
 <a href="logout2.jsp">�α׾ƿ�</a>
 
</body>
</html>
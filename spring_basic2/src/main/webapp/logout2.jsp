<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α׾ƿ�</title>
</head>
<body>

<%
Enumeration enumeration=session.getAttributeNames();

while(enumeration.hasMoreElements()){
	String sName=enumeration.nextElement().toString();
	String sValue=(String)session.getAttribute(sName);
	
	//Ư�� ���� ����
	if(sValue.equals("session1"))
		session.removeAttribute(sName);
	}
	//��� ���� ���� -> �α׾ƿ�
	if(session!=null) 
		session.invalidate();
	



%>





</body>
</html>
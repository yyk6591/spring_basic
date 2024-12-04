<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그아웃</title>
</head>
<body>

<%
Enumeration enumeration=session.getAttributeNames();

while(enumeration.hasMoreElements()){
	String sName=enumeration.nextElement().toString();
	String sValue=(String)session.getAttribute(sName);
	
	//특정 세션 삭제
	if(sValue.equals("session1"))
		session.removeAttribute(sName);
	}
	//모든 세션 삭제 -> 로그아웃
	if(session!=null) 
		session.invalidate();
	



%>





</body>
</html>
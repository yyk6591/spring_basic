<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session test</title>
</head>
<body>

	<%
	Enumeration enumeration=session.getAttributeNames();
	int i=0;
	while(enumeration.hasMoreElements()){
		i++;
		
		String sName=enumeration.nextElement().toString();
		String sValue=(String)session.getAttribute(sName);
		
		out.println("sName: "+sName+ "<br />");
		out.println("sValue: "+sValue+ "<br />");
	}
	if(i==0)out.println("�ش� ������ ���� �Ǿ����ϴ�");
	
	
	%>
	
	
</body>
</html>
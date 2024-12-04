<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session get</title>
</head>
<body>

	<%
	String mySessionName=(String)session.getAttribute("session1");
	out.println(mySessionName);
	
	Integer myNum=(Integer) session.getAttribute("session2");
	out.println(myNum);
	
	String myNum2=(String)session.getAttribute("session3");
	out.println(myNum2);
	out.println("******************<br />");
	
	String sName;
	String sValue;
	//session 모든 data
	Enumeration enumeration=session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		sName=enumeration.nextElement().toString();
		sValue=session.getAttribute(sName).toString();
		out.println("sName: "+sName+ " ,sValue: "+sValue+"<br />");
		
	}
	out.println("******************<br />");
	
	//WAS 자동으로 1개 설정..30분
	String sessionId=session.getId();
	out.println("sessionId: "+sessionId+"<br />");
	//세션 유지 시간 기본 30분 cof 폴더 -web.xml
	int sessionInter=session.getMaxInactiveInterval();
	out.println("sessionInter: "+sessionInter+"<br />");
	out.println("******************<br />");
	session.removeAttribute("session1");  //특정 session 종료
	Enumeration enumeration1= session.getAttributeNames();
	
	while(enumeration1.hasMoreElements()){
		sName=enumeration1.nextElement().toString();
		sValue=session.getAttribute(sName).toString();
		out.println("sName: "+sName+ "<br />");
		out.println("sValue: "+sValue+ "<br />");
	
	}
	out.println("******************<br />");
	 //모든 session 종료 -> 로그아웃 상태
	 session.invalidate();
	 
	 if(request.isRequestedSessionIdValid()){
		 out.println("session valid");
	 }else{
		 out.println("session invalid");
	 }
	

	%>
	
	
	
	
	
</body>
</html>
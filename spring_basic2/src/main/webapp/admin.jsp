<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	//세션설정
    session.setAttribute("sessionId", "ROLE_ADMIN");
 	//세션조회
    String sessionId=(String)session.getAttribute("sessionId");
    
 	if(!sessionId.equals("ROLE_ADMIN")){
 		%>
 		<script>
 		alert('관리자만 이용할수 있습니다!');
 		location.href='http://naver.com';
 		</script>
 		
 		<%
 		
 
 		/* out.write("<script>");
 		out.write("alert('관리자만 이용할 수 있습니다...');");
 		out.write("location.href='http://naver.com'");
 		out.write("</script>"); */
 	}
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
</head>
<body>
<%

//java code 작성




%>




</body>
</html>
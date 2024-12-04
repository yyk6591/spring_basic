
<%@page import="org.project.constraint.Role"%>
<%@page import="org.project.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String sessionId=(String)session.getAttribute("userEmail");
    String ROLE=(String)session.getAttribute("Role");
    if(sessionId!=null){
    	%>
    	<script>
			alert('로그인 상태!!')    	
    	</script>
    	<%
    }
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>


<h1>index</h1>
<a href="join.member">회원가입페이지</a> <br>
<a href="memberList.member">회원목록조회</a> <br>
<%
if(sessionId!=null){
%>
<a href="logout.member">로그아웃</a>	<br/>
	권한: <%=ROLE %>
	
<a href="writeView.board">게시글작성페이지</a>
	<%
}


%>
<a href="login.member">로그인페이지</a>

</body>
</html>
<%@page import="org.project.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%
    List<MemberDto>memberList=(List<MemberDto>) request.getAttribute("memberList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록</h1>
		<table>
		<tr>
			<th>ID</th>
			<th>Email</th>
			<th>Name</th>
			<th>age</th>
			<th>role</th>
			<th>createTime</th>
			<th>updateTime</th>
			<th>보기</th>
		</tr>
		
	<%
	
	for(MemberDto memberDto: memberList){
		%>
		<tr>
		
			<td><%=memberDto.getMemberId()%></td>
			<td><%=memberDto.getUserEmail() %></td>
			<td><%=memberDto.getUserName() %></td>
			<td><%=memberDto.getAge() %></td>
			<td></td>
			<td></td>
			<td></td>

		</tr>
		<%
	}
	
	
	%>
		
		
		
		
		
		
		
		
		
		
		</table>







</body>
</html>
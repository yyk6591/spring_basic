<%@page import="org.project.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% 
   
    
		MemberDto memberDto=(MemberDto)request.getAttribute("memberDto");    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원상세목록</title>
</head>
<body>
	<h1><%=memberDto.getUserName() %>님</h1>

	<thead>
		<tr>
			<th colspan="2">상세보기</th>
		</tr>
		<tr>
			<th>ID</th>
			<th>EMAIL</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>ROLE</th>
			<th>CREATETIME</th>
			<th>UPDATETIME</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td><%=memberDto.getMemberId() %></td>
		<td><%=memberDto.getUserEmail() %></td>
		<td><%=memberDto.getUserName() %></td>
		<td><%=memberDto.getAge() %></td>
		<td><%=memberDto.getRole() %></td>
		<td><%=memberDto.getCreateTime() %></td>
		<td><%=memberDto.getUpdateTime() %></td>
		</tr>
		<tr>
		<!-- 세션이메일과 이메일이 같으면 버튼 보이기안보이기 -->
			<%
			String userEmail =(String) session.getAttribute("userEmail");
		
			if(userEmail!=null && userEmail.equals(memberDto.getUserEmail())){
				%>	
			
			
		<td><a href="updateView.member?memberId=<%=memberDto.getMemberId() %>">수정페이지</a></td>
		<td><a href="delete.member?memberId=><%=memberDto.getMemberId() %>">삭제</a></td>
			
		</tr>
		<%
		}
			%>
			<tr>
				<td colspan="2">
				<%
				if(userEmail==null){
					%>
					<a href="join.member">회원가입페이지</a> <br>
					<%
				}
				%>
				<a href="memberList.member">회원목록페이지</a>
				</td>
			
			</tr>
	</tbody>
	


</body>
</html>
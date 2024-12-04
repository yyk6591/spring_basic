<%@page import="org.project.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    
    String sessionEmail=(String) session.getAttribute("userEmail");
    
    if(sessionEmail==null){
    	%>
    	<script>
    		alert("로그인후 이용하세요!");
    		location.href="/loginView.member";
    	</script>
    	<%
    }

    MemberDto memberDto=(MemberDto)request.getAttribute("memberDto"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원수정</title>
</head>
<body>
	<h1><%=memberDto.getUserName() %>님</h1>

	<thead>
		<tr>
			<th colspan="2">상세보기</th>
		</tr>
		<form action="updateOk.member" method="POST">
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
		<td>
			<input type="text" value="<%=memberDto.getMemberId() %>" name="memberId" readonly="readonly">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getUserEmail() %>" name="userEmail" readonly="readonly">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getUserName() %>" name="userName">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getAge() %>" name="age">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getRole() %>" name="role" readonly="readonly">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getCreateTime() %>" name="createTime" readonly="readonly">
		</td>
		<td>
			<input type="text" value="<%=memberDto.getUpdateTime() %>" name="updateTime" readonly="readonly">
		</td>
		</tr>
		</form>
		<tr>
			<td colspan="2">
			
			</td>
		</tr>
		<tr>
		<td><a href="updateView.member?memberId=<%=memberDto.getMemberId() %>"></a></td>
		<td><a href="delete.member?memberId=><%=memberDto.getMemberId() %>"></a></td>
		</tr>
	</tbody>
</body>
</html>
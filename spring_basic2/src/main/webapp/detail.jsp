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
<title>ȸ���󼼸��</title>
</head>
<body>
	<h1><%=memberDto.getUserName() %>��</h1>

	<thead>
		<tr>
			<th colspan="2">�󼼺���</th>
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
		<!-- �����̸��ϰ� �̸����� ������ ��ư ���̱�Ⱥ��̱� -->
			<%
			String userEmail =(String) session.getAttribute("userEmail");
		
			if(userEmail!=null && userEmail.equals(memberDto.getUserEmail())){
				%>	
			
			
		<td><a href="updateView.member?memberId=<%=memberDto.getMemberId() %>">����������</a></td>
		<td><a href="delete.member?memberId=><%=memberDto.getMemberId() %>">����</a></td>
			
		</tr>
		<%
		}
			%>
			<tr>
				<td colspan="2">
				<%
				if(userEmail==null){
					%>
					<a href="join.member">ȸ������������</a> <br>
					<%
				}
				%>
				<a href="memberList.member">ȸ�����������</a>
				</td>
			
			</tr>
	</tbody>
	


</body>
</html>
<%@page import="org.project.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    List<BoardDto> boardList=(List<BoardDto>)request.getAttribute("boardId");    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 목록 조회</title>
</head>
<body>
	<h1>회원목록</h1>
		<table>
		<tr>
			<th>ID</th>
			<th>title</th>
			<th>content</th>
			<th>memberId</th>
			<th>createTime</th>
			<th>updateTime</th>
			<th>보기</th>
		</tr>
		
	<%
	
	for(BoardDto boardDto:boardList){
		%>
		<tr>
		
			<td><%=boardDto.getBoardId()%></td>
			<td><%=boardDto.getTitle() %></td>
			<td><%=boardDto.getContent() %></td>
			<td><%=boardDto.getMemberId() %></td>
			<td><%=boardDto.getCreateTime() %></td>
			<td><%=boardDto.getUpdateTime() %></td>
			

		</tr>
		<%
	}
	
	
	%>
		
		
		
		
		
		
		
		
		
		
		</table>




</body>
</html>
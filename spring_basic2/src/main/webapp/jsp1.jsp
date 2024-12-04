
<%@page import="java.util.ArrayList"%>
<%@page import="org.project.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
        List<MemberDto> memberDtos=new ArrayList<>();
    
		memberDtos.add(new MemberDto(1L,"m1","m1",11,null,null,null));    
		memberDtos.add(new MemberDto(2L,"m2","m12",31,null,null,null));    
		memberDtos.add(new MemberDto(3L,"m3","m13",51,null,null,null));    
		memberDtos.add(new MemberDto(4L,"m4","m14",21,null,null,null));    
		memberDtos.add(new MemberDto(5L,"m5","m16",23,null,null,null));    
		
		
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=10 %> <br/>
<%="문자열" %> <br/>
<%=new Date() %> <br/>
<%=100+50 %> <br/>
<%=memberDtos.get(0) %>  <br/>
<ul>
<%
	for(MemberDto memberDto: memberDtos){
%>

	<li>
	<span>ID: <%=memberDto.getMemberId() %>  
	<span>EMAIL: <%=memberDto.getUserEmail() %> 
	<span>NAME: <%=memberDto.getUserName() %>  
	<span>AGE: <%=memberDto.getAge() %> 
	 </li>
	

<%		
	}
%>
</ul>

</body>
</html>
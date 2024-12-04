<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%
    	if(session.getAttribute("userEmail")==null){
    		out.println("<script>");
    		out.println("alert('로그인후 이용하세요');");
    		out.println("location.href='"+request.getContextPath()+"/'");
    		out.println("</script>");
    	}
    
    Long memberId=(Long)session.getAttribute("memberId");
    
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 작성</title>
</head>
<body>
	<form action="wirteOk.board" method="POST">
		게시글제목:  <input type="text" name="title" id="title"> <br>
		게시글내용:  <input type="text" name="content" id="content"> <br>
		memberId:  <input type="text" name="memberId" id="memberId" 
		value="<%=memberId %>" readonly="readonly"> <br>
		<input type="submit" value="게시글작성">
	</form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%
    	if(session.getAttribute("userEmail")==null){
    		out.println("<script>");
    		out.println("alert('�α����� �̿��ϼ���');");
    		out.println("location.href='"+request.getContextPath()+"/'");
    		out.println("</script>");
    	}
    
    Long memberId=(Long)session.getAttribute("memberId");
    
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խñ� �ۼ�</title>
</head>
<body>
	<form action="wirteOk.board" method="POST">
		�Խñ�����:  <input type="text" name="title" id="title"> <br>
		�Խñ۳���:  <input type="text" name="content" id="content"> <br>
		memberId:  <input type="text" name="memberId" id="memberId" 
		value="<%=memberId %>" readonly="readonly"> <br>
		<input type="submit" value="�Խñ��ۼ�">
	</form>



</body>
</html>
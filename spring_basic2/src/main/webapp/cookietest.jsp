<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cookie test</title>
</head>
<body>
	<%
	Cookie[] cookies =request.getCookies();
	if(cookies!= null){
		for(int i=0; i<cookies.length; i++){
			out.println(cookies[i].getName());
			out.println(cookies[i].getValue());
		}
	}else{
		%>
		<script>
		
		alert("��Ű�� �������� �ʽ��ϴ� -> �α׾ƿ� ����")
		
		</script>
		
		
		<% 
		
	}
	
	
	
	%>




</body>
</html>
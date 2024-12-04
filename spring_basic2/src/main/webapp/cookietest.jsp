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
		
		alert("쿠키가 존재하지 않습니다 -> 로그아웃 상태")
		
		</script>
		
		
		<% 
		
	}
	
	
	
	%>




</body>
</html>
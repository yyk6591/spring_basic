<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>request</title>
</head>
<body>

	클라이언트 IP = <%=request.getRemoteAddr() %> <br>
	요청정보길이 = <%=request.getContentLength() %> <br>
	요청정보 인코딩 = <%=request.getCharacterEncoding() %> <br>
	요청정보 컨텐트타입 =<%=request.getContentType() %>
	요청정보 프로토콜 = <%=request.getProtocol() %> <br>
	요청정보 전송방식 = <%=request.getMethod() %> <br>
	요청 URI = <%=request.getRequestURI()%> <br>
	컨텍스트 경로 = <%=request.getContextPath() %> <br>
	서버이름 = <%=request.getServerName() %> <br>
	서버포트 = <%=request.getServerPort() %> <br>

	<hr>
	<%=request.getCookies() %> <br>
	<%=request.getSession() %> <br>
	<%=request.getQueryString() %> <br>
	<hr>

	<%=request.getHeader("referer") %> <br>
	<%=request.getHeader("user-agent") %> <br>
	<%=request.getHeader("host") %> <br>
	<%=request.getHeader("User-Agent") %> <br>
	<%=request.getHeader("WL-Proxy-Client-IP") %> <br>
	<%=request.getHeader("Proxy-Client-IP") %> <br>
	<%=request.getHeader("X-Forwarded-For") %> <br>

	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>request</title>
</head>
<body>

	Ŭ���̾�Ʈ IP = <%=request.getRemoteAddr() %> <br>
	��û�������� = <%=request.getContentLength() %> <br>
	��û���� ���ڵ� = <%=request.getCharacterEncoding() %> <br>
	��û���� ����ƮŸ�� =<%=request.getContentType() %>
	��û���� �������� = <%=request.getProtocol() %> <br>
	��û���� ���۹�� = <%=request.getMethod() %> <br>
	��û URI = <%=request.getRequestURI()%> <br>
	���ؽ�Ʈ ��� = <%=request.getContextPath() %> <br>
	�����̸� = <%=request.getServerName() %> <br>
	������Ʈ = <%=request.getServerPort() %> <br>

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
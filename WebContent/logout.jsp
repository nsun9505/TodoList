<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert("�α׾ƿ� �Ǿ����ϴ�.");
	</script>
	<%
		response.sendRedirect("index.jsp");
	%>
</body>
</html>
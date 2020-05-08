<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert("회원 탈퇴 실패");
	</script>
	<jsp:include page="modify.jsp?id=<%=(String)request.getAttribute("id") %>"></jsp:include>
</body>
</html>
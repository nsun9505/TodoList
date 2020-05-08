<%@ page import="MDTO.MemberDTO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% 
	String id = request.getParameter("id");
	session.setAttribute("id", id);
	session.setAttribute("ValidMem", "yes");
	response.sendRedirect("list.do?id="+id);
%>
</body>
</html>
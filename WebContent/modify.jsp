<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 변경</title>
<script language="JavaScript" src="members.js" charset="UTF-8"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
	String id = request.getParameter("id");
%>
<div class="container" style="text-align:center">
	<h3>회원정보변경</h3>
	<hr>
	<form name="modifyForm">
  		<div class="form-group">
    		<label for="exampleInputEmail1">아이디</label>
    		<input type="text" value="<%=id %>" class="form-control" id="modifyId" name="id" readOnly>
  		</div>
  		<div class="form-group">
    		<label for="modifyPw">비밀번호</label>
    		<input type="password" class="form-control" id="modifyPw" name="pw" placeholder="변경할 비밀번호 입력">
  		</div>
  		<div class="form-group">
    		<input type="password" class="form-control" id="modifyPwCheck" placeholder="변경할 비밀번호 확인">
  		</div>
  		<div class="form-group">
  			<input type="button" class="btn btn-default" value="비밀번호변경" onclick="checkModifyInfo()">
  			<input type="button" class="btn btn-default" value="회원탈퇴" onclick="checkDelInfo()">
  			<input type="button" class="btn btn-default" value="취소" onclick="window.close()">
  		</div>
	</form>
</div>
</body>
</html>
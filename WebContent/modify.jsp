<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ����</title>
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
	<h3>ȸ����������</h3>
	<hr>
	<form name="modifyForm">
  		<div class="form-group">
    		<label for="exampleInputEmail1">���̵�</label>
    		<input type="text" value="<%=id %>" class="form-control" id="modifyId" name="id" readOnly>
  		</div>
  		<div class="form-group">
    		<label for="modifyPw">��й�ȣ</label>
    		<input type="password" class="form-control" id="modifyPw" name="pw" placeholder="������ ��й�ȣ �Է�">
  		</div>
  		<div class="form-group">
    		<input type="password" class="form-control" id="modifyPwCheck" placeholder="������ ��й�ȣ Ȯ��">
  		</div>
  		<div class="form-group">
  			<input type="button" class="btn btn-default" value="��й�ȣ����" onclick="checkModifyInfo()">
  			<input type="button" class="btn btn-default" value="ȸ��Ż��" onclick="checkDelInfo()">
  			<input type="button" class="btn btn-default" value="���" onclick="window.close()">
  		</div>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	if(session.getAttribute("ValidMem") == null) {
%>
	<jsp:forward page="index.jsp" />
<%
	}
	String id = (String)session.getAttribute("id");
%>
<c:set var='f' value="value"/>
<c:set var='d' value="date"/>
<c:set var="now" value="<%=new java.util.Date()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>To do List Main</title>
<script language="JavaScript" src="task.js" charset="UTF-8"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
hr{
	width:800px;
	color : green;
	size : 10px;
}
</style>
</head>
<body>
<div>
	<div style="text-align:center;">
		<h1 style="font:60px arial"><%=id %>님의 To-Do List</h1>
	</div>
	<div style="text-align:right;">
		<input type="button" value="회원정보변경" class="btn btn-default" onclick="popup('<%=id%>')">
		<input type="reset" value="로그아웃" class="btn btn-default" onclick="javascript:window.location='logout.jsp'">&nbsp;&nbsp;&nbsp;
	</div>
	<hr>
</div>
<div style="text-align:right">
	<form class="form-inline" method="post" name="deleteForm">
		<input type="hidden" name="id" value="<%=id %>">
		<input type="hidden" name="status" value="1">
		<input class="btn btn-default" type="button" value="ToDo전체 삭제" onclick="deleteSelect('1')">
		<input class="btn btn-default" type="button" value="Doing전체 삭제" onclick="deleteSelect('2')">
		<input class="btn btn-default" type="button" value="Done전체 삭제" onclick="deleteSelect('3')">
	</form>
</div>
<div class="container" style="text-align:center">
	<h2>Add Task</h2>
	<form class="form-inline" method="post" id="insertForm">
		<input type="hidden" name="id" value="<%=id %>">
  		<div class="form-group">
    		<input type="text" style="width:300px" class="form-control" id="mytask" name="task" placeholder="Task" maxlength="100">
  		</div>
  		<div class="form-group">
    		<input type="date" class="form-control" id="currentDate" name="deadline" max="2040-12-31">
  		</div>
  		<div class="form-group">
  			<input type="button" class="btn btn-default" value="추가" onclick="return checkInsertInfo()">
  		</div>
  		<div class="form-group">
  			<input type="button" class="btn btn-default" value="초기화" onclick="return insertItemInit()">
  		</div>
	</form>
	<script>
			document.getElementById("currentDate").value = new Date().toISOString().slice(0,10);
			document.getElementById("currentDate").min = new Date().toISOString().slice(0,10);
	</script>
</div>
	<hr>
<div class="container" style="text-align:center">
	<h2>To do</h2>
	<c:forEach items="${list}" var="dto">
		<c:if test="${dto.taskStatus == 1}">
			<form class="form-inline" action="updateTodo.do" method="post" id="${f}${dto.tId}">
				<input type="hidden" name="id" value="<%=id%>">
				<div class="form-group">
					<input type="text" name="todoTask" class="form-control" style="width:300px" value="${dto.task}">
				</div>
				<div class="form-group">
				<input type="date" name="todoDate" class="form-control" value="${dto.deadline}" max="2040-12-31">
				</div>
				<div class="form-group">
					<select name="taskStatus" class="form-control">
						<option value="1" selected="selected">To Do</option>
						<option value="2">Doing</option>
						<option value="3">Done</option>
					</select>
				</div>
				<div class="form-group">
					<input type="hidden" name="taskId" class="form-control" value="${dto.tId}">
				</div>
				<div class="form-group">
					<input type="button" value="수정" class="btn btn-default" onclick="checkUpdate(${f}${dto.tId})">
				</div>
				<div class="form-group">
					<input type="button" value="삭제" class="btn btn-default" onclick="checkDelete(${f}${dto.tId})">
				</div>
			</form>
			</c:if>
	</c:forEach>
</div>
<hr>
<div class="container" style="text-align:center">
	<h2>Doing</h2>
	<c:forEach items="${list}" var="dto">
		<c:if test="${dto.taskStatus == 2}">
			<form class="form-inline" action="updateTodo.do" method="post" id="${f}${dto.tId}">
				<input type="hidden" name="id" value="<%=id %>">
				<div class="form-group">
					<input class="form-control" type="text" name="todoTask" style="width:300px" value="${dto.task}">
				</div>
				<div class="form-group">
					<input class="form-control" type="date" name="todoDate" value="${dto.deadline}" max="2040-12-31">
				</div>
				<div class="form-group">
					<select name="taskStatus" class="form-control">
						<option value="1" >To Do</option>
						<option value="2" selected="selected">Doing</option>
						<option value="3">Done</option>
					</select>
				</div>
				<input type="hidden" name="taskId" value="${dto.tId}">
				<div class="form-group">
					<input type="button" value="수정" class="btn btn-default" onclick="checkUpdate(${f}${dto.tId})">
				</div>
				<div class="form-group">
					<input type="button" value="삭제" class="btn btn-default" onclick="checkDelete(${f}${dto.tId})">
				</div>
			</form>
		</c:if>
	</c:forEach>
</div>
<hr>
<div class="container" style="text-align:center">
	<h2>Done</h2>
	<c:forEach items="${list}" var="dto">
		<c:if test="${dto.taskStatus == 3}">
			<form class="form-inline" action="updateTodo.do" method="post" id="${f}${dto.tId}">
				<input type="hidden" name="id" value="<%=id%>">
				<div class="form-group">
					<input class="form-control" type="text" name="todoTask" style="width:300px" value="${dto.task}" >
				</div>
				<div class="form-group">
					<input class="form-control" type="date" name="todoDate" value="${dto.deadline}" max="2040-12-31">
				</div>
				<div class="form-group">
					<select name="taskStatus" class="form-control">
						<option value="1" >To Do</option>
						<option value="2">Doing</option>
						<option value="3" selected="selected">Done</option>
					</select>
				</div>
				<input type="hidden" name="taskId" value="${dto.tId}">
				<div class="form-group">
					<input type="button" value="수정" class="btn btn-default" onclick="checkUpdate(${f}${dto.tId})">
				</div>
				<div class="form-group">
					<input type="button" value="삭제" class="btn btn-default" onclick="checkDelete(${f}${dto.tId})">
				</div>
			</form>
		</c:if>
	</c:forEach>
</div>
<script>
	var myDate = document.getElementsByName("todoDate");
	var min = new Date().toISOString().slice(0,10);
	for(var i = 0; i < myDate.length; i++){
		myDate[i].min = min;
	}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	body{
		color: #fff;
		background: #63738a;
	}
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
<title>To Do List</title>
</head>
<body>
<div class="container">
	<br><br><br>
	<h1 style="text-align:center; font: 50px arial">To Do List</h1>
	<div class="login-form">
    <form action="loginCheck.do" method="post">
        <h2 class="text-center" style="color:#63738a">Log in</h2>       
        <div class="form-group">
            <input type="text" class="form-control" name="id" placeholder="���̵�" maxlength="20" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="pw" placeholder="��й�ȣ" maxlength="20" required="required">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary btn-block" value="�α���">
        </div>        
    </form>
    <p class="text-center"><a href="join.jsp" style="color:#fff">ȸ������</a></p>
	</div>
</div>
</body>
</html>
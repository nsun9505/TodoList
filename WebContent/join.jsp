<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	String checkId = (String)request.getAttribute("checkOkId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
<script type="text/javascript" src="<c:url value="/resource/js/jquery-3.4.1.js"/>"></script>
<script language="JavaScript" src="members.js" charset="UTF-8"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
	body{
		color: #fff;
		background: #63738a;
		font-family: 'Roboto', sans-serif;
	}
    .form-control{
		height: 40px;
		box-shadow: none;
		color: #969fa4;
	}
	.form-control:focus{
		border-color: #5cb85c;
	}
    .form-control, .btn{        
        border-radius: 3px;
    }
	.signup-form{
		width: 400px;
		margin: 0 auto;
		padding: 30px 0;
	}
	.signup-form h2{
		color: #636363;
        margin: 0 0 15px;
		position: relative;
		text-align: center;
    }
	.signup-form h2:before, .signup-form h2:after{
		content: "";
		height: 2px;
		width: 30%;
		background: #d4d4d4;
		position: absolute;
		top: 50%;
		z-index: 2;
	}	
	.signup-form h2:before{
		left: 0;
	}
	.signup-form h2:after{
		right: 0;
	}
    .signup-form .hint-text{
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f2f3f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}
	.signup-form input[type="checkbox"]{
		margin-top: 3px;
	}
	.signup-form .btn{        
        font-size: 16px;
        font-weight: bold;		
		min-width: 140px;
        outline: none !important;
    }
	.signup-form .row div:first-child{
		padding-right: 10px;
	}
	.signup-form .row div:last-child{
		padding-left: 10px;
	}    	
    .signup-form a{
		color: #fff;
		text-decoration: underline;
	}
    .signup-form a:hover{
		text-decoration: none;
	}
	.signup-form form a{
		color: #5cb85c;
		text-decoration: none;
	}	
	.signup-form form a:hover{
		text-decoration: underline;
	}  
</style>
</head>
<body>
<div class="signup-form">
	<form action="joinOk.do" method="post" name="joinForm">
		<h2>ȸ������</h2>
		<p class="hint-text" style="font-size:10px;">���̵�, ��й�ȣ : 4~14���� ���� ��ҹ��ڿ� ���ڷθ� �Է�</p>
        <div class="form-group">
			<div class="row">
			<%if(checkId == null){ %>
				<div class="col-xs-6"><input type="text" class="form-control" id="user_id" name="id" placeholder="���̵�" required="required" maxlength="14"></div>
				<div class="col-xs-6"><input type="button" class="form-control" onclick="return checkDupId()" value="�ߺ�Ȯ��"></div>
			<%} else{ %>
				<div class="col-xs-6"><input type="text" class="form-control" id="user_id" name="id" value="<%=checkId%>" placeholder="���̵�" required="required" maxlength="14" readOnly></div>
				<div class="col-xs-6"><input type="button" class="form-control" onclick="return checkDupId()" value="�ߺ�Ȯ��" disabled="disabled"></div>
			<% } %>
			</div>        	
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="name" placeholder="�̸�" required="required" maxlength="14">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" id="user_pw" name="pw" placeholder="��й�ȣ" required="required" maxlength="14">
        </div>
		<div class="form-group">
            <input type="password" class="form-control" id="user_pwCheck" name="pwck" placeholder="��й�ȣ Ȯ��" required="required">
        </div>        
		<div class="form-group">
            <input type="button" class="btn btn-success btn-lg btn-block" value="ȸ������" onclick="return checkInfo()">
        </div>
    </form>
	<div class="text-center">�̹� ������ �ֳ���? <a href="index.jsp">�α��� â ����</a></div>
</div>
</body>
</html>
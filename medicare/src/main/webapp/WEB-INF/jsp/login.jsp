<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<div class="container" align="center">
		<h3>
			<u>Medicare Login</u>
		</h3>
		<form:form id="loginFormId" modelAttribute="loginForm"
			action="checkLogin" onsubmit="return false;">
			<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />

			<div align="center" class="form-group">
				<input type="text" name="username" placeholder="Enter Username">
			</div>
			<div align="center" class="form-group">
				<input type="password" name="password" placeholder="Enter Password">
			</div>
			<div>
				<button class="btn btn-primary form-group" name="Submit" id='buttonId'
					type="button" value="Save"
					onclick="javascript:formSubmit('checkLogin',this.form,'checkLogin');">
					Submit</button>
			</div>
				<div ${ loginForm.loginSuccessfull==false ? '' : 'hidden'} style="color: red;">Please enter proper username and password</div>
			</form>
			<div style="padding-top: 30px">
				<button  class="btn btn-primary form-group" name="Register" id='Register'
					type="button" value="Register"
					onclick="javascript:formSubmit('registerUser',this.form,'registerUser');">
					Register as User</button>
			</div>
		</form:form>
	</div>
</body>
</html>
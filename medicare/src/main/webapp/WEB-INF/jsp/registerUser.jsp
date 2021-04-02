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
	<div class="container">
	<h2>Register User</h2>
	<form:form id="registerUserFormId" modelAttribute="registerUserForm" action="saveRegisterUser" onsubmit="return false;">
		<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />
		<div class="form-group">
			Enter the name : <input type="text" name="username" />
		</div>
		<div class="form-group">
			Enter the password : <input type="text" name="password" />
		</div>
		<div class="form-group">
			Enter the email : <input type="text" name="usermail" />
		</div>
		<div>
			<button class="btn btn-primary" name="Submit" id='buttonId' type="button" value="Save" onclick="javascript:formSubmit('saveRegisterUser',this.form,'saveRegisterUser');">
			Submit
			</button>
		</div>
	</form:form>
	</div>
</body>
</html>
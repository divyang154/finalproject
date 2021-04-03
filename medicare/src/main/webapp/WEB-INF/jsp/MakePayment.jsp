<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/common.js"></script>
</head>
<body>
	<div class="container">
		<h2>Make Payment</h2>
		<form:form id="makePayment" modelAttribute="addMedicineForm" action="payAndSave" onsubmit="return false;">
			<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />
			<div class="form-group">
				Credit Card Number : <input type="text" pattern="[0-9.]+"
					name="username" />
			</div>
			<div class="form-group">
				CVV Number : <input type="text" name="password" />
			</div>
			<div class="form-group">
				Expiry Date : <input type="month" name="email" />
			</div>
			<div class="form-group">
				<button class="btn btn-primary" name="Update" id='buttonId'
					type="button" value="Purchase"
					onclick="javascript:formSubmit('payAndSave',this.form,'payAndSave');">
					Make Payment</button>
			</div>
	</form:form>
	</div>
</body>
</html>
</html>
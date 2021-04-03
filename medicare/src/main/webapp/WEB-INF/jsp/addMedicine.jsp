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
	<h2>Medicine List</h2>
	<form:form id="addMedicineFormId" modelAttribute="addMedicineForm" action="addMedicine" onsubmit="return false;">
		<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />
		<div class="form-group">
			Enter the Medicine name : <input type="text" name="medicineName" />
		</div>
		<div class="form-group">
			Enter the Medicine price : <input type="text" name="medicinePrice" />
		</div>
		<div class="form-group">
			Enter the medicine seller : <input type="text" name="medicineSeller" />
		</div>
		<div class="form-group">
			Enter the medicine description : <input type="text" name="medicineDescription" />
		</div>
		<div>
			<button class="btn btn-primary" name="Submit" id='buttonId' type="button" value="Save" onclick="javascript:formSubmit('showAllMedicine',this.form,'showAllMedicine');">
			Submit
			</button>
		</div>
	</form:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
		<h2>User Purchase List</h2>
		<form:form id="userPurchaseFormId" modelAttribute="addMedicineForm"
			onsubmit="return false;">
			<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />
			<div class="panel-body container">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Select</th>
							<th>Medicine Name</th>
							<th>Medicine Price</th>
							<th>Medicine Seller</th>
							<th>Medicine Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${addMedicineForm.medicineDtoList}"
							varStatus="row" var="medicineDtosListVar">
							<tr id=${medicineDtosListVar.medicineId}>
								<td><input type="checkbox" name="selected"
									value="${medicineDtosListVar.medicineId}"></td>
								<td>${medicineDtosListVar.medicineName}</td>
								<td>${medicineDtosListVar.medicinePrice}</td>
								<td>${medicineDtosListVar.medicineSeller}</td>
								<td>${medicineDtosListVar.medicineDescription}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<button class="btn btn-primary" name="Update" id='buttonId'
						type="button" value="Purchase"
						 onclick="javascript:formSubmit('addMedicine',this.form,'getList');">
						Purchase</button>
				</div>
		</form:form>
	</div>
</body>
</html>
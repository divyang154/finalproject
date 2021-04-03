<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Medicine</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript" src="js/common.js"></script>	
</head>
<body>
	<div class="container">
		<h2 id="welcome-message">Display All Medicine</h2>
			<form:form id="editMedicineFormId" modelAttribute="addMedicineForm" onsubmit="return false;">
		<form:hidden id="formAct" path="formAct" value="businessDayEntryView" />
		<div class="panel-body container">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Medicine Name</th>
						<th>Medicine Price</th>
						<th>Medicine Seller</th>
						<th>Medicine Description</th>
						<th>Admin Operation</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${medicineForm.medicineDtoList}" varStatus="row"
						var="medicineDtosListVar">
						<tr id="${medicineDtosListVar.medicineId}">
							<td>${medicineDtosListVar.medicineName}</td>
							<td>${medicineDtosListVar.medicinePrice}</td>
							<td>${medicineDtosListVar.medicineSeller}</td>
							<td>${medicineDtosListVar.medicineDescription}</td>
							<td>
								<div>
									<button class="btn btn-primary" name="Update" id='buttonId'
										type="button" value="Update" ${ medicineDtosListVar.status==1 ? 'disabled="disabled"' : ''}
										onclick="javascript:medicineSearch(${medicineDtosListVar.medicineId},this.form);">
										Update</button>
									<button class="btn btn-primary" name="Delete" id='buttonId'
										type="button" value="Delete" ${ medicineDtosListVar.status==1 ? 'disabled="disabled"' : ''}
										onclick="javascript:medicineDelete(${medicineDtosListVar.medicineId},this.form);">
										Delete</button>
								   <button class="btn btn-primary" name="Enable"
										type="button" value="Enable" id="${medicineDtosListVar.medicineId}enable"
										onclick="javascript:medicineStatusEnable(${medicineDtosListVar.medicineId},this.form,1);">
										Enable</button>
									<button class="btn btn-primary" name="Disable" ${ medicineDtosListVar.status==1 ? 'disabled="disabled"' : ''}
										type="button" value="Disable" id="${medicineDtosListVar.medicineId}disable"
										onclick="javascript:medicineStatusDisable(${medicineDtosListVar.medicineId},this.form,0);">
										Disable</button>			
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<button class="btn btn-primary" name="Update" id='buttonId'
						type="button" value="Add Medicine"
						 onclick="javascript:formSubmit('loadMedicine',this.form,'loadMedicine');">
						Add Medicine</button>
		</form:form>
	</div>
</body>
<script>
function medicineSearch(medicineId,form) {
document.forms[0].action ='editMedicine?medicineId='+medicineId;
document.forms[0].submit();
}
function medicineDelete(medicineId,form) {
	document.forms[0].action ='deleteMedicine?medicineId='+medicineId;
	document.forms[0].submit();
}
function medicineStatusEnable(medicineId,form,value) {
	document.forms[0].action ='changeStatusEnable?medicineId='+medicineId;
	document.forms[0].submit();
}
function medicineStatusDisable(medicineId,form,value) {
	document.forms[0].action ='changeStatusDisable?medicineId='+medicineId;
	document.forms[0].submit();
}
</script>
</html>
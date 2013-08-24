<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	$(function() {
		$('#dob').datepicker({
			dateFormat : 'dd-mm-yy',
			changeYear : true
		});
	});
</script>

</head>
<body>
	<div class="page-header">Student Registration Form</div>

	<form:form modelAttribute="frmBean" action="" method="POST">
		<fieldset>
			<legend>Student Details</legend>
			<table>
				<thead>
					<tr>
						<td width="120">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<tr>
					<td><label for="firstName"><spring:message
								code="label.student.firstName" /></label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><label for="middleName"><spring:message
								code="label.student.middleName" /></label></td>
					<td><form:input path="middleName" /></td>
				</tr>
				<tr>
					<td><label for="lastName"><spring:message
								code="label.student.lastName" /></label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><label for="dob"><spring:message
								code="label.student.dateOfBirth" /></label></td>
					<td><form:input path="dob" /></td>
				</tr>
				<tr>
					<td><label for="gender"><spring:message
								code="label.student.gender" /></label></td>
					<td><form:select path="gender" cssStyle="width:125px;">
							<form:option value="-" label=" -- Select -- " />
							<form:option value="Male" label="Male" />
							<form:option value="Female" label="Female" />
						</form:select></td>
				</tr>
				<tr>
					<td><label for="gradeId"><spring:message
								code="label.student.grade" /></label></td>
					<td><form:select path="gradeId" cssStyle="width:125px;">
							<form:option value="0" label=" -- Select -- " />
							<form:options items="${fb.grades}" itemValue="gradeId"
								itemLabel="gradeName" />
						</form:select></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>Contact Details</legend>
			<table>
				<thead>
					<tr>
						<td width="120">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<%-- Contact details --%>
				<tr>
					<td><label for="building"><spring:message
								code="label.student.building" /></label></td>
					<td><form:input path="building" /></td>
				</tr>
				<tr>
					<td><label for="street"><spring:message
								code="label.student.street" /></label></td>
					<td><form:input path="street" /></td>
				</tr>
				<tr>
					<td><label for="area"><spring:message
								code="label.student.area" /></label></td>
					<td><form:input path="area" /></td>
				</tr>
				<tr>
					<td><label for="city"><spring:message
								code="label.student.city" /></label></td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td><label for="state"><spring:message
								code="label.student.state" /></label></td>
					<td><form:input path="state" /></td>
				</tr>
				<tr>
					<td><label for="state"><spring:message
								code="label.student.phoneNumber" /></label></td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td><label for="state"><spring:message
								code="label.student.alternatePhoneNumber" /></label></td>
					<td><form:input path="alternatePhoneNumber" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button value="reset" disabled="disabled">Reset</button>&nbsp;<form:button>Submit</form:button></td>
				</tr>
			</table>
		</fieldset>
	</form:form>

</body>
</html>
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
	<form:form modelAttribute="frmBean" action="" method="POST">
		<table>
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
				<td><label for="gradeId"><spring:message code="label.student.grade"/></label></td>
				<td>
					<form:select path="gradeId" cssStyle="width:125px;">
						<form:option value="0" label=" -- Select -- " />
						<form:options items="${fb.grades}" itemValue="gradeId" itemLabel="gradeName" />
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td>&nbsp;</td>
				<td><form:button value="Reset">Reset</form:button>&nbsp;<form:button>Submit</form:button></td>
			</tr>
		</table>

	</form:form>
</body>
</html>
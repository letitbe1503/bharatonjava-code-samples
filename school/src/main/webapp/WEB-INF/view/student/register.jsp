<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="frmBean">
		<table>
			<tr>
				<td><label for="firstName">First Name</label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><label for="middleName">Middle Name</label></td>
				<td><form:input path="middleName" /></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name</label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><label for="age">Age</label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</table>



	</form:form>
</body>
</html>
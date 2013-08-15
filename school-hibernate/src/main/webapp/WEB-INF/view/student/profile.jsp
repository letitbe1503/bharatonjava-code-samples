<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="page-header">Student's Profile</div>



	<table border="0" width="100%" cellpadding="5" style="text-align: left;">
		<thead>
			<tr>
				<td width="150">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</thead>
		<tr>
			<td><label>Student Id</label></td>
			<td>${student.studentId}</td>
		</tr>
		<tr>
			<td><label>Student Name</label></td>
			<td>${student.firstName}&nbsp;${student.middleName}&nbsp;${student.lastName}</td>
		</tr>
		<tr>
			<td><label>Date of Birth</label></td>
			<td><fmt:formatDate value="${student.dob}" type="date" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>
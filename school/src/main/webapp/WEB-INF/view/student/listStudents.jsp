<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<h3>All Students</h3>
	<table border="1" width="100%">
		<tr>
			<td><strong>First Name</strong></td>
			<td><strong>Middle Name</strong></td>
			<td><strong>Last Name</strong></td>
			<td><strong>Date of Birth</strong></td>
		</tr>
		<c:forEach items="${students}" var="item" varStatus="status">
			<tr>
				<td>${item.firstName}</td>
				<td>${item.middleName}</td>
				<td>${item.lastName}</td>
				<td>${item.dob}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
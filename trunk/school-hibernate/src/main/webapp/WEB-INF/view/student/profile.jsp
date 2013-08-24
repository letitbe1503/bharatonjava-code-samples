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
			<td>Grade</td>
			<td>${student.grade.gradeName }</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>
				<table>
					<tr><td>${student.contact.building},&nbsp;${student.contact.street},&nbsp;${student.contact.area}</td></tr>
					<tr><td>${student.contact.city}&nbsp;${student.contact.city.state}</td></tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td>
				<table cellpadding="5" style="color:white">
					<tr style="background-color:grey"><td><strong>Primary</strong></td><td width="150">${student.contact.phoneNumber}</td></tr>
					<tr style="background-color:grey"><td><strong>Alternate</strong></td><td width="150">${student.contact.alternatePhoneNumber}</td></tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
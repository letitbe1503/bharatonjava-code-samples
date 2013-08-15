<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="page-header">Grade Master</div>

	<form:form modelAttribute="frmBean" action="" method="POST" >
		<fieldset>
			<legend>Grade Master</legend>
			<table>
				<thead>
					<tr>
						<td width="120">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<tr>
					<td><label for="gradeName"><spring:message
								code="label.grade" /></label></td>
					<td><form:input path="gradeName" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button value="reset" disabled="disabled">Reset</button>&nbsp;<form:button>Save</form:button></td>
				</tr>
			</table>
		</fieldset>
		
	</form:form>

	<table cellpadding="5" border="1">
		<tr class="even">
			<th width="80">Grade Id</th>
			<th width="200">Grade Name</th>
			<th width="80">Action</th>
		</tr>
		<c:forEach  items="${grades}" var="g" varStatus="status">
			<tr>
				<td>${g.gradeId}</td>
				<td>${g.gradeName}</td>
				<td><a href="#">Delete</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>
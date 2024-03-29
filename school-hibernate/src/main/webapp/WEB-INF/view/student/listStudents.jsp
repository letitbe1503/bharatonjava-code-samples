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

<script type="text/javascript">
$(document).ready(function() {

	$('#fb select').change(function() {
	   // go($('#grade').val());
	});
	
});

</script>
</head>
<body>

	<div class="page-header">Students by Grade</div>

	<%--	
	<table class="dataGrid">
		<thead>
			<tr>
				<td><strong>First Name</strong></td>
				<td><strong>Middle Name</strong></td>
				<td><strong>Last Name</strong></td>
				<td><strong>Date of Birth</strong></td>
			</tr>
		</thead>
		<c:forEach items="${students}" var="item" varStatus="status">
			<tr>
				<td>${item.firstName}</td>
				<td>${item.middleName}</td>
				<td>${item.lastName}</td>
				<td><fmt:formatDate value="${item.dob}" pattern="dd-MM-yyyy" /></td>
			</tr>
		</c:forEach>
	</table>
 --%>
	<!-- datagrid test -->

	<form:form commandName="fb" method="POST">
		<table>
			<tr>
				<td id="gradeLabel">Choose Grade</td>
				<td>
					<form:select path="grade" cssStyle="width:125px;">
						<form:option value="0" label=" -- Select -- " />
						<form:options items="${fb.grades}" itemValue="gradeId" itemLabel="gradeName" />
					</form:select>
				</td>
				<td>
				<%-- <input id="gradeSubmitBtn" type="submit" value="List Students"> --%>
				<button id="gradeSubmitBtn" type="submit" >List Students</button>
				</td>
				<td>
					<div id="box" class="message">
						<div id="msg">test msg</div>
					</div>
				</td>
			</tr>
		</table>

	</form:form>


	<div class="datagrid">
		<table>
			<thead>
				<tr>
					<th>Sr.No</th>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>Age</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="item" varStatus="status">
					<tr
						<c:if test="${status.index % 2 eq 0}" >
						class = 'alt'	
					</c:if>>
						<td>${status.index + 1 }</td>
						<td>
						<spring:url value="/student/profile?id=${item.studentId}" var="studentProfileUrl" />
						<a href="${studentProfileUrl}" style="text-decoration:none;">
						${item.firstName}&nbsp;${item.middleName}&nbsp;${item.lastName}
						</a>
						
						</td>
						<td><fmt:formatDate value="${item.dob}" pattern="dd-MM-yyyy" /></td>
						<td><jsp:useBean id="dt" class="java.util.Date" /> <c:if
								test="${item.dob ne null and (dt.year - item.dob.year) gt 0}">
								${dt.year - item.dob.year} Y &nbsp;${dt.month - item.dob.month} M
							</c:if></td>
							
						<td>
						<spring:url value="/student/${item.studentId}/fee" var="feeUrl"/>
						<a href="${feeUrl}">Fee</a></td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
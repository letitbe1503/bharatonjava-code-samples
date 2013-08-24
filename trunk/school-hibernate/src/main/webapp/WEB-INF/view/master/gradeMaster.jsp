<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="/WEB-INF/view/common/taglibIncludes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="page-header">Grade Master</div>

	<form:form modelAttribute="frmBean" action="addGrade" method="POST">
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

	<div class="datagrid">
		<table>
			<thead>
				<tr>
					<th width="20">Sr.No.</th>
					<th width="20">Grade Id</th>
					<th width="200">Grade Name</th>
					<th width="80">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${grades}" var="g" varStatus="status">
					<tr
						<c:if test="${status.index % 2 eq 0}" >
						class = 'alt'	
					</c:if>>
						<td>${status.index + 1 }</td>
						<td>${g.gradeId}</td>
						<td>${g.gradeName}</td>
						<td><input
							onclick="javascript:deleteGrade('deleteGrade?id=${g.gradeId}');"
							value="Delete" type="button"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



</body>
</html>
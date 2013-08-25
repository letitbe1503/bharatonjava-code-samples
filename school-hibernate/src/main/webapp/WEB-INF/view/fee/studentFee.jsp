<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/WEB-INF/view/common/taglibIncludes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="page-header">Student Fee</div>


	<form:form modelAttribute="fb" action="fee" method="POST">
		<fieldset>
			<legend>Student Fee</legend>
			<table>
				<thead>
					<tr>
						<td width="120">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<tr>
					<td><label for="feeDate"><spring:message
								code="label.feeDate" /></label></td>
					<td><form:input path="feeDate" /></td>
				</tr>
				<tr>
					<td><label for="amount"><spring:message
								code="label.feeAmount" /></label></td>
					<td><form:input path="amount" /></td>
				</tr>
				<tr>
					<td><label for="comment"><spring:message
								code="label.feeComment" /></label></td>
					<td><form:textarea path="comment"
							cssStyle="width:300px;height:130px;" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><button value="reset" disabled="disabled">Reset</button>&nbsp;<form:button>Save</form:button></td>
				</tr>
			</table>
		</fieldset>

	</form:form>

	<c:choose>

		<c:when test="${fn:length(fees) eq 0}">
			<strong style="text-align: center;"> No records found</strong>
		</c:when>

		<c:otherwise>

			<div class="datagrid">
				<table>
					<thead>
						<tr>
							<th width="20">Sr.No.</th>
							<th width="80">Date</th>
							<th width="80">Amount</th>
							<th>Comment</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fees}" var="f" varStatus="status">
							<tr
								<c:if test="${status.index % 2 eq 0}" >
						class = 'alt'	
					</c:if>>
								<td>${status.index + 1 }</td>
								<td><fmt:formatDate value="${f.feeDate}" /> </td>
								<td>${f.amount}</td>
								<td>${f.comment}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</c:otherwise>
	</c:choose>

</body>
</html>
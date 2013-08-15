<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<spring:url value="assets/images/NoticeBoard.jpg" var="noticeBoardImgUrl" scope="page"/>

	<table border="0" width="100%" style="vertical-align: top;">
		<thead>
			<tr>
				<td width="50%"></td>
				<td width="50%"></td>
			</tr>
		</thead>
		<tr>
			<td><table border="0" width="100%" height="360">
					<thead>
						<tr>
							<td></td>
						</tr>
					</thead>
					<tr>
						<td class="notice-board">
							Independence day celebrations on 15th August
						
						</td>
					</tr>
				</table></td>
			<td style="vertical-align:top"><table border="0" width="100%">
					<thead>
						<tr>
							<td ><h3>Birthdays</h3></td>
						</tr>
					</thead>
					<tr>
						<td style="vertical-align:top">
						List of students with today's birth date to appear here.
						
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
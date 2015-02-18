<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of kids</title>
</head>
<body>
	<table border="1">
	<thead>
		<th>Name</th>
		<th>Age</th>
		<th>Ticket number</th>
		<th>Playsites visited</th>
	</thead>
	<tbody>
		<c:forEach items="${kids}" var="kid">
			<tr>
				<td>${kid.name}</td>
				<td>${kid.age}</td>
				<td>${kid.ticketNumber}</td>
				<td>
					<c:forEach items="${kid.getPlaySiteList()}" var="playSiteSummary">
						${playSiteSummary.toString()} <br />
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<br />
	<h3>Add new kid</h3>
	<form:form  modelAttribute="newKid" method="POST" action="${contextPath}/kids/addNewKid">
	<table>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Ticket number</td>
			<td><form:input path="ticketNumber" /></td>
		</tr>
		<tr>
			<td>Accepts waiting</td>
			<td><form:input path="waitingAccepted" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
			</td>
		</tr>
	</table>
	</form:form>
	<br />
	<a href="${contextPath}">Go to home page</a>
</body>
</html>
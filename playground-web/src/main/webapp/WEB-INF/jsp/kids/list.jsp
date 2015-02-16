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
	<a href="${contextPath}">Go to home page</a>
</body>
</html>
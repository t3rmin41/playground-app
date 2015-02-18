<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of available playsites</title>
</head>
<body>
	<a href="${contextPath}">Go to home page</a>
	<br />
	<br />
	<table border="1">
	<thead>
		<th>Description</th>
		<th>Capacity</th>
	</thead>
	<tbody>
		<c:forEach items="${playsites}" var="playsite">
			<tr>
				<td>${playsite.getDescription()}</td>
				<td>${playsite.getMaximumKids()}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<br />
</body>
</html>
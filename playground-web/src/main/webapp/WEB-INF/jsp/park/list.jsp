<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Amusement park management</title>
</head>
<body>
	<c:forEach items="${amusementParkList}" var="park">
		<table border="1">
		<thead>
			<th>ID</th>
			<th>${park.id}</th>
		</thead>
		<tbody>
			<c:forEach items="${park.getPlaySites()}" var="playSite">
				<tr>
					<td colspan="2">${playSite.toString()}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<br />
	</c:forEach>
	<br />
	<a href="${contextPath}">Go to home page</a>
</body>
</html>
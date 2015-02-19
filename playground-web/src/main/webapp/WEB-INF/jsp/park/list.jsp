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
	<div id="main" style="position: relative">
	<br />
	<div style="position: absolute; bottom: 0">	
		<a href="${contextPath}">Go to home page</a>
	</div>
	<div style="float:left; margin-right: 30px">
	<h3>List of parks</h3>
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
			<c:forEach items="${park.getSnapshots()}" var="snapshot">
					<c:forEach items="${snapshot.getPlaySiteSummaries()}" var="playSiteSummary">
					<tr>
						<td colspan="2">${playSiteSummary.getUtilizationAtTime()}</td>
					</tr>
					</c:forEach>
			</c:forEach>
		</tbody>
		</table>
		<br />
	</c:forEach>
	</div>
	<div style="float:left; margin-right: 30px">
		<h3>List of kids</h3>
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
	</div>
	</div>
</body>
</html>
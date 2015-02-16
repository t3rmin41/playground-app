<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Playground website</title>
</head>
<body>
	<br />
	<a href="${contextPath}/kids/list">List of kids</a>
	<br />
	<a href="${contextPath}/playsite/list">List of playsites</a>
	<br />
	<a href="${contextPath}/park/list">List of amusement parks</a>
</body>
</html>
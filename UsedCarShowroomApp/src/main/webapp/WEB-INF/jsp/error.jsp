<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="header">
			<h1>Used Car Showroom Application</h1>
			<h2 class="links">
				<a href="${contextPath}">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/create">Add New Car</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/logout">Logout</a>
			</h2>
		</div>
		<div class="padding-40" align="center">
			<h1>Error</h1>
			<h2>Something went wrong..</h2>
		</div>	
</body>
</html>
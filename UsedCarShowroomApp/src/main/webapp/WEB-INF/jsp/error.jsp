<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<style>
		     .links, .links a {color: #979da3; text-decoration: none;}
		</style>
	</head>
	<body style="margin:0;background: #e6f0e9;">
		<div
			style="background: #0a3939; color: white; text-align: center; padding: 9px; text-transform: uppercase;">
			<h1>Used Car Showroom Application</h1>
			<h2 class="links">
				<a href="${contextPath}">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/create">Add New Car</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${contextPath}/logout">Logout</a>
			</h2>
		</div>
		<div style="padding: 40px;text-align: center;">
			<h1>Error</h1>
			<h2>Something went wrong..</h2>
		</div>	
</body>
</html>
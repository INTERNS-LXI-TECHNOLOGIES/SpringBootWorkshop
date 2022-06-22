<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Used Car Showroom Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<h2>
			<b>Used Car Showroom Application</b>
		</h2>
	</div>
	<div align="center" class="container">
		<div class="col-sm-4 mt-3">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger mt-n4 mb-3" role="alert">Invalid username
					and password</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success mt-n4 mb-3" role="alert">You have been
					successfully logged out</div>
			</c:if>
			<h3>PLEASE LOGIN</h3>
			<form method="POST" action="${contextPath}/login" class="mt-5">
				<div class="mb-3 row">
					<label for="username" class="col-sm-2 col-form-label">Username</label>
					<div class="col-sm-10">
						<input type="text" name="username" class="form-control col-sm-10"
							id="username">
					</div>
				</div>
				<div class="mb-4 row">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" name="password"
							class="form-control col-sm-10" id="password">
					</div>
				</div>
				<input type="submit" value="LOGIN" class="btn"> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>
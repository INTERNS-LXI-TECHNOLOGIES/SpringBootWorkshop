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
		</div>
		<div align="center">
		<c:if test="${param.error != null}">          
	        <span class="failure"><br><br>Invalid username and password<br><br></span>
	    </c:if>  
	    <c:if test="${param.logout != null}">         
	        <span class="success"><br><br>You have been successfully logged out<br><br></span>
	    </c:if>  
		</div>
		<div align="center">
			<h3>PLEASE LOGIN</h3>
			<form method="POST" action="${contextPath}/login">
				Username: <input type="text" name="username"><br><br>
				Password: <input type="password" name="password"><br><br>
				<input type="submit" value="LOGIN" class="button">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>
	</body>
</html>
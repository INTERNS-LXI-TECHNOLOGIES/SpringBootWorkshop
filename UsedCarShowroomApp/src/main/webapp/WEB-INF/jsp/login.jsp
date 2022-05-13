<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
	</head>
	<body style="margin:0;background: #e6f0e9;">
		<div
			style="background: #0a3939; color: white; text-align: center; padding: 9px; text-transform: uppercase;">
			<h1>Used Car Showroom Application</h1>
		</div>
		<div align="center">
		<c:if test="${param.error != null}">          
	        <span style="color: #d13232;"><br><br>Invalid username and password<br><br></span>
	    </c:if>  
	    <c:if test="${param.logout != null}">         
	        <span style="color: #247d94;"><br><br>You have been successfully logged out<br><br></span>
	    </c:if>  
		</div>
		<div align="center">
			<h3>PLEASE LOGIN</h3>
			<form method="POST" action="${contextPath}/login">
				Username: <input type="text" name="username"><br><br>
				Password: <input type="password" name="password"><br><br>
				<input type="submit" value="LOGIN" style="background: #040505; color: white; border-radius: 12px; padding: 6px 12px; cursor: pointer;">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>
	</body>
</html>
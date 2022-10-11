<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Login Here</title>


	</head>

	<style>
	.login{
	background-color:red;
    border: none;
    border-radius:5px;
    color : white;
      width:70px;
      height:30px

	}


	</style>

	<body>
   <div
   style=" color: red; text-align: center;">
   <h2>Welcome To VEGEE-CART</h2>
</div>

<div align="center">
		<c:if test="${param.error != null}">

	        <span style="color: #d13232;"><br><br>Invalid username or password<br><br></span>
	    </c:if>
	    <c:if test="${param.logout != null}">
	        <span style="color: #247d94;"><br><br>You have been successfully logged out<br><br></span>
	    </c:if>
		</div>

<div align="center">

		</div>
		<div align="center">

			<h3>Log In</h3>
			<form method="POST" action="${contextPath}/login">
				Username: <input type="text" name="username"><br><br>
				Password: <input type="password"  name="password" ><br><br>
				<input type="submit" value="Log In" class="login">

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</body>
</html>
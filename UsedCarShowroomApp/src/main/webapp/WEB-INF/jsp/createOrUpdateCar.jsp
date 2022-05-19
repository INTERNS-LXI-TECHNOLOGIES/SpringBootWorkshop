<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
		<div align="center">
			<form:form action="${contextPath}/save" method="post" modelAttribute="car">
		        <table border="1" cellpadding="5" cellspacing="0" class="uppercase">
		            <caption>
		            	<h2>${caption}</h2>
		            </caption>
		            <tr>
		            	<form:hidden path="carId"/>
		                <th>Manufacturer</th>
		                <td>
		                	<form:input path="manufacturer"/>
		                </td>
		            </tr>
		            <tr>
		                <th>Model</th>
		                <td>
		                	<form:input path="model"/>	
		         	   	</td>
		            </tr>
		            <tr>
		                <th>Variant</th>
		                <td>
		                	<form:input path="variant"/>
		                </td>
		            </tr>
		            <tr>
		                <th>Year</th>
		                <td>
		                	<form:input path="year"/>
		                </td>
		            </tr>
		            <tr>
		                <th>Total Kilometers</th>
		                <td>
		                	<form:input path="totalKilometers"/>
		                </td>
		            </tr>
		            <tr>
		                <th>Expected Price</th>
		                <td>
		                	<form:input path="expectedPrice"/>
		                </td>
		            </tr>
		            <tr>
		                <th>Other Details</th>
		                <td>
		                	<form:input path="otherDetails"/>
		                </td>
		            </tr>
		            <tr>
		            	<td colspan="2" align="center">
		            		<input type="submit" value="Save" class="button" />
		            	</td>
		            </tr>
		        </table>
	        </form:form>
	    </div>	
	</body>
</html>
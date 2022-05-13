<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<style>
		    .links, .links a {color: #979da3; text-decoration: none;}
			input {text-transform: uppercase;}
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
		<div align="center">
			<form:form action="${contextPath}/save" method="post" modelAttribute="car">
		        <table border="1" cellpadding="5" cellspacing="0" style="text-transform: uppercase;">
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
		            		<input type="submit" value="Save" style="background: #040505; color: white; border-radius: 12px; padding: 6px 12px; cursor: pointer;" />
		            	</td>
		            </tr>
		        </table>
	        </form:form>
	    </div>	
	</body>
</html>
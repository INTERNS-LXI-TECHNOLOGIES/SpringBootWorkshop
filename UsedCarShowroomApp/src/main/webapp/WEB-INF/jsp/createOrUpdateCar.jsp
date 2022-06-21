<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="${contextPath}/css/style.css">
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<div align="center" class="container mt-4">
			<form:form action="${contextPath}/save" method="post" modelAttribute="car" class="col-6">
		        <h2>${caption}</h2>
		        <table class="table table-striped uppercase mt-4">
		            <tr class="border">
		            	<form:hidden path="carId"/>
		                <th>Manufacturer</th>
		                <td>
		                	<form:input class="form-control" path="manufacturer"/>
		                </td>
		            </tr>
		            <tr class="border">
		                <th>Model</th>
		                <td>
		                	<form:input class="form-control" path="model"/>	
		         	   	</td>
		            </tr>
		            <tr class="border">
		                <th>Variant</th>
		                <td>
		                	<form:input class="form-control" path="variant"/>
		                </td>
		            </tr>
		            <tr class="border">
		                <th>Year</th>
		                <td>
		                	<form:input class="form-control" path="year"/>
		                </td>
		            </tr>
		            <tr class="border">
		                <th>Total Kilometers</th>
		                <td>
		                	<form:input class="form-control" path="totalKilometers"/>
		                </td>
		            </tr>
		            <tr class="border">
		                <th>Expected Price</th>
		                <td>
		                	<form:input class="form-control" path="expectedPrice"/>
		                </td>
		            </tr>
		            <tr class="border">
		                <th>Other Details</th>
		                <td>
		                	<form:input class="form-control" path="otherDetails"/>
		                </td>
		            </tr>
		            <tr>
		            	<td colspan="2" align="center">
		            		<input type="submit" value="Save" class="btn" />
		            	</td>
		            </tr>
		        </table>
	        </form:form>
	    </div>	
	</body>
</html>
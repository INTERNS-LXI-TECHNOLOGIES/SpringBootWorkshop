<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Used Car Showroom Application</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container mt-5" align="center">
		<h2>CAR DETAILS</h2>
		<table class="table table-bordered uppercase mt-5 caption-top">
			<tr>
				<td><b>CAR ID:</b> ${car.carId}</td>
				<td><b>MANUFACTURER: </b>${car.manufacturer}</td>
				<td><b>MODEL: </b>${car.model}</td>
				<td><b>VARIANT: </b>${car.variant}</td>
			</tr>
			<tr>
				<td><b>YEAR: </b>${car.year}</td>
				<td><b>EXPECTED PRICE: </b>${car.expectedPrice}</td>
				<td><b>TOTAL KILOMETERS: </b>${car.totalKilometers}</td>
				<td><b>OTHER DETAILS: </b>${car.otherDetails}</td>
			</tr>
		</table>
		<table class="table table-striped table-hover uppercase mt-5 border">
 	    	<caption>Owner Details</caption>
			<tr class="bg-th">
				<th>NAME</th>
				<th>ADDRESS</th>
				<th>PHONE NUMBER</th>
				<th>ACTIONS</th>
			</tr>
			<c:forEach var="owner" items="${car.owners}">
				<tr>
					<td>${owner.name}</td>
					<td>${owner.address}</td>
					<td>${owner.phoneNumber}</td>
					<td>
						<sec:authorize access="hasRole('ADMIN')">
							<a href="${contextPath}/car/${car.carId}/delete-owner/${owner.phoneNumber}" onclick="return confirm('Are you sure you want to delete?')"><i title="Remove Owner" class="fa fa-trash text-danger ml-2"></i></a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
		<table class="table table-striped table-hover uppercase mt-5 mb-5 border">
 	    	<caption>Service History</caption>
			<tr class="bg-th">
				<th>SERVICE DATE</th>
				<th>TOTAL KILOMETERS</th>
				<th>SHOWROOM</th>
				<th>ACTIONS</th>
			</tr>
			<c:forEach var="sh" items="${car.serviceHistories}">
				<tr>
					<td>${sh.serviceDate}</td>
					<td>${sh.totalKilometers}</td>
					<td>${sh.showroom}</td>
					<td>
						<sec:authorize access="hasRole('ADMIN')">
							<a href="${contextPath}/car/${car.carId}/edit-service-history/${sh.serviceDate}"><i title="Edit Service History" class="fa fa-edit text-info ml-2"></i></a>
							<a href="${contextPath}/car/${car.carId}/delete-service-history/${sh.serviceDate}" onclick="return confirm('Are you sure you want to delete?')"><i title="Delete Service History" class="fa fa-trash text-danger ml-2"></i></a>
						</sec:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
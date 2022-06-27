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
	<form:form action="${contextPath}/save" method="post" modelAttribute="car">
		<h2>CAR DETAILS</h2>
		<table class="table table-bordered uppercase mt-5 caption-top">
			<caption><c:choose>
			  <c:when test="${action == 'view'}">
				<a href="${contextPath}/car-details/${car.carId}?action=edit" class="btn float-right">EDIT</a>
				<button class="btn float-right mr-2">ADD NEW CAR</button>
				</c:when>
			  <c:otherwise>
				<a href="${contextPath}/car-details/${car.carId}" class="btn float-right">CANCEL</a>
				<input type="submit" value="Save" class="btn float-right mr-2" />
			  </c:otherwise>
			</c:choose></caption>
			<tr>
				<td class="col-sm-2 align-middle">
					<b>CAR ID:</b> ${car.carId}
					<form:hidden path="carId"/>
				</td>
				<td class="col-sm-3">
			      <c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="manufacturer" class="col-sm-6 col-form-label"><b>MANUFACTURER: </b></label>
						    <div class="col-sm-6 pl-1">
				        		<form:input class="form-control" path="manufacturer"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>MANUFACTURER: </b>${car.manufacturer}
					</c:otherwise>
				  </c:choose>
				</td>
				<td class="col-sm-2">
				 <c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="model" class="col-sm-5 col-form-label mr-n2"><b>MODEL: </b></label>
						    <div class="col-sm-7 pl-0">
				        		<form:input class="form-control" path="model"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>MODEL: </b>${car.model}
					</c:otherwise>
				  </c:choose>
				</td>
				<td class="col-sm-5">
				<c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="totalKilometers" class="col-sm-5 col-form-label mr-n4"><b>TOTAL KILOMETERS: </b></label>
						    <div class="col-sm-4 pl-0">
				        		<form:input type="number" class="form-control" path="totalKilometers"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>TOTAL KILOMETERS: </b>${car.totalKilometers}
					</c:otherwise>
				  </c:choose>
				</td>
			</tr>
			<tr>
				<td>
				<c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="year" class="col-sm-4 col-form-label"><b>YEAR: </b></label>
						    <div class="col-sm-6 pl-0">
				        		<form:input type="number" class="form-control" path="year"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>YEAR: </b>${car.year}
					</c:otherwise>
				  </c:choose>
				  </td>
				<td>
				<c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="expectedPrice" class="col-sm-6 col-form-label pr-0"><b>EXPECTED PRICE: </b></label>
						    <div class="col-sm-6 pl-0">
				        		<form:input type="number" class="form-control" path="expectedPrice"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>EXPECTED PRICE: </b>${car.expectedPrice}
					</c:otherwise>
				  </c:choose>
				  </td>
				<td>
				<c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="variant" class="col-sm-5 col-form-label"><b>VARIANT: </b></label>
						    <div class="col-sm-7 pl-1">
						      		<form:select path="variant" class="form-control">
									  <form:option value="PETROL" label="PETROL"/>
									  <form:option value="DIESEL" label="DIESEL"/>
									  <form:option value="ELECTRIC" label="ELECTRIC"/>
									</form:select>
						      	</div>
						      </div>
						</c:when>
					<c:otherwise>
						<b>VARIANT: </b>${car.variant}
					</c:otherwise>
				</c:choose>
				</td>
				<td>
				<c:choose>
					<c:when test="${action == 'edit'}">
						<div class="row">
							<label for="otherDetails" class="col-sm-4 col-form-label mr-n4"><b>OTHER DETAILS: </b></label>
						    <div class="col-sm-8 p-0">
				        		<form:input class="form-control" path="otherDetails"/>
				        	</div>
				        </div>
					</c:when>
					<c:otherwise>
						<b>OTHER DETAILS: </b>${car.otherDetails}
					</c:otherwise>
				  </c:choose>
				  </td>
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
	</form:form>
	</div>
</body>
</html>
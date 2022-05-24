<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div class="header">
			<h1>Used Car Showroom Application</h1>
			<h2 class="links">
				<a href="${contextPath}/home">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="create">Add New Car</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="logout">Logout</a>
			</h2>
		</div>
		<div class="padding-40">
			<div class="search">
	       		<input type="text" class="searchTerm" placeholder="Search Car Model">
	      		<button type="submit" class="searchButton">
	      		<i class="fa fa-search"></i>
	      		</button>
	   	    </div>
	   	    <br><br>
			<table cellspacing="0" border="1" cellpadding="5" class="table-1 uppercase">
				<tr>
					<th>CAR ID</th>
					<th>MANUFACTURER</th>
					<th>MODEL</th>
					<th>VARIANT</th>
					<th>YEAR</th>
					<th><a href="${contextPath}/home?sortBy=totalKilometers" class="sort-by">TOTAL KILOMETERS</a></th>
					<th><a href="${contextPath}/home?sortBy=expectedPrice" class="sort-by">EXPECTED PRICE</a></th>
					<th>OTHER DETAILS</th>
					<sec:authorize access="hasRole('ADMIN')">
					<th>ACTIONS</th>
					</sec:authorize>
				</tr>
				<c:forEach var="car" items="${carList}">
					<tr>
						<td>${car.carId}</td>
						<td>${car.manufacturer}</td>
						<td>${car.model}</td>
						<td>${car.variant}</td>
						<td>${car.year}</td>
						<td>${car.totalKilometers}</td>
						<td>${car.expectedPrice}</td>
						<td>${car.otherDetails}</td>
						<sec:authorize access="hasRole('ADMIN')">
						<td>
							<a href="edit/${car.carId}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete/${car.carId}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
						</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
			<br><br>
			<div align="center">
				<div class="pagination">
				  <c:if test="${currentPage != 1}">
				  	<a href="${contextPath}/home?pageNo=${currentPage - 1}">&laquo;</a>
				  </c:if>
				  <c:forEach begin="1" end="${totalPages}" varStatus="loop">
					<a href="${contextPath}/home?pageNo=${loop.index}" class="${currentPage == loop.index ? 'active' : ''}">${loop.index}</a>
				  </c:forEach>
				  <c:if test="${currentPage != totalPages}">
				  	<a href="${contextPath}/home?pageNo=${currentPage + 1}">&raquo;</a>
				  </c:if>
				</div>
			</div>
		</div>
	</body>
</html>
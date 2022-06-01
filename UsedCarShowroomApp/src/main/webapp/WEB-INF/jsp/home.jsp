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
		<script>
			function validateForm() {
			  let min = document.getElementsByName('min')[0].value;
			  let max = document.getElementsByName('max')[0].value;
			  if (min <= 0) {
			    alert("Min price should be greater than zero");
			    return false;
			  } else if (max < min) {
			    alert("Min price should be less than max price");
			    return false;
			  }
			}
		</script>
	</head>
	<body>
		<div class="header">
			<h1>Used Car Showroom Application</h1>
			<h2 class="links">
				<a href="${contextPath}/home" class="selected">Home</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="create">Add New Car</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="logout">Logout</a>
			</h2>
		</div>
		<div class="padding-40">
			<form method="GET" action="${contextPath}/search" class="search">
	       		<input type="text" class="searchTerm uppercase" placeholder="Search Car Model" name="carModel" value="${carModel}" required>
	      		<button type="submit" class="searchButton">
	      			<i class="fa fa-search"></i>
	      		</button>
	   	    </form>
			<form method="GET" action="${contextPath}/filter" class="filter" onsubmit="return validateForm()">
	       		<input type="number" class="filterValue uppercase" placeholder="Min Price" name="min" value="${min}" required>
	       		<input type="number" class="filterValue uppercase" placeholder="Max Price" name="max" value="${max}" required>
	      		<button type="submit" class="filterButton">
	      			<i class="fa fa-filter"></i>
	      		</button>
	   	    </form>
	   	    <br><br>
			<table cellspacing="0" border="1" cellpadding="5" class="table-1 uppercase">
				<tr>
					<th>CAR ID</th>
					<th>MANUFACTURER</th>
					<th>MODEL</th>
					<th>VARIANT</th>
					<th>YEAR</th>
					<th><a href="${contextPath}/home?sortBy=totalKilometers&carModel=${carModel}&min=${min}&max=${max}" class="sort-by">TOTAL KILOMETERS</a></th>
					<th><a href="${contextPath}/home?sortBy=expectedPrice&carModel=${carModel}&min=${min}&max=${max}" class="sort-by">EXPECTED PRICE</a></th>
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
							<a href="edit/${car.carId}"><i class="fa fa-edit"></i></a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delete/${car.carId}" onclick="return confirm('Are you sure you want to delete?')"><i class="fa fa-trash"></i></a>
						</td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</table>
			<br><br>
			<div align="center">
				<div class="pagination">
				  <c:if test="${currentPage != 1}">
				  	<a href="${contextPath}/${navAction}?pageNo=${currentPage - 1}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}">&laquo;</a>
				  </c:if>
				  <c:forEach begin="1" end="${totalPages}" varStatus="loop">
					<a href="${contextPath}/${navAction}?pageNo=${loop.index}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}" class="${currentPage == loop.index ? 'active' : ''}">${loop.index}</a>
				  </c:forEach>
				  <c:if test="${currentPage > 1 && currentPage != totalPages}">
				  	<a href="${contextPath}/${navAction}?pageNo=${currentPage + 1}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}">&raquo;</a>
				  </c:if>
				</div>
			</div>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Used Car Showroom Application</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script>
			function validateForm() {
			  let min = document.getElementById('min').value;
			  let max = document.getElementById('max').value;
			  min = new Number(min);
			  max = new Number(max);
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
		<jsp:include page="header.jsp" />
		<div class="container">
			<div class="row mt-4">
				<form method="GET" action="${contextPath}/search" class="float-left col-sm-6">
		       		<input type="text" class="form-control uppercase col-sm-4 float-left" placeholder="Search Car Model" name="carModel" value="${carModel}" required>
		      		<button type="submit" class="btn ml-1">
		      			<i class="fa fa-search"></i>
		      		</button>
		   	    </form>
				<form method="GET" action="${contextPath}/filter" class="float-right col-sm-6" onsubmit="return validateForm()">
		      		<button type="submit" class="btn float-right ml-1">
		      			<i class="fa fa-filter"></i>
		      		</button>
		       		<input type="number" class="form-control uppercase col-sm-4 float-right ml-1" placeholder="Max Price" name="max" value="${max}" id="max" required>
		       		<input type="number" class="form-control uppercase col-sm-4 float-right" placeholder="Min Price" name="min" value="${min}" id="min" required>
		   	    </form>
	   	    </div>
			<table class="table table-striped table-hover uppercase mt-4 border">
					<tr class="bg-th">
						<th>CAR ID</th>
						<th>MANUFACTURER</th>
						<th>MODEL</th>
						<th>VARIANT</th>
						<th>YEAR</th>
						<th><a href="${contextPath}/home?sortBy=totalKilometers&carModel=${carModel}&min=${min}&max=${max}" class="sort-by">TOTAL KILOMETERS</a></th>
						<th><a href="${contextPath}/home?sortBy=expectedPrice&carModel=${carModel}&min=${min}&max=${max}" class="sort-by">EXPECTED PRICE</a></th>
						<th>OTHER DETAILS</th>
						<th>ACTIONS</th>
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
						<td>
							<a href="car-details/${car.carId}"><i title="View More Details..." class="fa fa-eye text-secondary"></i></a>
							<sec:authorize access="hasRole('ADMIN')">
								<a href="car-details/${car.carId}/edit"><i title="Edit Car" class="fa fa-edit text-info ml-2"></i></a>
								<a href="delete/${car.carId}" onclick="return confirm('Are you sure you want to delete?')"><i title="Delete Car" class="fa fa-trash text-danger ml-2"></i></a>
							</sec:authorize>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<div class="pagination m-3">
				  <c:if test="${currentPage != 1}">
				  	<a href="${contextPath}/${navAction}?pageNo=${currentPage - 1}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}">&laquo;</a>
				  </c:if>
				  <c:forEach begin="1" end="${totalPages}" varStatus="loop">
					<a href="${contextPath}/${navAction}?pageNo=${loop.index}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}" class="${currentPage == loop.index ? 'active' : ''}">${loop.index}</a>
				  </c:forEach>
				  <c:if test="${totalPages > 0 && currentPage != totalPages}">
				  	<a href="${contextPath}/${navAction}?pageNo=${currentPage + 1}&sortBy=${sortBy}&carModel=${carModel}&min=${min}&max=${max}">&raquo;</a>
				  </c:if>
				</div>
			</div>
		</div>
	</body>
</html>
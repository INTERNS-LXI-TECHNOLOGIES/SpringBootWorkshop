<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <form:form action="${contextPath}/save-owner" method="post" modelAttribute="owner">
  	  <table class="table table-bordered uppercase caption-top">
  	  	<caption>
  	  	  Owner Details
  	  	  <c:choose>
  	  	    <c:when test="${action == 'view'}">
  	  	      <sec:authorize access="hasRole('ADMIN')">
  	  		  	<a href="${contextPath}/delete-owner/${owner.id}" onclick="return confirm('Are you sure you want to delete?')">
  	  		  	  <i title="Delete Owner" class="fa fa-trash text-danger float-right ml-3"></i>
  	  		  	</a>
  	  		  	<a href="${contextPath}/owner-details/${owner.id}/edit">
  	  		  	  <i title="Edit Owner" class="fa fa-edit text-info float-right"></i>
  	  		  	</a>
  	  		  </sec:authorize>
  	  		  <a href="${contextPath}/create-owner">
  	  		    <i title="Add New Owner" class="fa fa-plus-square text-primary float-right mr-3"></i>
  	  		  </a>
  	  	    </c:when>
  	  	    <c:otherwise>
  	  	      <c:choose>
  	  	        <c:when test="${action == 'edit'}">
  	  		      <a href="${contextPath}/owner-details/${owner.id}" class="float-right">
  	  		        <i title="Cancel Changes" class="fa fa-times-circle-o text-secondary"></i>
  	  		      </a>
  	  		    </c:when>
  	  		    <c:otherwise>
  	  		      <a title="Cancel Changes" href="${contextPath}/home" class="float-right">
  	  		        <i class="fa fa-times-circle-o text-secondary"></i>
  	  		      </a>
  	  		    </c:otherwise>
  	  		  </c:choose>
  	  		  <button type="submit" class="p-0 border-0 float-right">
  	  		    <i title="Save Changes" class="fa fa-floppy-o text-info mr-2"></i>
  	  		  </button>
  	  	    </c:otherwise>
  	  	  </c:choose>
  	  	</caption>
  	  	<tr>
  	      <td class="col-sm-4">
		    <c:choose>
  	      	<c:when test="${action == 'edit' or action == 'add'}">
			  <div class="row">
				<label for="name" class="col-sm-6 col-form-label"><b>NAME: </b></label>
				<div class="col-sm-6 pl-1">
					<form:hidden path="id"/>
				  <form:input class="form-control" path="name" required="true" />
				</div>
		      </div>
  	      	</c:when>
  	      	<c:otherwise>
			  <b>NAME: </b>${owner.name}
  	      	</c:otherwise>
  	        </c:choose>
  	      </td>
  	      <td class="col-sm-4">
  	        <c:choose>
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      		<div class="row">
  	      		  <label for="address" class="col-sm-5 col-form-label mr-n2"><b>ADDRESS: </b></label>
  	      		  <div class="col-sm-7 pl-0">
  	              	<form:input class="form-control" path="address" required="true" />
  	              </div>
  	            </div>
  	      	  </c:when>
  	      	  <c:otherwise>
  	      	    <b>ADDRESS: </b>${owner.address}
  	      	  </c:otherwise>
  	        </c:choose>
  	      </td>
  	      <td class="col-sm-4">
  	        <c:choose>
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      	    <div class="row">
				  <label for="phoneNumber" class="col-sm-5 col-form-label mr-n4"><b>PHONE NUMBER: </b></label>
				  <div class="col-sm-4 pl-0">
					<form:input type="number" class="form-control" path="phoneNumber" required="true" />
				  </div>
  	            </div>
  	      	  </c:when>
  	      	  <c:otherwise>
  	      	  	<b>PHONE NUMBER: </b>${owner.phoneNumber}
  	      	  </c:otherwise>
  	        </c:choose>
  	      </td>
  	    </tr>
  	  </table>
  	</form:form>
  	<table class="table table-striped table-hover uppercase mt-5 border">
      <caption>
       Car Details
       <a href="${contextPath}/add-car/${owner.id}">
  	  	 <i title="Add New Car" class="fa fa-plus-square text-primary float-right ml-3"></i>
  	   </a>
      </caption>
	  <tr class="bg-th">
  	    <th>CAR ID</th>
		<th>MANUFACTURER</th>
		<th>MODEL</th>
		<th>VARIANT</th>
		<th>YEAR</th>
		<th>TOTAL KILOMETERS</th>
		<th>EXPECTED PRICE</th>
		<th>OTHER DETAILS</th>
		<th>ACTIONS</th>
	  </tr>
	  <c:forEach var="c" items="${owner.cars}">
  	    <tr>
  	      <form:form action="${contextPath}/owner/${owner.id}/save-car" method="post" modelAttribute="car">
  	  	  <td>
  	  	    <c:choose>
			  <c:when test="${car.carId == c.carId}">
  	            <form:select path="carId" class="form-control">
				  <form:options items="${cars}" itemValue="carId" itemLabel="carId" />
				</form:select>
			  </c:when>
			  <c:otherwise>
  	  		    ${c.carId}
			  </c:otherwise>
			</c:choose>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.manufacturer}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.model}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.variant}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.year}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.totalKilometers}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.expectedPrice}
			</c:if>
  	  	  </td>
  	  	  <td>
			<c:if test="${car.carId != c.carId}">
  	  		  ${c.otherDetails}
			</c:if>
  	  	  </td>
  	  	  <td>
  	  		<sec:authorize access="hasRole('ADMIN')">
  	  		<c:choose>
		      <c:when test="${car.carId == c.carId}">
			    <button type="submit" class="p-0 border-0 bg-transparent">
				  <i title="Save Car" class="fa fa-floppy-o text-info ml-2"></i>
				</button>
				<a href="${contextPath}/owner-details/${owner.id}">
  	  		      <i title="Cancel Changes" class="fa fa-times-circle-o text-secondary ml-2"></i>
  	  		    </a>
			  </c:when>
			  <c:otherwise>
			    <a href="${contextPath}/owner/${owner.id}/remove-car/${c.carId}" onclick="return confirm('Are you sure you want to delete?')">
				  <i title="Remove car" class="fa fa-trash text-danger ml-2"></i>
				</a>
			  </c:otherwise>
			</c:choose>
  	  		</sec:authorize>
  	  	  </td>
  	  	  </form:form>
  	    </tr>
  	  </c:forEach>
  	</table>
  </div>
</body>
</html>
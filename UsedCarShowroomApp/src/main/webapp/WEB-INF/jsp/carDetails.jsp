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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script type="text/javascript">
    $(document).ready(function () {
        $(".datepicker").datepicker({
        	format: 'dd/mm/yyyy'
        });
    });

    function getOwnerDetails(ownerId) {
	  var addOwnerLink = document.getElementById('addOwner');
	  addOwnerLink.href = addOwnerLink.href + '?ownerId=' + ownerId;
	  addOwnerLink.click();
    }
  </script>
</head>
<body>
  <jsp:include page="header.jsp" />
  <div class="container mt-5" align="center">
    <form:form action="${contextPath}/save" method="post" modelAttribute="car">
  	  <table class="table table-bordered uppercase caption-top">
  	  	<caption>
  	  	  Car Details
  	  	  <c:choose>
  	  	    <c:when test="${action == 'view'}">
  	  	      <sec:authorize access="hasRole('ADMIN')">
  	  		  	<a href="${contextPath}/delete/${car.carId}" onclick="return confirm('Are you sure you want to delete?')">
  	  		  	  <i title="Delete Car" class="fa fa-trash text-danger float-right ml-3"></i>
  	  		  	</a>
  	  		  	<a href="${contextPath}/car-details/${car.carId}/edit">
  	  		  	  <i title="Edit Car" class="fa fa-edit text-info float-right"></i>
  	  		  	</a>
  	  		  </sec:authorize>
  	  		  <a href="${contextPath}/create">
  	  		    <i title="Add New Car" class="fa fa-plus-square text-primary float-right mr-3"></i>
  	  		  </a>
  	  	    </c:when>
  	  	    <c:otherwise>
  	  	      <c:choose>
  	  	        <c:when test="${action == 'edit'}">
  	  		      <a href="${contextPath}/car-details/${car.carId}" class="float-right">
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
  	      <td class="col-sm-2 align-middle">
  	      	<b>CAR ID:</b> ${car.carId}
  	      	<form:hidden path="carId"/>
  	      </td>
  	      <td class="col-sm-3">
		    <c:choose>
  	      	<c:when test="${action == 'edit' or action == 'add'}">
			  <div class="row">
				<label for="manufacturer" class="col-sm-6 col-form-label"><b>MANUFACTURER: </b></label>
				<div class="col-sm-6 pl-1">
				  <form:input class="form-control" path="manufacturer" required="true" />
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
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      		<div class="row">
  	      		  <label for="model" class="col-sm-5 col-form-label mr-n2"><b>MODEL: </b></label>
  	      		  <div class="col-sm-7 pl-0">
  	              	<form:input class="form-control" path="model" required="true" />
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
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      	    <div class="row">
				  <label for="totalKilometers" class="col-sm-5 col-form-label mr-n4"><b>TOTAL KILOMETERS: </b></label>
				  <div class="col-sm-4 pl-0">
					<form:input type="number" class="form-control" path="totalKilometers" required="true" />
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
  	      <td class="col-sm-2">
  	        <c:choose>
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      		<div class="row">
				  <label for="year" class="col-sm-4 col-form-label"><b>YEAR: </b></label>
				  <div class="col-sm-6 pl-0">
					<form:input type="number" class="form-control" path="year" required="true" />
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
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      		<div class="row">
				  <label for="expectedPrice" class="col-sm-6 col-form-label pr-0"><b>EXPECTED PRICE: </b></label>
				  <div class="col-sm-6 pl-0">
					<form:input type="number" class="form-control" path="expectedPrice" required="true" />
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
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
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
  	      	  <c:when test="${action == 'edit' or action == 'add'}">
  	      		<div class="row">
				  <label for="otherDetails" class="col-sm-4 col-form-label mr-n4"><b>OTHER DETAILS: </b></label>
  	      	      <div class="col-sm-8 p-0">
  	            	<form:input class="form-control" path="otherDetails" required="true" />
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
  	</form:form>
  	<table class="table table-striped table-hover uppercase mt-5 border">
      <caption>
       Owner Details
       <c:if test="${action != 'add'}">
       	 <a href="${contextPath}/add-owner/${car.carId}" id="addOwner">
  	  	   <i title="Add New Owner" class="fa fa-plus-square text-primary float-right ml-3"></i>
  	     </a>
       </c:if>
      </caption>
	  <tr class="bg-th">
  	    <th>NAME</th>
  	    <th>ADDRESS</th>
  	    <th>PHONE NUMBER</th>
  	    <th>ACTIONS</th>
	  </tr>
	  <c:forEach var="ow" items="${car.owners}">
  	    <tr>
  	      <form:form action="${contextPath}/car/${car.carId}/save-owner" method="post" modelAttribute="owner">
  	  	  <td>
  	  	    <c:choose>
			  <c:when test="${owner.id == ow.id}">
  	            <form:select path="id" class="form-control uppercase" required='true' onchange="getOwnerDetails(this.value)">
				  <form:option value="">--Select An Owner--</form:option>
				  <form:options items="${owners}" itemValue="id" itemLabel="name" />
				</form:select>
			  </c:when>
			  <c:otherwise>
  	  		    ${ow.name}
			  </c:otherwise>
			</c:choose>
  	  	  </td>
  	  	  <td class="align-middle">
  	  	  	<c:choose>
			  <c:when test="${owner.id == ow.id}">
  	            ${owner.address}
			  </c:when>
			  <c:otherwise>
  	  		    ${ow.address}
			  </c:otherwise>
			</c:choose>
  	  	  </td>
  	  	  <td class="align-middle">
  	  	  	<c:choose>
			  <c:when test="${owner.id == ow.id}">
  	            ${owner.phoneNumber}
			  </c:when>
			  <c:otherwise>
  	  		    ${ow.phoneNumber}
			  </c:otherwise>
			</c:choose>
  	  	  </td>
  	  	  <td class="align-middle">
  	  	   <c:if test="${owner.id != ow.id}">
  	  	     <a href="${contextPath}/owner-details/${ow.id}"><i title="View More Details..." class="fa fa-eye text-secondary"></i></a>
  	  	   </c:if>
  	  		<sec:authorize access="hasRole('ADMIN')">
  	  		  <c:choose>
		        <c:when test="${owner.id == ow.id}">
			      <button type="submit" class="p-0 border-0 bg-transparent">
			  	    <i title="Save Owner" class="fa fa-floppy-o text-info ml-2"></i>
			  	  </button>
			  	  <a href="${contextPath}/car-details/${car.carId}">
  	  		        <i title="Cancel Changes" class="fa fa-times-circle-o text-secondary ml-2"></i>
  	  		      </a>
			    </c:when>
			    <c:otherwise>
			      <a href="${contextPath}/car/${car.carId}/remove-owner/${ow.id}" onclick="return confirm('Are you sure you want to delete?')">
			  	    <i title="Remove owner" class="fa fa-trash text-danger ml-2"></i>
			  	  </a>
			    </c:otherwise>
			  </c:choose>
  	  		</sec:authorize>
  	  	  </td>
  	  	  </form:form>
  	    </tr>
  	  </c:forEach>
  	</table>
  	<table class="table table-striped table-hover uppercase mt-5 mb-5 border">
      <caption>
        Service History
        <c:if test="${action != 'add'}">
      	  <a href="${contextPath}/create-service-history/${car.carId}">
  	  	    <i title="Add New Service History" class="fa fa-plus-square text-primary float-right ml-3"></i>
  	  	  </a>
  	  	</c:if>
      </caption>
  	  <tr class="bg-th">
  	    <th>SERVICE DATE</th>
  	    <th>TOTAL KILOMETERS</th>
  	    <th>SHOWROOM</th>
  	    <th>ACTIONS</th>
  	  </tr>
  	  <c:forEach var="sh" items="${car.serviceHistories}">
  	    <tr>
		  <form:form action="${contextPath}/car/${car.carId}/save-service-history" method="post" modelAttribute="serviceHistory">
  	    	<td>
  	    	  <c:choose>
				<c:when test="${serviceHistory.id == sh.id}">
  	  			  <form:hidden path="id"/>
  	         	  <form:input class="datepicker form-control" path="serviceDate" required="true" />
				</c:when>
				<c:otherwise>
  	  			  <fmt:formatDate value="${sh.serviceDate}" pattern="dd/MM/yyyy"/>
				</c:otherwise>
			  </c:choose>
			</td>
  	    	<td>
  	    	  <c:choose>
				<c:when test="${serviceHistory.id == sh.id}">
  	         	  <form:input type="number" class="form-control" path="totalKilometers" required="true" />
				</c:when>
				<c:otherwise>
  	  			  ${sh.totalKilometers}
				</c:otherwise>
			  </c:choose>
			</td>
  	    	<td>
  	    	  <c:choose>
				<c:when test="${serviceHistory.id == sh.id}">
  	         	  <form:input class="form-control" path="showroom" required="true" />
				</c:when>
				<c:otherwise>
  	  			  ${sh.showroom}
				</c:otherwise>
			  </c:choose>
			</td>
  	    	<td class="align-middle">
  	    	  <sec:authorize access="hasRole('ADMIN')">
  	    	  	<c:if test="${serviceHistory.id != sh.id}">
  	    	  	  <a href="${contextPath}/car/${car.carId}/edit-service-history/${sh.id}">
					<i title="Edit Service History" class="fa fa-edit text-info ml-2"></i>
				  </a>
				  <a href="${contextPath}/car/${car.carId}/delete-service-history/${sh.id}" onclick="return confirm('Are you sure you want to delete?')">
				    <i title="Delete Service History" class="fa fa-trash text-danger ml-2"></i>
				  </a>
  	    	  	</c:if>
  	    	  </sec:authorize>
  	    	  <c:if test="${serviceHistory.id == sh.id}">
  	    	  	<button type="submit" class="p-0 border-0 bg-transparent">
				  <i title="Save Service History" class="fa fa-floppy-o text-info ml-2"></i>
				</button>
				<a href="${contextPath}/car-details/${car.carId}">
  	  		      <i title="Cancel Changes" class="fa fa-times-circle-o text-secondary ml-2"></i>
  	  		    </a>
  	    	  </c:if>
  	    	</td>
  	      </form:form>
		</tr>
  	  </c:forEach>
  	</table>
  </div>
</body>
</html>

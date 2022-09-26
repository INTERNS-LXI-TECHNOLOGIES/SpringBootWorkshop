<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Dictionary Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(1, 68, 22)">
			<div>

				<h3 class="navbar-brand"> Dictionary App </h3>

			<h5 class="links">

            				<a style= "color:white" href="/${contextPath}">Words List</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white" href="${contextPath}/createSynonym/${word.id}">Add New Synonym</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white"  href="logout">Log Out</a>
            			</h5>
            			</div>
       </header>
	<br>

	<div class="row">
    	<div class="container">

    	<h3 class="text-center">WORD SYNONYMS</h3>
        <br>

	        <table class="table table-bordered">

    					<tr>
    						<th>Word ID</th>
    						<th>Word</th>
    						<th>Malayalam Meaning</th>
    					</tr>

    					<tr>
                        	<td>${word.id}</td>
                            <td>${word.name}</td>
                           <td>${word.meaning}</td>
                     </tr>


	<div class="row">
	<div class="container">


			<br>
			<table class="table table-bordered">

					<tr>
						<th>ID</th>
						<th>Synonym-1</th>
						<th>Synonym-2</th>
						<% if (request.isUserInRole("ADMIN")) { %>
						<th>Actions</th>
						<% } %>
					</tr>

					<c:forEach var="word" items="${word.synonym}" varStatus="status">
						<tr>
							 <td>${word.synonym_id}</td>
                            <td>${word.synonym_1}</td>
                            <td>${word.synonym_2}</td>
							<% if (request.isUserInRole("ADMIN")) { %>
							<td>
							<a href="${contextPath}/editSynonym/${word.synonym_id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="${contextPath}/deleteSynonym/${word.synonym_id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
                           </td>
						<% } %>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
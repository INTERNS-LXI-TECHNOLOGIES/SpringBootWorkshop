<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			style="background-color: blue">
			<div>

				<h3 class="navbar-brand"> Dictionary App </h3>

			<h5 class="links">

            				<a style= "color:white" href="/${contextPath}">Words List</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white" href="createSynonym">Add New Synonym</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white"  href="logout">Log Out</a>
            			</h5>
            			</div>
       </header>
	<br>

	<div class="row">

			<br>
			<table class="table table-bordered">

					<tr>
					  <th>Word ID</th>
						<th>Synonym ID</th>
						<th>Synonym_1</th>
						<th>Synonym_2</th>
						<% if (request.isUserInRole("ADMIN")) { %>
						<th>Actions</th>
						<% } %>
					</tr>

					<c:forEach var="word" items="${word.synonyms}" varStatus="status">
						<tr>
						     <td>${word.id}</td>
							 <td>${synonyms.synonym_id}</td>
                            <td>${synonyms.synonym_1}</td>
                            <td>${synonyms.synonym_2}</td>
							<% if (request.isUserInRole("ADMIN")) { %>
							<td>
							<a href="editSynonym/${synonyms.synonym_id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="deleteSynonym/${synonyms.synonym_id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
                           </td>
						<% } %>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
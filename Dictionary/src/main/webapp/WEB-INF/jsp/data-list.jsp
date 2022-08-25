<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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

            				<a style= "color:white" href="${contextPath}">Words List</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white" href="create">Add New Word</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white" href="file.html">Import File</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white"  href="logout">Log Out</a>
            			</h5>
            			</div>
       </header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Words</h3>

			<div class="container" >
				<div align="center">
				<form>
				<h5><input type="search" placeholder="Search Word">
				<button type="submit">Search</button></h5>

			  </form>
			  <form class="nosubmit">
			  </form>
			  </div>

			<br>
			<table class="table table-bordered">

					<tr>
						<th>ID</th>
						<th>Word</th>
						<th>Parts Of Speech</th>
						<th>Meaning</th>
						<% if (request.isUserInRole("ADMIN")) { %>
						<th>Actions</th>
						<% } %>
					</tr>

					<c:forEach var="word" items="${wordsList}" varStatus="status">
						<tr>
							<td><c:out value="${status.index + 1}" /></td>
                            <td>${word.name}</td>
                            <td>${word.speech}</td>
                            <td>${word.meaning}</td>
							<% if (request.isUserInRole("ADMIN")) { %>
							<td>
							<a href="edit/${word.id}">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="delete/${word.id}" onclick="return confirm('Are you sure you want to delete?')">Delete</a>
                           </td>
						<% } %>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
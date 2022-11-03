<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<html>
<head>
<title>Dictionary Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<script type="text/javascript">
    function clearSearch() {
        window.location = "http://localhost:8080/home";
    }
</script>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>

				<h3 class="navbar-brand"> Dictionary App </h3>

			<h5 class="links">

            				<a style= "color:white" href="${contextPath}/home">Words List</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:white" href="http://localhost:8080">Home Page</a>
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
				<form th:action="@{/}">
                     <input type="text" placeholder=  "Search Words" name="keyword" id="keyword" size="50" th:value="${keyword}" required />
                    &nbsp;
                    <input type="submit" value="Search" />
                    &nbsp;
                    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
                </form>
			  </div>

			<br>
			<table class="table table-bordered">

					<tr>
						<th>ID</th>
						<th>Word</th>
						<% if (request.isUserInRole("ADMIN")) { %>
						<th>Select Word</th>
						<% } %>
					</tr>
					<form action="${contextPath}/saveSynonym/${id}" method="post" modelAttribute="word">

					<c:forEach var="word" items="${wordsList}" varStatus="status">
						<tr>
							<td><c:out value="${status.index + 1}" /></td>
                            <td>${word.name}</td>
							<% if (request.isUserInRole("ADMIN")) { %>
							<td>

							<input type = "hidden" name = "id" value ="${word.id}">
							<input type = "hidden" name = "name" value ="${word.name}">
							<input type = "hidden" name = "partsOfSpeech" value ="${word.partsOfSpeech}">
							<input type = "hidden" name = "meaning" value ="${word.meaning}">

							<button type="submit" class="btn btn-success" name = "synonyms" value = "${word.id}">Select</button>

                           </td>
						<% } %>
						</tr>
					</c:forEach>
			</table>
			</form>
		</div>
	</div>
</body>
</html>
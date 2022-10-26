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
    window.location = "http://localhost:8080";

    }
</script>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(99, 186, 240)">
			<div>

				<h3 class="navbar-brand" style= "color:rgb(18, 0, 0)"> Dictionary App </h3>

			<h5 class="links">

            				<a style= "color:rgb(18, 0, 0)" href="home">Words List</a>
            				&nbsp;&nbsp;|&nbsp;&nbsp;
            				<a style= "color:rgb(14, 1, 1)"  href="logout">Log Out</a>

            			</h5>
            			</div>
       </header>
	<br>

	<div class="row">

		<div class="container">

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

  </body>
</html>
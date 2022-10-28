<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- Font Awesome -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
            rel="stylesheet"
        />
        <!-- Stylesheet -->
        <link rel="stylesheet" href="style.css" />
        
<title>Dictionary Application</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: "Lato", sans-serif;
}

.Search {
  height: 60%;
  width: 80%;
  font-size: 20px;
  padding: 100px 8px 8px  300px;

}


.background {
 
  width: 70%;
  background-color: #f444f4;
  padding: 80px 100px;
  border-radius: 20px;
  box-shadow: 0 20px 40px rgba(38, 33, 61, 0.2);
  
}



.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: rgb(10, 1, 1);
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 18px;
  color: #f6f2f2;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #a73030;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 20px;
  font-size: 30px;
  margin-left: 40px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>

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

<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <% if (request.isUserInRole("ADMIN")) { %>
  <a href="home">Words List</a>
  <% } %>
  <a href="logout">Log Out</a>
</div>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(99, 186, 240)">
			<span style="font-size:25px;cursor:pointer" onclick="openNav()">&#9776;</span>
			<div>

				<h3 class="navbar-brand" style= "font-size:23px; padding: 8px 8px 8px 32px; color:rgb(18, 0, 0)"> Dictionary App </h3>


            			</div>
       </header>
	<br>

			<div class="Search" >
				
				<form th:action="@{/}">
          <div class="background">
                     <input type="text" placeholder=  "Search Words" name="keyword" id="keyword" size="20" th:value="${keyword}" required />
                    &nbsp;
                    <input type="submit" value="Search" />
                    &nbsp;
                    <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
                </form>
              </div>
			  </div>

			<br>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<html>
<head>


<title>Dictionary Application</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

*{

	margin: 0;

	padding: 0;

	font-family: sans-serif;

	box-sizing: border-box;

}

body {
  font-family: "Lato", sans-serif;
  height: 100vh;

  	align-items: center;

  	background: linear-gradient(25deg, #8600b3 50%, #cc33ff 50%);
}

.Search {
  height: 60%;
  width: 80%;
  font-size: 20px;
  padding: 100px 8px 8px  300px;

}

form.example input[type=text] {
  padding: 10px;
  font-size: 15px;
  border-radius: 20px;
  border: 1px solid grey;
  float: left;
  width: 70%;
  background: #f1f1f1;
}

form.example input[type=button] {
   float: left;
    width: 12%;
    padding: 9.5px;
    background: #2196F3;
    color: white;
    font-size: 17px;
    border-radius: 20px;
    border: 1px solid grey;
    border-left: none;
    cursor: pointer;
}

form.example button {
  float: left;
  width: 10%;
  padding: 14px ;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border-radius: 20px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}


.background {

  width: 70%;
  background-color: #fdfdfd;
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

  <div class="background-box">

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
				<form class="example" action="/home-result">
          <div class="background">
            <input type="text" placeholder=  "Search Words" name="keyword" id="keyword" size="20" th:value="${keyword}" required />
            &nbsp;
            <button type="submit"><i class="fa fa-search"></i></button>
            &nbsp;
            <input type="button" value="Clear" id="btnClear" onclick="clearSearch()" />
                </form>

                <c:forEach var="word" items="${wordsList}" varStatus="status">
                        <h4> ${word.name}</h4>
                       <p> ${word.meaning}</p>

                     </c:forEach>
              </div>
			  </div>
      </div>

  </body>
</html>
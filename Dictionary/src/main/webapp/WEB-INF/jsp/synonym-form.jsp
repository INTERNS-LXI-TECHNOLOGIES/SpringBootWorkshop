<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			style="background-color: rgb(1, 68, 22)">

			<div>
                  <h3 class="navbar-brand"> Dictionary App </h3>

            <h5 class="links">

				<a style= "color:white" href="/${contextPath}">Words List</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a style= "color:white" href="${contextPath}/createSynonym/${word.id}">Add New Synonym</a>
                &nbsp;&nbsp;|&nbsp;&nbsp;
                <a style= "color:white" href="${contextPath}/logout">Log Out</a>
                </h5>
                	</div>

               </header>

	<br>

        <form action="/action_page.php">
          <label for="cars">Choose a car:</label>
          <select name="cars" id="cars">
            <option value="volvo">Volvo</option>
            <option value="saab">Saab</option>
            <option value="opel">Opel</option>
            <option value="audi">Audi</option>
          </select>
          <br><br>
          <input type="submit" value="Submit">
        </form>

			</div>
		</div>
	</div>
</body>
</html>
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
			style="background-color: blue">

			<div>
                  <h3 class="navbar-brand"> Dictionary App </h3>

            <h5 class="links">

				<a style= "color:white" href="/${contextPath}">Words List</a>
				&nbsp;&nbsp;|&nbsp;&nbsp;
				<a style= "color:white" href="${contextPath}/create">Add New Word</a>
                &nbsp;&nbsp;|&nbsp;&nbsp;
                <a style= "color:white" href="${contextPath}/logout">Log Out</a>
                </h5>
                	</div>

               </header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form:form action="${contextPath}/save" method="post" modelAttribute="word">

				<table border="1" cellpadding="5" cellspacing="0" style="text-transform: uppercase;">

				<caption>
					<h2>${caption}</h2>
				</caption>

				   <tr>
				   <form:hidden path="id"/>
                	 <th>Word</th>
                		 <td>
                		<form:input path="name"/>
                	  </td>
                	  </tr>

                	   <tr>
                         <th>Parts Of Speech</th>
                           <td>
                             <form:input path="partsOfSpeech"/>
                              </td>
                            </tr>
                	 <tr>
                    <th>Meaning</th>
                	 <td>
                 	<form:input path="meaning"/>
                  </td>
                </tr>
               <tr>
				<button type="submit" class="btn btn-success">Save</button>
				   </tr>
                </table>
				  </form:form>
			</div>
		</div>
	</div>
</body>
</html>
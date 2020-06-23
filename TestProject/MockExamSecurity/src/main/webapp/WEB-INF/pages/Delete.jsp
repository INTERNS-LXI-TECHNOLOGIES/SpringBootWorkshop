<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<style>
	  	.button
	  	{
	  		background-color: #4CAF50;
	  	}
	  	div
	  	{
	  		padding-top: 20px;
	  		padding-right: 70px;
	  		padding-left: 70px;
	  		padding-bottom: 20px;
	  	}
  	</style>
	<title>DELETE</title>
</head>
	<h1 align=center>Delete</h1>
</div>
<body background="aa.jpg">
	<table align=center border="1" width=30% height=25%>
	<tr>
		<td><center><div><b>Do you want to delete</b></center></div></td><br>
	</tr>
	<tr>
	<td>
    <center><a href="delete?id=${exam.id}"><input type="submit" value="Confirm"></a></center>
	<center><a href="home"><input type="submit" value="Cancel"></a></center>
	</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.entity.MockEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<div class = "wrapper">
		<div  align="center" >
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">EXAM RESULT</font></h1>
			<br>
			<br>
			</div>
<div style="padding-left: 40px;" align="left">
<%
int mark = Integer.parseInt(session.getAttribute("Mark").toString());
%>
<br>
<br>
<div class ="resultDiv">
<h1><label>RESULT : <%out.println(mark); %></label></h1><br><%
if(mark<=2)
{
	%><h1><label>FAILED BETTER LUCK NEXTTIME </label></h1><br><%	
}
else 
{
	%><h1><label>CONGRADULATIONS YOU PASS </label></h1><br><%
}
%>
</div>
</div>
<div align="center">
<form action="">
<button class="button"><a href="http://localhost:8080/MockExam/">Back</a></button>
</form>
</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<style>
	.button {
  display: inline-block;
  padding: 10px 20px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #FFC312;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #FFC312}

.button:active {
  background-color: #FFC312;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
	div
	{
		padding-top: 40px;
		padding-right: 30px;
		padding-left: 80px;
		padding-bottom: 20px;
	}
	
	<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
body {
  margin: 0;
}
.header {
  background-color: #FFC312;
  padding: 20px;
  text-align: center;
}
  </style>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
	<title>DELETE</title>
</head>
<div class="header">
	<h1 align=center>Delete Question</h1>
</div>
<body background="aa.jpg">
	<tr>
		<td><center><div><h1>Successfully deleted</h1></center></div></td><br>
	</tr>
	<tr>
	<td>
    <center><a href="deleteExam"><input type="submit" class="button" value="ok"></a></center>
	</tr>
</body>
</html>
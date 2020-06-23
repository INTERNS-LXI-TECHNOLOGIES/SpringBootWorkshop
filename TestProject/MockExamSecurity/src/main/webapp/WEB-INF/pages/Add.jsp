<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>New Question</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</style>
</head>
<body>
		<div class="header">
        <h1>New Question</h1>
		</div>
		 <div align="center">
        <form:form action="addsucc" method="post" modelAttribute="exam">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Question:</td>
                <td><form:input path="question" /></td>
            </tr>
            <tr>
                <td>Option1:</td>
                <td><form:input path="option1" /></td>
            </tr>
			<tr>
                <td>Option2:</td>
                <td><form:input path="option2" /></td>
            </tr>
			<tr>
                <td>Option3:</td>
                <td><form:input path="option3" /></td>
            </tr>
			<tr>
                <td>Option4:</td>
                <td><form:input path="option4" /></td>
            </tr>
            <tr>
                <td>Answer:</td>
                <td><form:input path="answer" /></td>
            </tr>
            
        <td colspan="2" align="center"><input type="submit" class="button" value="Save"></a>
		<a href="http://localhost:8080/MockExam/"><input type="button" class="button" value="Back"></a></td>
		<tr>
                
            </tr>
			</table>
        </form:form>
		
    </div>
</body>
</html>
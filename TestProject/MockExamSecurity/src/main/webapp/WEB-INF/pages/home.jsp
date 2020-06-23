<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Management Screen</title>
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
</head>
<body>
     <div class="header">
        <h1>MOCK EXAM</h1>
        <h3>
            <a href="newExam">ADD</a>
        </h3>
		</div>
		<div align="center">
        <table border="1">
 
            <th>Question</th>
            <th>Option1</th>
			<th>Option2</th>
			<th>Option3</th>
			<th>Option4</th>
            <th>Answer</th>
 
            <c:forEach var="exam" items="${listExam}">
                <tr>
 
                    <td>${exam.question}</td>
                    <td>${exam.option1}</td>
                    <td>${exam.option2}</td>
                    <td>${exam.option3}</td>
					<td>${exam.option4}</td>
					<td>${exam.answer}</td>
                    <td><a href="editExam?id=${exam.id}">Edit</a>
                             <a
                        href="delete?id=${exam.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table><br>
		<br><a href="http://localhost:8080/MockExam/"><input type="button" class="button" value="Back"></a>
    </div>
</body>
</html>
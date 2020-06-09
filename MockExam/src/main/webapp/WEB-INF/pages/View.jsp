<%@page contentType="text/HTML" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mock Exam</title>
</head>
<body>
    <div align="center">
        <h1>Exam Questions</h1>
        <table border="1">
 			<tr>
 			<th>SlNo</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Option1</th>
            <th>Option2</th>
            <th>Option3</th>
            <th>Option4</th>
            </tr>
 
            <c:forEach var="listQuestions" items="${listQuestions}">
                <tr>
					<td>${listQuestions.id}</td>	 
                    <td>${listQuestions.question}</td>
                    <td>${listQuestions.answer}</td>
                    <td>${listQuestions.option1}</td>
                    <td>${listQuestions.option2}</td>
                    <td>${listQuestions.option3}</td>
                    <td>${listQuestions.option4}</td>
 
                </tr>
            </c:forEach>
        </table>
    </DIV>
</body>
</HTML>
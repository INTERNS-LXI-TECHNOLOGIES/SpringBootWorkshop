<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ViewAll Questions</title>
<style>
	.button
	{
		background-color: #4CAF50;
	}
	div
	{
		padding-top: 40px;
		padding-right: 30px;
		padding-left: 80px;
		padding-bottom: 20px;
	}
  </style>
</head>
<body>
    <div align="center">
        <h1>Questions</h1>
		<%
		String j = request.getParameter("indexValue");
		int i = Integer.parseInt(j);
		int k = Integer.parseInt(request.getParameter("indexValue"));
		out.println("Qno: "+request.getParameter("indexValue"));
		if(i<${listExam}.size())
		{%>
                 <td>${exam.question}</td>
                    <td>${exam.option1}</td>
                    <td>${exam.option2}</td>
                    <td>${exam.option3}</td>
					<td>${exam.option4}</td>
					<td>${exam.answer}</td>
                    <td><a href="editExam?id=${exam.id}">Edit</a>
                             <a
                        href="deleteExam?id=${exam.id}">Delete</a></td>
 
                </tr>
            <%}%>
        </table><br>
		<br><input type="button" class="button" value="Back" onclick="history.back()">
    </div>
</body>
</html>
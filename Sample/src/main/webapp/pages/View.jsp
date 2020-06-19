<%@page contentType="text/HTML" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mock Exam</title>
<style type="text/css">
.button {
  height: 52px;
     width: 186px;
     border: none;
     border-radius: 20px;
     background: linear-gradient(to left, #ab68ca, #de67a3);
     color: #fff;
     font-weight: bolder;
     margin-top: 30px;
     cursor: pointer;
     outline: none;
     font-size: 21px;
}
.button:hover {background-color: #3e8e41}
.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.wrapper {
     width: 78%;
     height: 76%;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
     overflow-y: auto;
   }
table{
border: 1px solid darkmagenta;
  height: 50px;
  width:87%;
}
th{
text-align:center;
border: 1px solid darkmagenta;
  height: 50px;
  width:93px;
  
}
tr{
text-align:center;
border: 1px solid darkmagenta;
  height: 50px;
  font-variant-caps: petite-caps;
  font-size: 22px;
}
td{
text-align:center;
border: 1px solid darkmagenta;
  height: 50px;
}
</style>
</head>
<body>
<%
int i =1;
%>
<div class = "wrapper">
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">DISPLAY ALL QUESTIONS</font></h1>
			<br>
			<br>
			</div>
    <div align="center">
    	<br>
        <table>
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
					<td><%out.print(i); %></td>	 
                    <td>${listQuestions.question}</td>
                    <td>${listQuestions.answer}</td>
                    <td>${listQuestions.option1}</td>
                    <td>${listQuestions.option2}</td>
                    <td>${listQuestions.option3}</td>
                    <td>${listQuestions.option4}</td>
                </tr>
                <%i++; %>
            </c:forEach>
        </table>
        <form >
        <button formaction="admin" class="button">BACK</button>
    	</form>
    </DIV>
    </div>
</body>
</HTML>
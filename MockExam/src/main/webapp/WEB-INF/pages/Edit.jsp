<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
</head>
<body>
    <div class="header">
        
        <div align="center" >
            <br>
            <br>
            <h1><font size="50px" color="white" >Update Question</font></h1>
            <br>
            <br>
        </div>
  <div align="center" style="padding-left: 2%;text-align: -webkit-right;">
        <form:form action="add" method="POST" modelAttribute="mockModel">
        <table style="width:84%;" >
            <form:hidden path="id" />
            <tr>
                <td>Question:</td>
                <td><form:input path="question" /></td>
            </tr>
            <tr>
                <td>Answer:</td>
                <td><form:input path="answer" /></td>
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
        </table>
        <div align="center">
        <button type="submit" class="button">SAVE</button> <button formaction="displayAll" class="button">BACK</button>
        </div>
        </form:form>
    </div>
</div>
</body>
</html>
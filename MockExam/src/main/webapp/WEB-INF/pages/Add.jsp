<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
</head>
<body background="space.jpg">
	<div class="wrapper">
		<div style="background-image: space.jpg;" align="center">
            <br>
            <br>
      		<font size="9" color="#87CEFA">Enter Question</font>
            <br>
            <br>
        </div>
  <div align="center">
        <form:form action="add" method="POST" modelAttribute="mockModel">
          <table style="width:84%;" >
           
            <tr>
                <td>Question </td>
                <td><form:input path="question" /></td>
            </tr>
            <tr>
                <td>Answer </td>
                <td><form:input path="answer" /></td>
            </tr>
            <tr>
                <td>Option1 </td>
                <td><form:input path="option1" /></td>
            </tr>
            <tr>
                <td>Option2 </td>
                <td><form:input path="option2" /></td>
            </tr>
            <tr>
                <td>Option3 </td>
                <td><form:input path="option3" /></td>
            </tr>
            <tr>
                <td>Option4 </td>
                <td><form:input path="option4" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</div>
</body>
</html>
<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
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
     width: 900px;
     height: 625px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
input[type=text] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  border-bottom:2px solid darkmagenta;
}
td{
font-size: x-large;
}
</style>
</head>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<body>
	<div class="wrapper">
        
		<div align="center" style="background-color: darkmagenta;" >
            <br>
            <br>
      		<h1><font size="50px" color="white" >Enter Question</font></h1>
            <br>
            <br>
        </div>
  <div align="center" style="padding-left: 2%;text-align: -webkit-right;">
        <form:form action="add" method="GET" modelAttribute="mockModel">
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
        <button class="button">SAVE</button> <button formaction="admin" class="button">BACK</button>
        </div>
        </form:form>
    </div>
</div>
</body>
</html>
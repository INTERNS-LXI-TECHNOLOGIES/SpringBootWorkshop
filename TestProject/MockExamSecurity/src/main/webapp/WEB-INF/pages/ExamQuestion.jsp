<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.entity.Exam" %>
<html>
<head>
<title>Exam Question View</title>
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
  background-color: #ff0080;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #ff0040}

.button:active {
  background-color: #ff0040;
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
  background-color: #ff0080;
  padding: 20px;
  text-align: center;
}
  </style>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>
</head>
<script>
<%
String clock = request.getParameter( "clock" );
if( clock == null ) clock = "20";
%>
var timeout = <%=clock%>;
function timer()
{
  if( --timeout > 0 )
  {
    document.forma.clock.value = timeout;
    window.setTimeout( "timer()", 1000 );
  }
  else
  {
    document.forma.clock.value = "Time over";
    // window.location.href = "index.jsp";
  }
}
</script>
<body>

	   <%
	   List<Exam> qn = (List<Exam>)session.getAttribute("listExam");
       int i = Integer.parseInt(request.getParameter("indexValue"));
       %>
	
        <div class="header">
		<h1>Questions</h1>
		<br><form action="<%=request.getRequestURL()%>" name="forma">
		<h2 align="right">Seconds remaining:<input type="text" name="clock" value="<%=clock%>" style="border:0px solid white"></h2></form>
		</div>
        <div> 
<b>		
        <%if(i < qn .size())
        	{%>
		<script>
        timer();
      </script>
		<form action="option" method="get" >
		<label><%out.print(qn.get(i).getQuestion()); %></label><br>
        <input type="checkbox" value="1" name="opt" id="option1" >
        <label for = "option1"><%out.print(qn.get(i).getOption1()); %></label><br>
        <input type="checkbox" value="2" name="opt" id="option2" >
        <label for = "option2"><%out.print(qn.get(i).getOption2()); %></label><br>
        <input type="checkbox" value="3" name="opt" id="option3" >
        <label for = "option3"><%out.print(qn.get(i).getOption3()); %></label><br>
        <input type="checkbox" value="4" name="opt" id="option4" >
        <label for = "option4"><%out.print(qn.get(i).getOption4()); %></label><br>
		 <%i++; %>
		 </b>
		 <br>
		 
	  <input type="hidden" name ="indexValue" value="<%out.print(i);%>">
      <button formaction="option" name="indexValue" class="button" value ="<%out.print(i);%>">Next</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="button" value="Back" onclick="history.back()">
		  </form>
		  
			<%}
	else
	{
    response.sendRedirect("result");
    }%>
	</div>
</body>
</html>
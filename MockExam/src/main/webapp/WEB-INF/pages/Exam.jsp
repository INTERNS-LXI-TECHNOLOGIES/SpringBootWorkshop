<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List"%>
<%@page import="com.lxisoft.entity.MockEntity" %>
<html>
<head>
<meta http-equiv="Content_Type" content="text/html;charset=UTF-8"/>

<script type="text/javascript">
		function selectRadio() {
			document.getElementById('submitBtn').type = "submit";
		}
		function check() {
		var checkRadio = document.querySelector( 
                'input[name="option"]:checked'); 
                if(!checkRadio) {
            		alert("Please Select a Option");
            	}
		}
<%
String clock = "20";
%>
var timeout = <%=clock%>;
function timer()
{
	if( --timeout > 0 )
	{
		document.getElementById('clocky').innerHTML = timeout;
		window.setTimeout( "timer()", 1000 );
	}
	else
	{
		var data = window.location.href.split('=');
		var qcount = parseInt(data[1]) +1;
		window.location.href=data[0].slice(0,data[0].lastIndexOf('/'))+'/Option?ques='+qcount;
	}
}
</script>
</head>
<body>

    <form action="result.jsp" name="num">
        <div align="right">
                <h1><font color="#C0C0C0">Seconds Remaining : <span id="clocky"><%=clock%></font></span> </h1>
        </div>
    </form>
        <script>
            timer();
        </script>

	   <%
	   List<MockEntity> questionList = (List<MockEntity>)session.getAttribute("listQuestions");
       int no = Integer.parseInt(request.getParameter("count"));
       
       %>
	<div class="header">
        
		<div align="center" >
            <br>
            <h1><font size="50px" color="white" >MockeExam</font></h1>
            <br>
      		<h2><font size="50px" color="white" >Questions</font></h2>
            
        </div>
        <%if(no < questionList.size())
        	{%>
  <div align="left" style="padding-left: 2%;">
  <form method="GET" action="selectOption">
        <h1><label>Quest No <%out.print(no+1+" : "); out.print(questionList.get(no).getQuestion()); %></label></h1><br>
        
        <h2><input onclick="selectRadio()" type="radio" value="<%=(questionList.get(no).getAnswer())%>" name="option" id="option1" >
        <label for = "option1"><%out.print(questionList.get(no).getOption1()); %></label></h2><br>
        
        <h2><input onclick="selectRadio()" type="radio" value="<%=(questionList.get(no).getOption2())%>" name="option" id="option2" >
        <label for = "option2"><%out.print(questionList.get(no).getOption2()); %></label></h2><br>
        
        <h2><input onclick="selectRadio()" type="radio" value="<%=(questionList.get(no).getOption3())%>" name="option" id="option3" > 
        <label for = "option3"><%out.print(questionList.get(no).getOption3()); %></label></h2><br>
        
        <h2><input onclick="selectRadio()" type="radio" value="<%=(questionList.get(no).getOption4())%>" name="option" id="option4" >
        <label for = "option4"><%out.print(questionList.get(no).getOption4()); %></label></h2><br>
      	
        <%no++; %>
        <div align="center">
       

            <input type="hidden" name ="count" value="<%out.print(no);%>">
        <!-- <button onclick="check()" type="button" id="submitBtn" class="button" name ="count" value ="<%out.print(no);%>">Next</button> -->
        
        <button formaction="selectOption" name="count" class="button" value ="<%out.print(no);%>">Next</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" class="button" value="Back" onclick="history.back()">
        </div>
        </form>
    </div>
    <%
        }
        else
        {
        	response.sendRedirect("result");
        }
    %>
    
</div>
</body>
</html>
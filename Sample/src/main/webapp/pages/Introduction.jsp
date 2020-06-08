<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
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
     width: 920px;
     height: 680px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
 .intro{
 padding-left: 80px;
 font-variant: all-small-caps;
 font-size: x-large;
 }
</style>
</head>
<body>
<div class = "wrapper">
	<!-- <div align = "center"> -->
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">INTRODUCTION</font></h1>
			<br>
			<br>
			</div>
			<div class = "intro">
				<ul>
				
					<li><h1>  Exam has Total 10 Questions. </h1></li>
					<li><h1>  Each Question has 20 sec. </h1></li>
					<li><h1>  No Negative Marks.</h1></li>
					<li><h1>  Minimum 6 Right Answers For Pass.</h1></li>
			
				</ul>
			</div>
<div style="padding-top: 18px;" align="center">
<form>
<input type="hidden" name = "count" value = "0" >
<button formaction = "userQuestion" class="button">Start Exam</button> <button formaction="logout" class="button">LOGOUT</button> <button class="button" formaction="index" >Back</button>
</form>
</div>
</div>
</body>
</html>
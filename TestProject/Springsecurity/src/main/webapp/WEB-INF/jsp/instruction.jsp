<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
<style>
body
.container {
  height: 700px;
  position: relative;
  border: 5px solid oldlace;
}
.center {
  margin: 0;
  position: absolute;
  top: 25%;
  left: 30%;
  -ms-transform: translate(-30%, -30%);
  transform: translate(-20%, -20%);
}
.button_css
{
  background-color: midnightblue;
  color: white;
  width: 150px;
  height: 40px;
}
</style>
</head>
<body>
<div class = "wrapper">
    <div  align="center" style="background-color: grey;">
      <br>
      <br>
    <h1><font style="font-size:50px;" color="white">INSTRUCTIONS</font></h1>
      <br>
      <br>
      </div>
      <div class = "intro">
        <ul>
        
          <li><h1>  Exam has Total 10 Questions. </h1></li>
          <li><h1>  Each Question has 20 sec when you start exam timer will start. </h1></li>
          <li><h1>  No Negative Marks and each question carry 1.</h1></li>
          <li><h1>  Each Question have four Options.</h1></li>
          <li><h1>  Minimum 6 Right Answers For Pass.</h1></li>      
        </ul>

        <c:>
  <form>
    <input type="hidden" name = "count" value = "0" >
    <input type="submit" formaction="startExam" class="button" name="next" value="NEXT" >

  </form>
</c:>
  </div>
</div>
</body>
</html>

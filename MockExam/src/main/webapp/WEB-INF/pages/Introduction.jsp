<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
<html>
<head>
<style type="text/css">
.button {
  height: 52px;
     width: 186px;
     border: none;
     border-radius: 20px;
     background-color:#566573 ;
     color: #fff;
     font-weight: bolder;
     margin-top: 30px;
     cursor: pointer;
     outline: none;
     font-size: 21px;
}
.button:hover {background-color: #566573}
.button:active {
  background-color: #566573;
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
<body background="space.jpg">
<div class = "wrapper">

<div  align="center" style="background-color: darkmagenta;">
      <br>
      <br>
    <h1><font style="font-size:50px;" color="white">INTRODUCTION</font></h1>
      <br>
      <br>
      </div>
      <div class = "intro">

        <header>
          <h3><font color="black">* You have got 10 minutes to complete the exam</font></h3>
          <h3><font color="black">* Answer all questions</font></h3>
          <h3><font color="black">* Read questions carefully and select the answer given below</font></h3>
          <h3><font color="black">* Any malpractice will lead to debar</font></h3>
         <div style="padding-top: 18px;" align="center">
      <form>
      <input type="hidden" name = "count" value = "0" >
      <button formaction = "exam" class="button">Start</button> <button class="button" formaction="/" >Back</button>
    </form>
  </div>
</header>
</body>
</html>
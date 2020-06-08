<%@page contentType = "text/html;charset=UTF-8" pageEncoding = "UTF-8"%>
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
     height: 600px;
     position: relative;
     margin: 3% auto;
     box-shadow: 2px 18px 70px 0px #9d9d9d;
   }
</style>
</head>
<body>
<form>
	<div class = "wrapper">
		<div  align="center" style="background-color: darkmagenta;">
			<br>
			<br>
		<h1><font style="font-size:50px;" color="white">!! WELCOME ADMIN !!</font></h1>
			<br>
			<br>
		</div>
			<br>
		<div align="center" style="padding-top: 80px;">
		<button formaction="displayAll" class="button">VIEW</button>
		<button formaction="addQuestion" class="button">ADD</button>
		<button formaction="update" class="button">UPDATE</button>
		<button formaction="delete" class="button">DELETE</button>
		<button formaction="introduction" class="button">TEST EXAM</button>
		<button formaction="logout" class="button">LOGOUT</button>
		<button formaction="index" class="button">BACK</button>
		<br>
		<br>
	</div> 
</div>
</form>
</body>
</html>
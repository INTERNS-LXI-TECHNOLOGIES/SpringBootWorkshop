<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
<meta charset="ISO-8859-1">
<title>Vegetable Add Form</title>

<style>
  h1{
color:white;	
background-color:rgb(95, 95, 209);
font-size:40px;
height:65px;
width:1200px;
}
h4{
  font-size:30px;
color:white;	
background-color:red;
border-radius:10px;
margin : 30px 450px;
height:40px;
width:300px;
}
table{
border:none;
}
th,td{
 padding : 9px;
}
table{
border:none;
}
td{
  padding : 9px;
}
.subBtn{
background-color:red;
border: none;
border-radius:10px;
color : white;
width:70px;
  height:30px
}
.homeBtn{
margin:50px;


}
</style>

</head>


<html>

<body>

<center>

<h1>VEGETABLE ADDING FORM</h1>

<div align = "left">

  
  <a href = "<%=request.getContextPath() %>"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
    </a>
    
    </div>

<form action ="<%=request.getContextPath() %>/create-vegetable" enctype="multipart/form-data" method ="POST">

<table style = "width: 80%">

<tr>

  <td>Enter Name</td>
  <td><input type = "text" name = "name"/></td>
  </tr>
  
  <tr> 
  <td>Enter Price </td>
  <td><input type = "text" name = "price"/></td>
</tr>

<tr>
<td>Enter Stock</td>
<td><input type = "text" name = "stock"/></td>
</tr>

<tr>
<td>Enter OrderQuantity</td>
<td><input type = "text" name = "minOrderQuantity"/></td>
</tr>

<tr>
  <td>Select Photo</td>
  <td><input type="file" name="imageFile"></td>
  </tr>

 </table>

 
 <input type = "submit" value = "submit" class = "subBtn"/>
 

</form>
</div>
</center>
</body>

</html>
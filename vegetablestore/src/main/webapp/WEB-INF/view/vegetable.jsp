

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>

<title>Vegetable List</title>
<style>
h1{
color:white;
background-color:blue;
font-size:37px;
height:60px;
width:1330px;
}
h2{
color:white;
background-color:chartreuse;
border-radius:10px;
margin : 1px 10px 70px 440px;
height:40px;
width:410px;
}
table{
  border: none;

}
td{
  color :black;
  padding : 20px;
  }
.vegetableBtn{
margin : 0px 1px 1px 70px;
border-radius:10px;
height:30px;
width:100px;
}
.editBtn{
  background-color:blue;
  color : white;
  border: none;
  border-radius:10px;
  width:70px;
  height:30px
}
.deleteBtn{
background-color:red;
border: none;
border-radius:10px;
color : white;
width:70px;
  height:30px;

}
.vegetableBtn{
height:40px;
}
.search{
border-color:red;
height:40px;
  width : 500px;
}
.searchBtn{
background-color: rgb(66, 224, 66);
  color: white;
border:none;
}
.category{
background-color:blue;
color:white;
text-align:left;
}
</style>

</head>
<%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
<%@ page import="com.lxisoft.vegetablestore.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<body>

  <h1><center>VEGETABLE STORE</center></h1>

  <div
  style= "text-align: left;">
  <a href = "/"><img src ="image?name=refresh.jpg" alt="google-play" height = 50px  ></a>
</div>


  <div
  style= "text-align: right;">
  <a href = "log-out"  ><img src ="image?name=logout.jpeg" alt="google-play" height = 60px  class="log" onclick = "return confirm('Are You Sure Want to Logout')"></a></center>
</div>


  <a href = "add-form"><img src ="image?name=add.jpeg" alt="google-play" height = 50px  class="vegetableBtn"></a>


<h2><center>Vegetable Details</center></h2>
 <table>

<form action = "search" method = "get">
 <center> <input type = "text" class = "search" name = "search" placeholder = "Search"/>
<button class = "searchBtn">Search</button>

</center></form>


<div class = "category">
<%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
for(Category category:categories) {%>
<tr>
<td>
<form action = "categories" method = "GET">

   <input type = "hidden" name ="id" value= <%=category.getId()%>
      <input type = "submit" ><button><%=category.getType()%><button></input></form>


</td>
</tr><%}%>
</div></table>
<center><table style="width: 50%;" border="0" >
 <%List<Vegetable> vegetables = (ArrayList<Vegetable>)request.getAttribute("vegetables");


  for (Vegetable vegetable : vegetables) {%>

    <div class = "list">
      <div class = "row">
<div class = "col">
    <tr>
      <td><img src="data:image/jpg;base64,<%= vegetable.getBase64Image()%>"width = "200" height ="140"></td>

  <td><center><%out.println("Id : " +vegetable.getId());%></center>

<center><%out.println("Name :"+vegetable.getName());%></center>

<center><%out.println( "Price :"+vegetable.getPrice());%></center>

<center><%out.println("Stock :"+vegetable.getStock());%></center>

<center><%out.println("Order Quantity :"+vegetable.getMinOrderQuantity());%></center></td>



  <td><form action = "select-vegetable" method = "GET">

    <center><input type = "hidden" name ="id" value= <%=vegetable.getId()%>
      <input type = "submit" ><button class = "editBtn">Edit</button></input></center></form>



    <form action = "delete-vegetable" method = "POST">

      <center><input type = "hidden" name ="id" value= <%=vegetable.getId()%>
        <input type = "submit" ><button class = "deleteBtn" onclick ="return confirm('Are You Delete Permanently?')">Delete</button></input></center></form>
        </td>

</div>
</div>
</div>
<%}%>
</table></center>
</body>

</html>

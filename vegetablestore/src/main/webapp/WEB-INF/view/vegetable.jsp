

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


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
.vegetableBtn{
margin : 0px 1px 1px 70px;
border-radius:10px;
height:40px;
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
.card{
border:none;
}
</style>

</head>
<%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
<%@ page import="com.lxisoft.vegetablestore.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<body>

  <h1><center>VEGEE-CART</center></h1>
  <div
  style= "text-align: left;">
  <a href = "/"><img src ="image?name=refresh.jpg" alt="google-play" height = 50px  ></a>
</div>

  <div
  style= "text-align: right;">
  <a href = "log-out"  ><img src ="image?name=logout.jpeg" alt="google-play" height = 60px  class="log-out" onclick = "return confirm('Are You Sure Want to Logout')"></a></center>
</div>


  <a href = "add-form"><img src ="image?name=add.jpeg" alt="google-play" height = 50px  class="vegetableBtn"></a>



<form action = "search" method = "get">
 <center> <input type = "text" class = "search" name = "search" placeholder = "Search"/>
<button class = "searchBtn">Search</button>

</center></form>


                 <!-- Categories-->


<%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");%>

<div class = "col-md-2 text-left">

<div class="list-group">

 <a href="#" class="list-group-item list-group-item-action active">
   Categories
  </a>

  <%for(Category category:categories) {%>

<a href="categories?id=<%= category.getId()%>" class="list-group-item list-group-item-action"><%=category.getCategory()%></a>

<%}%>
</div>
</div>


                 <!-- Vegetables -->

<div class = "container">

<div class = "row">

 <%List<Vegetable> vegetables = (ArrayList<Vegetable>)request.getAttribute("vegetables");


  for (Vegetable vegetable : vegetables) {%>

<div class = "col-4 my-5">

<div class="card text-center" style="width: 18rem;">
  <img class="card-img-top" src="data:image/jpg;base64,<%= vegetable.getBase64Image()%>" alt="Card image cap" width = "200" height ="200">
  <div class="card-body">
    <h5 class="card-title"><%=vegetable.getName()%></h5>
    <p class="card-text">stock :<%=vegetable.getStock()%></p>
     <p class="card-text">Minimum Order Quantity :<%=vegetable.getMinOrderQuantity()%></p>
     <h5 class="card-title text-danger">Rs:<%=vegetable.getPrice()%>/-</h5>

     <form action = "select-vegetable" method = "GET">

         <center><input type = "hidden" name ="id" value= <%=vegetable.getId()%>
           <input type = "submit" ><button class = "editBtn">Edit</button></input></center></form>

           <form action = "delete-vegetable" method = "POST">

                 <center><input type = "hidden" name ="id" value= <%=vegetable.getId()%>
                   <input type = "submit" ><button class = "deleteBtn" onclick ="return confirm('Are You Delete Permanently?')">Delete</button></input></center></form>

  </div>
</div>
</div>
            <%}%>
</div>
</div>

</body>

</html>

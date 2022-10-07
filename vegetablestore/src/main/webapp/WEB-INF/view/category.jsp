<!DOCTYPE html>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<head>

<title>category</title>

<%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


<style>

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
.card{
border: none;
}

</style>

</head>
<body>

<div align = "left">
  <a href = "/"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
  </a>
</div>

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
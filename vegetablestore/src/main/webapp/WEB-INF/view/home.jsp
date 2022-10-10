

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<head>

<title>Home</title>


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


<!--navbar-->



<nav class="navbar navbar-expand-lg navbar-light bg-warning fixed-top">


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">

    <h4><a class="navbar-brand text-white fw-bold" href="#">VEGEE-CART</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button></h4>

      <li class="nav-item active">
        <a class="nav-link" href="#carouselExampleIndicators">Home <span class="sr-only">(current)</span></a>

        <li class="nav-item">
              <a class="nav-link" href="add-form">Add</a>
            </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categories
        </a>

        <%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");%>

         <div class="dropdown-menu" aria-labelledby="navbarDropdown">

         <%for(Category category:categories) {%>

        <a href="categories?id=<%= category.getId()%>" class="dropdown-item" ><%=category.getCategory()%></a>

        <div class="dropdown-divider"></div>
        <%}%>

        </div>
      </li>


      <li class="nav-item">
              <a class="nav-link" href="logout">log out</a>
            </li>
    </ul>

    <form class="form-inline my-2 my-lg-0" action ="search" method = "get">
      <input class="form-control mr-sm-2" type="search" name = "search" placeholder="Search" aria-label="Search">
      <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>


  <div
  style= "text-align: right;">
  <a href = "log-out"  ><img src ="image?name=logout.jpeg" alt="google-play" height = 60px  class="log-out" onclick = "return confirm('Are You Sure Want to Logout')"></a></center>
</div>


<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="image?name=carousel1.jpg"  height = 550px alt="First slide">
    </div>

    <div class="carousel-item">
      <img class="d-block w-100" src="image?name=carousel2.jpg"  height = 550px alt="Second slide">
    </div>

    <div class="carousel-item">
      <img class="d-block w-100" src="image?name=carousel3.jpg"  height = 550px alt="Third slide">
    </div>
  </div>

  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



                 <!-- Vegetables -->

<div class = "container" id = "vegetables">

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

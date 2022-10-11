<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
.card{
padding:10px;
}
.container
</style>

</head>


<html>

<%@ page import="com.lxisoft.vegetablestore.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<body>

<center>

<h1>ADDING FORM</h1>

<div align = "left">

  
  <a href = "/"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
    </a>
    
    </div>

<div class = "container">
<div class = "row">
<div class = "col-md-4">
<div class ="card">
<div class = "card-body">
<div>
 <a href = "#add-Vegetable"><img src ="image?name=add1.jpg" height = 120px alt="google-play" class="homeBtn">
    </a>
   </div>
<div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addVegetable">
Add Vegetable
   </button>
 </div>
</div>
</div>
</div>



<div class = "col-md-4">
<div class ="card">
<div class = "card-body">
<div>
 <a href = "#add-category"><img src ="image?name=add1.jpg" height = 120px alt="google-play" class="homeBtn">
    </a>
   </div>

 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addCategory">
Add Category
   </button>
</div>
</div>
</div>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="addCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Add Category</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

        </button>
      </div>
      <div class="modal-body">

<form action = "create-category" method = "post">

<div class = "form-group">

<input type = "text" class = "form-control" name = "category" placeholder= "Enter New Category" required/>

</div>

<div class = "container text-center">
<button class = "btn btn-outline-success">Add Category</button>
 <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>
</div>
</form>
      </div>

    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="addVegetable" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Vegetable</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

        </button>
      </div>
      <div class="modal-body">

        <form action ="create-vegetable" enctype="multipart/form-data" method ="POST">

        <div class = "form-group">
        <input type = "text" class = "form-control" placeholder = "Enter Name" name = "name" required/>
        </div>

          <div class = "form-group">
                <input type = "text" class = "form-control" placeholder = "Enter Price" name = "price" required/>
                </div>

             <div class = "form-group">
                <input type = "text" class = "form-control" placeholder = "Enter Stock" name = "stock" required/>
                        </div>

             <div class = "form-group">
                   <input type = "text" class = "form-control" placeholder = "Enter Minimum Order Quantity" name = "minOrderQuantity" required/>
                   </div>

<div class = "form-group">
<select name ="category" class = "form-control" id = "">

<%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");%>

<%for(Category category:categories) {%>

<option value =<%= category.getId() %>><%= category.getCategory()%></option>

<%}%>
</select>
</div>

<div class = "form-group text-left">

<label for="imageFile">Select Image</label>
<br>
<input type = "file" name = "imageFile" required />

</div>

<div class = "container text-center">

<button class = "btn btn-outline-success">Add Vegetable</button>
<button type="button" class="btn btn-outline-danger" data-dismiss="modal">Close</button>

</div>

        </form>

      </div>
    </div>
  </div>
</div>


</body>

</html>
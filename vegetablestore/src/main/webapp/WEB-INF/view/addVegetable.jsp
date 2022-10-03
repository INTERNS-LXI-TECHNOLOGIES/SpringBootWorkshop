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

   <button class = btn >Add Vegetable</button>
   <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
Add Category
   </button>


<form action ="create-vegetable" enctype="multipart/form-data" method ="POST">

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


<%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");%>


<div class = "form-group">
<select name ="category" class = "form-control" id = "">


<%for(Category category:categories) {%>

<option value =<%= category.getId() %>><%= category.getCategory()%></option>

<%}%>
</select>

</div>



<tr>
  <td>Select Photo</td>
  <td><input type="file" name="imageFile"></td>
  </tr>

 </table>

 
 <input type = "submit" value = "submit" class = "subBtn"/>
 

</form>
</div>
</center>

<!-- Button trigger modal -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>

</html>
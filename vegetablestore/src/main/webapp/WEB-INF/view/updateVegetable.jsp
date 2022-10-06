<html>


<head>

<style>
   h1{
color:white;	
background-color:red;
font-size:30px;
height:40px;
width:1300px;
padding : 5px;
}

.subBtn{

   background-color:blue;
  color : white;
  border: none;
  border-radius:10px;
  width:70px;
  height:30px

}
.form-group{
font-size:15px;
border-radius:30px;
padding:10px;
border-color:red;
}
.form-control{
border-radius:10px;
padding:10px;
border-color:red;
}

</style>


   <%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
   <%@ page import="com.lxisoft.vegetablestore.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

</head>
<body>

<center><h1>VEGEE-CART UPDATE FORM</h1></center>



<a href = "/"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
</a>
 <div class = "container">
   <form action ="update-vegetable" enctype="multipart/form-data" method = "POST">

    <%Vegetable vegetable =(Vegetable) request.getAttribute("vegetable");%>
     <%List<Category> categories = (ArrayList<Category>)request.getAttribute("categories");%>

    <center><img src="data:image/jpg;base64,<%= vegetable.getBase64Image()%>"width = "300" height ="180"> </center>

    <!-- id -->
   <div class = "form-group">
   <input type = "hidden" name = "id" value =<%=vegetable.getId()%>>
   </div>

<!-- name -->
   <center><div class = "form-group">
   <label for = "form-control">Vegetable Name</label>
           <input type = "text" class = "form-control" value =<%=vegetable.getName()%> name = "name" required/>
           </div></center>

<!-- price -->
          <center><div class = "form-group">
           <label for = "form-control">Vegetable Price</label>
            <input type = "text" class = "form-control" value =<%=vegetable.getPrice()%> name = "price" required/>
              </div></center>

<!-- stock -->
  <center><div class = "form-group">
           <label for = "form-control">Vegetable Stock</label>
            <input type = "text" class = "form-control" value =<%=vegetable.getStock()%> name = "stock" required/>
              </div></center>


<!-- order -->
  <center><div class = "form-group">
           <label for = "form-control">Vegetable Stock</label>
            <input type = "text" class = "form-control" value =<%=vegetable.getMinOrderQuantity()%> name = "minOrderQuantity" required/>
              </div></center>


<center><div class = "form-group">
  <label for = "category">Vegetable Category</label>
  <select name ="category" class = "form-control" id = "">

  <%for(Category category:categories) {%>

  <option value =<%= category.getId() %>><%= category.getCategory()%></option>
  <%}%>
  </select>

  </div></center>


  <center><div class = "form-group text-left">

  <label for="imageFile">Select Image</label>

  <input type = "file" name = "imageFile" class = "form-control" required />

  </div></center>


   </div>





     <center><input type = "submit" value = "submit" class ="subBtn"/></center>
     

 </form>
</body>
</html>
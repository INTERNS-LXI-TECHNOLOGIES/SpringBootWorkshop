<html>


<head>

<style>
   h1{
color:white;	
background-color:red;
font-size:40px;
height:65px;
width:1200px;
padding : 13px;
}
table{
border:none;
}
th,td{
  padding : 9px;
}
.subBtn{

   background-color:blue;
  color : white;
  border: none;
  border-radius:10px;
  width:70px;
  height:30px

}
.homeBtn{
margin:50px;


}

</style>


   <%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

</head>
<body>

<center><h1>VEGETABLE UPDATE FORM</h1></center>


<a href = "/"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
</a>
   
   <form action ="update-vegetable" enctype="multipart/form-data" method = "POST">


   <%Vegetable vegetable =(Vegetable) request.getAttribute("vegetable");%>


<center>
<table style = "width: 80%">


<td> <center><img src="data:image/jpg;base64,<%= vegetable.getBase64Image()%>"width = "200" height ="140"> </center></td>

   <td><input type = "hidden" name = "id" value =<%=vegetable.getId()%>></td>
   </tr>
   
   <tr>

      <td>Enter Name</td>
      <td><input type = "text" name = "name" value =<%=vegetable.getName()%>></td>
      </tr>
      
      <tr> 
      <td>Enter Price </td>
      <td><input type = "text" name = "price"  value =<%=vegetable.getPrice()%>></td>
    </tr>
    
    <tr>
    <td>Enter Stock</td>
    <td><input type = "text" name = "stock"  value =<%=vegetable.getStock()%>></td>
    </tr>
    
    <tr>
    <td>Enter OrderQuantity</td>
    <td><input type = "text" name = "minOrderQuantity"  value =<%=vegetable.getMinOrderQuantity()%>></td>
    </tr>

    <tr>
    <td>Change category</td>
    <td><input type = "text" name = "type"></td>
    </tr>

   <tr>
     <td>Select Photo</td>
     <td><input type="file" name="imageFile" value = <%=vegetable.getImage()%>></td>
     </tr>

     </table>
     
     <input type = "submit" value = "submit" class ="subBtn"/>
     
    

 </center>

 </form>
</body>
</html>
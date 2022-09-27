<html>

<head>

<title>category</title>

<%@ page import="com.lxisoft.vegetablestore.entity.Vegetable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<body>
<div align = "left">


  <a href = "/"><img src ="image?name=home.jpeg" alt="google-play" height = 60px  class="homeBtn">
    </a>

    </div>

<center><table style="width: 50%;" border="0" >
 <%List<Vegetable> vegetables = (ArrayList<Vegetable>)request.getAttribute("vegetables");

  for (Vegetable vegetable : vegetables) {

  %>



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

</tr></div></div></div>

<%}%>
</table>

</body>

</head>
</html>
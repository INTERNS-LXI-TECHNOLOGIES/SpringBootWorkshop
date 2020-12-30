<!DOCTYPE html>
<html>
<head> 
<style>
	table, th, td {
  border: 1px solid black;
}
</style> 
	<h1 align="center">CONTACTS</h1>
	<title>
		
	</title>
</head>
<body style="background: white">
<%@page import = "com.lxisoft.controller.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*,com.lxisoft.secured.*"%>

<table align="center" style="border-collapse: collapse;">
	        <tr>
				<th >NAME</th>
								<th >Number</th>
																<th >Email-ID</th>
																						



				
			</tr>
<% List<Contact> contactList=(List<Contact>) request.getAttribute("contactList");
	
	for(Contact contact : contactList)
		{ %>
			<b>
			<tr style=" font-style:oblique;  ">
			<td>
					<%out.println(contact.getName());%>
				</td>
				<td>
					<%out.println(contact.getNumber());%>
				</td>
				<td>
					<%out.println(contact.getEmail());%>
				</td>
				 
			
			</tr>
			</b>
			<%
		} %>

</table>
<center><a href="index.jsp"><input type="button" value="Go back to menu" name="cancel"/></a></center>

</body>
</html>
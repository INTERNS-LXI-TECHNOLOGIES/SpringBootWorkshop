<!DOCTYPE html>
<html>
<head> 
<style>
	table, th, td {
  border: 1px solid black;
}
</style> 
	<h1 align="center">CONTACTS</h1>
	<p align="center"><b>Note:</b>Press the name to do Any updates.</p>
	<title>
		
	</title>
</head>
<body style="background: white">
<%if (request.isUserInRole("admin")) {%>
<%@page import = "com.lxisoft.controller.*"%>
<%@page import = "com.lxisoft.repository.*"%>
<%@page import = "com.lxisoft.model.*,java.util.*,com.lxisoft.secured.*"%>

<table align="center" style="border-collapse: collapse;">
	        <tr>
				<th >NAME</th>
								<th >Number</th>
																<th >Email-ID</th>
																						<th >Delete Contact</th>



				
			</tr>
<% ArrayList<Contact> contactList=(ArrayList<Contact>) request.getAttribute("contactList");
	
	for(Contact contact : contactList)
		{ %>
			<b>
			<tr style=" font-style:oblique;  ">
			<td>
		<a href="UpdateContactSelected?id=<%=contact.getID()%>&name=<%=contact.getName()%>&number=<%=contact.getNumber()%>&email=<%=contact.getEmail()%>"><input type="button" name="submit" value="<%=contact.getName() %>"></a>
				</td>
				<td>
					<%out.println(contact.getNumber());%>
				</td>
				<td>
					<%out.println(contact.getEmail());%>
				</td>
				 <td>
					<a href="DeleteContact.jsp?temp=<%=contact.getName()%>&id=<%=contact.getID()%>"><input type="button" name="submit" value="Delete"></a>
				</td>
			
			</tr>
			</b>
			<%
		} %>

</table>
<center><a href="index.jsp"><input type="button" value="Go back to menu" name="cancel"/></a></center>
<%}
else
{
	            response.sendRedirect("WrongUser.jsp");

}%>

</body>
</html>
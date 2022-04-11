<%@page import="edu.jspiders.mycontacts.dto.MyContacts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.spiders.mycontacts.dao.ContactDataBaseOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
<link rel="stylesheet" href="./resources/css/index.css">
</head>
<body>
	<div class="container">
		<div class="fon">My Contacts</div>
	<nav class="font">
		<a href="./index" >Home</a> 
		<a href="./insert" >Add Contact</a> 
		<a href="./search" >Search Contact</a> 
		<a href="./display" >Contacts</a>
	</nav>
	</div>
	<div>
		<table border="2" align="center" cellpadding="10" cellspacing="20" rules="all">
		<tr>
		<th>Phone</th>
		<th>Name</th>
		<th>Email</th>
		<th>DOB</th>
		<th>Edit</th>	
		<th>Delete</th>	
		</tr>
		
		<%
			ContactDataBaseOperations op = new ContactDataBaseOperations();
			ArrayList<MyContacts> allContact = op.getAllContacts();
			for(int i = 0 ; i < allContact.size() ; i++)
			{
				MyContacts cntct = allContact.get(i);
		%>		
			<tr >
				<td><%= cntct.getNumber() %> </td>
				<td> <%= cntct.getName() %></td>
				<td> <%= cntct.getEmailId() %></td>
				<td> <%= cntct.getDOB() %></td>
				<td> <a href="./edit?name=<%= cntct.getName() %>" >edit</a></td>
				<td> <a href="./delete?name=<%= cntct.getName() %>" >delete</a></td>
			</tr>
		<%
			}
		%>
	</table>
	</div>
</body>
</html>
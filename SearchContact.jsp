<%@page import="edu.jspiders.mycontacts.dto.MyContacts"%>
<%@page import="edu.spiders.mycontacts.dao.ContactDataBaseOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
</head>
<body style="background:rgb(133, 133, 218)">
		<%
		String name = request.getParameter("name");
		ContactDataBaseOperations operations = new ContactDataBaseOperations();
	    MyContacts searchedContact = operations.searchContact(name);

		if(searchedContact != null)
		{
		%>
			<h1>Mail to <%= searchedContact.getName() %></h1>
			<a href="mailto:<%= searchedContact.getEmailId() %>"></a>
			<%
	    }
		else
		{
			%>
			<h1  >Contact Not Found</h1>
			<%
		}
	%>
	
</body>
</html>
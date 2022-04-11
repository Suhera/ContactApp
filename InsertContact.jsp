<%@page import="java.time.LocalDate"%>
<%@page import="edu.spiders.mycontacts.dao.ContactDataBaseOperations"%>
<%@page import="edu.jspiders.mycontacts.dto.MyContacts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Contact</title>
</head>
<body>
		<%
		String number = request.getParameter("number");
		Long num = Long.parseLong(number);
		String name = request.getParameter("name");
		String email = request.getParameter("mail");
		LocalDate date = LocalDate.parse(request.getParameter("dob"));
		String dob = date.toString();


		MyContacts contact = new MyContacts();
		
		contact.setNumber(num);
		contact.setName(name);
		contact.setEmailId(email);
		contact.setDOB(dob);
		
		
		ContactDataBaseOperations operations =new ContactDataBaseOperations();
	
		boolean isAdded = operations.addContact(contact);
		if(isAdded)
		{
   		 %>
			<h1 style="background-color:  pink">Contact Added</h1>
			  <jsp:include page="./display"></jsp:include>  
		<%
		}
		else
		{
		%>
			<h1 style="background-color: pink">Contact has not been Added</h1>
			<jsp:include page="./insert"></jsp:include> 
		<%
		}	
		%> 
</body>
</html>
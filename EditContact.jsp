<%@page import="edu.jspiders.mycontacts.dto.MyContacts"%>
<%@page import="edu.spiders.mycontacts.dao.ContactDataBaseOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/index.css">
</head>
<body>
		<%
		String name = request.getParameter("name");
		ContactDataBaseOperations op = new ContactDataBaseOperations();
		MyContacts cntct = op.searchContact(name);
	%>
	
	<div>
	<form action="update" method="POST">
	
		<div class="user-details">
	
		<div class="input-box">
			<span class="details">Phone</span> <input type="number"
				name="number" placeholder="Number" required required value="<%= (cntct.getNumber()) %>" readonly="readonly">
		</div>
		
		<div class="input-box">
			<span class="details">Name</span> <input type="text"
				name="name" placeholder="Name" required value="<%= cntct.getName() %>">
		</div>
		
		<div class="input-box">
			<span class="details">Mail ID</span> <input type="email"
				name="email" placeholder="mail@gmail.com" required value="<%= cntct.getEmailId() %>">
		</div>
		<div class="input-box">
			<span class="details">Date_Of_Birth</span> <input type="date"
				name="dob"  required value="<%= cntct.getDOB() %>">
		</div>
		<div class="button">
			<input type="submit" value="Update Contact">

		</div>
	</form>
</div>
	
</body>
</html>
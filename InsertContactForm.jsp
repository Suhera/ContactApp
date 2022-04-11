<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Contact</title>
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
	
	<form action="addContact" method="POST">
			
				<div class="user-details">
			
				<div class="input-box">
					<span class="details">Phone</span> <input type="number"
						name="number" placeholder="Number" required>
				</div>
				
				<div class="input-box">
					<span class="details">Name</span> <input type="text"
						name="name" placeholder="Name" required>
				</div>
				
				<div class="input-box">
					<span class="details">Mail ID</span> <input type="email"
						name="mail" placeholder="mail@gmail.com" required>
				</div>
				<div class="input-box">
					<span class="details">Date_Of_Birth</span> <input type="date"
						name="dob"  required>
				</div>
				<div class="button">
					<input type="submit" value="Add Contact">

				</div>
			</form>
</body>
</html>
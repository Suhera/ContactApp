<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Contact</title>
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
			<form action="searchContact" method="post">
			<div class="user-details">
				<div class="input-box">
					<span class="details">Name</span> <input type="text"
						name="name" placeholder="Contact Name" required>
				</div>
				<div class="button">
					<input type="submit" value="SEARCH">

				</div>
			</div>
		</form>
		</div>
</body>
</html>
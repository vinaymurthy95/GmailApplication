<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register gmail</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="signup" method="post">
		Email :<input type="email" name="email"><br> User name :<input
			type="text" name="userName"><br> Password :<input
			type="password" name="password"><br> Security Question :
		<select name="question" id="cars">
			<option value="What is Your Petname">What is Your Petname</option>
			<option value="Who is Your favourite Heroine">Who is Your
				favourite Heroine</option>
			<option value="Your Vehicle Number">Your Vehicle Number</option>
		</select><br> Security Answer :<input type="text" name="answer"><br>
		<input type="submit" name="Sign Up">

	</form>
</body>
</html>
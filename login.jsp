<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login gmail</title>
</head>
<body>
	<h1>Login Page</h1>
	<h4 style="color: red">${msg }</h4>
	<form action="logingmail" method="post">
		Email:<input type="email" name="email"
			placeholder="Enter Emailaddress"><br> Password:<input
			type="password" name="password" placeholder="Enter Password"><br>
		<input type="submit" value="Login"> <a href="forgot">Forgot
			Password</a>
	</form>
</body>
</html>
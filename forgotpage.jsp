<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4 style="color: red">${msg }</h4>
	<h1>Forgot password??</h1>
	<form action="forgotpassword" method="post">
		Enter Email-id:<input type="email" name="email"
			placeholder="Enter Emailaddress"><br> Security Question
		: <select name="question" id="cars">
			<option value="What is Your Petname">What is Your Petname</option>
			<option value="Who is Your favourite Heroine">Who is Your
				favourite Heroine</option>
			<option value="Your Vehicle Number">Your Vehicle Number</option>
		</select><br> Security Answer :<input type="text" name="answer"><br>
		<input type="submit" name="Sign Up">
	</form>
</body>
</html>
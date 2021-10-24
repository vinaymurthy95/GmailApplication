<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="mailcompose" method="post">
		From: <input type="email" name="fromemail"><br>
		<br> To: <input type="email" name="toemail"><br>
		<br> Subject:<input type="text" name="subject"><br>
		<br> <label for="content"></label> Content:
		<textarea id="content" name="content" rows="4" cols="50"> </textarea>
		<br> <input type="submit" value="send">
		<a href="logout">Logout</a><br>
	
</body>
</html>
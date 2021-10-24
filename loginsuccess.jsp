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
	<h1>Login Successfull !!</h1>
	<h2>WelCome to Gmail Application: ${usr}</h2>
	<h2>
		<a href="compose">Compose</a><br> <a href="inbox">Inbox</a><br>
		<a href="sent">Sent</a><br> <a href="draft">Drafts</a><br> <a
			href="logout">Logout</a><br>
	</h2>
</body>
</html>

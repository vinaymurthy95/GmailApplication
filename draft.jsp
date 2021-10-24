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
	<h1>Draft</h1>
	<table border="1">

		<tr>
			<th>From</th>
			<th>To</th>
			<th>Subject</th>
			<th>Content</th>

		</tr>
		<c:forEach var="gdto" items="${lismdto}">
			<tr>
				<td><c:out value="${gdto.fromemail}"></c:out></td>
				<td><c:out value="${gdto.toemail}"></c:out></td>
				<td><c:out value="${gdto.subject}">
					</c:out></td>
				<td><c:out value="${gdto.content}">
					</c:out></td>

			</tr>
		</c:forEach>
	</table>
	<h2>
		<a href="compose">Compose</a><br> <a href="inbox">Inbox</a><br>
		<a href="sent">Sent</a><br> <a href="draft">Drafts</a><br> <a
			href="logout">Logout</a><br>
	</h2>
</body>
</html>
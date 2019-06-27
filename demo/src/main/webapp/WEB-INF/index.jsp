<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Helllooo</title>
</head>
<body>
	<h1>Hello Whats Up</h1>
	
	<ul>
		<c:forEach items="${groceryList}" var="listItem">
		<li><c:out value="${listItem}" /></li>
		</c:forEach>
	</ul>
	
	<form action="/serach" method="GET">
		<p>
			<label for="name">Name: </label>
			<input type="text" name="name" />
		</p>
		<input type="submit" />
	</form>
	
	<p><c:out value="${currentCounter}"/></p>
    
</body>
</html>
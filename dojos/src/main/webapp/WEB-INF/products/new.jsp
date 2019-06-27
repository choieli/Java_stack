<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>New Product</title>
</head>
<body>

	<h1>Create New Product</h1>
	<p><form:errors path="productObj.*"></form:errors></p>
	<form:form action="/products" method="POST" modelAttribute="productObj">
	
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name"></form:input>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:input type="text" path="description"></form:input>
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:input type="number" path="price"></form:input>
		</p>
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>
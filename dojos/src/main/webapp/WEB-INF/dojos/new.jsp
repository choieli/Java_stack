<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>New Dojo</title>
</head>
<body>

	<h1>Create New Dojo</h1>
	<p><form:errors path="dojoObj.*"></form:errors></p>
	<form:form action="/dojos" method="POST" modelAttribute="dojoObj">
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name"></form:input>
		</p>
		<input type="submit" />
	</form:form>

</body>
</html>
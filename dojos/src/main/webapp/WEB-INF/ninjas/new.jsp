<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>New Ninja</title>
</head>
<body>

	<h1>Create New Ninja</h1>
	<p><form:errors path="ninjaObj.*"></form:errors></p>
	<form:form action="/ninjas" method="POST" modelAttribute="ninjaObj">
	
		<p>
			<form:label path="dojo">Dojo: </form:label>
			<form:select path="dojo">
				<c:forEach items="${allDojos}" var="d">
					<form:option value="${d.id}">
						<c:out value="${d.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input type="text" path="firstName"></form:input>
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:input type="text" path="lastName"></form:input>
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:input type="number" path="age"></form:input>
		</p>
		<input type="submit" value="create" />
	</form:form>

</body>
</html>
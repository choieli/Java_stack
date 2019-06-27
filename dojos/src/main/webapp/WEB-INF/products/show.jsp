<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Show Product</title>
</head>
<body>

	<h1><c:out value="${product.name}"/></h1>
	<div>
		<h2>Categories:</h2>
		<ul>
			<c:forEach items="${product.categories}" var="c">
				<li><c:out value="${c.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	
	<form:form action="/addCategory" method="POST" modelAttribute="middleTableObj">
			<form:select path="category">
			<c:forEach items="${nonCategories}" var="cat">
				<form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
			</c:forEach>
			</form:select>
		<form:hidden path="product" value="${product.id}"/>
		<input type="submit" />
	</form:form>

</body>
</html>
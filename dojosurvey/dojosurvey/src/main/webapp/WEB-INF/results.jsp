<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>Submitted info</h3>
	<table>
		<tbody>
			<tr>
				<td>Name:</td>
				<td><c:out value="${ name }" /></td>
			</tr>
			<tr>
				<td>Dojo Location:</td>
				<td><c:out value="${ location }" /></td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td><c:out value="${ lang }" /></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><c:out value="${ comment }" /></td>
			</tr>
		</tbody>
	</table>

</body>
</html>
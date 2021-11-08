<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Page is Active</title>
</head>
<body>
 	<form method="POST" action="/process">
		<table>
			<c:out value="${ nameError }" />
			<tr>
				<td>Your Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Dojo Location:</td>
				<td>
					<select name="location">
						<option>San Jose</option>
						<option>Los Angeles</option>
						<option>Seattle</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Favorite Language:</td>
				<td>
					<select name="language">
						<option>Python</option>
						<option>JavaScript</option>
						<option>Java</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Comment (optional):</td>
			</tr>
		</table>
		<input type="text" name="comment">
		<input type="submit" value="Submit">
	</form>
</body>
</html>
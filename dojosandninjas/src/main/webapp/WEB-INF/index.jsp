<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		td {
			padding-left: 20px;
			padding-right: 20px;
		}
		h1 {
			margin-left: 20px;
		}
	</style>
	<title>People and Licenses</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1>Information</h1>
	<table class="table table-striped table-dark table-hover ">
		<thead>
			<tr>
				<th> Dojo Name</th>
				<th> Ninja Count</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos}">
			<tr>
				<td>${dojo.name}</td>
				<td>${dojo.ninjas.size()} ninjas</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
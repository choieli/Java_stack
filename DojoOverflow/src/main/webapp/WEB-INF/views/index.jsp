<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Dashboard</title>
</head>
<body>
	<div class="container text-center">	
		<h1 class="display-3 border-bottom border-dark"><small>Questions Dashboard</small></h1>
	</div>
	<br>
	<div class="container">
		<table class="table ">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Question</th>
		      <th scope="col">Tags</th>
		    </tr>
		  </thead>
		  <tbody >
		  	<c:forEach items="${questions}" var="q">
		  		<tr>
			      <td class="border-bottom border-left border-dark"><p class="font-weight-bold"><a class="text-info" href="questions/${q.id}">${q.question}</a> </p></td>
			      <td class="border border-dark">
			      	<c:forEach items="${q.tags}" var="t">
			      		<button class="btn btn-success">${t.subject}</button>
			      	</c:forEach>
			      </td>
			    </tr>
			  
		  	</c:forEach>
		  	</tbody>

		  	
		 </table>
 
	</div>
	<br>
	<div class="container text-right border-top border-dark">
		<br>
		<a href="/questions/new"><button type="button" class="btn btn-info">New Question</button></a>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>
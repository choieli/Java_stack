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
	<title>New Question</title>
</head>
<body>
	<div class="container text-center">	
		<h1 class="display-3 border-bottom border-dark"><small>What is your Question?</small></h1>
	</div>
	<br>
	<div class="container">
		<c:out value="${error}" escapeXml="false"/>
		<form:form action="/questions/new" method="POST" modelAttribute="addQuestion">
			<p>
				<form:errors path="question" cssClass="alert alert-danger"/>
				
			
			</p>
			<p>
				<form:label cssClass="font-weight-normal" path="question">Question</form:label>
				<form:textarea cssClass="form-control" rows="3" path="question"/>
			</p>
		
			<p>
				<label for="tags">Tags</label>
				<input type="text" class="form-control col-4" name="other">
				
			</p>
			<p class="text-right border-top border-dark">
				<br>
				<button type="submit" class="btn btn-info">Ask</button>
			</p>
			
		</form:form>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>
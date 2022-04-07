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
	<title>Question Profile</title>
</head>
<body>
	<div class="container text-center">	
		<h1 class="display-3 border-bottom border-dark"><small>${question.question }</small></h1>
	</div>
	<br>
	<div class="container">
		<h4 class="h4 font-weight-normal">
			
				Tags: 
				<c:forEach items="${question.tags}" var="t">
			      	<button class="btn btn-success">${t.subject}</button>
			    </c:forEach>
			
		</h4>
	</div>
	<br>
	<div class="container border-bottom border-dark">
		<div class="row">
			<div class="col">
				<table class="table">
					  <thead class="thead-dark">
						    <tr>
						      <th scope="col">Answers</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <c:forEach items="${question.answer }" var="a">
						      	<td class="text-info"> • ${a.answer}</td>
						      </c:forEach>
						    
						    </tr>
						 </tbody>
					</table>
			</div>
			<div class="col">
						
				<form:form action="/questions/${question.id}" method="POST" modelAttribute="addTheAnswer">
					
						<form:errors path="answer" cssClass="alert alert-danger" element="p"/>
					
					
					<p>
						<form:label cssClass="font-weight-normal" path="answer">Add your Answer</form:label>
						<form:textarea cssClass="form-control" rows="3" path="answer"/>
					</p>
					
					<p class="text-right">
						<br>
						<button type="submit" class="btn btn-info">Add Answer</button>
					</p>
					
				</form:form>
			</div>
		</div>
	</div>
	<div class="container mt-4">
		<a href="/questions"><button class="btn btn-primary">Dashboard</button></a>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>
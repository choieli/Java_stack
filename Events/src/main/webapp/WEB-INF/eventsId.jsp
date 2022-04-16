<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Event Details</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
	
		<h1 class="display-2"><c:out value="${event.name}"/></h1>
		
		<h5>Host: <c:out value="${event.host.first_name}"/></h5>
		<h5>Date: <fmt:formatDate pattern ="MMMM dd, yyyy" value ="${event.date}"/></h5>
		<h5>Location: <c:out value="${event.city}"/></h5>
		<h5>People who are attending this event: <c:out value="${event.attendees.size()}"/></h5>
		<table class="table eventTable">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Location</th>
		    </tr>
		  </thead>
		  <tbody>
			  <c:forEach var="attendees" items="${event.attendees }">
			    <tr>
			      <th><c:out value="${attendees.first_name}"/> <c:out value="${attendees.last_name}"/></th>
			      <td><c:out value="${attendees.city}"/></td>
			    </tr>
	    	  </c:forEach>
		  </tbody>
		</table>
			<div id="rghtpnl">
			<a href="/events">Back to Events</a>
			<h2 class="display-2">Message Wall</h2>
			<div id="commentbox">
                <c:forEach items="${messages}" var="msg">
                    <p>${msg.user.first_name} says: ${msg.message}</p>
                    
                </c:forEach>
            </div>
                <form:form method="post" action="/events/addmsg" modelAttribute="messageObj">
                	<h5>
                		<form:input cssClass="txtbox" type="textarea" path="message"/>
					</h5>
					<form:hidden path="user" value="${user.id}"/>
					<form:hidden path="event" value="${event.id}"/>
			   		<input class="btn" type="submit" value="Submit">          
                </form:form>
               	<form:errors cssClass="red" path="message.*"/>
		</div>
		
		
	
	</div>
	



</body>
</html>
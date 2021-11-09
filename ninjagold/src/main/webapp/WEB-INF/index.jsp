<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div id="container">
		<div>
			<h3>Your Gold: </h3>
			<p><c:out value="${gold}" /></p>
		</div>
		<div id="choice-blocks">
			<div class="choice">
				<h3>Farm</h3>
				<p>(earns 10-20 golds)</p>
				<a href="/farm"><button>Find Gold!</button></a>
			</div>
			<div class="choice">
				<h3>Cave</h3>
				<p>(earns 5-10 golds)</p>
				<a href="/cave"><button>Find Gold!</button></a>
			</div>
			<div class="choice">
				<h3>House</h3>
				<p>(earns 2-5 golds)</p>
				<a href="/house"><button>Find Gold!</button></a>
			</div>
			<div class="choice">
				<h3>Casino!</h3>
				<p>(earns/takes 0-50 golds)</p>
				<a href="/casino"><button>Find Gold!</button></a>
			</div>
			<div class="choice">
				<h3>Spa</h3>
				<p>(takes 5-20 golds)</p>
				<a href="/spa"><button>Find Gold!</button></a>
			</div>
		</div>
		<div id="reset">
			<br>
			<a href="/reset"><button>Reset</button></a>
		</div>
		
		<div id="activity">
			<p> Activities: </p>
			<div id="activity-box">
				<c:forEach items="${ logs }" var="log">
					<p class=${log.get(1)}> ${log.get(0)}</p>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>
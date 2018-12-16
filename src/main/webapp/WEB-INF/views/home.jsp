<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Spring Boot with Spring Data Application</title>
<link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to Spring Boot with Spring Data!</h1>
			<p>Book Application</p>
		</div>
		<c:if test="${role == 'librarian'}">
			<p>
				<a href="/SpringBootBookApplication/book/addBook"
					class="btn btn-secondary btn-lg btn-block">Add Book</a>
			<p>
				<a href="/SpringBootBookApplication/book/searchBook"
					class="btn btn-secondary btn-lg btn-block">Search Book By
					Subject</a>
		</c:if>
		<c:if test="${role == 'principal'}">
		
		<p>
			<a href="/SpringBootBookApplication/subject/addSubject"
				class="btn btn-secondary btn-lg btn-block">Add Subject</a>
		<p>
			<a href="/SpringBootBookApplication/subject/searchSubject"
				class="btn btn-secondary btn-lg btn-block">Search Subject By
				Duration</a>
		</c:if>
	</div>

</body>
</html>

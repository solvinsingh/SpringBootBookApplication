<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Find Books</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
</head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>


<body>
<c:if test="${empty listOfBooks}">
		
	<h2>Find Books</h2>
	<form:form method="POST" action="searchBook" modelAttribute="book">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>

			<tr>
				<td><form:label path="title">Book Title:</form:label></td>
				<td><form:input path="title" /> <form:errors path="title"
						cssClass="error" /></td>
			</tr>


			<tr height="50">
				<td />
				<td><input type="submit" value="Find" class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</tr>
		</table>
	</form:form>
	</br>
</c:if>
	
<c:if test="${!empty listOfBooks}">
<h3>Book List</h3>
    <div class="container">

	<table class="table table-striped">
	<thead>
	<tr>
			<th>ID</th> &nbsp;&nbsp;
			<th>Title</th> &nbsp;&nbsp;
			<th>Price</th> &nbsp;&nbsp;
			<th>Publish Date</th>
		</tr>
	<thead>
	<tbody>		
	<c:forEach items="${listOfBooks}" var="sub">
		<tr>
				<td align="center">${sub.bookId}</td> 
				<td align="center">${sub.title}</td> 
				<td align="center">${sub.price}</td>		
				<td align="center">${sub.publishDate}</td>		
						
			</tr>
	</c:forEach>
	</tbody>
	</table>
</div>
</c:if>
</body>
</html>

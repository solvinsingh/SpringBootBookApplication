<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Books List</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
	<span>Welcome <strong> <c:out value="${userName}" />
	</strong></span>
	<br>
	<div class="container">
	<h2>Books List</h2>

		<table border="2" width="70%" cellpadding="2"
			class="table table-striped table-bordered">
			<thead>

				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Price</th>
					<th>Volume</th>
					<th>Publish Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty bookList}">
					<tr>
						<td colspan="11" align="center">No record found to display.</td>
					</tr>
				</c:if>

				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.bookId}</td>
						<td>${book.title}</td>
						<td>${book.price}</td>
						<td>${book.volume}</td>
						<td>${book.publishDate}</td>
						<td><a href="${contextPath}book/update/${book.bookId}">Edit</a>
							&nbsp;&nbsp; <a href="${contextPath}book/delete/${book.bookId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div></div>
		<a href="${contextPath}book/addBook" class="btn btn-primary">Add
			New Book</a> &nbsp;&nbsp; <a href="${contextPath}"
			class="btn btn-primary">Home</a> &nbsp;&nbsp;
	</div>
	<br />

</body>
</html>
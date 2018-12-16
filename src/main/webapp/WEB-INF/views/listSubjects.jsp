<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Subjects List</title>
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
		<h2>Subjects List</h2>
	
		<table border="2" width="70%" cellpadding="2"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>DurationInHours</th>
					<th>Action</th>

				</tr>
			</thead>
			<tbody>
				<c:if test="${empty subList}">
					<tr>
						<td colspan="11" align="center">No record found to display.</td>
					</tr>
				</c:if>

				<c:forEach var="sub" items="${subList}">
					<tr>
						<td>${sub.subjectId}</td>
						<td>${sub.subtitle}</td>
						<td>${sub.durationInHours}</td>
						<td><a href="${contextPath}subject/update/${sub.subjectId}">Edit</a>
							&nbsp;&nbsp; <a
							href="${contextPath}subject/delete/${sub.subjectId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div></div>
		<a href="${contextPath}subject/addSubject" class="btn btn-primary">Add
			New Subject</a> &nbsp;&nbsp; <a href="${contextPath}"
			class="btn btn-primary">Home</a> &nbsp;&nbsp;
	</div>
	<br />



</body>
</html>
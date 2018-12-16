<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Find Subjects</title>
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
<c:if test="${empty listOfSubjects}">
		
	<h2>Find Subjects</h2>
	<form:form method="POST" action="searchSubject" modelAttribute="subject">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>

			<tr>
				<td><form:label path="durationInHours">Subject Duration:</form:label></td>
				<td><form:input path="durationInHours" /> <form:errors path="durationInHours"
						cssClass="error" /></td>
			</tr>


			<tr height="50">
				<td />
				<td><input type="submit" value="Find"  class="btn btn-primary"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</tr>
		</table>
	</form:form>
	</br>
</c:if>
	
<c:if test="${!empty listOfSubjects}">
<h3>Subject List</h3>
		<div class="container">

			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Subject ID</th> &nbsp;&nbsp;
						<th>Sub Title</th> &nbsp;&nbsp;
						<th>Duration(In Hours)</th> &nbsp;&nbsp;
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listOfSubjects}" var="sub">
						<tr>
							<td align="center">${sub.subjectId}</td>
							<td align="center">${sub.subtitle}</td>
							<td align="center">${sub.durationInHours}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>

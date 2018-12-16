<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Subject</title>
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
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
		
	<form:form method="POST" action="subject" modelAttribute="subject">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<div class="container">
			<h2>Add Subject</h2>
		
		<table class="table table-striped table-bordered">
			<tr>
				<td><form:label path="subjectId">Subject Id:</form:label></td>
				<td><form:input path="subjectId" /> 
				    <form:errors path="subjectId" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td><form:label path="subtitle">Subject Title:</form:label></td>
				<td><form:input path="subtitle" /> <form:errors path="subtitle"
						cssClass="error" /></td>
			</tr>
			
			<tr>				
				<td><form:label path="durationInHours">Duration In Hours:</form:label></td>
				<td><form:input path="durationInHours" />
				 <form:errors path="durationInHours" cssClass="error" />
				</td>
			</tr>


			<tr height="50">
				<td />
				<td><input type="submit" value="Save" class="btn btn-primary" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Reset" class="btn btn-primary" /> &nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="${contextPath}/SpringBootBookApplication/subject/list" class="btn btn-link">Back</a></td>
			</tr>
		</table>
		</div>
	</form:form>
</body>
</html>

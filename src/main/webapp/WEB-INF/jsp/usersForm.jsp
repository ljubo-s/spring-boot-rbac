<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Form</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<spring:url value="/users/saveUsers" var="saveURL" />
		<h2>Users</h2>
		<form:form modelAttribute="usersForm" method="post" action="${saveURL }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Userame</label>
				<form:input path="username" cssClass="form-control" id="username" />
			</div>
			<div class="form-group">
				<label>Password</label>
				<form:input path="password" cssClass="form-control" id="password" />
			</div>
			<div class="form-group">
				<label>Status</label>
				<form:input path="status" cssClass="form-control" id="status" />
			</div>
			<div class="form-group">
				<label>Date of Insert</label>
				<form:input path="dateofinsert" cssClass="form-control" id="dateofinsert" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>

	</div>
</body>
</html>
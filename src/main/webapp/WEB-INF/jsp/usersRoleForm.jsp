<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users x Role Form</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<spring:url value="/usersRole/saveUsersRole" var="saveURL" />
		<h2>User x Role</h2>
		<form:form modelAttribute="usersRoleForm" method="post" action="${saveURL }" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Description</label>
				<form:input path="description" cssClass="form-control" id="description" />
			</div>
			<div class="form-group">
				<label>Status</label>
				<form:input path="status" cssClass="form-control" id="status" />
			</div>
			<div class="form-group">
				<label>Users id</label>
				<form:input path="users.id" cssClass="form-control" id="users.id" />
			</div>
			<div class="form-group">
				<label>Role id</label>
				<form:input path="role.id" cssClass="form-control" id="role.id" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>
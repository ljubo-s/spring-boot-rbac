<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Permission x Users List</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Permission x Users List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a></h2>
		<table class="table table-striped">
			<tr>
				<th scope="row">#ID</th>
				<th scope="row">Description</th>
				<th scope="row">Status</th>
				<th scope="row">Permission id</th>
				<th scope="row">Users id</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</tr>
			<tbody>
				<c:forEach items="${permissionUsersList}" var="permissionUsers">
					<tr>
						<td>${permissionUsers.id}</td>
						<td>${permissionUsers.description}</td>
						<td>${permissionUsers.status}</td>
						<td>${permissionUsers.users.id}</td>
						<td>${permissionUsers.permission.id}</td>
						<td>
							<spring:url value="/permissionUsers/updatePermissionUsers/${permissionUsers.id}" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL}" role="button">Update</a>
						</td>
						<td>
							<spring:url value="/permissionUsers/deletePermissionUsers/${permissionUsers.id}" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL}" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/permissionUsers/addPermissionUsers/" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add New Permission x Users</a>
	</div>
</body>
</html>
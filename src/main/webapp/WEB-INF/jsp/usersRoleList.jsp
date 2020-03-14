<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users x Role List</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Users x Role List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a></h2>
		<table class="table table-striped">
			<tr>
				<th scope="row">#ID</th>
				<th scope="row">Description</th>
				<th scope="row">Status</th>
				<th scope="row">Users id</th>
				<th scope="row">Role id</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</tr>
			<tbody>
				<c:forEach items="${usersRoleList }" var="usersRole">
					<tr>
						<td>${usersRole.id }</td>
						<td>${usersRole.description }</td>
						<td>${usersRole.status }</td>
						<td>${usersRole.users.id }</td>
						<td>${usersRole.role.id }</td>
						<td>
							<spring:url value="/usersRole/updateUsersRole/${usersRole.id }" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
						</td>
						<td>
							<spring:url value="/usersRole/deleteUsersRole/${usersRole.id }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/usersRole/addUsersRole/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New Users x Role</a>
	</div>
</body>
</html>
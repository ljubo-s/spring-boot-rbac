<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Permission List</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Permission List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="../"> * </a></h2>
		<table class="table table-striped">
			<tr>
				<th scope="row">#ID</th>
				<th scope="row">Title</th>
				<th scope="row">Module</th>
				<th scope="row">Key</th>
				<th scope="row"></th>
				<th scope="row"></th>
			</tr>
			<tbody>
				<c:forEach items="${permissionList }" var="permission">
					<tr>
						<td>${permission.id }</td>
						<td>${permission.title }</td>
						<td>${permission.module }</td>
						<td>${permission.key }</td>
						<td>
							<spring:url value="/permission/updatePermission/${permission.id }" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
						</td>
						<td>
							<spring:url value="/permission/deletePermission/${permission.id }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/permission/addPermission/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" role="button">Add New Permission</a>
	</div>
</body>
</html>
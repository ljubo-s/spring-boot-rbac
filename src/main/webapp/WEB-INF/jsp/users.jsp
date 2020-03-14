<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users</title>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td align="center">
				<h2>
					Users &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a>
				</h2>

				<form:form action="/users/users.form" method="post" modelAttribute="users">

					<table>
						<tr>
							<td>Id</td>
							<td>
								<form:input path="id" id="paramid" value="${param.id}" />
							</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>
								<form:input path="username"></form:input>
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<form:input path="password"></form:input>
							</td>
						</tr>
						<tr>
							<td>Date of insert</td>
							<td>
								<form:input path="dateofinsert"></form:input>
							</td>
						</tr>
						<tr>
							<td>Status</td>
							<td>
								<form:input path="status"></form:input>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<br></br>
								<input type="submit" name="action" value="Add" />
								<input type="submit" name="action" value="Edit" />
								<input type="submit" name="action" value="Delete" />
								<input type="submit" name="action" value="Search" />
								<br></br>
							</td>
						</tr>
					</table>
				</form:form>

				<table style="border: 1px solid; min-width: 80%; max-width: 100%; text-align: center" id="table_id">
					<thead style="background: #d3dce3">
						<tr>
							<th>rb</th>
							<th>Id</th>
							<th>Username</th>
							<th>Password</th>
							<th>Stauts</th>
							<th>Date of insert</th>
						</tr>
					</thead>
					<tbody style="background: #ccc">
						<c:forEach items="${usersList}" var="users" varStatus="i">
							<tr align="center">
								<td>
									<c:out value="${i.index + 1 }" />
								</td>
								<td>${users.id}</td>
								<td>${users.username}</td>
								<td>${users.password}</td>
								<td>${users.status}</td>
								<td>${users.dateofinsert}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
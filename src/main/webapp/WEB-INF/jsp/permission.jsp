<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Permission</title>
</head>
<body>
	<table align="center" width="100%">
		<tr>
			<td align="center">
				<h1>
					Permission JSP &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a>
				</h1>
				<form:form action="/permission/permission.form" method="post" modelAttribute="permission">
					<table>
						<tr>
							<td>Id</td>
							<td>
								<form:input path="id"></form:input>
							</td>
						</tr>
						<tr>
							<td>Title</td>
							<td>
								<form:input path="title"></form:input>
							</td>
						</tr>
						<tr>
							<td>Module</td>
							<td>
								<form:input path="module"></form:input>
							</td>
						</tr>
						<tr>
							<td>Key</td>
							<td>
								<form:input path="key"></form:input>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<br></br>
								<input type="submit" name="action" value="Add" />
								<input type="submit" name="action" value="Edit" />
								<input type="submit" name="action" value="Delete" />
								<input type="submit" name="action" value="Search" />
							</td>
						</tr>
					</table>
				</form:form>
				<p></p>
				<table style="border: 1px solid; width: 80%; text-align: center">
					<thead style="background: #d3dce3">
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Module</th>
							<th>Key</th>
						</tr>
					</thead>
					<tbody style="background: #ddd">
						<c:forEach items="${permissionList}" var="permission">
							<tr>
								<td>${permission.id}</td>
								<td>${permission.title}</td>
								<td>${permission.module}</td>
								<td>${permission.key}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
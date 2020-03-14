<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Index</title>
</head>
<body>
	<table style="width: 100%; border: 0;">
		<tr>
			<td align="center">
				<h1>Index</h1>
				<p></p>
				<table style="width: 97%; border-spacing: 10px;">

					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details> 
								<summary>Permissions</summary>
								<p>1. Permissions</p>
								<p>2. Permissions List</p>
								<p>3. Permissions & Users</p>
								<p>4. Permissions & Role</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center">
							<a href="permission">
								<button type="button" style="height: 50px; width: 120px;">Permissions</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="permission/list">
								<button type="button" style="height: 50px; width: 120px;">Permission List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="permissionUsers">
								<button type="button" style="height: 50px; width: 120px;">Permission & Users</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="permissionUsers/list">
								<button type="button" style="height: 50px; width: 120px;">PermissionUsers List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="permissionRole">
								<button type="button" style="height: 50px; width: 120px;">Permission & Role</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="permissionRole/list">
								<button type="button" style="height: 50px; width: 120px;">PermisionRole List</button>
							</a>
						</td>
					</tr>
					
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details> 
								<summary>Rolls</summary>
								<p>1. Roles</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="role">
								<button type="button" style="height: 50px; width: 120px;">Role</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="role/list">
								<button type="button" style="height: 50px; width: 120px;">Role List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details>
							<summary>Users </summary>
							<p>1. Users</p>
							<p>2. Users & Role</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="users">
								<button type="button" style="height: 50px; width: 120px;">Users</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="users/list">
								<button type="button" style="height: 50px; width: 120px;">Users List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="usersRole">
								<button type="button" style="height: 50px; width: 120px;">Users & Role</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="usersRole/list">
								<button type="button" style="height: 50px; width: 120px;">UsersRoleList</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
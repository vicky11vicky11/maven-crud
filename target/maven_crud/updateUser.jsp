<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Update User</title>
		<link rel="stylesheet" href="css/updateUser.css" />
	</head>
	<body>
		<h1 class="heading">Update User</h1>

		<form action="updateUser">
			<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
			<div>
				<label for="name">Name</label> <input type="text" id="name" name="name"
				value="<%= request.getParameter("name") %>">
			</div>
			<div>
				<label for="email">Email</label> <input type="text" id="email"
				name="email" value="<%= request.getParameter("email") %>">
			</div>
			<div>
				<label for="age">Age</label> <input type="text" id="age" name="age"
				value="<%= request.getParameter("age") %>">
			</div>
			<div>
				<label for="phone">Phone</label> <input type="text" id="phone"
				name="phone" value="<%= request.getParameter("phone") %>">
			</div>
			<input type="submit" value="Update" class="button" />
		</form>
	</body>
</html>

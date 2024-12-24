<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.User" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>User Management System</title>
		<link rel="stylesheet" href="css/home.css">
	</head>
	<body>
		<h1 class="heading" >Welcome to User Management System .....</h1>
		<a href="addUser.jsp" class="add-user-btn" >Add User</a>
		
		<%  List<User> usersList = (List<User>) session.getAttribute("usersList"); %>
			<table >
				<tr class="row">
					<td class="row-heading" >Name</td>
					<td class=" row-heading" >Email</td>
					<td  class="row-heading"  >Age</td>
					<td  class="row-heading" >Phone</td>
					<td class="row-heading" >Action </td>
				</tr>
				<% for (User user : usersList) { %>
					<tr class="row" >
						<td><% out.print(user.getName()); %></td>
						<td><% out.print(user.getEmail()); %></td>
						<td><% out.print(user.getAge()); %></td>	
						<td><% out.print(user.getPhone()); %></td>
						<td> <a href="updateUser.jsp?id=<%= user.getId() %>&name=<%= user.getName() %>&email=<%= user.getEmail() %>&age=<%= user.getAge() %>&phone=<%= user.getPhone() %>" class="update-user-btn" >Update</a> | <a href="deleteUser?id=<%= user.getId() %>" class="delete-user-btn" >Delete</a> </td>
					</tr>
				<% } %>
			</table>	
	</body>
</html>

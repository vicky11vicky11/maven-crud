<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Add User Page</title>
		<link rel="stylesheet" href="css/addUser.css" />
	</head>
	<body>
		<h1 class="heading">Add User Details</h1>
		<form action="addUser" >
			<table>
				<tbody>
					<tr class="row">
						<td class="label-name">Name</td>
						<td><input type="text" name="name" class="input-name" /></td>
					</tr>
					<tr class="row">
						<td class="label-email">Email</td>
						<td><input type="email" name="email" class="input-email" /></td>
					</tr>
					<tr class="row">
						<td class="label-age">Age</td>
						<td><input type="number" name="age" class="input-age" /></td>
					</tr>
					<tr class="row">
						<td class="label-phone">Phone</td>
						<td><input type="text" name="phone" class="input-phone" /></td>
					</tr>
					<tr class="row btn-container">
						<td rowspan="2" >
							<input type="submit" value="Add User" class="input-submit-btn" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>

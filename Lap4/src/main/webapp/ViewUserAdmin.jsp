<%@page import="java.util.ArrayList"%>
<%@page import="model.BEAN.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Information</title>
    <style>
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
    <script type="text/javascript">
        function confirmDelete(userId) {
            if (confirm('Are you sure you want to delete this user?')) {
                window.location.href = 'deleteUser?id=' + userId;
            }
        }
    </script>
</head>
<body>
	<td style="">
       <a href="addDepartment">Department manage</a> |
       <a href="addStaff">Staff manage</a> |
       <a href="addUser">User manage</a> |
    </td>
    <h2>Add Department </h2>
	<form action="addUser" method="post">
		Username : <input type="text" name="username">
		Password : <input type="text" name="password">
		IdInfor : <input type="text" name="idInfor">
		<br>
		<br>
	<input type="submit" value="Add">
	<input type="reset" value="Reset">
	</form>
	<h2>User Information</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Password</th>
                <th>IdInfor</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<User> users = (ArrayList<User>)request.getAttribute("userarray");
            	for (User user : users) {
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getIdInfor() %></td>
                <td style="">
                    <a href="editUser?id=<%= user.getId() %>">Edit</a>|
                    <a href="javascript:void(0);" onclick="confirmDelete(<%= user.getId() %>);">Delete</a>
                </td>
            </tr>
			<%
                }
            %>
        </tbody>
    </table>
</body>
</html>
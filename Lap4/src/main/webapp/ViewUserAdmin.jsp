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
    	body {
            font-family: Arial, sans-serif;
            background-color: #cadff0; /* Light sea blue background */
            margin: 0;
            padding: 20px;
        }
        table {
            width: 50%;
            margin: auto;
            border-collapse: collapse;
            border: 1px solid black;
            background-color: #fff;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
        .cot{
        	width: 200px;
        }
        
        form {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="tel"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"], input[type="reset"] {
            width: 48%;
            padding: 10px;
            margin-right: 2%;
            border: none;
            border-radius: 5px;
            background-color: #5cb85c;
            color: white;
            font-size: 16px;
        }
        input[type="reset"] {
            background-color: #d9534f;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center; /* Center the heading */
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
    <h2>Add User </h2>
	<form action="addUser" method="post" class="user-form">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">
        
        <label for="password">Password:</label>
        <input type="text" id="password" name="password">
        
        <label for="idInfor">IdInfor:</label>
        <input type="text" id="idInfor" name="idInfor">
        
        <div class="buttons">
            <input type="submit" value="Add">
            <input type="reset" value="Reset">
        </div>
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
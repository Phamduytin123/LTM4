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
            background-color: #feddd4; /* Light sea blue background */
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
    </style>
</head>
<body>
	
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
                User user = (User)request.getAttribute("user");
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getUsername() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getIdInfor() %></td>
                <td style="">
                    <a href="editDepartment?id=<%= user.getId() %>">Edit</a>
                </td>
            </tr>

        </tbody>
    </table>
</body>
</html>
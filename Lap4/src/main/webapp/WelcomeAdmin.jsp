<%@page import="model.BEAN.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department List</title>
    <style>
    	body {
            font-family: Arial, sans-serif;
            background-color: #9de498; /* Light sea blue background */
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
        function confirmDelete(departmentId) {
            if (confirm('Are you sure you want to delete this department?')) {
                window.location.href = 'deleteDepartment?id=' + departmentId;
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
	<form action="addDepartment" method="post" class="department-form">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        
        <label for="description">Description:</label>
        <input type="text" id="description" name="description">
        
        <div class="buttons">
            <input type="submit" value="Add">
            <input type="reset" value="Reset">
        </div>
    </form>
    <h2>Department List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departmentarray");
                for(Department department : departments){
            %>
            <tr>
                <td><%= department.getId() %></td>
                <td><%= department.getName() %></td>
                <td><%= department.getDescription() %></td>
                <td style="">
                    <a href="viewDepartment?id=<%= department.getId() %>">View</a> |
                    <a href="editDepartment?id=<%= department.getId() %>">Edit</a> |
                    <a href="javascript:void(0);" onclick="confirmDelete(<%= department.getId() %>);">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
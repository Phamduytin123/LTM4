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
        table {
            width: 50%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
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
	<form action="addDepartment" method="post">
		name : <input type="text" name="name">
		description : <input type="text" name="description">
		<br>
		<br>
	<input type="submit" value="Add">
	<input type="reset" value="Reset">
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
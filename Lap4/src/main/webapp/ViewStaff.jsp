<%@page import="model.BEAN.Department"%>
<%@page import="model.BEAN.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
    	body {
            font-family: Arial, sans-serif;
            background-color: #ffeca8; /* Light sea blue background */
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
        function confirmDelete(staffId) {
            if (confirm('Are you sure you want to delete this staff?')) {
                window.location.href = 'deleteStaff?id=' + staffId;
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
    <h2>Add Staff</h2>
	<form action="addStaff" method="post">

        <label for="idDepartment">Department:</label>
        <select id="idDepartment" name="idDepartment" required>
            <% 
                ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departmentarray");
                for (Department department : departments) {
            %>
            <option value="<%= department.getId() %>"><%= department.getName() %></option>
            <% 
                }
            %>
        </select>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required>

        <input type="submit" value="Add">
        <input type="reset" value="Reset">
    </form>
    
    <h2>Staff List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>IdDepartment</th>
                <th>name</th>
                <th>address</th>
                <th>gender</th>
                <th>phone</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<Staff> staffs = (ArrayList<Staff>) request.getAttribute("staffarray");
                for(Staff staff : staffs){
            %>
            <tr>
                <td><%= staff.getId() %></td>
                <td><%= staff.getIdDepartment()%></td>
                <td style="width: 350px"><%= staff.getName() %></td>
                <td><%= staff.getAddress() %></td>
                <td><%= staff.getGender() %></td>
                <td><%= staff.getPhone() %></td>
                <td class="cot">
                    <a href="viewUser?id=<%= staff.getId() %>">View</a> |
                    <a href="editStaff?id=<%= staff.getId() %>">Edit</a> |
                    <a href="javascript:void(0);" onclick="confirmDelete(<%= staff.getId() %>);">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
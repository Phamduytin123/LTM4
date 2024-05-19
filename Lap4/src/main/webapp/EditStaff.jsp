<%@page import="model.BEAN.Staff"%>
<%@page import="model.BEAN.User"%>
<%@page import="model.BEAN.Department"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Staff</title>
<style type="text/css">
		form {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
</style>
</head>
<body>
	<h1>Update Staff</h1>
	<% 
            Staff staff = (Staff)request.getAttribute("staff");
    %>
	<form action="editStaff" method="post">
    <label for="id">Staff ID:</label>
    <input type="text" id="id" name="id" value="<%= staff.getId() %>" readonly>

    <label for="idDepartment">Department:</label>
    <select id="idDepartment" name="idDepartment" required>
        <% 
            ArrayList<Department> departments = (ArrayList<Department>) request.getAttribute("departmentarray");
            for (Department department : departments) {
        %>
        <option value="<%= department.getId() %>" <% if (department.getId() == staff.getIdDepartment()) { %>selected<% } %>><%= department.getName() %></option>
        <% 
            }
        %>
    </select>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= staff.getName() %>" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="<%= staff.getAddress() %>" required>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender" required>
        <option value="male" <% if ("male".equals(staff.getGender())) { %>selected<% } %>>Male</option>
        <option value="female" <% if ("female".equals(staff.getGender())) { %>selected<% } %>>Female</option>
        <option value="other" <% if ("other".equals(staff.getGender())) { %>selected<% } %>>Other</option>
    </select>

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" name="phone" value="<%= staff.getPhone() %>" required>

    <input type="submit" value="Update">
    <input type="reset" value="Reset">
</form>
</body>
</html>
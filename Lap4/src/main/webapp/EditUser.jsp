<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<h1>Edit User</h1>
    <form action="editUser" method="post">
        <input readonly="readonly" name="id" value="${user.id}" />
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${user.username}" required />
        </div>
        <div>
            <label for="password">Password:</label>
            <textarea id="password" name="password" required>${user.password}</textarea>
        </div>
        <div>
            <label for="idInfor">idInfor:</label>
            <textarea id="idInfor" name="idInfor" required>${user.idInfor}</textarea>
        </div>
        <div>
            <button type="submit">Update</button>
        </div>
    </form>
</body>
</html>
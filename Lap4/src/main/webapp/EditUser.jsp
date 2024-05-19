<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
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
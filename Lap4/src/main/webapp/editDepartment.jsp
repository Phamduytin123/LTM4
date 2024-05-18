<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Department</title>
</head>
<body>
    <h1>Edit Department</h1>
    <form action="editDepartment" method="post">
        <input readonly="readonly" name="id" value="${department.id}" />
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${department.name}" required />
        </div>
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${department.description}</textarea>
        </div>
        <div>
            <button type="submit">Update</button>
        </div>
    </form>
</body>
</html>
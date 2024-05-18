<%@page import="model.BEAN.User"%>
<%@page import="model.BEAN.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			ArrayList<User> userArray = (ArrayList<User>) request.getAttribute("userArray");
			for(User item : userArray){
		%>
		
		<tr>
			<td><%=item.getUsername() %></td>
			<td><%=item.getPassword() %></td>
		</tr>
		
		<%}%>
	</table>
</body>
</html>
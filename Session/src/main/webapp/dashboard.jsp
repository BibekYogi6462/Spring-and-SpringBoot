<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
</head>
<body>

<%
String user = (String)session.getAttribute("user");
if(user == null) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<h2>Welcome <%= user %>!</h2>
<p>You are logged in.</p>
<a href="LogoutServlet">Logout</a>

</body>
</html>
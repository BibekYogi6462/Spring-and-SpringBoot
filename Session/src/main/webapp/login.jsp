<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<h2>Login Page</h2>

<%
String error = request.getParameter("error");
if(error != null) {
    out.println("<p style='color:red'>Invalid username/password</p>");
}
%>

<form action="LoginServlet" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
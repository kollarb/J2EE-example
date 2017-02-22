<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.firstwebapplication.model.UserModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<%! int a=5; %>
<% UserModel um = (UserModel) request.getAttribute("userModel");%>
<p><%=session.getAttribute("Username")%> You are in home page</p>
<p>value of a is:  <%=a%></p>
</body>
</html>
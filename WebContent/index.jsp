<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<form id="index" action="TestServlet" method="post">
  userName:<input type="text" name="userName" required><br></br>
  password:<input type="password" name="password" required ><br></br>
  <input type="submit" value="login">
</form>
</body>
</html>
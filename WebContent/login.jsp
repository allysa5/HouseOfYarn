<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<jsp:include page="include.jsp"/>
<jsp:include page="navbar.jsp"/>


<form action= "LoginServlet" method="post">
Email: <input type="text" name="email" id="email"></input><br>
password: <input type="password" name="password" ><br>
<input type="submit" value="Log In"></input>
<input type="reset" value="Reset"></input>
</form>


</body>
</html>
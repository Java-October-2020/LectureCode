<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matt's Bad Joke Site</title>
</head>
<body>
<form method="POST" action="/submitjoke">
<input type="text" name="name"> // Matt
<input type="text" name="email"> // matt@matt.com
<input type="text" name="joke"> // Why did the chicken cross the road
<button>Submit</button>
</form>
</body>
</html>
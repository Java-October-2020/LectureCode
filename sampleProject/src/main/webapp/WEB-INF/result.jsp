<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Name: <c:out value="${name}"/> </p>
<p>email: <c:out value="${email}"/></p>
<p>Joke: <c:out value="${joke}"/></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wedding Details</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>Wedding Details</h3>
<a href="/wedding">Dashboard</a> | <a href="/logout">Logout</a>
<hr>
<h1>${wedding.wedderOne } and ${wedding.wedderTwo}'s Wedding</h1>
<h3><fmt:formatDate value="${wedding.date}" pattern="MMMM dd, yyyy"/></h3>

<p>Guests:</p>
<ul>
<c:forEach items="${wedding.guests}" var="guest">
<li>${guest.firstName} ${guest.lastName}</li>
</c:forEach>
</ul>
</div>
</body>
</html>
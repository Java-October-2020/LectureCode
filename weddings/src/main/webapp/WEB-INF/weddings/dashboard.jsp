<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
<title>Weddings Dashboard</title>
</head>
<body>
<div class="container">
<h1>Welcome To Wedding Planner</h1>
<a href="/logout">Logout</a>
<a href="/wedding/new">Create Wedding</a>
<hr>
<table class="table table-dark table-hover">
<thead>
<tr>
<th>Wedding</th>
<th>Date</th>
<th>Guests</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${weddings}" var="wedding">
<tr>
<td><a href="/wedding/${wedding.id}"> ${wedding.wedderOne} ${wedding.wedderTwo }</a></td>
<td><fmt:formatDate value="${wedding.date}" pattern="MMMM dd, yyyy"/></td>
<td>${wedding.guests.size()}</td>

<c:choose>
<c:when test="${wedding.planner.id } == ${user.id }">
<td><a href="#">Edit</a> | <a href="#">Delete</a></td>

</c:when>
<c:when test="${wedding.guests.contains(user) }">
<td><a href="#">Un-RSVP</a>
</c:when>
<c:otherwise>
<td><a href="wedding/rsvp/${wedding.id}">RSVP</a></td>
</c:otherwise>
</c:choose>


</td>
</tr>
</c:forEach>
</tbody>



</table>


</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Collection dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<t:wrapper>
<table class="table table-dark">
<thead>
	<th>Action</th>
	<th>Artist Name</th>
	<th>Album Name</th>
	<th>Year</th>
	<th>Number Of Likes</th>
</thead>
<tbody>
<c:forEach items="${allRecords}" var="record">
<tr>
<td>
<c:choose>
  <c:when test="${record.likers.contains(user)}">
    <a href="/dashboard/unlike/${record.id}">Remove From Personal Collection</a>
  </c:when>
  <c:otherwise>
    <a href="/dashboard/like/${record.id}">Add To Personal Collection</a>
  </c:otherwise>
</c:choose>




</td>

<td>${record.artistName}</td>
<td><a href="/dashboard/${record.id}">${record.albumName}</a></td>
<td>${record.year }</td>
<td>${record.likers.size()}</td>
</tr>
</c:forEach>
</tbody>


</table>


</div>
</t:wrapper>
</body>
</html>
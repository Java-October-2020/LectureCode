<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Profile Page</title>
</head>
<body>
<t:wrapper>
<h2>User details for ${user.firstName} ${user.lastName }</h2>
<hr>
<h3>Records Added</h3>
<ul>
<c:forEach items="${user.records}" var="record">
<li><a href="${record.id}">${record.albumName}</a> by ${record.artistName}</li>
</c:forEach>
</ul>

<h3>Records In Collection</h3>
<hr>
<ul>
<c:forEach items="${user.recordsLiked}" var="ric">

<li><a href="${ric.id}">${ric.albumName}</a> by ${ric.artistName}</li>
</c:forEach>

</ul>

</t:wrapper>
</body>
</html>
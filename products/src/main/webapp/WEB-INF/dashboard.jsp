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
<div class="container">
<h1>Products On Steroids</h1>
<p>Welcome ${user.firstName }</p>
<a href="/products/new">Add New Product</a>
<hr>
<table class="table table-dark">
<thead>
	<th>Product</th>
	<th>Rating</th>

</thead>
<tbody>
<c:forEach items="${allProducts}" var="product">
<tr>

<td><a href="/product/${product.id}">${product.name}</td>
<td>
<c:set var="avg" value="${0}"/>
<c:forEach items="${product.ratings}" var="rating">
<c:if test="${product.ratings.size() != 0 }">
<c:set var="avg" value="${avg + rating.rating}"/>
</c:if>
</c:forEach>
<c:if test="${avg > 0 }">
<c:set var="avg" value="${avg / product.ratings.size() }"/>
</c:if>
<c:out value="${avg}"/>
</td>
</tr>
</c:forEach>
</tbody>


</table>


</div>

</body>
</html>
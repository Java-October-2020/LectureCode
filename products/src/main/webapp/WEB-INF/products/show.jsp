<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1><c:out value="${product.name}"/></h1>
<c:out value="${product.description }"/>
<c:out value="${product.price}"/>
<h2>Users who rated this product</h2>
<table class="table table-dark">
<thead>
<tr>
<th>Name</th>
<th>Rating</th>
</tr>
</thead>
<tbody>
<c:forEach items="${product.ratings}" var="rating">
<tr>
<td><p>${rating.user.firstName} ${rating.user.lastName}</p></td>
<td><p>${rating.rating}</p></td>
</tr>
</c:forEach>
</tbody>
</table>

<h3>Categories</h3>
<c:if test="${empty categories}">
No Categories have been added
</c:if>
<c:if test="${not empty categories}">
<ul>
<c:forEach var="added" items="${categories}">
<li><c:out value="${added.name}"/></li>
</c:forEach>
</ul>
</c:if>

<hr>

<form action="/product/addCategory/${product.id}" method="POST">
<select name="category">
<c:forEach var="cat" items="${uniqueCats}">
	<option value="${cat.id}">${cat.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form>
<hr>
<c:if test="${product.ratings.contains(user) }">

<h1>Add A Rating</h1>
<form method="post" action="/product/rate/${product.id}">
<input type="text" name="rating">
<button>Add Rating!</button>
</form>

</c:if>



</div>
</body>
</html>
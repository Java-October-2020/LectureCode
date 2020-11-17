<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Product</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>
<c:out value="${product.description }"/>
<c:out value="${product.price}"/>

<h3>Categories</h3>
<c:if test="${empty categories}">
No Categories have been added
</c:if>
<c:if test="${not empty categories}">
<c:forEach var="added" items="${categories}">

<c:out value="${added.name}"/>
</c:forEach>
</c:if>

<form:form action="/products/addCategory/${product.id}" method="post" modelAttribute="category">
<select name="category">
<c:forEach var="category" items="${uniqueCats }">
	<option value="${category.id}">${category.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form:form>

</body>
</html>
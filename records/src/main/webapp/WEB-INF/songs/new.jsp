<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song to Album</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<form:form method="POST" action="/songs" modelAttribute="song">
<div class="form-group">
<form:label path="record">Select Record To Add A Song</form:label>
<form:errors path="record"/>
<form:select path="record">
<c:forEach items="${records}" var="record">
<option value="${record.id}">${record.artistName} - ${record.albumName }</option>
</c:forEach>
</form:select>
</div>

    <div class="form-group">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    </div>
    
        <div class="form-group">
    <form:label path="length">Length
    <form:errors path="length"/>
    <form:input path="length"/></form:label>
    </div>

<button>Add Song to Album!</button>

</form:form>
</body>
</html>
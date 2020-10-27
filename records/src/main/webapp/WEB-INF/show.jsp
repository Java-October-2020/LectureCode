<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h3>Details for ${record.albumName}</h3>
<p>Artist: ${record.artistName }
<p>Year Released ${record.year}</p>




<c:choose>
<c:when test="${record.label != null}">
<p>Label Name: ${record.label.name}</p>
<p>Label City: ${record.label.city}</p>
<p>Label State: ${record.label.state}</p>
</c:when>
<c:otherwise>
<h2>New Label Registration</h2>
<form:form method="POST" action="/label" modelAttribute="label">
<form:hidden path="record" value="${record.id}"/>
<p>
<form:label path="name">Name:
<form:errors path="name"/>
<form:input path="name"/></form:label>
</p>
<p>
<form:label path="city">City:
<form:errors path="city"/>
<form:input path="city"/></form:label>
</p>
<p>
<form:label path="state">State:
<form:errors path="state"/>
<form:input path="state"/></form:label>
<button>Add Label</button>
</p>
</form:form>
</c:otherwise>
</c:choose>

<hr>
<h3>Edit Record</h3>
<form:form method="POST" action="/${record.id}" modelAttribute="record">
	<input type="hidden" name="_method" value="put">
	<div class="form-group">
	<form:label path="artistName">Artist Name:
	<form:errors path="artistName"/>
	<form:input path="artistName"/></form:label>	
	</div>
		<div class="form-group">
	<form:label path="albumName">Album Name:
	<form:errors path="albumName"/>
	<form:input path="albumName"/></form:label>	
	</div>
		<div class="form-group">
	<form:label path="year">Year:
	<form:errors path="year"/>
	<form:input path="year"/></form:label>	
	</div>
	<button>Update Record</button>
</form:form>

</div>
</body>
</html>
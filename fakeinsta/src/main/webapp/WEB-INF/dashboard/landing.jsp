<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fake Insta</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<div class="row">
<div class="col">
<h3>Welcome ${currentUser.userName}</h3>
</div>
<div class="col"><a href="/logout">Logout</a></div>
</div>
<div class="row">

<form method="POST" action="/dashboard/upload" enctype="multipart/form-data">
<div class="form-group">
	<input type="file" name="pic" class="form-control-file" id="inlineFormInput">
	</div>
	<div class="col-auto">
	<textarea name="description" class="form-control" id="exampleFormControlTextarea1" rows="2" placeholder="Enter a Description"></textarea></div>
<button>Upload Pic!</button>
</form>
</div>
<hr>


<div class="row">
<div class="col">
<p>Following: <c:out value="${currentUser.getFollowing().size()}"/> | Followers: <c:out value="${currentUser.getFollowers().size()}"/></p>
</div>
<div class="col-5">
<h3>Timeline</h3>
<hr>
<c:forEach items="${timeline}" var="pic">
<b>${pic.user.userName }</b>
<p><img src="${pic.image_url}" height="300" width="350"></p>
<p>${pic.description}</p>
</c:forEach>
</div>

<!--  Follow -->
<div class="col">
<h3>Users To Follow</h3>
<c:forEach items="${users}" var="user">
<a href="/dashboard/${user.id}">Follow</a> - ${user.userName }
</c:forEach>
</div>



</div>

</div>


</body>
</html>
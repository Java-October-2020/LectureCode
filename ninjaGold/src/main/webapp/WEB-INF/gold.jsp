<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<p>Your Gold: <c:out value="${gold}"/></p>
<div class="building">
<form method="POST" action="/findGold">
<input type="hidden" value="farm" name="building">
<h3>Farm</h3>
<p>Earns 10-20 Gold</p>
<button>Find Gold</button>
</form>
</div>

<div class="building">
<form method="POST" action="/findGold">
<input type="hidden" value="cave" name="building">
<h3>Cave</h3>
<p>Earns 5-10 Gold</p>
<button>Find Gold</button>
</form>
</div>

<div class="building">
<form method="POST" action="/findGold">
<input type="hidden" value="house" name="building">
<h3>House</h3>
<p>Earns 2-5 Gold</p>
<button>Find Gold</button>
</form>
</div>

<div class="building">
<form method="POST" action="/findGold">
<input type="hidden" value="casino" name="building">
<h3>Casino</h3>
<p>Earns / Takes 0-50 Gold</p>
<button>Find Gold</button>
</form>
</div>

// Condition? true=do this : false= do this
<h3>Activities</h3>
<div class="activities">
<c:forEach items="${activity}" var="act">
<p class="${act.contains("lost")? "red" : "green"}"><c:out value="${act}"/></p>
</c:forEach>

</div>
</body>
</html>
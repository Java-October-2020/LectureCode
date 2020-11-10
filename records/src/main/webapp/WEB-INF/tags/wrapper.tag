<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Collection dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome ${user.firstName} ${user.lastName }</h1>
<h2>The Best Official Record Collection</h2>
<a href="/dashboard/add">Add Record To Collection</a> | </a><a href="/songs/new">Add Song To Album!</a> | <a href="/logout">Log Out</a>
<hr>
	<jsp:doBody/>
	</div>
</body>
</html>
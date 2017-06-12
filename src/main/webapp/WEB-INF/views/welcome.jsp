<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>Purchase Requests</h1>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Saved</a></li>
				<li role="presentation"><a href="#">Submitted</a></li>
				<li role="presentation"><a href="#">Approved</a></li>
			</ul>
		</div><body>

	<div class="row">
	<table class="table">
		<thead>
			<tr>
				<th>firstName</th>
				<th>lastName</th>
				<th>email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>
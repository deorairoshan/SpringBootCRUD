<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CRUD Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">CRUD Example</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="/newEmployee">New Employee</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<c:choose>
			<c:when test="${mode == 'EMPLOYEE_VIEW'}">
				<table class="table">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Phone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="employee" items="${employees}">
							<tr>
								<td>${employee.firstName}</td>
								<td>${employee.lastName}</td>
								<td>${employee.email}</td>
								<td>${employee.phone}</td>
								<td><a href="editEmployee?id=${employee.id}"> <span
										class="glyphicon glyphicon-pencil"></span>
								</a> &nbsp; &nbsp;<a href="deleteEmployee?id=${employee.id}"> <span
										class="glyphicon glyphicon-trash"></span>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${mode == 'EMPLOYEE_EDIT' || mode == 'EMPLOYEE_NEW'}">
				<form name=updateForm" action="save" method="post">
					<input type="hidden" class="form-control" id="id" name="id"
						value="${employee.id}">
					<div class="form-group">
						<label for="firstName">First Name:</label> <input type="text"
							class="form-control" id="firstName" name="firstName" value="${employee.firstName}">
					</div>
					<div class="form-group">
						<label for="lastName">Last Name:</label> <input type="text"
							class="form-control" id="lastName" name="lastName" value="${employee.lastName}">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email"
							class="form-control" id="email" name="email" value="${employee.email}">
					</div>
					<div class="form-group">
						<label for="phone">Phone:</label> <input type="text"
							class="form-control" id="phone" name="phone" value="${employee.phone}">
					</div>
					<span style="font-weight: bold;">Address:</span>
					<div class="form-group">
						<label for="street">Street:</label> <input type="text"
							class="form-control" id="address.street" name="address.street"
							value="${employee.address.street}">
					</div>
					<div class="form-group">
						<label for="area">Area:</label> <input type="text"
							class="form-control" id="address.area" name="address.area" value="${employee.address.area}">
					</div>
					<div class="form-group">
						<label for="city">City:</label> <input type="text"
							class="form-control" id="address.city" name="address.city" value="${employee.address.city}">
					</div>
					<div class="form-group">
						<label for="state">State:</label> <input type="text"
							class="form-control" id="address.state" name="address.state" value="${employee.address.state}">
					</div>
					<div class="form-group">
						<label for="country">Country:</label> <input type="text"
							class="form-control" id="address.country" name="address.country"
							value="${employee.address.country}">
					</div>
					<div class="form-group">
						<label for="zip">Zip:</label> <input type="text"
							class="form-control" id="address.zip" name="address.zip" value="${employee.address.zip}">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>
		</c:choose>
	</div>
</body>
</html>
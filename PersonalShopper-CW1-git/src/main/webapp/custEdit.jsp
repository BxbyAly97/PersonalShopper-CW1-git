<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Personal Shopper Customer Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #aec6cf">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					PersonalShopper: Customer Management App </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${user != null}">
Edit Customer Information
</c:if>
						<c:if test="${user == null}">
Add New User
</c:if>
					</h2>
				</caption>
				<c:if test="${user != null}">
					<input type="hidden" name="oriName"
						value="<c:out value='${user.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>
				<fieldset class="form-group">
					<label>Date of Birth</label> <input type="text"
						value="<c:out value='${user.dob}' />" class="form-control"
						name="dob">
				</fieldset>
				<fieldset class="form-group">
					<label>Home Address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="address">
				</fieldset>
				<fieldset class="form-group">
					<label>Email Address</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label> Phone Number</label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
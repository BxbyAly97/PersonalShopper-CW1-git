<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Customer Information</title>
		</head>
		<body>
		
			<div class="row">
				<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
					<div class="container">
						<h3 class="text-center">List of Users</h3>
						<hr>
					<div class="container text-left">
						<a href="<%=request.getContextPath()%>/regPage.jsp" class="btn btn-success">Add New User</a>
					</div>
					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Name</th>
								<th>Password</th>
								<th>DOB</th>
								<th>Address</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<!-- for (Todo todo: todos) { -->
							<c:forEach var="user" items="${listCust}">
							<script>
							console.log("${user.name}");
							console.log("comes here");
							</script>
							
							<tr>
								<td>
								<c:out value="${user.name}" />
								</td>
								<td>
								<c:out value="${user.password}" />
								</td>
								<td>
								<c:out value="${user.dob}" />
								</td>
								<td>
								<c:out value="${user.address}" />
								</td>
								<td>
								<c:out value="${user.email}" />
								</td>
								<td>
								<c:out value="${user.phone}" />
								</td>
								<td><a href="CustomerServlet/edit?name=<c:out value='${user.name}' />">Edit</a>  &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?name=<c:out value='${user.name}' />">Delete</a></td>
							</tr>
						</c:forEach>
						<!-- } -->
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
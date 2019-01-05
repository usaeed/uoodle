<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@include file="bootstrap/header.jsp"%>
</head>
<body>
	<center>
		<h3>
			<a href="/uoodle.co.uk/new">Add New Car</a> &nbsp;&nbsp;&nbsp; <a
				href="/uoodle.co.uk/list">List All Cars</a>

		</h3>
	</center>
	<div align="center">
		<table class="table table-striped table-bordered w-75 p-3"
			cellpadding="5">
			<caption>
				<h2>List of Cars</h2>
			</caption>
			<thead>
				<tr class="bg-primary text-white">
					<th>ID</th>
					<th>Name</th>
					<th>Model</th>
					<th>Year</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="car" items="${listCar}">
					<tr>
						<td><c:out value="${car.id}" /></td>
						<td><c:out value="${car.name}" /></td>
						<td><c:out value="${car.model}" /></td>
						<td><c:out value="${car.year}" /></td>
						<td><a
							href="/uoodle.co.uk/edit?id=<c:out value='${car.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="/uoodle.co.uk/delete?id=<c:out value='${car.id}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@include file="bootstrap/footer.jsp"%>
</body>
</html>
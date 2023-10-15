<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer List</title>
</head>
<body>
	<h2>고객 리스트</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Age</th>
			<th>EntryDate</th>
		</tr>
		<c:forEach var="customer" items="${customer}">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
				<td>${customer.age}</td>
				<td>${customer.entryDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
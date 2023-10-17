<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>customerInfo</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>E-MAIL</th>
				<th>이름</th>
				<th>나이</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${customerInfo.id }</td>
					<td>${customerInfo.email }</td>
					<td>${customerInfo.name }</td>
					<td>${customerInfo.age }</td>
					<td>${customerInfo.entry_date }</td>
				</tr>
		</tbody>
	</table>
</body>
</html>
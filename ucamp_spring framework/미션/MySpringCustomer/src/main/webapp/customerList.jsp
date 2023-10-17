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
	<h1>customerList</h1>
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
			<c:if test="${fn:length(customerList)==0}">
				<tr>
					<td colspan="5">customerList 값이 없음</td>
				</tr>
			</c:if>
			<c:forEach var="customer" items="${customerList }">
				<tr>
					<td>${customer.id }</td>
					<td>${customer.email }</td>
					<td><a href="./getCustomer.do?id=${customer.id }">${customer.name }</a></td>
					<td>${customer.age }</td>
					<td>${customer.entry_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
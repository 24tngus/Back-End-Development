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
	<h1>전체 고객 리스트</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>EMAIL</th>
				<th>NAME</th>
				<th>AGE</th>
				<th>ENTRY_DATE</th>
			</tr>
		</thead>
		<tbody>
			<!-- JSTL코드를 사용해서 조회값이 없을 시 출력, el태그는 page>request>session>apllication -->
			<c:if test="${fn:length(customerList)==0}">
				<tr>
					<td colspan="5">UserList 값이 없음</td>
				</tr>
			</c:if>
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.email}</td>
					<td>${customer.name}</td>
					<td>${customer.age}</td>
					<td>${customer.entryDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
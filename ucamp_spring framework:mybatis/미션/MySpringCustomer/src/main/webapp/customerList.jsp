<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>고객 관리</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<h2 class="text-center">고객 목록</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>&nbsp;</th>
					<th>이름</th> 
					<th>이메일</th>
					<th>나이</th>
					<th>등록일자</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td>
					 	<a href="getUser.do?id=${customer.name}">${customer.name}</a>
					 </td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.age}</td>
					<td>${customer.entryDate}</td>
					
				</tr>
			</c:forEach>
		</tbody> 
	</table>
	</div>
</body>
</html>


































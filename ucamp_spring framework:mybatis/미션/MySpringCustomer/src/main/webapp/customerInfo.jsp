<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 상세정보</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	    <h2 class="text-center">고객 상세정보</h2>
		<table class="table table-bordered table table-hover">
			<tr><td>이름 :</td><td>${customer.name}</td></tr>
			<tr><td>이메일 :</td><td>${customer.email}</td></tr>
			<tr><td>나이 :</td><td>${customer.age}</td></tr>
			<tr><td>등록일자 : </td><td>${customer.entryDate}</td></tr>
		</table>
	</div>
</body>
</html>

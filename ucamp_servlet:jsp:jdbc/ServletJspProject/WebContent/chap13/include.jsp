<%@ page contentType="text/html;charset=euc-kr" %>
<html>
<head>
<title>JavaServer Page</title>
</head>
<body BGCOLOR='white'>
안녕하세요
<br><br>
-------------------------------------------<br>
directive tag include를 사용한 결과입니다.<br>
<%@ include file="footer.html" %><br><br>
-------------------------------------------<br>
jsp standard tag include를 사용한 결과입니다.<br>
<jsp:include page="footer.html" /><br>
-------------------------------------------
</body>
</html>

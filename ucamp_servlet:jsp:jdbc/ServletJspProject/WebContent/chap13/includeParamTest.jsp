<%@ page contentType="text/html;charset=euc-kr" %>
<html>
<head>
<title>Include Param Test</title>
</head>
<body BGCOLOR='white'>
안녕하세요
<br><br>
-------------------------------------------<br>
jsp standard tag include를 사용한 결과입니다.<br>
<jsp:include page="paramTest.jsp"> 
  <jsp:param name="msg" value="Welcome" />
</jsp:include>
-------------------------------------------
</body>
</html>

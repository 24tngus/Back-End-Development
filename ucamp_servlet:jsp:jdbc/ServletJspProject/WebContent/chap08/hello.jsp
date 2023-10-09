<%@ page contentType="text/html;charset=euc-kr" %>
<html>
<head>
<title>Hello JavaServer Page</title>
</head>
<body bgcolor='white'>
<%
	  request.setCharacterEncoding("euc-kr");
    out.print("Welcome :" );
%>
<%= request.getParameter("name")  %>
</body>
</html>

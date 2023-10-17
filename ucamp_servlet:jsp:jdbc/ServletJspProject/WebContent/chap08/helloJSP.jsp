<%@ page contentType="text/html;charset=euc-kr" %>
<%! private static final String DEFAULT_NAME = "World"; %>
<html>
<head>
<title>Hello JavaServer Page</title>
</head>
<body bgcolor='white'>
<%-- Determine the specified name (or user default) --%>
<%
    request.setCharacterEncoding("euc-kr");
    out.print("Welcome :" );
    String name = request.getParameter("name");
    if ( ( name == null ) || ( name.length() ) == 0 ) {
        name = DEFAULT_NAME;
    }
%>
<b>Hello, <%= name %></b>
</body>
</html>

<%@ page contentType="text/html;charset=euc-kr" 
         isErrorPage="true" %>
<html>    
<head>   
    <title>Jsp Exception Page</title>
</head> 
<body bgcolor = 'white'>
    <b>Error가 발생했습니다. 주의하세요!!<br>
    <b>에러 종류는 <%=exception.getClass().getName()%> 입니다. 
</body>   
</html> 

<%@ page contentType = "text/html;charset=euc-kr" %>
<html><head>
</head>
<body>

<% request.setCharacterEncoding("euc-kr"); %>
<center><br><br>아래와 같이 회원 등록되었습니다.<br>
<table border=1>
<tr>
    <td align=right>ID : </td>
    <td width=200>&nbsp; <%= request.getParameter("tfMemberID") %> </td>
</tr>
<tr>
    <td align=right>이름 : </td>
    <td width=200>&nbsp; <%= request.getParameter("tfName") %> </td>
</tr>
<tr>
    <td align=right>암호 : </td>
    <td width=200>&nbsp; <%= request.getParameter("tfPassword") %> </td>
</tr>
<tr>
    <td align=right>주소 : </td>
    <td width=200>&nbsp; <%=request.getParameter("tfAddress") %> </td>
</tr>
<tr>
    <td align=right>전화번호 : </td>
    <td width=200>&nbsp; <%= request.getParameter("tfPhone") %> </td>
</tr>
<tr>
    <td align=right>본인확인힌트 : </td>
    <td width=200>&nbsp; <%= request.getParameter("selPasswordQuestion") %> </td>
</tr>
<tr>
    <td align=right>본인확인답 : </td>
    <td width=200>&nbsp; <%= request.getParameter("tfPasswordAnswer") %> </td>
</tr>
<tr>
    <td align=right>결혼여부 : </td>
    <td width=200>&nbsp; <%= request.getParameter("rdMarriage") %> </td>
</tr>
<tr>
    <td align=right>취미 : </td>
    <td width=200>&nbsp; <%= request.getParameter( "chkHobby" ) %> </td>
</tr>
<tr>
    <td align=right>비고 : </td>
    <td width=200>&nbsp; <%= request.getParameter("etc") %> </td>
</tr>
</table></center>
</body>
</html>

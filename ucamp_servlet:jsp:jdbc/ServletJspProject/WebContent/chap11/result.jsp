<%@ page contentType = "text/html;charset=euc-kr" %>
<%@ page import = "chap11.entity.Member" %>
<html><head>
</head>
<body>
<jsp:useBean id="member" class="chap11.entity.Member" scope="request" />
<center><br><br>아래와 같이 회원 등록되었습니다.<br>
<table border=1>
<tr>
    <td align=right>ID : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfMemberID" /> </td>
</tr>
<tr>
    <td align=right>이름 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfName" /></td>
</tr>
<tr>
    <td align=right>암호 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfPassword" /> </td>
</tr>
<tr>
    <td align=right>주소 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfAddress" /> </td>
</tr>
<tr>
    <td align=right>전화번호 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfPhone" /></td>
</tr>
<tr>
    <td align=right>본인확인힌트 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="selPasswordQuestion" /> </td>
</tr>
<tr>
    <td align=right>본인확인답 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="tfPasswordAnswer" /> </td>
</tr>
<tr>
    <td align=right>결혼여부 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="rdMarriage" /> </td>
</tr>
<tr>
    <td align=right>취미 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="chkHobby" /> </td>
</tr>
<tr>
    <td align=right>비고 : </td>
    <td width=200>&nbsp; <jsp:getProperty name="member" property="etc" /> </td>
</tr>
</table></center>
</body>
</html>

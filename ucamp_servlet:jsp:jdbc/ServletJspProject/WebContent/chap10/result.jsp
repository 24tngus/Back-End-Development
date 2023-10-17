<%@ page contentType = "text/html;charset=euc-kr" %>
<%@ page import = "chap10.entity.Member" %>
<html><head>
</head>
<body>
<% Member member = (Member)request.getAttribute("member"); %>
<center><br><br>아래와 같이 회원 등록되었습니다.<br>
<table border=1>
<tr>
    <td align=right>ID : </td>
    <td width=200>&nbsp; <%= member.getTfMemberID() %> </td>
</tr>
<tr>
    <td align=right>이름 : </td>
    <td width=200>&nbsp; <%= member.getTfName() %> </td>
</tr>
<tr>
    <td align=right>암호 : </td>
    <td width=200>&nbsp; <%= member.getTfPassword() %> </td>
</tr>
<tr>
    <td align=right>주소 : </td>
    <td width=200>&nbsp; <%=member.getTfAddress() %> </td>
</tr>
<tr>
    <td align=right>전화번호 : </td>
    <td width=200>&nbsp; <%= member.getTfPhone() %> </td>
</tr>
<tr>
    <td align=right>본인확인힌트 : </td>
    <td width=200>&nbsp; <%= member.getSelPasswordQuestion() %> </td>
</tr>
<tr>
    <td align=right>본인확인답 : </td>
    <td width=200>&nbsp; <%= member.getTfPasswordAnswer() %> </td>
</tr>
<tr>
    <td align=right>결혼여부 : </td>
    <td width=200>&nbsp; <%= member.getRdMarriage() %> </td>
</tr>
<tr>
    <td align=right>취미 : </td>
    <td width=200>&nbsp; <%= member.getChkHobby() %> </td>
</tr>
<tr>
    <td align=right>비고 : </td>
    <td width=200>&nbsp; <%= member.getEtc() %> </td>
</tr>
</table></center>
</body>
</html>

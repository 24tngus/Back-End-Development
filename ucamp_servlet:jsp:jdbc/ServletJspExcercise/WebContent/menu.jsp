<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import ="entity.MemberEntity" %>

<%
    MemberEntity loginMember = null;
    if ( session != null )
    {
        loginMember = (MemberEntity)session.getAttribute( "loginMember" );
    }
%>

<html>
<head>
<title>ȸ������</title>
</head>
</head>
<body Bgcolor=#eeeeff>
<table align=left cellspacing=0 cellpadding=0 >
   	<tr height=25>
   		<td colspan=3>&nbsp</td>
   	</tr>
	<tr><td width=200 align=center><b><a href="welcome.html" target=main>HOME</a></b></td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><a href="enroll.html" target=main>[ȸ�����]</a> </td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><a href="login.html" target=main>[�α���]</a></td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><A href="memberList" target=main>[��üȸ����ȸ]</A> </td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center> <a href="logout" target=_top>[�α׾ƿ�]</a></td></tr>

</table>
</body>
</html>

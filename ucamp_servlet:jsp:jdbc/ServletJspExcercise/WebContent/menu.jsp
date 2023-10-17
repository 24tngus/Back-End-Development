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
<title>회원관리</title>
</head>
</head>
<body Bgcolor=#eeeeff>
<table align=left cellspacing=0 cellpadding=0 >
   	<tr height=25>
   		<td colspan=3>&nbsp</td>
   	</tr>
	<tr><td width=200 align=center><b><a href="welcome.html" target=main>HOME</a></b></td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><a href="enroll.html" target=main>[회원등록]</a> </td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><a href="login.html" target=main>[로그인]</a></td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center><A href="memberList" target=main>[전체회원조회]</A> </td></tr>
	<tr height=20><td></td></tr>
	<tr><td width=200 align=center> <a href="logout" target=_top>[로그아웃]</a></td></tr>

</table>
</body>
</html>

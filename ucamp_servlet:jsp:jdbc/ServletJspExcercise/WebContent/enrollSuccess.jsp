<%@ page contentType = "text/html;charset=euc-kr" %>
<%@ page import = "entity.MemberEntity" %>
<html>
<head>
</head>

<body>
<!--  �Ʒ� �κп� request�������� �Ѿ�� MemberEntity ��ü��  ������ �ڵ带 �ۼ��Ͻÿ�. -->
<jsp:useBean id="member" class="entity.MemberEntity" scope="request" />

<center><br><br><br><b>�Ʒ��� ���� ȸ���� ��ϵǾ����ϴ�!!</b><br><br>

<table border="1">
<tr>
    <td align="right">ID </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfMemberID" /></td>
</tr>
<tr>
    <td align="right">�̸� </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfName" /> </td>
</tr>
<tr>
    <td align="right">��ȣ </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfPassword" /> </td>
</tr>
<tr>
    <td align="right">�ּ� </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfAddress" /> </td>
</tr>
<tr>
    <td align="right">��ȭ��ȣ </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfPhone" /> </td>
</tr>
<tr>
    <td align="right">����Ȯ�� ��Ʈ </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="selPasswordQuestion" /> </td>
</tr>
<tr>
    <td align="right">����Ȯ�� �亯 </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="tfPasswordAnswer" />  </td>
</tr>
<tr>
    <td align="right">��ȥ ���� </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="rdMarriage" /> </td>
</tr>
<tr>
    <td align="right">��� </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="chkHobby" /> </td>
</tr>
<tr>
    <td align="right">��� </td>
    <td width="200">&nbsp; <jsp:getProperty name="member" property="etc" /> </td>
</tr>
</table></center>
</body>
</html>

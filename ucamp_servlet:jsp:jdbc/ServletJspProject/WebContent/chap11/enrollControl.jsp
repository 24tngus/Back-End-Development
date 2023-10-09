<%@ page contentType ="text/html;charset=euc-kr" %>
<%@ page import="chap11.entity.Member, chap11.biz.MemberService" %>

<%-- 1. 사용자로부터 받은 request를 처리한다.--%>
<% request.setCharacterEncoding( "euc-kr" ); %>
<jsp:useBean id="member" class="chap11.entity.Member" scope="request" />
<jsp:setProperty name="member" property="*" />

<%-- 2. biz logic 수행한다. --%>
<%
	chap11.biz.MemberService service = new MemberService();

    boolean result = service.register(member);
%>
    
    <%-- 3. view 선택한다.(성공했을때, 실패했을때)--%>  
      
<%    
    if ( result ){
%>
<jsp:forward page="/chap11/result.jsp" />
<%
    }else {
%>       
<jsp:forward page="/chap11/error.html" />
<%
    }
%>

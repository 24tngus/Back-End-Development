/*------------------------------------------------------------------------------
 * Name : EnrollServlet
 * Description : 멤버 등록을 처리하는 서블릿 클래스
 * Version  : 1.0
 * Project : VCC Phase I - Web Workshop
 * Copyright 2008 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   변        경        사        항
 *------------------------------------------------------------------------------
 *     DATE       AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2008. 1. 1.   기술대학원    Ver1.0 작성
 *----------------------------------------------------------------------------*/

package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//import biz.MemberBiz;
import entity.MemberEntity;

/**
 * <pre>
 *  멤버 등록을 처리하는 서블릿 클래스
 * </pre>
 * 
 * @author LG CNS 기술대학원
 * @version 1.0, 2008/01/01
 */
public class EnrollServlet extends HttpServlet {

    /**
     * 멤버 등록을 처리하고, 성공했을 때 "result.jsp" 화면을 실패했을 때 "enrollFail.html" 화면을 보여주는
     * 메소드.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

        // 1. 사용자로부터 받은 request를 처리
        MemberEntity member = processFormData( request );

        // 2. biz logic 수행
//        MemberBiz biz = new MemberBiz();
//        boolean result = biz.enroll( member );

        // 3. view 선택(성공했을때, 실패했을때)
        // 작성하시오.







    }

    public MemberEntity processFormData( HttpServletRequest request ) {

        MemberEntity member = new MemberEntity();
        try {
            request.setCharacterEncoding( "euc-kr" );
            member.setTfMemberID( request.getParameter( "tfMemberID" ) );
            member.setTfName( request.getParameter( "tfName" ) );
            member.setTfPassword( request.getParameter( "tfPassword" ) );
            member.setTfAddress( request.getParameter( "tfAddress" ) );
            member.setTfPhone( request.getParameter( "tfPhone" ) );
            member.setSelPasswordQuestion( request.getParameter( "selPasswordQuestion" ) );
            member.setTfPasswordAnswer( request.getParameter( "tfPasswordAnswer" ) );
            member.setRdMarriage( request.getParameter( "rdMarriage" ) );
            member.setChkHobby( makeHobby( request.getParameterValues( "chkHobby" ) ) );
            member.setEtc( request.getParameter( "etc" ) );
        } catch ( Exception e ) {
            System.out.println( e );
        }
        return member;
    }

    public String makeHobby( String[] inputValues ) {

        String record = "";
        if ( inputValues != null ) {
            for ( int inx = 0 ; inx < inputValues.length ; inx++ ) {
                if ( inx != 0 )
                    record += " ";
                record += inputValues[inx];
            }
        }
        return record;
    }

}

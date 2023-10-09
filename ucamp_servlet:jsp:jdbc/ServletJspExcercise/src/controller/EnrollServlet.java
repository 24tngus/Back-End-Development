/*------------------------------------------------------------------------------
 * Name : EnrollServlet
 * Description : ��� ����� ó���ϴ� ���� Ŭ����
 * Version  : 1.0
 * Project : VCC Phase I - Web Workshop
 * Copyright 2008 LG CNS All rights reserved
 *------------------------------------------------------------------------------
 *                   ��        ��        ��        ��
 *------------------------------------------------------------------------------
 *     DATE       AUTHOR                       DESCRIPTION
 *-------------  --------  ----------------------------------------------------- 
 * 2008. 1. 1.   ������п�    Ver1.0 �ۼ�
 *----------------------------------------------------------------------------*/

package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//import biz.MemberBiz;
import entity.MemberEntity;

/**
 * <pre>
 *  ��� ����� ó���ϴ� ���� Ŭ����
 * </pre>
 * 
 * @author LG CNS ������п�
 * @version 1.0, 2008/01/01
 */
public class EnrollServlet extends HttpServlet {

    /**
     * ��� ����� ó���ϰ�, �������� �� "result.jsp" ȭ���� �������� �� "enrollFail.html" ȭ���� �����ִ�
     * �޼ҵ�.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

        // 1. ����ڷκ��� ���� request�� ó��
        MemberEntity member = processFormData( request );

        // 2. biz logic ����
//        MemberBiz biz = new MemberBiz();
//        boolean result = biz.enroll( member );

        // 3. view ����(����������, ����������)
        // �ۼ��Ͻÿ�.







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

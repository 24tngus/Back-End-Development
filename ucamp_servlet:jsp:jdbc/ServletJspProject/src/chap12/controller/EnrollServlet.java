package chap12.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import chap12.biz.MemberService;
import chap12.entity.Member;



public class EnrollServlet extends HttpServlet {
    public void doPost( HttpServletRequest req, HttpServletResponse res )
    throws IOException, ServletException {
        
        //1. 사용자로부터 받은 request를 처리한다.
        Member member = processFormData( req );
        
        //2. biz logic 수행한다.
        MemberService service = new MemberService();
        boolean result = service.register(member);
        
        //3. view 선택한다.(성공했을때, 실패했을때) 
        if ( result ) {
            RequestDispatcher view = req.getRequestDispatcher("/chap12/result.jsp");
            req.setAttribute("member", member);
            view.forward(req, res);
        } else {
            res.sendRedirect("/chap12/error.html");
        }
    }

    public Member processFormData( HttpServletRequest req )
    {
    
        Member member = new Member();
        try
        {
            req.setCharacterEncoding("euc-kr");
            member.setTfMemberID(req.getParameter( "tfMemberID" ));
            member.setTfName(req.getParameter( "tfName" ));
            member.setTfPassword(req.getParameter( "tfPassword" ));
            member.setTfAddress(req.getParameter( "tfAddress" ));
            member.setTfPhone(req.getParameter( "tfPhone" ));
            member.setSelPasswordQuestion(req.getParameter( "selPasswordQuestion" ));
            member.setTfPasswordAnswer(req.getParameter( "tfPasswordAnswer" ));
            member.setRdMarriage(req.getParameter( "rdMarriage" ));
            member.setChkHobby( makeHobby( req.getParameterValues( "chkHobby" )));
            member.setEtc(req.getParameter( "etc" ));
        }
        catch( Exception e )
        {
             System.out.println ( e );
        }
        return member;    
    }
    
    public String makeHobby (  String[] inputValues )
    {
        String record = "";
        if ( inputValues != null )
        {
            for ( int inx = 0; inx < inputValues.length; inx++ )
            {
                if ( inx != 0 )
                    record += " "; 
                record += inputValues[ inx ];
            }
        }                
        return record;
    }

}

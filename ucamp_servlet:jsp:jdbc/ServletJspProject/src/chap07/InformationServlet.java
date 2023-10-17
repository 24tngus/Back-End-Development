
package chap07;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*; 
import java.util.*;

/**
 * @author 기술대학원 
 *
 */
public class InformationServlet extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse res ) 
                 throws ServletException, IOException {

        req.setCharacterEncoding( "euc-kr" );
        res.setContentType( "text/html;charset=euc-kr" );

        PrintWriter out = res.getWriter();
        out.println( "<html><body>" );
        out.println( "회원 정보<br>" );

        HttpSession session = req.getSession( false );

        if ( session != null ) {
        	String id = (String)session.getAttribute( "loginId" );
        	String pw = (String)session.getAttribute( "password" );
            out.println( "회원 아이디 : " + id + "<br>" );
            out.println( "비밀번호 : " + pw + "<br>" );
            out.println( session.getId() );
        } else {
            out.println( "No Session" );
        }
        out.println( "</body></html>" );
        out.close();
    }
}



package chap07;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*; 
import java.util.*;

/**
 * @author 기술대학원 
 *
 */
public class BasketServlet extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse res ) 
                 throws ServletException, IOException {

        req.setCharacterEncoding( "euc-kr" );
        res.setContentType( "text/html;charset=euc-kr" );

        PrintWriter out = res.getWriter();
        out.println( "<html><body>" );
        out.println( "Cart List<br>" );

        HttpSession session = req.getSession( false );

        if ( session != null ) {
            ArrayList list = (ArrayList)session.getAttribute( "product" );
            out.println( "product : " + list + "<br>" );
            out.println( session.getId() );
        } else {
            out.println( "No Session" );
        }
        out.println( "</body></html>" );
        out.close();
    }
}


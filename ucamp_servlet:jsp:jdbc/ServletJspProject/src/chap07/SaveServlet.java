
package chap07;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*;

/**
 * @author 기술대학원 
 *
 */
public class SaveServlet extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse res )
                        throws ServletException, IOException {
        req.setCharacterEncoding( "euc-kr" );
        res.setContentType( "text/html;charset=euc-kr" );

        String p = req.getParameter( "product" );
        System.out.println( "product : " + p + "<br>" );
        HttpSession session = req.getSession();
        ArrayList list = null;
        if ( session.isNew() ) {
            list = new ArrayList();
            list.add( p );
        } else {
            list = (ArrayList)session.getAttribute( "product" );
            list.add( p );
        }

        session.setAttribute( "product", list );

        PrintWriter out = res.getWriter();
        out.println( "<html><body>" );
        out.println( "Product added." );
        out.println( "<a href=/basket>My Cart</a>" );
        out.println( "</body></html>" );
        out.close();
    }
}


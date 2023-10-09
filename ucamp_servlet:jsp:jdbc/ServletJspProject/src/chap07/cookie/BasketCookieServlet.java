
package chap07.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BasketCookieServlet extends HttpServlet {

    public void doGet( HttpServletRequest req, HttpServletResponse res ) 
                throws ServletException, IOException {

        req.setCharacterEncoding( "euc-kr" );
        res.setContentType( "text/html;charset=euc-kr" );

        PrintWriter out = res.getWriter();
        out.println( "<HTML><body>" );
        out.println( "Cart List<br>" );

        Cookie cookies[] = req.getCookies();

        if ( cookies != null ) {
            for ( int i = 0 ; i < cookies.length ; i++ ) {
                Cookie cookie = cookies[i];
                out.println( cookie.getName() + " : " + cookie.getValue()  + "<br>" );
            }
        } else {
            out.println( "물품이 없습니다." );
        }
        out.println( "</body></html>" );
        out.close();
    }
}

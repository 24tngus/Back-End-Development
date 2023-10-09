package chap07.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SaveCookieServlet extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse res ) 
                           throws ServletException, IOException {

        req.setCharacterEncoding( "euc-kr" );
        res.setContentType( "text/html;charset=euc-kr" );

        String p = req.getParameter( "product" );
        System.out.println( "product : " + p  );
        
        Cookie[] cookies = req.getCookies();
        
        Cookie c = null;
        if ( cookies == null || cookies.length == 0 ) {
            c = new Cookie( "Cart1", p );
        } else {
            c = new Cookie( "Cart" + (cookies.length + 1), p );
        }
       
        c.setMaxAge(60*60);
        
        res.addCookie( c );

        PrintWriter out = res.getWriter();
        out.println( "<HTML><body>" );
        out.println( "Product added." );
        out.println( "<a href=/basketCookie>My Cart</a>" );
        out.println( "</body></html>" );
        out.close();
    }
}

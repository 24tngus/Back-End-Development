
package chap06;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class OrderServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) 
                     throws IOException {

        ServletContext context = getServletContext();
        response.setContentType( "text/html;charset=euc-kr" );
        PrintWriter out = response.getWriter();
        out.println( "<HTML>" );
        out.println( "<BODY BGCOLOR='white'>" );
        out.println( "<B> product1 : " + (String)context.getAttribute( "product1" ) + "</B><br>" );
        out.println( "<B> product2 : " + (String)context.getAttribute( "product2" ) + "</B><br>" );
        out.println( "<B> product3 : " + (String)context.getAttribute( "product3" ) + "</B><br>" );
        out.println( " 위의 제품을 주문하실수 있습니다!!!!" );
        out.println( "</BODY>" );
        out.println( "</HTML>" );
        log("------------------");
        log("제품을 주문했습니다.");
        log("------------------");
    }
}

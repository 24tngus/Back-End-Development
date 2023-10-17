
package chap04;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * @author 기술대학원 
 *
 */
public class HelloServlet extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) 
           throws IOException {

        response.setContentType( "text/html;charset=euc-kr" );
        PrintWriter out = response.getWriter();

        out.println( "<HTML>" );
        out.println( "<HEAD>" );
        out.println( "<TITLE>Hello Servlet</TITLE>" );
        out.println( "</HEAD>" );
        out.println( "<BODY BGCOLOR='white'>" );
        out.println( "<B>Hello, World </B>" );
        out.println( "</BODY>" );
        out.println( "</HTML>" );
        out.close();

    }
}


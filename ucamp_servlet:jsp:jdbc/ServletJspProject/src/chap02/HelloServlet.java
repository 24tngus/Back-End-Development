package chap02;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {
    public void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws IOException {

        response.setContentType( "text/html;charset=euc-kr" );
        PrintWriter out = response.getWriter();
        out.println( "<html><html>" );
        out.println( "<title>Hello Servlet</title></head>" );
        out.println( "<body>" );
        out.println( "<b>Hello, World!!! 안녕~</b><br>" );
        out.println( "지금 시간은 " + new Date() + "입니다." );
        out.println( "</body>" );
        out.println( "</html>" );
        out.close();
    }
}

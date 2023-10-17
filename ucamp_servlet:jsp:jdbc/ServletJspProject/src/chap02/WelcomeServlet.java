package chap02;

import java.io.*;          // PrintWriter
import javax.servlet.*;    // ServletException
import javax.servlet.http.*; 

public class WelcomeServlet extends HttpServlet {
    public void doGet( HttpServletRequest req,
                       HttpServletResponse res ) 
                throws ServletException, IOException {
        res.setContentType("text/html;charset=euc-kr");
        
        PrintWriter out = res.getWriter();
        out.println( "<html>" );
        out.println( "<head>" );
        out.println( "<title>Your First Page</title>" );
        out.println( "</head>" );
        out.println( "<body>" );
        out.println( "<h1>Welcome, Servlet!!!</h1>" );
        out.println( "</body>" );
        out.println( "</html>" );
        out.close();
    }
}

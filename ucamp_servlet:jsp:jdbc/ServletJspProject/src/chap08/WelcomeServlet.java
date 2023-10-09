package chap08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class WelcomeServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,IOException {
        request.setCharacterEncoding("euc-kr");
        response.setContentType( "text/html;charset=euc-kr");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello JavaServer Page</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<body bgcolor='white'>");
        
        String name = request.getParameter("name");
        
        if ( name == null || name.equals("") ) {
            out.println("<b>No Input Information.</b><br>");
            out.println("NAME : " + name +"<br>");
        } else {
            out.println( "<b>" + getWelcomeMessage( name ) +"</b>" );
        }
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
        
    public String getWelcomeMessage( String name ) {
        return "Welcome :" + name ;
    }
}
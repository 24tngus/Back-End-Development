package chap05;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

public class HelloServlet extends HttpServlet {

    private String greetingText;

    public void init() {
        System.out.println( "<<Init Method Called>>" );
        greetingText = getInitParameter( "greetingText" );
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response )
                               throws IOException,ServletException {
        request.setCharacterEncoding( "euc-kr" );
        response.setContentType( "text/html;charset=euc-kr" );
        PrintWriter out = response.getWriter();

        System.out.println( ">> greetingText get = " + greetingText  );
        out.println( "<HTML><HEAD>" );
        out.println( "<TITLE>Hello Servlet</TITLE></HEAD>" );
        out.println( "<BODY BGCOLOR='white'>" );
        out.println( "<B>" + greetingText +"</B>" );
        out.println( "<br>" + request.getParameter("name") + "님 환영합니다.");
        out.println( "</BODY>" );
        out.println( "</HTML>" );
        out.close();
    }
    
	public void destroy(){
        System.out.println( "<< Destroy Method Called>>" );
    }

}

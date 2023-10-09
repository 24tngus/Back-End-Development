
package chap05;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

public class LifeCycle  extends HttpServlet {
    
    public void init() {
        System.out.println( "Init Method Called" );
    }
    
    public void doGet( HttpServletRequest req,  HttpServletResponse res )
                         throws ServletException, IOException {
        System.out.println( "doGet Method Called" );
        
        res.setContentType( "text/html;charset=euc-kr" );
        
        PrintWriter out = res.getWriter();
        out.println( "HI~!!" );
        out.close();
    }
    
    public void destroy() {
        System.out.println( "Destroy Method Called" );
    }

}

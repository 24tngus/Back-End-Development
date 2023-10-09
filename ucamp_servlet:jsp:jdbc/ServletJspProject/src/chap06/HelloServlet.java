
package chap06;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author 기술대학원
 */
public class HelloServlet extends HttpServlet {
    private String myName;

    public void init() {

        ServletContext context = getServletContext();
        String catalogFileName = context.getInitParameter( "catalogFileName" );
        myName = context.getInitParameter( "myName" );

        BufferedReader br = null;

        try{
            br = new BufferedReader( new FileReader(  catalogFileName  )); 
            String str = br.readLine(); 
            System.out.println( str );
	    }catch( IOException ie ){
	        context.log( "Error: catalog file read error Exception : " + ie ); 
	    }

    }

    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException,
            IOException {

        System.out.println( "doGet Method Called" );
        System.out.println( myName );

        res.setContentType( "text/html;charset=euc-kr" );

        PrintWriter out = res.getWriter();
        out.println( "HI~!!" );
        out.close();
    }

    public void destroy() {

        System.out.println( "Destroy Method Called" );
    }
}

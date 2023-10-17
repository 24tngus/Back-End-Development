
package chap03;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {

        generateResponse( req, res );
    }
    
    public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        generateResponse( req, res );
    }
    
    public void generateResponse( HttpServletRequest req, HttpServletResponse res )throws ServletException, IOException {
        res.setContentType( "text/html;charset=euc-kr" );

        PrintWriter out = res.getWriter();
        out.println( "<html>" );
        out.println( "<head>" );
        out.println( "<title>로그인 결과</title>" );
        out.println( "</head>" );
        out.println( "<body>" );

        /* login.html 의 폼 데이터에서 사용자가 이름과 패스워드 둘 다 입력하였으면,
         * XXX 님 환영합니다. 라는 메시지를 하나라도 입력을 하지 않았으면,
         * 이름 또는 패스워드가 입력되지 않았습니다. 라는 메시지를 클라이언트의 브라우져로
         *  출력하도록 하는 Servlet을 작성
         */
        String name = req.getParameter( "name" );
        String pass = req.getParameter( "pass" );
        
        if ( ( name == null || name.equals("") ) || ( pass == null || pass.equals("")) ) {
            out.println( "이름 또는 패스워드가 입력되지 않았습니다" );
        } else {
            out.println( name + "님 환영합니다." );
        }
        
        out.println( "</body>" );
        out.println( "</html>" );
        out.close();
    }
}

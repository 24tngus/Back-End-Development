
package chap07;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.ArrayList;


/**
 * <pre>
 *  사용자 로그인 시 사용되는 서블릿 클래스
 * </pre>
 * 
 * @author LG CNS 기술대학원
 * @version 1.0, 2006/01/01
 */
public class LoginServlet extends HttpServlet {
    /**
     * servlet service 메소드. 올바른 로그인인지 확인하고 인증되면 Session을 생성한다. 해당하는 화면으로 보여준다.
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {

        request.setCharacterEncoding( "euc-kr" );
        response.setContentType( "text/html;charset=euc-kr" );

        String id = request.getParameter( "loginId" );
        String pw = request.getParameter( "password" );
        System.out.println( "사용자 아이디  : " + id + "<br>" );
        HttpSession session = request.getSession();

        session.setAttribute( "loginId", id );
        session.setAttribute( "password", pw );

        PrintWriter out = response.getWriter();
        out.println( "<html><body>" );
        out.println( "로그인 되었습니다 <br>" );
        out.println( "<a href=/info>My Information</a>" );
        out.println( "</body></html>" );
        out.close();

    }
}

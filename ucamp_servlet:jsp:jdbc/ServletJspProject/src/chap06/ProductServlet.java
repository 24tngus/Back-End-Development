
package chap06;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ProductServlet extends HttpServlet {
    public void doGet( HttpServletRequest request, HttpServletResponse response ) 
                                  throws IOException {

        ServletContext context = getServletContext();
        context.setAttribute( "product1", "냉장고" );
        context.setAttribute( "product2", "TV" );
        context.setAttribute( "product3", "세탁기" );

        response.setContentType( "text/html;charset=euc-kr" );
        PrintWriter out = response.getWriter();
        out.println( "<HTML>" );
        out.println( "<BODY BGCOLOR='white'>" );
        out.println( "<B> product1 : 냉장고</B><br>" );
        out.println( "<B> product2 : TV</B><br>" );
        out.println( "<B> product3 : 세탁기</B><br>" );
        out.println( "를 context 영역에 올려 놓았습니다.^^" );
        out.println( "</BODY>" );
        out.println( "</HTML>" );
        out.close();
    }
}

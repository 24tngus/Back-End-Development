package chap03;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class FormTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");

		PrintWriter out = res.getWriter();
		out.println("<html> ");
		out.println("<body> ");
        out.println( "콘솔 창을 확인하세요.");

		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String region = req.getParameter("region");
		String other = req.getParameter("etc");
		String lastData = req.getParameter("lastdata");

		if (hobby != null) {
			for (int inx = 0; inx < hobby.length; inx++) {
				System.out.println("hobby:["+ inx + "]" + hobby[inx]);
			}
		}

		System.out.println("gender:" + gender);
		System.out.println("region:" + region);
		System.out.println("other:" + other);
		System.out.println("lastData:" + lastData);
		System.out.println("-------getParameterNames()-------");
        
		Enumeration e = req.getParameterNames();
		while (e.hasMoreElements()) {
           
            String parmaName = (String)e.nextElement();
			System.out.println(parmaName);
            System.out.println(req.getParameter( parmaName ));
		}

		out.println("</body> ");
		out.println("</html> ");
		out.close();
	}
    
}

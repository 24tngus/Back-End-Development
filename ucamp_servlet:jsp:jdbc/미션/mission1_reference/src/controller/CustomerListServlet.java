package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import vo.CustomerVO;

/**
 * Servlet implementation class CustomerListServlet
 */
// @WebServlet("/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    // init은 Servlet이 초기화 될 때 호출
	public void init(ServletConfig config) throws ServletException {
		// ServletConfig : Java Servlet의 설정 정보를 담고 있는 객체
		// Servlet이 web.xml파일에 정의된 초기화 매개변수를 읽어오기 위해 사용
		
		System.out.println("init");
		
		String driverClass = config.getInitParameter("driverClass");
		String dbUrl = config.getInitParameter("dbUrl");
		String dbUserName = config.getInitParameter("dbUserName");
		String dbUserPw = config.getInitParameter("dbUserPw");
		
		customerDAO = new CustomerDAO(driverClass, dbUrl, dbUserName, dbUserPw);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
		// DB와의 연결 해제
        customerDAO.connectionClosed();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request, response의 인코딩설정을 UTF-8로 처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//DAO에서 원하는 데이터 추출 후 request객체에 담기
        List<CustomerVO> customerAllList = customerDAO.getAllCustomerList();
        request.setAttribute("customerList", customerAllList);

        // RequestDispatcher은 서블릿 컨테이너(ex>Apache Tomcat)내부에서 동작
        // 서블릿과 JSP페이지 간의 요청 및 응답을 전달하는데 사용
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerList.jsp");
        requestDispatcher.forward(request, response);

	}
}

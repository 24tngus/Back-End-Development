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
 * Servlet implementation class UserListServlet
 */
// @WebServlet("/userList")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerDAO customerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println(">> init");
    	String driver = config.getInitParameter("driverClass"); // org.mariadb.jdbc.Driver (web.xml의 param.value)
    	String url = config.getInitParameter("dbUrl");
    	String username = config.getInitParameter("dbUsername");
    	String password = config.getInitParameter("dbPassword");
    	System.out.println(driver);
    	System.out.println(url);
    	System.out.println(username);
    	System.out.println(password);
    	
    	customerDao = new CustomerDAO(driver, url, username, password);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> doGet");
		// response(응답) 데이터를 utf-8로 인코딩
		response.setContentType("text/html; charset=UTF-8");
		// response.getWriter() : 응답에 대한 string 생성 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// UserDAO를 호출해서 DB 데이터를 가져오기
		List<CustomerVO> customerList = customerDao.getCustomerList();
		
		// Request 객체에 userList를 저장하기
		request.setAttribute("customer", customerList); // key : users, value : userList
		// RequestDispatcher 생성하기
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp"); //userList.jsp 포워딩 필요
		// userList.jsp 페이지로 포워딩하기
		dispatcher.forward(request, response); // 전달 받은 인자값 그대로 forward
	}
	
	@Override
	public void destroy() {
		System.out.println(">> destroy");
		super.destroy();
	}

}

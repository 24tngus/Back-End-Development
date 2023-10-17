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
    	String driver = config.getInitParameter("driverClass"); // org.mariadb.jdbc.Driver (web.xml�� param.value)
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
		// response(����) �����͸� utf-8�� ���ڵ�
		response.setContentType("text/html; charset=UTF-8");
		// response.getWriter() : ���信 ���� string ���� 
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// UserDAO�� ȣ���ؼ� DB �����͸� ��������
		List<CustomerVO> customerList = customerDao.getCustomerList();
		
		// Request ��ü�� userList�� �����ϱ�
		request.setAttribute("customer", customerList); // key : users, value : userList
		// RequestDispatcher �����ϱ�
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp"); //userList.jsp ������ �ʿ�
		// userList.jsp �������� �������ϱ�
		dispatcher.forward(request, response); // ���� ���� ���ڰ� �״�� forward
	}
	
	@Override
	public void destroy() {
		System.out.println(">> destroy");
		super.destroy();
	}

}

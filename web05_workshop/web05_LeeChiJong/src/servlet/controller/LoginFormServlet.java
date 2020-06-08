package servlet.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import content.vo.BookDAO;
import content.vo.BookDAOImpl;
import content.vo.User;

public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao = null;
    
    public LoginFormServlet() {
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		dao = BookDAOImpl.getInstance();
		User user = null;
		try {
			user = dao.login(userId, password);
		} catch (SQLException e) {
			System.out.println("로그인 실패");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		RequestDispatcher rdp = null;
		rdp = request.getRequestDispatcher("loginResult.jsp");
		try {
			rdp.forward(request, response);
		} catch (IOException e) {
			System.out.println("forward Error");
		}
	}
}

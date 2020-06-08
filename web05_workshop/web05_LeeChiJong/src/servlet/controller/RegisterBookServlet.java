package servlet.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.vo.Book;
import content.vo.BookDAO;
import content.vo.BookDAOImpl;

/**
 * Servlet implementation class RegisterBook
 */
public class RegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookDAO dao;
	private Book book;
	private RequestDispatcher rdp;
	
    public RegisterBookServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼값 받기
		System.out.println("Get Book info....");
		String isbn1 = request.getParameter("isbn1");
		String isbn2 = request.getParameter("isbn2");
		String isbn3 = request.getParameter("isbn3");
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publish_date = request.getParameter("publish_date");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		
		book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description);
		
		dao = BookDAOImpl.getInstance();
		try {
			dao.registerBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("book", book);
		rdp = request.getRequestDispatcher("registerSuccess.jsp");
		rdp.forward(request, response);
	}
}

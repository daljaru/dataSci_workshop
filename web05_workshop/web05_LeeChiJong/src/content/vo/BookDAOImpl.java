package content.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{
	private DataSource ds;
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("lookup성공");
		} catch (NamingException e1) {
			System.out.println("DataSource Lookup 실패...");
		}
	}
	public static BookDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	@Override
	public void registerBook(Book bookVO) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query="insert into book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, bookVO.getIsbn());
			ps.setString(2, bookVO.getTitle());
			ps.setString(3, bookVO.getCatalogue());
			ps.setString(4, bookVO.getNation());
			ps.setString(5, bookVO.getPublish_date());
			ps.setString(6, bookVO.getPublisher());
			ps.setString(7, bookVO.getAuthor());
			ps.setInt(8, bookVO.getPrice());
			ps.setString(9, bookVO.getCurrency());
			ps.setString(10, bookVO.getCatalogue());
			ps.executeUpdate();
		}finally {
			closeAll(ps, conn);
		}
		return;
	}
	@Override
	public ArrayList<Book> showAllBooks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		Book book = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			conn = getConnection();
			String query = "select isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description from book";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String catalogue = rs.getString("catalogue");
				String nation = rs.getString("nation");
				String publish_date = rs.getString("publish_date");
				String publisher = rs.getString("publisher");
				String author = rs.getString("author");
				int price = rs.getInt("price");
				String currency = rs.getString("currency");
				String description = rs.getString("description");
				book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description);
				books.add(book);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return books;
	}

	@Override
	public ArrayList<User> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		User user = null;
		ArrayList<User> users = new ArrayList<User>();
		try {
			conn = getConnection();
			String query = "select userId, password, name, email from userinfo";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String userId = rs.getString("userId");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				user = new User(userId, password, name, email);
				users.add(user);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return users;
	}
	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		User user = null;
		try {
			conn = getConnection();
			String query = "select userId, password, name, email from userinfo where userId=? and password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				user = new User(userId, password, name, email);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return user;
	}

}

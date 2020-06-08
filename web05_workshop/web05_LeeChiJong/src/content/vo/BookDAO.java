package content.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	public ArrayList<User> showAllMember() throws SQLException;
	public User login(String userId, String password) throws SQLException;

	void registerBook(Book bookVO) throws SQLException;
	ArrayList<Book> showAllBooks() throws SQLException;
}
